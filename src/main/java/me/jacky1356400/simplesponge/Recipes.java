package me.jacky1356400.simplesponge;

import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes {

    private static RecipeList list = new RecipeList();

    private static int id = 0;

    public static void init(){
        ItemStack W = new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE);
        ItemStack M = new ItemStack(Items.MAGMA_CREAM);
        Item S = Item.getItemFromBlock(SimpleSpongeBlocks.sponge);
        Item MS = Item.getItemFromBlock(SimpleSpongeBlocks.magmaticSponge);
        String T = "stickWood";
        String B = "slimeball";
        CraftingManager.REGISTRY.register(id++, new ResourceLocation(SimpleSponge.MODID + ":recipe" + id),
                RecipeHelper.getShapeless(SimpleSpongeBlocks.sponge, new Object[] {W, B}));
        CraftingManager.REGISTRY.register(id++, new ResourceLocation(SimpleSponge.MODID + ":recipe" + id),
                RecipeHelper.getShapeless(SimpleSpongeBlocks.magmaticSponge, new Object[] {S, M}));
        CraftingManager.REGISTRY.register(id++, new ResourceLocation(SimpleSponge.MODID + ":recipe" + id),
                RecipeHelper.getShaped(new ItemStack(SimpleSpongeItems.spongeOnAStick, 1, 0),
                        3, 3, new Object[] {null, S, null, null, T, null, null, T, null}));
        CraftingManager.REGISTRY.register(id++, new ResourceLocation(SimpleSponge.MODID + ":recipe" + id),
                RecipeHelper.getShaped(new ItemStack(SimpleSpongeItems.magmaticSpongeOnAStick,1, 0),
                        3, 3, new Object[] {null, MS, null, null, T, null, null, T, null}));
    }

}
