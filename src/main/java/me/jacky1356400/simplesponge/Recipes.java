package me.jacky1356400.simplesponge;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Created by Admin on 04/06/2017.
 */
public class Recipes {

    public static void init(){
        ShapelessOreRecipe spongeRecipe = new ShapelessOreRecipe(new ItemStack(SimpleSpongeBlocks.sponge), Blocks.WOOL, "slimeball");
        GameRegistry.addRecipe(spongeRecipe);
        GameRegistry.addShapedRecipe(new ItemStack(SimpleSpongeItems.spongeOnAStick), "  s", " w ", "w  ", 's', SimpleSpongeBlocks.sponge, 'w', Items.STICK);
    }

}
