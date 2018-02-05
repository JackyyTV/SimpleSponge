package jackyy.simplesponge.proxy;

import jackyy.simplesponge.registry.ModBlocks;
import jackyy.simplesponge.registry.ModItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onModelRegistry(ModelRegistryEvent e) {
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
