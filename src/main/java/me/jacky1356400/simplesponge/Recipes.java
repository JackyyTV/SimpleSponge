package me.jacky1356400.simplesponge;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

    public static void init(){
        ShapelessOreRecipe spongeRecipe = new ShapelessOreRecipe(new ItemStack(SimpleSpongeBlocks.sponge),
                new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE), "slimeball");
        GameRegistry.addRecipe(spongeRecipe);

        ShapedOreRecipe spongeOnAStickRecipe = new ShapedOreRecipe(new ItemStack(SimpleSpongeItems.spongeOnAStick),
                " s ", " w ", " w ", 's', SimpleSpongeBlocks.sponge, 'w', "stickWood");
        GameRegistry.addRecipe(spongeOnAStickRecipe);

        ShapelessOreRecipe magmaticSpongeRecipe = new ShapelessOreRecipe(new ItemStack(SimpleSpongeBlocks.magmaticSponge),
                new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE), Items.MAGMA_CREAM);
        GameRegistry.addRecipe(magmaticSpongeRecipe);

        ShapedOreRecipe magmaticSpongeOnAStickRecipe = new ShapedOreRecipe(new ItemStack(SimpleSpongeItems.magmaticSpongeOnAStick),
                " s ", " w ", " w ", 's', SimpleSpongeBlocks.magmaticSponge, 'w', "stickWood");
        GameRegistry.addRecipe(magmaticSpongeOnAStickRecipe);
    }

}
