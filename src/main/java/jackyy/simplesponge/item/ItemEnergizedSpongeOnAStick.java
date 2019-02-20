package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.ModList;

//@Optional.Interface(iface = "cofh.redstoneflux.api.IEnergyContainerItem", modid = "redstoneflux")
public class ItemEnergizedSpongeOnAStick extends ItemSpongeOnAStickBase /*implements IEnergyContainerItem*/ {

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
                if (ModList.get().isLoaded("redstoneflux")) {
                    ItemStack empty = new ItemStack(this);
                    items.add(empty);
                    /*
                    ItemStack full = new ItemStack(this);
                    ModUtils.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                    items.add(full);
                    */
                }
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

    /*
    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag bool) {
        tooltip.add(new TextComponentString(ModUtils.formatNumber(getEnergyStored(stack)) + " / " + ModUtils.formatNumber(getMaxEnergyStored(stack)) + " RF"));
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
