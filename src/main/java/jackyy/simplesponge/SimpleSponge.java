package jackyy.simplesponge;

import jackyy.simplesponge.registry.ModBlocks;
import jackyy.simplesponge.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SimpleSponge.MODID)
public class SimpleSponge {

    public static final String MODID = "simplesponge";
    public static final String MODNAME = "Simple Sponge";
    public static final ItemGroup TAB = new ItemGroup(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.spongeOnAStick);
        }
    };
    public static final Logger LOGGER = LogManager.getLogger(MODNAME);

    public SimpleSponge() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemRegistry(RegistryEvent.Register<Item> event) {
            ModItems.init(event);
        }
        @SubscribeEvent
        public static void onBlockRegistry(RegistryEvent.Register<Block> event) {
            ModBlocks.init(event);
        }
    }

    /*
    @SubscribeEvent
    public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
        LOGGER.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been modified. This will NOT be supported by the mod author!");
    }
    */

}
