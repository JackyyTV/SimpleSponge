package jackyy.simplesponge.registry;

import jackyy.simplesponge.SimpleSponge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@Config(modid = SimpleSponge.MODID, name = "SimpleSponge")
public class ModConfig {

    public static Sponge sponge = new Sponge();
    public static MagneticSponge magneticSponge = new MagneticSponge();
    public static EnergizedSponge energizedSponge = new EnergizedSponge();
    public static CompressedSponge compressedSponge = new CompressedSponge();
    public static Misc misc = new Misc();

    public static class Sponge {
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for a Sponge On A Stick")
        public int spongeOnAStickMaxDamage = 256;
        @Config.RangeInt(min = 1, max = 64)
        @Config.Comment("Set the range for a Sponge")
        public int spongeRange = 3;
        @Config.RangeInt(min = 1, max = 64)
        @Config.Comment("Set the range for a Sponge On A Stick")
        public int spongeOnAStickRange = 3;
    }

    public static class MagneticSponge {
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability for a Magmatic Sponge On A Stick")
        public int magmaticSpongeOnAStickMaxDamage = 256;
        @Config.RangeInt(min = 1, max = 64)
        @Config.Comment("Set the range for a Magmatic Sponge")
        public int magmaticSpongeRange = 3;
        @Config.RangeInt(min = 1, max = 64)
        @Config.Comment("Set the range for a Magmatic Sponge On A Stick")
        public int magmaticSpongeOnAStickRange = 3;
    }

    public static class EnergizedSponge {
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the max energy for an Energized Sponge On A Stick")
        public int energizedSpongeOnAStickMaxEnergy = 500000;
        @Config.RangeInt(min = 1, max = 10000)
        @Config.Comment("Set the per right click energy use for an Energized Sponge On A Stick")
        public int energizedSpongeOnAStickPerRightClickUse = 100;
        @Config.RangeInt(min = 1, max = 64)
        @Config.Comment("Set the range for an Energized Sponge On A Stick")
        public int energizedSpongeOnAStickRange = 7;
    }

    public static class CompressedSponge {
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability (multiplied by 9) for a Compressed Sponge On A Stick")
        public int compressedSpongeOnAStickMaxDamage = 256;
        @Config.RangeInt(min = 1, max = 64)
        @Config.Comment("Set the range (multiplied by 2) for a Compressed Sponge On A Stick")
        public int compressedSpongeOnAStickRange = 3;
        @Config.RangeInt(min = 1)
        @Config.Comment("Set the durability (multiplied by 9) for a Compressed Magmatic Sponge On A Stick")
        public int compressedMagmaticSpongeOnAStickMaxDamage = 256;
        @Config.RangeInt(min = 1, max = 64)
        @Config.Comment("Set the range (multiplied by 2) for a Compressed Magmatic Sponge On A Stick")
        public int compressedMagmaticSpongeOnAStickRange = 3;
    }

    public static class Misc {
        @Config.Comment({
                "When OpenBlocks is detected, certain crafting recipes will be changed / disabled.",
                "Set this to false if you wish to use the sponges from this mod.",
                "You'll have to use CraftTweaker to prevent recipe conflicts."
        })
        public boolean openBlocksIntegration = true;
    }

    @Mod.EventBusSubscriber
    public static class ConfigHolder {
        private static final MethodHandle CONFIGS_GETTER = findFieldGetter(ConfigManager.class, "CONFIGS");
        private static Configuration config;
        private static MethodHandle findFieldGetter(Class<?> clazz, String... fieldNames) {
            final Field field = ReflectionHelper.findField(clazz, fieldNames);
            try {
                return MethodHandles.lookup().unreflectGetter(field);
            } catch (IllegalAccessException e) {
                throw new ReflectionHelper.UnableToAccessFieldException(fieldNames, e);
            }
        }
        @SuppressWarnings("unchecked")
        public static Configuration getConfig() {
            if (config == null) {
                try {
                    final String fileName = "SimpleSponge.cfg";
                    final Map<String, Configuration> configsMap = (Map<String, Configuration>) CONFIGS_GETTER.invokeExact();
                    final Optional<Map.Entry<String, Configuration>> entryOptional = configsMap.entrySet().stream()
                            .filter(entry -> fileName.equals(new File(entry.getKey()).getName())).findFirst();
                    entryOptional.ifPresent(stringConfigurationEntry -> config = stringConfigurationEntry.getValue());
                } catch (Throwable throwable) {
                    SimpleSponge.logger.error("Failed to get Configuration instance!", throwable);
                }
            }
            return config;
        }
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(SimpleSponge.MODID)) {
                ConfigManager.load(SimpleSponge.MODID, Config.Type.INSTANCE);
            }
        }
    }

}
