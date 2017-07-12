package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.SimpleSpongeItems;
import me.jacky1356400.simplesponge.SimpleSponge;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SimpleSpongeTab extends CreativeTabs {

    public SimpleSpongeTab() {
        super(SimpleSponge.MODID);
    }
    @Override
    public ItemStack getTabIconItem(){
        return new ItemStack(SimpleSpongeItems.spongeOnAStick);
    }

}
