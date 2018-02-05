package jackyy.simplesponge.item;

import jackyy.simplesponge.SimpleSponge;
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

import java.text.NumberFormat;
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

    public int getPerBlockUse() {
        return this.getPerBlockUse();
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack){
        return stack.isItemDamaged();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        if (!isPowered()){
            tooltip.add(NumberFormat.getInstance().format(stack.getMaxDamage() - stack.getItemDamage()) + " / " + NumberFormat.getInstance().format(stack.getMaxDamage()) + " " + I18n.format("tooltip." + SimpleSponge.MODID + ".durability"));
        }
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return soakUp(world, pos, player, stack)? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        boolean result = soakUp(world, player.getPosition(), player, stack);
        return ActionResult.newResult(result? EnumActionResult.SUCCESS : EnumActionResult.FAIL, stack);
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
                        else if (isPowered() && stack.getTagCompound().getInteger("Energy") < getPerBlockUse()) break;
                    }

                }
            }
        }

        if (hitLava) {
            if (!isMagmatic()) {
                stack.stackSize = 0;
                player.setFire(6);
            }
        }

        if (absorbedAnything) {
            if (isPowered()) {
                if (stack.getTagCompound().getInteger("Energy") >= getPerBlockUse()) {
                    stack.getTagCompound().setInteger("Energy", stack.getTagCompound().getInteger("Energy") - getPerBlockUse());
                }
            } else {
                if (damage >= getDmg()) {
                    stack.stackSize = 0;
                } else if (!player.isCreative()) {
                    stack.setItemDamage(damage);
                }
            }
            return true;
        }

        return false;
    }

}
