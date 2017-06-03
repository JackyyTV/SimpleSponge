package jacky1356400.simplesponge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import jacky1356400.simplesponge.items.*;

public final class ItemRenderRegister {
	
	public static void registerItemRenderer() {
    }
	
	public static void reg(Item item) {
	    Item ItemSpongeOnAStick = GameRegistry.findItem("simplesponge", "Sponge_On_A_Stick");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(ItemSpongeOnAStick, 0, new ModelResourceLocation("simplesponge:Sponge_On_A_Stick", "inventory"));
	}
}

