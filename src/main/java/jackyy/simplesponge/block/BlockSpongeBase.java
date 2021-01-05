package jackyy.simplesponge.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockSpongeBase extends Block {

    private static final int TICK_RATE = 20;
    private static final Random RANDOM = new Random();

    public BlockSpongeBase() {
        super(Properties.create(Material.SPONGE).sound(SoundType.CLOTH).tickRandomly().hardnessAndResistance(0.3f));
    }

    public boolean isMagmatic() {
        return this.isMagmatic();
    }

    public int getRange() {
        return this.getRange();
    }

    @Override @Deprecated
    public boolean eventReceived(BlockState state, World world, BlockPos pos, int id, int param) {
        if (world.isRemote) {
            for (int i = 0; i < 20; i++) {
                double px = pos.getX() + RANDOM.nextDouble() * 0.1;
                double py = pos.getY() + 1.0 + RANDOM.nextDouble();
                double pz = pos.getZ() + RANDOM.nextDouble();
                world.addParticle(ParticleTypes.LARGE_SMOKE, px, py, pz, 0.0D, 0.0D, 0.0D);
            }
        } else {
            world.setBlockState(pos, Blocks.FIRE.getDefaultState());
        }
        return true;
    }

    @Override @Deprecated
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        clearupLiquid(world, pos);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        clearupLiquid(world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, TICK_RATE + RANDOM.nextInt(5));
    }

    @Override @Deprecated
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        clearupLiquid(world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, TICK_RATE + RANDOM.nextInt(5));
    }

    private void clearupLiquid(World world, BlockPos pos) {
        if (world.isRemote()) return;
        boolean hitLava = false;
        for (int dx = -getRange(); dx <= getRange(); dx++) {
            for (int dy = -getRange(); dy <= getRange(); dy++) {
                for (int dz = -getRange(); dz <= getRange(); dz++) {
                    final BlockPos workPos = pos.add(dx, dy, dz);
                    final BlockState state = world.getBlockState(workPos);
                    Material material = state.getMaterial();
                    if (material.isLiquid()) {
                        hitLava |= material == Material.LAVA;
                        world.setBlockState(workPos, Blocks.AIR.getDefaultState());
                    } else if (state.hasProperty(BlockStateProperties.WATERLOGGED) && state.get(BlockStateProperties.WATERLOGGED)) {
                        world.setBlockState(workPos, state.with(BlockStateProperties.WATERLOGGED, false));
                    }
                }
            }
        }
        if (hitLava && !isMagmatic()) world.addBlockEvent(pos, this, 0, 0);
    }

}
