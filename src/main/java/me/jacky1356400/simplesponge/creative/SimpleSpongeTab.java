package me.jacky1356400.simplesponge.creative;

import me.jacky1356400.simplesponge.SimpleSponge;
import me.jacky1356400.simplesponge.SimpleSpongeItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SimpleSpongeTab {

    public static CreativeTabs spongeCreativeTab = new CreativeTabs("simplesponge"){
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem(){
            return SimpleSpongeItems.spongeOnAStick;
        }
    };

}
