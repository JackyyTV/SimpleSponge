package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.world.item.Rarity;

public class ItemCreativeSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCreativeSpongeOnAStick() {
        super(new Properties().durability(9001).rarity(Rarity.EPIC));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.creativeSpongeRange.get();
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public boolean isCreative() {
        return true;
    }

}
