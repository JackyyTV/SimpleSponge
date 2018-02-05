package jackyy.simplesponge.registry;

import jackyy.simplesponge.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public class ModItems {

    public static ItemSpongeOnAStick spongeOnAStick = new ItemSpongeOnAStick();
    public static ItemMagmaticSpongeOnAStick magmaticSpongeOnAStick = new ItemMagmaticSpongeOnAStick();
    public static ItemEnergizedSpongeOnAStick energizedSpongeOnAStick = new ItemEnergizedSpongeOnAStick();
    public static ItemCompressedSpongeOnAStick compressedSpongeOnAStick = new ItemCompressedSpongeOnAStick();
    public static ItemCompressedMagmaticSpongeOnAStick compressedMagmaticSpongeOnAStick = new ItemCompressedMagmaticSpongeOnAStick();

    public static void init(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(
                spongeOnAStick,
                magmaticSpongeOnAStick,
                energizedSpongeOnAStick,
                compressedSpongeOnAStick,
                compressedMagmaticSpongeOnAStick,
                new ItemBlock(ModBlocks.sponge).setRegistryName(ModBlocks.sponge.getRegistryName()),
                new ItemBlock(ModBlocks.magmaticSponge).setRegistryName(ModBlocks.magmaticSponge.getRegistryName())
        );
    }

    public static void initModels() {
        spongeOnAStick.initModel();
        magmaticSpongeOnAStick.initModel();
        energizedSpongeOnAStick.initModel();
        compressedSpongeOnAStick.initModel();
        compressedMagmaticSpongeOnAStick.initModel();
    }

}
