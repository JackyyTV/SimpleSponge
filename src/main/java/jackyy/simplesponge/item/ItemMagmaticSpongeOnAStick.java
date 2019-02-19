package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;

public class ItemMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    private static int dmg;
    private static int range;
    static {
        try {
            dmg = ModConfigs.CONFIG.magmaticSpongeOnAStickMaxDamage.get();
            range = ModConfigs.CONFIG.magmaticSpongeOnAStickRange.get();
        } catch (NullPointerException e) {
            dmg = 256;
            range = 3;
        }
    }

    public ItemMagmaticSpongeOnAStick() {
        super(new Properties().defaultMaxDamage(dmg));
        setRegistryName("magmatic_sponge_on_a_stick");
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getDmg() {
        return dmg;
    }

    @Override
    public int getRange() {
        return range;
    }

}
