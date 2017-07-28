package me.jacky1356400.simplesponge.item;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.util.Data;
import me.jacky1356400.simplesponge.util.EnergyStorageNBT;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.text.NumberFormat;
import java.util.List;

public class ItemEnergizedSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemEnergizedSpongeOnAStick(){
        setRegistryName(Data.MODID + ":energized_sponge_on_a_stick");
        setUnlocalizedName(Data.MODID + ".energized_sponge_on_a_stick");
        setCreativeTab(Data.TAB);
        Data.ITEMS.add(this);
        setNoRepair();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab)) {
            ItemStack empty = new ItemStack(this);
            list.add(empty);
            ItemStack full = new ItemStack(this);
            IEnergyStorage storage = getEnergy(full);
            if (storage != null && storage instanceof EnergyStorageNBT) {
                ((EnergyStorageNBT) storage).setEnergyStorad(storage.getMaxEnergyStored());
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
        return Config.energizedSpongeOnAStickRange;
    }

    @Override
    public int getEnergy() {
        return Config.energizedSpongeOnAStickMaxEnergy;
    }

    @Override
    public int getPerBlockUse() {
        return Config.energizedSpongeOnAStickPerBlockUse;
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return true;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack){
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
        IEnergyStorage energyStorage = getEnergy(stack);
        tooltip.add(NumberFormat.getInstance().format(energyStorage.getEnergyStored()) + " / " +
                NumberFormat.getInstance().format(energyStorage.getMaxEnergyStored()) + " FE");
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        IEnergyStorage storage = getEnergy(stack);
        return 1D - ((double) storage.getEnergyStored() / (double) storage.getMaxEnergyStored());
    }

    public static IEnergyStorage getEnergy(ItemStack stack) {
        if (stack.hasCapability(CapabilityEnergy.ENERGY, null))
            return stack.getCapability(CapabilityEnergy.ENERGY, null);
        return null;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new Caps(new EnergyStorageNBT(getEnergy(),getEnergy() / 100));
    }

    public class Caps implements ICapabilitySerializable<NBTTagCompound> {
        EnergyStorageNBT storage;

        public Caps(EnergyStorageNBT storage) {
            this.storage = storage;
        }

        @Override
        public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
            return capability == CapabilityEnergy.ENERGY;
        }

        @Override
        public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
            return hasCapability(capability, facing) ? (T) storage : null;
        }

        @Override
        public NBTTagCompound serializeNBT() {
            return storage.serializeNBT();
        }

        @Override
        public void deserializeNBT(NBTTagCompound nbt) {
            storage.deserializeNBT(nbt);
        }
    }

}
