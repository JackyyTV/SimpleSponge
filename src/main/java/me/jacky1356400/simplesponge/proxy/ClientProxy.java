package me.jacky1356400.simplesponge.proxy;

import me.jacky1356400.simplesponge.SimpleSpongeBlocks;
import me.jacky1356400.simplesponge.SimpleSpongeItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Admin on 04/06/2017.
 */
public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent e){
        super.preInit(e);
        SimpleSpongeItems.initModels();
        SimpleSpongeBlocks.initModels();
    }

    public void init(FMLInitializationEvent e){

    }

    public void postInit(FMLPostInitializationEvent e){

    }

}
