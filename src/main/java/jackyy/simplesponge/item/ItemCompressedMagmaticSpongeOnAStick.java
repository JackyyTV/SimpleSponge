package jackyy.simplesponge.item;

import net.minecraft.item.ItemStack;

public class ItemCompressedMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedMagmaticSpongeOnAStick() {
        setRegistryName("compressed_magmatic_sponge_on_a_stick");
        setDamage(new ItemStack(this), getDmg());
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