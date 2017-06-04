package me.jacky1356400.simplesponge;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

    public static void init(){
        ShapelessOreRecipe spongeRecipe = new ShapelessOreRecipe(new ItemStack(SimpleSpongeBlocks.sponge), Blocks.WOOL, "slimeball");
        GameRegistry.addRecipe(spongeRecipe);
        ShapedOreRecipe spongeonastickRecipe = new ShapedOreRecipe(new ItemStack(SimpleSpongeItems.spongeOnAStick), " s ", " w ", " w ", 's', SimpleSpongeBlocks.sponge, 'w', "stickWood");
        GameRegistry.addRecipe(spongeonastickRecipe);
    }

}
