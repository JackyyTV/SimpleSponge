package jackyy.simplesponge.registry;

import jackyy.simplesponge.block.BlockMagmaticSponge;
import jackyy.simplesponge.block.BlockSponge;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

public class ModBlocks {

    public static BlockSponge sponge = new BlockSponge();
    public static BlockMagmaticSponge magmaticSponge = new BlockMagmaticSponge();

    public static void init(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                sponge,
                magmaticSponge
        );
    }

}
