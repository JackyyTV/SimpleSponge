package me.jacky1356400.simplesponge.item;

import me.jacky1356400.simplesponge.util.Data;
import me.jacky1356400.simplesponge.util.EnergyStorageNBT;
import me.jacky1356400.simplesponge.util.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.IEnergyStorage;

import java.text.NumberFormat;
import java.util.List;

public class ItemSpongeOnAStickBase extends Item implements IHasModel {

    public ItemSpongeOnAStickBase(){
        setMaxStackSize(1);
    }

    public boolean isPowered() {
        return false;
    }

    public boolean isMagmatic() {
        return this.isMagmatic();
    }

    public int getRange() {
        return this.getRange();
    }

    public int getDmg() {
        return this.getDmg();
    }

    public int getEnergy() {
        return this.getEnergy();
    }

    public int getPerBlockUse() {
        return this.getPerBlockUse();
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack){
        return stack.isItemDamaged();
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        if (!isPowered()){
            tooltip.add(NumberFormat.getInstance().format(stack.getMaxDamage() - stack.getItemDamage()) + " / " + NumberFormat.getInstance().format(stack.getMaxDamage()) + " " + I18n.format("tooltip." + Data.MODID + ".durability"));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return soakUp(world, pos, player, player.getHeldItem(hand))? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        boolean result = soakUp(world, player.getPosition(), player, player.getHeldItem(hand));
        return ActionResult.newResult(result? EnumActionResult.SUCCESS : EnumActionResult.FAIL, player.getHeldItem(hand));
    }

    public boolean soakUp(World world, BlockPos pos, EntityPlayer player, ItemStack stack) {
        boolean absorbedAnything = false;
        boolean hitLava = false;
        int damage = stack.getItemDamage();
        IEnergyStorage storage = ItemEnergizedSpongeOnAStick.getEnergy(stack);

        for (int x = -getRange(); x <= getRange(); x++) {
            for (int y = -getRange(); y <= getRange(); y++) {
                for (int z = -getRange(); z <= getRange(); z++) {
                    final BlockPos targetPos = pos.add(x, y, z);

                    Material material = world.getBlockState(targetPos).getMaterial();
                    if (material.isLiquid()) {
                        absorbedAnything = true;
                        hitLava |= material == Material.LAVA;
                        world.setBlockToAir(targetPos);
                        if (!isPowered() && ++damage >= getDmg()) break;
                        else if (isPowered() && storage.getEnergyStored() < getPerBlockUse()) break;
                    }

                }
            }
        }

        if (hitLava) {
            if (!isMagmatic()) {
                stack.setCount(0);
                player.setFire(6);
            }
        }

        if (absorbedAnything) {
            if (isPowered()) {
                if (storage.getEnergyStored() >= getPerBlockUse()) {
                    ((EnergyStorageNBT) storage).setEnergyStorad(storage.getEnergyStored() - getPerBlockUse());
                }
            } else {
                if (damage >= getDmg()) {
                    stack.setCount(0);
                } else if (!player.isCreative()) {
                    stack.setItemDamage(damage);
                }
            }
            return true;
        }

        return false;
    }

}
