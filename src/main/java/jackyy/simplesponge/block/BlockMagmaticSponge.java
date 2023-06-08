package jackyy.simplesponge.block;

import jackyy.simplesponge.registry.ModConfigs;

public class BlockMagmaticSponge extends BlockSpongeBase {

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.magmaticSpongeRange.get();
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

}
