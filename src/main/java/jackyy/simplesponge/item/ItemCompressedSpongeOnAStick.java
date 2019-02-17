package jackyy.simplesponge.item;

public class ItemCompressedSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedSpongeOnAStick() {
        super(new Properties().defaultMaxDamage(1));
        setRegistryName("compressed_sponge_on_a_stick");
    }

    @Override
    public int getDmg() {
        //return ModConfig.compressedSponge.compressedSpongeOnAStickMaxDamage * 9;
        return 1;
    }

    @Override
    public int getRange() {
        //return ModConfig.compressedSponge.compressedSpongeOnAStickRange * 2;
        return 1;
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

}