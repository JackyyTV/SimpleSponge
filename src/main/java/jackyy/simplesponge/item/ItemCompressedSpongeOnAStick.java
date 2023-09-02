package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.item.Rarity;

public class ItemCompressedSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedSpongeOnAStick() {
        super(new Properties().maxDamage(512 * 9).rarity(Rarity.UNCOMMON));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.compressedSpongeOnAStickRange.get() * 2;
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

}
