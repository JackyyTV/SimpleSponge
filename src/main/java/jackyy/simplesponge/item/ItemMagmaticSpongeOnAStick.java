package jackyy.simplesponge.item;

public class ItemMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemMagmaticSpongeOnAStick() {
        super(new Properties().defaultMaxDamage(1));
        setRegistryName("magmatic_sponge_on_a_stick");
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getDmg() {
        //return ModConfig.magneticSponge.magmaticSpongeOnAStickMaxDamage;
        return 1;
    }

    @Override
    public int getRange() {
        //return ModConfig.magneticSponge.magmaticSpongeOnAStickRange;
        return 1;
    }

}
