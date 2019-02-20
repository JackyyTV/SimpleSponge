package jackyy.simplesponge.registry;

import jackyy.simplesponge.SimpleSponge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = SimpleSponge.MODID, name = "SimpleSponge", category = SimpleSponge.MODID)
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
        @Config.Comment("Set to true to enable the Energized Sponge On A Stick (Requires RF to use)")
        public boolean enableEnergizedSpongeOnAStick = true;
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
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(SimpleSponge.MODID)) {
                ConfigManager.sync(SimpleSponge.MODID, Config.Type.INSTANCE);
            }
        }
    }

}
