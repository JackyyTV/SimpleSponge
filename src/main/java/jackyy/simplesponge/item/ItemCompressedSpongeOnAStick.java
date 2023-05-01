package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;

public class ItemCompressedSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedSpongeOnAStick() {
        super(new Properties().durability(512 * 9));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.compressedSpongeOnAStickRange.get() * 2;
    }

    @Override
    public boolean isMagnetic() {
        return false;
    }

    @Override
    public boolean isPowered() {
        return false;
    }

}
