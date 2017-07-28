package me.jacky1356400.simplesponge;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

    public static void init(){
        if (!Loader.isModLoaded("openblocks") && Config.openBlocksIntegration) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SimpleSpongeBlocks.sponge), new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE), "slimeball"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SimpleSpongeItems.spongeOnAStick), " s ", " w ", " w ", 's', SimpleSpongeBlocks.sponge, 'w', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SimpleSpongeItems.compressedSpongeOnAStick), "sss", "sss", "sss", 's', SimpleSpongeItems.spongeOnAStick));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SimpleSpongeBlocks.magmaticSponge), SimpleSpongeBlocks.sponge, Items.MAGMA_CREAM));
        } else {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SimpleSpongeBlocks.magmaticSponge), Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge")), Items.MAGMA_CREAM));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SimpleSpongeItems.compressedSpongeOnAStick), "sss", "sss", "sss", 's', Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick"))));
        }

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SimpleSpongeItems.magmaticSpongeOnAStick), " s ", " w ", " w ", 's', SimpleSpongeBlocks.magmaticSponge, 'w', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SimpleSpongeItems.compressedMagmaticSpongeOnAStick), "sss", "sss", "sss", 's', SimpleSpongeItems.magmaticSpongeOnAStick));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SimpleSpongeItems.energizedSpongeOnAStick), " s ", " b ", " r ", 's', SimpleSpongeItems.magmaticSpongeOnAStick, 'b', Items.BLAZE_ROD, 'r', "blockRedstone"));
    }

}
