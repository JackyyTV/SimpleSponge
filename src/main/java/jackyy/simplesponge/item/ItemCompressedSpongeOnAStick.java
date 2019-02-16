package jackyy.simplesponge.item;

import net.minecraft.item.ItemStack;

public class ItemCompressedSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedSpongeOnAStick() {
        setRegistryName("compressed_sponge_on_a_stick");
        setDamage(new ItemStack(this), getDmg());
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