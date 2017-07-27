package me.jacky1356400.simplesponge.item;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.SimpleSponge;
import me.jacky1356400.simplesponge.util.EnergyStorageNBT;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.NumberFormat;
import java.util.List;

public class ItemEnergizedSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemEnergizedSpongeOnAStick(){
        setRegistryName(SimpleSponge.MODID + ":energized_sponge_on_a_stick");
        setUnlocalizedName(SimpleSponge.MODID + ".energized_sponge_on_a_stick");
        setCreativeTab(SimpleSponge.spongeCreativeTab);
        setNoRepair();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        ItemStack empty = new ItemStack(this);
        list.add(empty);
        ItemStack full = new ItemStack(this);
        IEnergyStorage storage = getEnergy(full);
        if (storage != null && storage instanceof EnergyStorageNBT) {
            ((EnergyStorageNBT) storage).setEnergyStorad(storage.getMaxEnergyStored());
            list.add(full);
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
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean bool) {
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
