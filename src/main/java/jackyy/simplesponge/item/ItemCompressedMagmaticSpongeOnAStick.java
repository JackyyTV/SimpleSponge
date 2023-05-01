package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;

public class ItemCompressedMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedMagmaticSpongeOnAStick() {
        super(new Properties().durability(1024 * 9));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.compressedMagmaticSpongeOnAStickRange.get() * 2;
    }

    @Override
    public boolean isMagnetic() {
        return true;
    }

    @Override
    public boolean isPowered() {
        return false;
    }

}
