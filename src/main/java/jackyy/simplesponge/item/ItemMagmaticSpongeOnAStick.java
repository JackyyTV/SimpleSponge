package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.world.item.Rarity;

public class ItemMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemMagmaticSpongeOnAStick() {
        super(new Properties().durability(1024).rarity(Rarity.UNCOMMON));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.magmaticSpongeOnAStickRange.get();
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public boolean isPowered() {
        return false;
    }

}
