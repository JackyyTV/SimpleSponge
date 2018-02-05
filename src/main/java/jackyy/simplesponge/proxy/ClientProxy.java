package jackyy.simplesponge.proxy;

import jackyy.simplesponge.registry.ModBlocks;
import jackyy.simplesponge.registry.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModItems.initModels();
        ModBlocks.initModels();
    }

    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

}
