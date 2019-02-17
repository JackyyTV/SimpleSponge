package jackyy.simplesponge.item;

public class ItemCompressedMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedMagmaticSpongeOnAStick() {
        super(new Properties().defaultMaxDamage(1));
        setRegistryName("compressed_magmatic_sponge_on_a_stick");
    }

    @Override
    public int getDmg() {
        //return ModConfig.compressedSponge.compressedMagmaticSpongeOnAStickMaxDamage * 9;
        return 1;
    }

    @Override
    public int getRange() {
        //return ModConfig.compressedSponge.compressedMagmaticSpongeOnAStickRange * 2;
        return 1;
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

}