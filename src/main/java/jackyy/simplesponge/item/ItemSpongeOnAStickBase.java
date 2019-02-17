package jackyy.simplesponge.item;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.util.ModUtils;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.List;

public class ItemSpongeOnAStickBase extends Item {

    public ItemSpongeOnAStickBase(Properties props) {
        super(props.group(SimpleSponge.TAB));
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
        return stack.isDamaged();
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (!isPowered()){
            tooltip.add(new TextComponentString(ModUtils.formatNumber(stack.getMaxDamage() - stack.getDamage()) + " / " + ModUtils.formatNumber(stack.getMaxDamage()) + " " + I18n.format("tooltip." + SimpleSponge.MODID + ".durability")));
        }
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext context) {
        return soakUp(context.getWorld(), context.getPos(), context.getPlayer(), context.getPlayer().getHeldItemMainhand()) ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        boolean result = soakUp(world, player.getPosition(), player, player.getHeldItemMainhand());
        return ActionResult.newResult(result? EnumActionResult.SUCCESS : EnumActionResult.FAIL, player.getHeldItemMainhand());
    }

    private boolean soakUp(World world, BlockPos pos, EntityPlayer player, ItemStack stack) {
        boolean absorbedAnything = false;
        boolean hitLava = false;
        int damage = stack.getDamage();

        for (int x = -getRange(); x <= getRange(); x++) {
            for (int y = -getRange(); y <= getRange(); y++) {
                for (int z = -getRange(); z <= getRange(); z++) {
                    final BlockPos targetPos = pos.add(x, y, z);
                    final IBlockState state = world.getBlockState(targetPos);
                    Material material = world.getBlockState(targetPos).getMaterial();
                    if (material.isLiquid()) {
                        absorbedAnything = true;
                        hitLava |= material == Material.LAVA;
                        world.removeBlock(targetPos);
                        if (!isPowered() && ++damage >= getDmg()) break;
                        else if (isPowered() && stack.getTag().getInt("Energy") < getPerRightClickUse()) break;
                    } else if (state.has(BlockStateProperties.WATERLOGGED) && state.get(BlockStateProperties.WATERLOGGED)) {
                        absorbedAnything = true;
                        hitLava = false;
                        world.setBlockState(targetPos, state.with(BlockStateProperties.WATERLOGGED, false));
                        if (!isPowered() && ++damage >= getDmg()) break;
                        else if (isPowered() && stack.getTag().getInt("Energy") < getPerRightClickUse()) break;
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
                if (stack.getTag().getInt("Energy") >= getPerRightClickUse()) {
                    stack.setTagInfo("Energy", new NBTTagInt(stack.getTag().getInt("Energy") - getPerRightClickUse()));
                }
            } else {
                if (damage >= getDmg()) {
                    stack.setCount(0);
                } else if (!player.isCreative()) {
                    stack.setDamage(damage);
                }
            }
            return true;
        }

        return false;
    }

}
