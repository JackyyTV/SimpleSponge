package jackyy.simplesponge.block;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class BlockSpongeBase extends Block {

    private static final int TICK_RATE = 20;
    private static final Random RANDOM = new Random();

    public BlockSpongeBase() {
        super(Properties.of(Material.SPONGE).sound(SoundType.WOOL).randomTicks().strength(0.3f));
    }

    public int getRange() {
        return this.getRange();
    }

    public boolean isMagnetic() {
        return this.isMagnetic();
    }

    @Override @Deprecated
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int id, int param) {
        if (world.isClientSide()) {
            for (int i = 0; i < 20; i++) {
                double px = pos.getX() + RANDOM.nextDouble() * 0.1;
                double py = pos.getY() + 1.0 + RANDOM.nextDouble();
                double pz = pos.getZ() + RANDOM.nextDouble();
                world.addParticle(ParticleTypes.LARGE_SMOKE, px, py, pz, 0.0D, 0.0D, 0.0D);
            }
        } else {
            world.setBlock(pos, Blocks.FIRE.defaultBlockState(), 3);
        }
        return true;
    }

    @Override @Deprecated
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        clearupLiquid(world, pos);
    }

    @Override @Deprecated
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState state2, boolean bool) {
        clearupLiquid(world, pos);
        world.scheduleTick(pos, this, TICK_RATE + RANDOM.nextInt(5));
    }

    @Override @Deprecated
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource rand) {
        clearupLiquid(world, pos);
        world.scheduleTick(pos, this, TICK_RATE + RANDOM.nextInt(5));
    }

    private void clearupLiquid(Level world, BlockPos pos) {
        if (world.isClientSide()) return;
        boolean hitLava = false;
        boolean allowHotLiquid = ModConfigs.CONFIG.regularSpongeAbsorbHotLiquid.get();
        for (int dx = -getRange(); dx <= getRange(); dx++) {
            for (int dy = -getRange(); dy <= getRange(); dy++) {
                for (int dz = -getRange(); dz <= getRange(); dz++) {
                    final BlockPos workPos = pos.offset(dx, dy, dz);
                    final BlockState state = world.getBlockState(workPos);
                    Material material = state.getMaterial();
                    if (material.isLiquid()) {
                        hitLava |= material == Material.LAVA;
                        if (hitLava && !allowHotLiquid) break;
                        world.setBlock(workPos, Blocks.AIR.defaultBlockState(), 3);
                    } else if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getProperties().contains(BlockStateProperties.WATERLOGGED)) {
                        world.setBlock(workPos, state.setValue(BlockStateProperties.WATERLOGGED, false), 3);
                    } else if (material == Material.WATER_PLANT || material == Material.REPLACEABLE_WATER_PLANT) {
                        BlockEntity tile = state.hasBlockEntity() ? world.getBlockEntity(workPos) : null;
                        dropResources(state, world, workPos, tile);
                        world.setBlock(workPos, Blocks.AIR.defaultBlockState(), 3);
                    }
                }
            }
        }
        if (hitLava && !isMagnetic() && allowHotLiquid) world.blockEvent(pos, this, 0, 0);
    }

}
