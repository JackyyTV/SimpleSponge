package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;

public class ItemMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemMagmaticSpongeOnAStick() {
        super(new Properties().durability(1024));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.magmaticSpongeOnAStickRange.get();
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
