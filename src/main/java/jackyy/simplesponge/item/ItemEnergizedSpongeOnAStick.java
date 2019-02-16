package jackyy.simplesponge.item;

import net.minecraft.item.ItemStack;

//@Optional.Interface(iface = "cofh.redstoneflux.api.IEnergyContainerItem", modid = "redstoneflux")
public class ItemEnergizedSpongeOnAStick extends ItemSpongeOnAStickBase /*implements IEnergyContainerItem*/ {

    public ItemEnergizedSpongeOnAStick() {
        setRegistryName("energized_sponge_on_a_stick");
    }

    /*
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
    */

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
        //return ModConfig.energizedSponge.energizedSpongeOnAStickRange;
        return 1;
    }

    @Override
    public int getEnergy() {
        //return ModConfig.energizedSponge.energizedSpongeOnAStickMaxEnergy;
        return 1;
    }

    @Override
    public int getPerRightClickUse() {
        //return ModConfig.energizedSponge.energizedSpongeOnAStickPerRightClickUse;
        return 1;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    /*
    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag bool) {
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
    */

}
