package jackyy.simplesponge;

import jackyy.simplesponge.registry.ModBlocks;
import jackyy.simplesponge.registry.ModConfigs;
import jackyy.simplesponge.registry.ModItems;
import jackyy.simplesponge.registry.crafting.ModCrafting;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(SimpleSponge.MODID)
public class SimpleSponge {

    public static final String MODID = "simplesponge";
    public static final ItemGroup TAB = new ItemGroup(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.spongeOnAStick);
        }
    };

    public SimpleSponge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.SPEC, "SimpleSponge.toml");
        ModCrafting.registerConditions();
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

}
