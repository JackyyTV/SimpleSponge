package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;

public class ItemCompressedSpongeOnAStick extends ItemSpongeOnAStickBase {

    private static int dmg;
    private static int range;
    static {
        try {
            dmg = ModConfigs.CONFIG.compressedSpongeOnAStickMaxDamage.get();
            range = ModConfigs.CONFIG.compressedSpongeOnAStickRange.get();
        } catch (NullPointerException e) {
            dmg = 256;
            range = 3;
        }
    }

    public ItemCompressedSpongeOnAStick() {
        super(new Properties().defaultMaxDamage(dmg * 9));
        setRegistryName("compressed_sponge_on_a_stick");
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
        return false;
    }

}