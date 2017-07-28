package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.item.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SimpleSpongeItems {

    public static ItemSpongeOnAStick spongeOnAStick;
    public static ItemMagmaticSpongeOnAStick magmaticSpongeOnAStick;
    public static ItemEnergizedSpongeOnAStick energizedSpongeOnAStick;
    public static ItemCompressedSpongeOnAStick compressedSpongeOnAStick;
    public static ItemCompressedMagmaticSpongeOnAStick compressedMagmaticSpongeOnAStick;

    public static void init(){
        spongeOnAStick = GameRegistry.register(new ItemSpongeOnAStick());
        magmaticSpongeOnAStick = GameRegistry.register(new ItemMagmaticSpongeOnAStick());
        energizedSpongeOnAStick = GameRegistry.register(new ItemEnergizedSpongeOnAStick());
        compressedSpongeOnAStick = GameRegistry.register(new ItemCompressedSpongeOnAStick());
        compressedMagmaticSpongeOnAStick = GameRegistry.register(new ItemCompressedMagmaticSpongeOnAStick());
    }

    public static void initModels(){
        spongeOnAStick.initModel();
        magmaticSpongeOnAStick.initModel();
        energizedSpongeOnAStick.initModel();
        compressedSpongeOnAStick.initModel();
        compressedMagmaticSpongeOnAStick.initModel();
    }

}
