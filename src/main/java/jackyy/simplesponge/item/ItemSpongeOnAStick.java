package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;

public class ItemSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemSpongeOnAStick() {
        super(new Properties().durability(512));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.spongeOnAStickRange.get();
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

    @Override
    public boolean isPowered() {
        return false;
    }

}
