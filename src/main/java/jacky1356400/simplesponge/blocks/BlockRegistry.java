package jacky1356400.simplesponge.blocks;

import jacky1356400.simplesponge.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {
	
	public static BlockSponge Sponge;

	public static void loadBlocks()
	{
		GameRegistry.register(Sponge = new BlockSponge());
	}

	public static void registerBlocksItems()
	{
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

		mesher.register(Item.getItemFromBlock(Sponge), 0, new ModelResourceLocation(Main.MODID + ":" + "Sponge", "inventory"));
	}

}
