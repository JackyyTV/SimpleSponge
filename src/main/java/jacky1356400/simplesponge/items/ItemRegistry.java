package jacky1356400.simplesponge.items;

import jacky1356400.simplesponge.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
	
	public static ItemSpongeOnAStick SpongeOnAStick;
	
	public static void loadItems()
	{
		GameRegistry.register(SpongeOnAStick = new ItemSpongeOnAStick());
	}

	public static void registerItems()
	{
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

		mesher.register(ItemRegistry.SpongeOnAStick, 0, new ModelResourceLocation(Main.MODID + ":" + "Sponge_On_A_Stick", "inventory"));
	}

}
