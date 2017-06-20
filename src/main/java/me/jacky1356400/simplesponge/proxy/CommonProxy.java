package me.jacky1356400.simplesponge.proxy;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.SimpleSponge;
import me.jacky1356400.simplesponge.SimpleSpongeBlocks;
import me.jacky1356400.simplesponge.SimpleSpongeItems;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e){
        File configDir = e.getModConfigurationDirectory();
        config = new Configuration(new File(configDir.getPath(), "simplesponge.cfg"));
        Config.readConfig();
        SimpleSpongeItems.init();
        SimpleSpongeBlocks.init();
    }

    public void init(FMLInitializationEvent e){
        SimpleSponge.logger.info("proxy");
    }

    public void postInit(FMLPostInitializationEvent e){

    }

}
