package jackyy.simplesponge.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Particles;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSpongeBase extends Block {

    private static final int TICK_RATE = 20;
    private static final Random RANDOM = new Random();

    public BlockSpongeBase() {
        super(Properties.create(Material.SPONGE).sound(SoundType.CLOTH).tickRandomly().hardnessAndResistance(0.3f));
    }

    @Override
    public int tickRate(IWorldReaderBase world) {
        return TICK_RATE;
    }

    public boolean isMagmatic() {
        return this.isMagmatic();
    }

    public int getRange() {
        return this.getRange();
    }

    @Override @Deprecated
    public boolean eventReceived(IBlockState state, World world, BlockPos pos, int id, int param) {
        if (world.isRemote) {
            for (int i = 0; i < 20; i++) {
                double px = pos.getX() + RANDOM.nextDouble() * 0.1;
                double py = pos.getY() + 1.0 + RANDOM.nextDouble();
                double pz = pos.getZ() + RANDOM.nextDouble();
                world.addParticle(Particles.LARGE_SMOKE, px, py, pz, 0.0D, 0.0D, 0.0D);
            }
        } else {
            world.setBlockState(pos, Blocks.FIRE.getDefaultState());
        }
        return true;
    }

    @Override @Deprecated
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
        clearupLiquid(world, pos);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        clearupLiquid(world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, TICK_RATE + RANDOM.nextInt(5));
    }

    @Override @Deprecated
    public void tick(IBlockState state, World world, BlockPos pos, Random random) {
        clearupLiquid(world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, TICK_RATE + RANDOM.nextInt(5));
    }

    private void clearupLiquid(World world, BlockPos pos) {
        if (world.isRemote) return;
        boolean hitLava = false;
        for (int dx = -getRange(); dx <= getRange(); dx++) {
            for (int dy = -getRange(); dy <= getRange(); dy++) {
                for (int dz = -getRange(); dz <= getRange(); dz++) {
                    final BlockPos workPos = pos.add(dx, dy, dz);
                    final IBlockState state = world.getBlockState(workPos);
                    Material material = state.getMaterial();
                    if (material.isLiquid()) {
                        hitLava |= material == Material.LAVA;
                        world.setBlockState(workPos, Blocks.AIR.getDefaultState());
                    } else if (state.has(BlockStateProperties.WATERLOGGED) && state.get(BlockStateProperties.WATERLOGGED)) {
                        world.setBlockState(workPos, state.with(BlockStateProperties.WATERLOGGED, false));
                    }
                }
            }
        }
        if (hitLava && !isMagmatic()) world.addBlockEvent(pos, this, 0, 0);
    }

}
