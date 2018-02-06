package jackyy.simplesponge.item;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.util.ModUtils;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ItemSpongeOnAStickBase extends Item {

    public ItemSpongeOnAStickBase() {
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

    public int getPerRightClickUse() {
        return this.getPerRightClickUse();
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack){
        return stack.isItemDamaged();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        if (!isPowered()){
            tooltip.add(ModUtils.formatNumber(stack.getMaxDamage() - stack.getItemDamage()) + " / " + ModUtils.formatNumber(stack.getMaxDamage()) + " " + I18n.format("tooltip." + SimpleSponge.MODID + ".durability"));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return soakUp(world, pos, player, player.getHeldItemMainhand())? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        boolean result = soakUp(world, player.getPosition(), player, player.getHeldItemMainhand());
        return ActionResult.newResult(result? EnumActionResult.SUCCESS : EnumActionResult.FAIL, player.getHeldItemMainhand());
    }

    private boolean soakUp(World world, BlockPos pos, EntityPlayer player, ItemStack stack) {
        boolean absorbedAnything = false;
        boolean hitLava = false;
        int damage = stack.getItemDamage();

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
                        else if (isPowered() && stack.getTagCompound().getInteger("Energy") < getPerRightClickUse()) break;
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
                if (stack.getTagCompound().getInteger("Energy") >= getPerRightClickUse()) {
                    stack.getTagCompound().setInteger("Energy", stack.getTagCompound().getInteger("Energy") - getPerRightClickUse());
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
