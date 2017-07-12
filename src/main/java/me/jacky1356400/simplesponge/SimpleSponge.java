package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = SimpleSponge.MODID, version = SimpleSponge.VERSION, name = "SimpleSponge", useMetadata = true)
public class SimpleSponge {

    public static final String VERSION = "2.2";
    public static final String MODID = "simplesponge";
    public static final SimpleSpongeTab spongeCreativeTab = new SimpleSpongeTab();

    public static Logger logger = LogManager.getLogger("SimpleSponge");

    @SidedProxy(serverSide = "me.jacky1356400.simplesponge.proxy.CommonProxy", clientSide = "me.jacky1356400.simplesponge.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){
        proxy.postInit(e);
    }

}
