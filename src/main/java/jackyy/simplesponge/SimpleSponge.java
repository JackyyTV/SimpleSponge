package jackyy.simplesponge;

import jackyy.simplesponge.proxy.CommonProxy;
import jackyy.simplesponge.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = SimpleSponge.MODID, version = SimpleSponge.VERSION, name = SimpleSponge.MODNAME, dependencies = SimpleSponge.DEPENDS, acceptedMinecraftVersions = SimpleSponge.MCVERSION, certificateFingerprint = "@FINGERPRINT@", useMetadata = true)
public class SimpleSponge {

    public static final String VERSION = "3.7.1";
    public static final String MCVERSION = "[1.12,1.13)";
    public static final String MODID = "simplesponge";
    public static final String MODNAME = "Simple Sponge";
    public static final String DEPENDS = "required-after:gunpowderlib@[1.12.2-1.1,);required-after:forge@[14.23.5.2816,);after:openblocks;";
    public static final CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.spongeOnAStick);
        }
    };

    public static Logger logger = LogManager.getLogger(MODNAME);

    @SidedProxy(serverSide = "jackyy.simplesponge.proxy.CommonProxy", clientSide = "jackyy.simplesponge.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
        logger.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been modified or running in dev environment.");
    }

}
