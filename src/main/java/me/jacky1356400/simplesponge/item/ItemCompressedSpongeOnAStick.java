package me.jacky1356400.simplesponge.item;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.util.Data;

public class ItemCompressedSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedSpongeOnAStick(){
        setRegistryName(Data.MODID + ":compressed_sponge_on_a_stick");
        setUnlocalizedName(Data.MODID + ".compressed_sponge_on_a_stick");
        setMaxDamage(getDmg());
        setCreativeTab(Data.TAB);
        Data.ITEMS.add(this);
    }

    @Override
    public int getDmg() {
        return Config.compressedSpongeOnAStickMaxDamage * 9;
    }

    @Override
    public int getRange() {
        return Config.compressedSpongeOnAStickRange * 2;
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

}