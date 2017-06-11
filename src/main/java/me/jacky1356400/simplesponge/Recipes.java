package me.jacky1356400.simplesponge;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class Recipes {

    public static void init(){
        Block W = Blocks.WOOL;
        Item S = Item.getItemFromBlock(SimpleSpongeBlocks.sponge);
        String T = "stickWood";
        String B = "slimeball";
        RecipeHelper.addShapeless(SimpleSpongeBlocks.sponge,
                new Object[] {W, B});
        RecipeHelper.addShaped(SimpleSpongeItems.spongeOnAStick, 3, 3,
                new Object[] {null, S, null, null, T, null, null, T, null});
    }

}
