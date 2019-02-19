package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;

public class ItemCompressedMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    private static int dmg;
    private static int range;
    static {
        try {
            dmg = ModConfigs.CONFIG.compressedMagmaticSpongeOnAStickMaxDamage.get();
            range = ModConfigs.CONFIG.compressedMagmaticSpongeOnAStickRange.get();
        } catch (NullPointerException e) {
            dmg = 256;
            range = 3;
        }
    }

    public ItemCompressedMagmaticSpongeOnAStick() {
        super(new Properties().defaultMaxDamage(dmg * 9));
        setRegistryName("compressed_magmatic_sponge_on_a_stick");
    }

    @Override
    public int getDmg() {
        return dmg * 9;
    }

    @Override
    public int getRange() {
        return range * 2;
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

}