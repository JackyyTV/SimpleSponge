package jackyy.simplesponge.proxy;

import jackyy.simplesponge.registry.ModBlocks;
import jackyy.simplesponge.registry.ModItems;
import jackyy.simplesponge.registry.ModRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        ModItems.init();
        ModBlocks.init();
    }

    public void init(FMLInitializationEvent e) {
        ModRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

}
