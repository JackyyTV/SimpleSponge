package jacky1356400.simplesponge.recipes;
import jacky1356400.simplesponge.blocks.BlockSponge;
import jacky1356400.simplesponge.items.ItemSpongeOnAStick;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Recipes {
	
	public static BlockSponge Sponge;
    public static ItemSpongeOnAStick Sponge_On_A_Stick;
	
	public static void registerRecipes() {

        //Sponge
		GameRegistry.addShapelessRecipe(
				new ItemStack(Sponge, 1, 0),
				Blocks.WOOL, "slimeball");

        //Sponge On A Stick
        GameRegistry.addRecipe(
        		new ItemStack(Sponge_On_A_Stick), 
        		" s ", 
        		" w ", 
        		" w ", 
        		's', Sponge, 
        		'w', "stickWood");
        
    }
	
}
