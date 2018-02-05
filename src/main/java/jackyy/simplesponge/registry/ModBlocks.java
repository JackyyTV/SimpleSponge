package jackyy.simplesponge.registry;

import jackyy.simplesponge.block.BlockMagmaticSponge;
import jackyy.simplesponge.block.BlockSponge;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static BlockSponge sponge;
    public static BlockMagmaticSponge magmaticSponge;

    public static void init() {
        sponge = GameRegistry.register(new BlockSponge());
        GameRegistry.register(new ItemBlock(sponge), sponge.getRegistryName());
        magmaticSponge = GameRegistry.register(new BlockMagmaticSponge());
        GameRegistry.register(new ItemBlock(magmaticSponge), magmaticSponge.getRegistryName());
    }

    public static void initModels() {
        sponge.initModel();
        magmaticSponge.initModel();
    }

}
