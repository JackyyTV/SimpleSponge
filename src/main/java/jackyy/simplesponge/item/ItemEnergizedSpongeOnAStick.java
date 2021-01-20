package jackyy.simplesponge.item;

import jackyy.gunpowderlib.capability.FEItemStackCapability;
import jackyy.gunpowderlib.capability.FEStorageCapability;
import jackyy.gunpowderlib.capability.IFEContainer;
import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nullable;
import java.util.List;

public class ItemEnergizedSpongeOnAStick extends ItemSpongeOnAStickBase implements IFEContainer {

    private static int range;
    private static int energy;
    private static int use;
    static {
        try {
            range = ModConfigs.CONFIG.energizedSpongeOnAStickRange.get();
            energy = ModConfigs.CONFIG.energizedSpongeOnAStickMaxEnergy.get();
            use = ModConfigs.CONFIG.energizedSpongeOnAStickPerRightClickUse.get();
        } catch (NullPointerException e) {
            range = 7;
            energy = 500000;
            use = 100;
        }
    }

    public ItemEnergizedSpongeOnAStick() {
        super(new Properties().maxStackSize(1).setNoRepair());
        setRegistryName("energized_sponge_on_a_stick");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (isInGroup(group)) {
            if (ModConfigs.CONFIG.enableEnergizedSpongeOnAStick.get()) {
                ItemStack empty = new ItemStack(this);
                items.add(empty);
                ItemStack full = new ItemStack(this);
                EnergyHelper.setDefaultEnergyTag(full, getEnergy());
                items.add(full);
            }
        }
    }

    @Override
    public boolean isPowered() {
        return true;
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getPerRightClickUse() {
        return use;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag advanced) {
        tooltip.add(
                StringHelper.formatNumber(getEnergyStored(stack))
                        .appendString(" / ")
                        .append(StringHelper.formatNumber(getEnergy()))
                        .appendString(" FE")
        );
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        FEStorageCapability storage = (FEStorageCapability) stack.getCapability(CapabilityEnergy.ENERGY, null).orElse(null);
        if (storage == null) {
            return 0;
        }
        return 1 - (double) getEnergyStored(stack) / getEnergy();
    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        return EnergyHelper.receiveEnergy(container, maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        return EnergyHelper.extractEnergy(container, maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        if (container.getTag() == null || !container.getTag().contains(EnergyHelper.ENERGY_NBT)) {
            return 0;
        }
        return Math.min(NBTHelper.getInt(container, EnergyHelper.ENERGY_NBT), getEnergy());
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return getEnergy();
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return new FEItemStackCapability<>(new FEStorageCapability(this, stack));
    }

}
