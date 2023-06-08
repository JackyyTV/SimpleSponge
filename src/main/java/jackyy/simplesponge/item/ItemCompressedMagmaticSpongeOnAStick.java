package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.item.Rarity;

public class ItemCompressedMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedMagmaticSpongeOnAStick() {
        super(new Properties().maxDamage(1024 * 9).rarity(Rarity.UNCOMMON));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.compressedMagmaticSpongeOnAStickRange.get() * 2;
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
