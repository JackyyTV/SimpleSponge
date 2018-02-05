package jackyy.simplesponge.item;

import cofh.redstoneflux.api.IEnergyContainerItem;
import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfig;
import jackyy.simplesponge.util.EnergyContainerItemWrapper;
import jackyy.simplesponge.util.ModUtils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@Optional.Interface(iface = "cofh.redstoneflux.api.IEnergyContainerItem", modid = "redstoneflux")
public class ItemEnergizedSpongeOnAStick extends ItemSpongeOnAStickBase implements IEnergyContainerItem {

    public ItemEnergizedSpongeOnAStick() {
        setRegistryName(SimpleSponge.MODID + ":energized_sponge_on_a_stick");
        setUnlocalizedName(SimpleSponge.MODID + ".energized_sponge_on_a_stick");
        setCreativeTab(SimpleSponge.TAB);
        setNoRepair();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab)) {
            if (Loader.isModLoaded("redstoneflux")) {
                ItemStack empty = new ItemStack(this);
                list.add(empty);
                ItemStack full = new ItemStack(this);
                ModUtils.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                list.add(full);
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
        return ModConfig.energizedSponge.energizedSpongeOnAStickRange;
    }

    @Override
    public int getEnergy() {
        return ModConfig.energizedSponge.energizedSpongeOnAStickMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return ModConfig.energizedSponge.energizedSpongeOnAStickPerBlockUse;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag bool) {
        tooltip.add(ModUtils.formatNumber(getEnergyStored(stack)) + " / " + ModUtils.formatNumber(getMaxEnergyStored(stack)) + " RF");
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        if (stack.getTagCompound() == null) {
            ModUtils.setDefaultEnergyTag(stack, 0);
        }
        return 1D - ((double) stack.getTagCompound().getInteger("Energy") / (double) getMaxEnergyStored(stack));
    }

    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        return ModUtils.receive(container, maxReceive, getMaxEnergyStored(container), simulate);
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        return ModUtils.extract(container, maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        return ModUtils.getEnergyStored(container);
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return getEnergy();
    }

    @Override @Optional.Method(modid = "redstoneflux")
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new EnergyContainerItemWrapper(stack, this);
    }

}
