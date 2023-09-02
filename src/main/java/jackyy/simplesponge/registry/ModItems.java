package jackyy.simplesponge.registry;

import jackyy.simplesponge.item.*;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IRarity;
import net.minecraftforge.event.RegistryEvent;

public class ModItems {

    public static ItemSpongeOnAStick spongeOnAStick = new ItemSpongeOnAStick();
    public static ItemMagmaticSpongeOnAStick magmaticSpongeOnAStick = new ItemMagmaticSpongeOnAStick();
    public static ItemCreativeSpongeOnAStick creativeSpongeOnAStick = new ItemCreativeSpongeOnAStick();
    public static ItemEnergizedSpongeOnAStick energizedSpongeOnAStick = new ItemEnergizedSpongeOnAStick();
    public static ItemCompressedSpongeOnAStick compressedSpongeOnAStick = new ItemCompressedSpongeOnAStick();
    public static ItemCompressedMagmaticSpongeOnAStick compressedMagmaticSpongeOnAStick = new ItemCompressedMagmaticSpongeOnAStick();
    public static ItemCompressedCreativeSpongeOnAStick compressedCreativeSpongeOnAStick = new ItemCompressedCreativeSpongeOnAStick();

    public static void init(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(
                spongeOnAStick,
                magmaticSpongeOnAStick,
                creativeSpongeOnAStick,
                energizedSpongeOnAStick,
                compressedSpongeOnAStick,
                compressedMagmaticSpongeOnAStick,
                compressedCreativeSpongeOnAStick,
                new ItemBlock(ModBlocks.sponge).setRegistryName(ModBlocks.sponge.getRegistryName()),
                new ItemBlock(ModBlocks.magmaticSponge) {
                    @Override
                    public IRarity getForgeRarity(ItemStack stack) {
                        return EnumRarity.UNCOMMON;
                    }
                }.setRegistryName(ModBlocks.magmaticSponge.getRegistryName()),
                new ItemBlock(ModBlocks.creativeSponge) {
                    @Override
                    public IRarity getForgeRarity(ItemStack stack) {
                        return EnumRarity.EPIC;
                    }
                }.setRegistryName(ModBlocks.creativeSponge.getRegistryName())

        );
    }

    public static void initModels() {
        spongeOnAStick.initModel();
        magmaticSpongeOnAStick.initModel();
        creativeSpongeOnAStick.initModel();
        energizedSpongeOnAStick.initModel();
        compressedSpongeOnAStick.initModel();
        compressedMagmaticSpongeOnAStick.initModel();
        compressedCreativeSpongeOnAStick.initModel();
    }

}
