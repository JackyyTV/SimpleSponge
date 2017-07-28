package me.jacky1356400.simplesponge.init;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.block.BlockMagmaticSponge;
import me.jacky1356400.simplesponge.block.BlockSponge;
import me.jacky1356400.simplesponge.item.*;
import me.jacky1356400.simplesponge.util.Data;
import me.jacky1356400.simplesponge.util.RecipeHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

public class ModRegistry {

    public static final Block SPONGE = new BlockSponge();
    public static final Block SPONGELAVA = new BlockMagmaticSponge();
    public static final Item SPONGESTICK = new ItemSpongeOnAStick();
    public static final Item SPONGESTICKLAVA = new ItemMagmaticSpongeOnAStick();
    public static final Item COMPSPONGESTICK = new ItemCompressedSpongeOnAStick();
    public static final Item COMPSPONGESTICKLAVA = new ItemCompressedMagmaticSpongeOnAStick();
    public static final Item ENSPONGESTICK = new ItemEnergizedSpongeOnAStick();
    public static final Item SPONGEOB = Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge"));
    public static final Item SPONGESTICKOB = Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick"));

    private static void initRecipes() {
        if (Loader.isModLoaded("openblocks")) {
            if (Config.openBlocksIntegration) {
                RecipeHelper.addShapeless(SPONGELAVA, SPONGEOB, Items.MAGMA_CREAM);
                RecipeHelper.addShaped(COMPSPONGESTICK, 3, 3, SPONGESTICKOB, SPONGESTICKOB, SPONGESTICKOB, SPONGESTICKOB, SPONGESTICKOB, SPONGESTICKOB, SPONGESTICKOB, SPONGESTICKOB, SPONGESTICKOB);
            } else {
                RecipeHelper.addShapeless(SPONGE, new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE), "slimeball");
                RecipeHelper.addShaped(SPONGESTICK, 3, 3, null, SPONGE, null, null, "stickWood", null, null, "stickWood", null);
                RecipeHelper.addShaped(COMPSPONGESTICK, 3, 3, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK);
                RecipeHelper.addShapeless(SPONGELAVA, ModRegistry.SPONGE, Items.MAGMA_CREAM);
            }
        } else {
            RecipeHelper.addShapeless(SPONGE, new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE), "slimeball");
            RecipeHelper.addShaped(SPONGESTICK, 3, 3, null, SPONGE, null, null, "stickWood", null, null, "stickWood", null);
            RecipeHelper.addShaped(COMPSPONGESTICK, 3, 3, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK, SPONGESTICK);
            RecipeHelper.addShapeless(SPONGELAVA, ModRegistry.SPONGE, Items.MAGMA_CREAM);
        }
        RecipeHelper.addShaped(SPONGESTICKLAVA, 3, 3, null, ModRegistry.SPONGELAVA, null, null, "stickWood", null, null, "stickWood", null);
        RecipeHelper.addShaped(COMPSPONGESTICKLAVA, 3, 3, SPONGESTICKLAVA, SPONGESTICKLAVA, SPONGESTICKLAVA, SPONGESTICKLAVA, SPONGESTICKLAVA, SPONGESTICKLAVA, SPONGESTICKLAVA, SPONGESTICKLAVA, SPONGESTICKLAVA);
        RecipeHelper.addShaped(ENSPONGESTICK, 3, 3, null, ModRegistry.SPONGESTICKLAVA, null, null, Items.BLAZE_ROD, null, null, "blockRedstone", null);
    }

    @SubscribeEvent
    public void onBlockRegistry(RegistryEvent.Register<Block> e) {
        e.getRegistry().registerAll(Data.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(Data.ITEMS.toArray(new Item[0]));
        for (Block block : Data.BLOCKS)
            e.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SubscribeEvent
    public void onRecipeRegistry(RegistryEvent.Register<IRecipe> e) {
        initRecipes();
        e.getRegistry().registerAll(Data.RECIPES.toArray(new IRecipe[0]));
    }

}
