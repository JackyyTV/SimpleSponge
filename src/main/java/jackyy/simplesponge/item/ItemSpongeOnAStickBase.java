package jackyy.simplesponge.item;

import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
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

    public int getEnergy() {
        return this.getEnergy();
    }

    public int getPerRightClickUse() {
        return this.getPerRightClickUse();
    }

    public int getRange() {
        return this.getRange();
    }

    public boolean isMagmatic() {
        return this.isMagmatic();
    }

    public boolean isCreative() {
        return false;
    }

    public boolean isPowered() {
        return false;
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (!isPowered()){
            tooltip.add(
                    StringHelper.formatNumber(stack.getMaxDamage() - stack.getDamage())
                            .appendString(" / ")
                            .appendSibling(StringHelper.formatNumber(stack.getMaxDamage()))
                            .appendString(" ")
                            .appendSibling(new TranslationTextComponent("tooltip." + SimpleSponge.MODID + ".durability"))
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
        boolean succ = false;
        boolean hitLava = false;
        boolean allowHotLiquid = ModConfigs.CONFIG.regularSpongeAbsorbHotLiquid.get();
        int dmg = stack.getDamage();
        int maxDmg = stack.getMaxDamage();

        for (int x = -getRange(); x <= getRange(); x++) {
            for (int y = -getRange(); y <= getRange(); y++) {
                for (int z = -getRange(); z <= getRange(); z++) {
                    final BlockPos targetPos = pos.add(x, y, z);
                    final BlockState state = world.getBlockState(targetPos);
                    Material material = world.getBlockState(targetPos).getMaterial();
                    if (material.isLiquid()) {
                        succ = true;
                        hitLava |= material == Material.LAVA;
                        if (hitLava && !isMagmatic() && !allowHotLiquid) break;
                        world.setBlockState(targetPos, Blocks.AIR.getDefaultState());
                        if (!player.isCreative() && !isCreative()) {
                            if (!isPowered() && ++dmg >= maxDmg) break;
                            else if (isPowered() && EnergyHelper.getEnergyStored(stack) < getPerRightClickUse()) break;
                        }
                    } else if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.get(BlockStateProperties.WATERLOGGED)) {
                        succ = true;
                        hitLava = false;
                        world.setBlockState(targetPos, state.with(BlockStateProperties.WATERLOGGED, false));
                        if (!player.isCreative() && !isCreative()) {
                            if (!isPowered() && ++dmg >= maxDmg) break;
                            else if (isPowered() && EnergyHelper.getEnergyStored(stack) < getPerRightClickUse()) break;
                        }
                    } else if (material == Material.OCEAN_PLANT || material == Material.SEA_GRASS) {
                        succ = true;
                        hitLava = false;
                        TileEntity tile = state.hasTileEntity() ? world.getTileEntity(targetPos) : null;
                        Block.spawnDrops(state, world, targetPos, tile);
                        world.setBlockState(targetPos, Blocks.AIR.getDefaultState());
                        if (!player.isCreative() && !isCreative()) {
                            if (!isPowered() && ++dmg >= maxDmg) break;
                            else if (isPowered() && EnergyHelper.getEnergyStored(stack) < getPerRightClickUse()) break;
                        }
                    }
                }
            }
        }

        if (hitLava && !isMagmatic() && allowHotLiquid) {
            stack.setCount(0);
            player.setFire(6);
        }

        if (succ) {
            if (!player.isCreative() && !isCreative()) {
                if (isPowered()) {
                    if (EnergyHelper.getEnergyStored(stack) >= getPerRightClickUse()) {
                        NBTHelper.setInt(stack, EnergyHelper.ENERGY_NBT, EnergyHelper.getEnergyStored(stack) - getPerRightClickUse());
                    }
                } else {
                    if (dmg >= maxDmg) {
                        stack.setCount(0);
                    }
                    stack.setDamage(dmg);
                }
            }
            return true;
        }

        return false;
    }

}
