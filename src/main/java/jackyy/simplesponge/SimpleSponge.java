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

    public static final String VERSION = "2.4.2";
    public static final String MCVERSION = "[1.11,1.12)";
    public static final String MODID = "simplesponge";
    public static final String MODNAME = "Simple Sponge";
    public static final String DEPENDS = "after:openblocks;";
    public static final CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack getTabIconItem() {
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
        logger.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been modified. This will NOT be supported by the mod author!");
    }

}
