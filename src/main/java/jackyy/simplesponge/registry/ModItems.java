package jackyy.simplesponge.registry;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.item.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimpleSponge.MODID);

    public static final RegistryObject<Item> SPONGE_ON_A_STICK
            = ITEMS.register("sponge_on_a_stick", ItemSpongeOnAStick::new);
    public static final RegistryObject<Item> MAGMATIC_SPONGE_ON_A_STICK
            = ITEMS.register("magmatic_sponge_on_a_stick", ItemMagmaticSpongeOnAStick::new);
    public static final RegistryObject<Item> ENERGIZED_SPONGE_ON_A_STICK
            = ITEMS.register("energized_sponge_on_a_stick", ItemEnergizedSpongeOnAStick::new);
    public static final RegistryObject<Item> COMPRESSED_SPONGE_ON_A_STICK
            = ITEMS.register("compressed_sponge_on_a_stick", ItemCompressedSpongeOnAStick::new);
    public static final RegistryObject<Item> COMPRESSED_MAGMATIC_SPONGE_ON_A_STICK
            = ITEMS.register("compressed_magmatic_sponge_on_a_stick", ItemCompressedMagmaticSpongeOnAStick::new);

    public static final RegistryObject<Item> SPONGE_BLOCK_ITEM
            = ITEMS.register("sponge", () -> new BlockItem(ModBlocks.SPONGE.get(), new Item.Properties().group(SimpleSponge.TAB)));
    public static final RegistryObject<Item> MAGMATIC_SPONGE_BLOCK_ITEM
            = ITEMS.register("magmatic_sponge", () -> new BlockItem(ModBlocks.MAGMATIC_SPONGE.get(), new Item.Properties().group(SimpleSponge.TAB)));

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
