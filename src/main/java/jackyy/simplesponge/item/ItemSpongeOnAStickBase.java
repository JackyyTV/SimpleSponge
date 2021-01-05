package jackyy.simplesponge.item;

import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import jackyy.simplesponge.SimpleSponge;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
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
            tooltip.add(
                    StringHelper.formatNumber(stack.getMaxDamage() - stack.getDamage())
                            .appendString(" / ")
                            .append(StringHelper.formatNumber(stack.getMaxDamage()))
                            .appendString(" ")
                            .append(new TranslationTextComponent("tooltip." + SimpleSponge.MODID + ".durability"))
            );
        }
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        return soakUp(context.getWorld(), context.getPos(), context.getPlayer(), context.getPlayer().getHeldItemMainhand()) ? ActionResultType.SUCCESS : ActionResultType.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        boolean result = soakUp(world, player.getPosition(), player, player.getHeldItemMainhand());
        return result ? ActionResult.resultSuccess(player.getHeldItemMainhand()) : ActionResult.resultFail(player.getHeldItemMainhand());
    }

    private boolean soakUp(World world, BlockPos pos, PlayerEntity player, ItemStack stack) {
        boolean absorbedAnything = false;
        boolean hitLava = false;
        int damage = stack.getDamage();

        for (int x = -getRange(); x <= getRange(); x++) {
            for (int y = -getRange(); y <= getRange(); y++) {
                for (int z = -getRange(); z <= getRange(); z++) {
                    final BlockPos targetPos = pos.add(x, y, z);
                    final BlockState state = world.getBlockState(targetPos);
                    Material material = world.getBlockState(targetPos).getMaterial();
                    if (material.isLiquid()) {
                        absorbedAnything = true;
                        hitLava |= material == Material.LAVA;
                        world.setBlockState(targetPos, Blocks.AIR.getDefaultState());
                        if (!isPowered() && ++damage >= getDmg()) break;
                        else if (isPowered() && EnergyHelper.getEnergyStored(stack) < getPerRightClickUse()) break;
                    } else if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.get(BlockStateProperties.WATERLOGGED)) {
                        absorbedAnything = true;
                        hitLava = false;
                        world.setBlockState(targetPos, state.with(BlockStateProperties.WATERLOGGED, false));
                        if (!isPowered() && ++damage >= getDmg()) break;
                        else if (isPowered() && EnergyHelper.getEnergyStored(stack) < getPerRightClickUse()) break;
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
            if (!player.isCreative()) {
                if (isPowered()) {
                    if (EnergyHelper.getEnergyStored(stack) >= getPerRightClickUse()) {
                        NBTHelper.setInt(stack, StringHelper.ENERGY_NBT, EnergyHelper.getEnergyStored(stack) - getPerRightClickUse());
                    }
                } else {
                    if (damage >= getDmg()) {
                        stack.setCount(0);
                    }
                    stack.setDamage(damage);
                }
            }
            return true;
        }

        return false;
    }

}
