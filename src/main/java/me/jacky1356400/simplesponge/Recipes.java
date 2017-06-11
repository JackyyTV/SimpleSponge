package me.jacky1356400.simplesponge;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes {

    public static void init(){
        ItemStack W = new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE);
        Item S = Item.getItemFromBlock(SimpleSpongeBlocks.sponge);
        String T = "stickWood";
        String B = "slimeball";
        RecipeHelper.addShapeless(SimpleSpongeBlocks.sponge,
                new Object[] {W, B});
        RecipeHelper.addShaped(SimpleSpongeItems.spongeOnAStick, 3, 3,
                new Object[] {null, S, null, null, T, null, null, T, null});
    }

}
