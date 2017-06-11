package me.jacky1356400.simplesponge;

import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.client.util.RecipeBookClient;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class Recipes {

    private static List<RecipeList> recipes = RecipeBookClient.field_194086_e.get(CreativeTabs.TOOLS);
    private static RecipeList list = new RecipeList();

    public static void init(){
        ItemStack W = new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE);
        ItemStack M = new ItemStack(Items.MAGMA_CREAM);
        Item S = Item.getItemFromBlock(SimpleSpongeBlocks.sponge);
        Item MS = Item.getItemFromBlock(SimpleSpongeBlocks.magmaticSponge);
        String T = "stickWood";
        String B = "slimeball";
        list.func_192709_a(RecipeHelper.addShapeless(SimpleSpongeBlocks.sponge,
                new Object[] {W, B}));
        list.func_192709_a(RecipeHelper.addShaped(SimpleSpongeItems.spongeOnAStick, 3, 3,
                new Object[] {null, S, null, null, T, null, null, T, null}));
        list.func_192709_a(RecipeHelper.addShapeless(SimpleSpongeBlocks.magmaticSponge,
                new Object[] {S, M}));
        list.func_192709_a(RecipeHelper.addShaped(SimpleSpongeItems.magmaticSpongeOnAStick, 3, 3,
                new Object[] {null, MS, null, null, T, null, null, T, null}));

        // Keep this last
        recipes.add(list);
    }

}
