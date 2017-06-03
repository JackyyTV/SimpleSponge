package jacky1356400.simplesponge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import jacky1356400.simplesponge.blocks.BlockSponge;

public final class BlockRenderRegister {
	
    public static void registerBlockRenderer() {
    }
    
    public static void reg(Block block) {
    	Item Sponge = GameRegistry.findItem("simplesponge", "Sponge");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(Sponge, 0, new ModelResourceLocation("simplesponge:Sponge", "inventory"));
    }
    
}
