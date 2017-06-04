package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.block.BlockSponge;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Admin on 04/06/2017.
 */
public class SimpleSpongeBlocks {

    public static BlockSponge sponge;

    public static void init(){
        sponge = GameRegistry.register(new BlockSponge());
        GameRegistry.register(new ItemBlock(sponge), sponge.getRegistryName());
    }

    public static void initModels(){
        sponge.initModel();
    }

}
