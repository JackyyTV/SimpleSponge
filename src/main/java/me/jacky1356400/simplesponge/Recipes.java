package me.jacky1356400.simplesponge;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes {

    private static int id = 0;

    public static void init(){
        ItemStack W = new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE);
        ItemStack M = new ItemStack(Items.MAGMA_CREAM);
        Item S = Item.getItemFromBlock(SimpleSpongeBlocks.sponge);
        Item MS = Item.getItemFromBlock(SimpleSpongeBlocks.magmaticSponge);
        String T = "stickWood";
        String B = "slimeball";
        // THESE RECIPES ARE NOW JSONIFIED
    }

}
