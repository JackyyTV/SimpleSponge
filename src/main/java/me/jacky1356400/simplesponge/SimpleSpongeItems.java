package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.item.ItemMagmaticSpongeOnAStick;
import me.jacky1356400.simplesponge.item.ItemSpongeOnAStick;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SimpleSpongeItems {

    public static ItemSpongeOnAStick spongeOnAStick;
    public static ItemMagmaticSpongeOnAStick magmaticSpongeOnAStick;

    public static void init(){
        spongeOnAStick = GameRegistry.register(new ItemSpongeOnAStick());
        magmaticSpongeOnAStick = GameRegistry.register(new ItemMagmaticSpongeOnAStick());
    }

    public static void initModels(){
        spongeOnAStick.initModel();
        magmaticSpongeOnAStick.initModel();
    }

}
