package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class ItemMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemMagmaticSpongeOnAStick() {
        super(new Item.Properties().maxDamage(1024).rarity(Rarity.UNCOMMON));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.magmaticSpongeOnAStickRange.get();
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

}
