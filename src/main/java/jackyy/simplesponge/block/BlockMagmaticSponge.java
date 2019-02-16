package jackyy.simplesponge.block;

public class BlockMagmaticSponge extends BlockSpongeBase {

    public BlockMagmaticSponge() {
        setRegistryName("magmatic_sponge");
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getRange() {
        //return ModConfig.magneticSponge.magmaticSpongeRange;
        return 1;
    }

}
