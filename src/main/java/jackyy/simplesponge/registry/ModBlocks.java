package jackyy.simplesponge.registry;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.block.BlockCreativeSponge;
import jackyy.simplesponge.block.BlockMagmaticSponge;
import jackyy.simplesponge.block.BlockSponge;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SimpleSponge.MODID);

    public static final RegistryObject<Block> SPONGE = BLOCKS.register("sponge", BlockSponge::new);
    public static final RegistryObject<Block> MAGMATIC_SPONGE = BLOCKS.register("magmatic_sponge", BlockMagmaticSponge::new);
    public static final RegistryObject<Block> CREATIVE_SPONGE = BLOCKS.register("creative_sponge", BlockCreativeSponge::new);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
