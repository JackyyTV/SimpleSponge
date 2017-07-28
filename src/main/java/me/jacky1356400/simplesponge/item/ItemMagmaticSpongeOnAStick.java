package me.jacky1356400.simplesponge.item;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.util.Data;

public class ItemMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemMagmaticSpongeOnAStick(){
        setRegistryName(Data.MODID + ":magmatic_sponge_on_a_stick");
        setUnlocalizedName(Data.MODID + ".magmatic_sponge_on_a_stick");
        setMaxDamage(Config.magmaticSpongeOnAStickMaxDamage);
        setCreativeTab(Data.TAB);
        Data.ITEMS.add(this);
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getDmg() {
        return Config.magmaticSpongeOnAStickMaxDamage;
    }

    @Override
    public int getRange() {
        return Config.magmaticSpongeOnAStickRange;
    }

}
