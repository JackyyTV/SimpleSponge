package jackyy.simplesponge.block;

import jackyy.simplesponge.registry.ModConfigs;

public class BlockMagmaticSponge extends BlockSpongeBase {

    private static int range;
    static {
        try {
            range = ModConfigs.CONFIG.magmaticSpongeRange.get();
        } catch (NullPointerException e) {
            range = 3;
        }
    }

    public BlockMagmaticSponge() {
        setRegistryName("magmatic_sponge");
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getRange() {
        return range;
    }

}
