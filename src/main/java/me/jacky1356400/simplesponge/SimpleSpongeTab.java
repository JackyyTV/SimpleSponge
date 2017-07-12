package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.SimpleSpongeItems;
import me.jacky1356400.simplesponge.SimpleSponge;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SimpleSpongeTab extends CreativeTabs {

    public SimpleSpongeTab() {
        super(SimpleSponge.MODID);
    }
    @Override
    public Item getTabIconItem(){
        return SimpleSpongeItems.spongeOnAStick;
    }

}
