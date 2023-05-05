package jackyy.simplesponge.item;

import jackyy.gunpowderlib.capability.FEItemStackCapability;
import jackyy.gunpowderlib.capability.FEStorageCapability;
import jackyy.gunpowderlib.capability.IFEContainer;
import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;
import java.util.List;

public class ItemEnergizedSpongeOnAStick extends ItemSpongeOnAStickBase implements IFEContainer {

    public ItemEnergizedSpongeOnAStick() {
        super(new Properties().stacksTo(1).setNoRepair());
    }

    @Override
    public int getEnergy() {
        return ModConfigs.CONFIG.energizedSpongeOnAStickMaxEnergy.get();
    }

    @Override
    public int getPerRightClickUse() {
        return ModConfigs.CONFIG.energizedSpongeOnAStickPerRightClickUse.get();
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.energizedSpongeOnAStickRange.get();
    }

    @Override
    public boolean isMagnetic() {
        return true;
    }

    @Override
    public boolean isPowered() {
        return true;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> items) {
        if (this.allowedIn(tab)) {
            if (ModConfigs.CONFIG.enableEnergizedSpongeOnAStick.get()) {
                ItemStack empty = new ItemStack(this);
                items.add(empty);
                ItemStack full = new ItemStack(this);
                EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                items.add(full);
            }
        }
    }

    @Override @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag advanced) {
        tooltip.add(
                StringHelper.formatNumber(getEnergyStored(stack))
                        .append(" / ")
                        .append(StringHelper.formatNumber(getMaxEnergyStored(stack)))
                        .append(" FE")
        );
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        FEStorageCapability storage = (FEStorageCapability) stack.getCapability(ForgeCapabilities.ENERGY, null).orElse(null);
        if (storage == null) {
            return 0;
        }
        return (int) Math.round(13.0D * getEnergyStored(stack) / (double) getMaxEnergyStored(stack));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return Mth.hsvToRgb(1 / 3.0F, 1.0F, 1.0F);
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
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new FEItemStackCapability<>(new FEStorageCapability(this, stack));
    }

}
