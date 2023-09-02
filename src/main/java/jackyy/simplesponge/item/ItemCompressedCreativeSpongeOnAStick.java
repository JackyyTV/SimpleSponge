package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.item.Rarity;

public class ItemCompressedCreativeSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedCreativeSpongeOnAStick() {
        super(new Properties().maxDamage(9001).rarity(Rarity.EPIC));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.compressedCreativeSpongeOnAStickRange.get() * 2;
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
