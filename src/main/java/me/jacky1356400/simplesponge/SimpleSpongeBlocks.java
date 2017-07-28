package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.block.*;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SimpleSpongeBlocks {

    public static BlockSponge sponge;
    public static BlockMagmaticSponge magmaticSponge;

    public static void init(){
        sponge = GameRegistry.register(new BlockSponge());
        GameRegistry.register(new ItemBlock(sponge), sponge.getRegistryName());
        magmaticSponge = GameRegistry.register(new BlockMagmaticSponge());
        GameRegistry.register(new ItemBlock(magmaticSponge), magmaticSponge.getRegistryName());
    }

    public static void initModels(){
        sponge.initModel();
        magmaticSponge.initModel();
    }

}
