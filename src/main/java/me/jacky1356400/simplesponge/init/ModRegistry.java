package me.jacky1356400.simplesponge.init;

import me.jacky1356400.simplesponge.block.BlockMagmaticSponge;
import me.jacky1356400.simplesponge.block.BlockSponge;
import me.jacky1356400.simplesponge.item.ItemMagmaticSpongeOnAStick;
import me.jacky1356400.simplesponge.item.ItemSpongeOnAStick;
import me.jacky1356400.simplesponge.util.Data;
import me.jacky1356400.simplesponge.util.RecipeHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

public class ModRegistry {

    public static final Block SPONGE = new BlockSponge();
    public static final Block SPONGELAVA = new BlockMagmaticSponge();
    public static final Item SPONGESTICK = new ItemSpongeOnAStick();
    public static final Item SPONGESTICKLAVA = new ItemMagmaticSpongeOnAStick();

    @SuppressWarnings("deprecation")
    private static void initRecipes() {
        ItemStack W = new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE);
        String S = "slimeball";
        String T = "stickWood";
        Item M = Items.MAGMA_CREAM;
        Block SP = ModRegistry.SPONGE;
        Block SPL = ModRegistry.SPONGELAVA;
        RecipeHelper.addShapeless(SPONGE, W, S);
        RecipeHelper.addShapeless(SPONGELAVA, SP, M);
        RecipeHelper.addShaped(SPONGESTICK, 3, 3, null, SP, null, null, T, null, null, T, null);
        RecipeHelper.addShaped(SPONGESTICKLAVA, 3, 3, null, SPL, null, null, T, null, null, T, null);
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
