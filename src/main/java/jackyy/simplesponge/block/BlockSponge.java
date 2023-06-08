package jackyy.simplesponge.block;

import jackyy.simplesponge.registry.ModConfigs;

public class BlockSponge extends BlockSpongeBase {

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.spongeRange.get();
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

}
