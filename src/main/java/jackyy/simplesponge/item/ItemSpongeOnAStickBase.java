package jackyy.simplesponge.item;

import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemSpongeOnAStickBase extends Item {

    public ItemSpongeOnAStickBase(Properties props) {
        super(props);
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

    @Override @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag advanced) {
        super.appendHoverText(stack, world, tooltip, advanced);
        if (!isPowered()){
            tooltip.add(
                    StringHelper.formatNumber(stack.getMaxDamage() - stack.getDamageValue())
                            .append(" / ")
                            .append(StringHelper.formatNumber(stack.getMaxDamage()))
                            .append(" ")
                            .append(Component.translatable("tooltip." + SimpleSponge.MODID + ".durability"))
            );
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return soakUp(context.getLevel(), context.getClickedPos(), context.getPlayer(), context.getItemInHand()) ? InteractionResult.SUCCESS : InteractionResult.FAIL;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        boolean result = soakUp(world, player.getOnPos(), player, player.getItemInHand(hand));
        return result ? InteractionResultHolder.pass(player.getItemInHand(hand)) : InteractionResultHolder.fail(player.getItemInHand(hand));
    }

    private boolean soakUp(Level world, BlockPos pos, Player player, ItemStack stack) {
        boolean succ = false;
        boolean hitLava = false;
        boolean allowHotLiquid = ModConfigs.CONFIG.regularSpongeAbsorbHotLiquid.get();
        int dmg = stack.getDamageValue();
        int maxDmg = stack.getMaxDamage();

        for (int x = -getRange(); x <= getRange(); x++) {
            for (int y = -getRange(); y <= getRange(); y++) {
                for (int z = -getRange(); z <= getRange(); z++) {
                    final BlockPos targetPos = pos.offset(x, y, z);
                    final BlockState state = world.getBlockState(targetPos);
                    Material material = world.getBlockState(targetPos).getMaterial();
                    if (material.isLiquid()) {
                        succ = true;
                        hitLava |= material == Material.LAVA;
                        if (hitLava && !isMagmatic() && !allowHotLiquid) break;
                        world.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 3);
                        if (!player.isCreative() && !isCreative()) {
                            if (!isPowered() && ++dmg >= maxDmg) break;
                            else if (isPowered() && EnergyHelper.getEnergyStored(stack) < getPerRightClickUse()) break;
                        }
                    } else if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getProperties().contains(BlockStateProperties.WATERLOGGED)) {
                        succ = true;
                        hitLava = false;
                        world.setBlock(targetPos, state.setValue(BlockStateProperties.WATERLOGGED, false), 3);
                        if (!player.isCreative() && !isCreative()) {
                            if (!isPowered() && ++dmg >= maxDmg) break;
                            else if (isPowered() && EnergyHelper.getEnergyStored(stack) < getPerRightClickUse()) break;
                        }
                    } else if (material == Material.WATER_PLANT || material == Material.REPLACEABLE_WATER_PLANT) {
                        succ = true;
                        hitLava = false;
                        BlockEntity tile = state.hasBlockEntity() ? world.getBlockEntity(targetPos) : null;
                        Block.dropResources(state, world, targetPos, tile);
                        world.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 3);
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
            player.setSecondsOnFire(6);
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
                    stack.setDamageValue(dmg);
                }
            }
            return true;
        }

        return false;
    }

}
