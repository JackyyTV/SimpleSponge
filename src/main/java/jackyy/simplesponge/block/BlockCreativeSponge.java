package jackyy.simplesponge.block;

import jackyy.simplesponge.registry.ModConfigs;

public class BlockCreativeSponge extends BlockSpongeBase {

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.creativeSpongeRange.get();
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

}
