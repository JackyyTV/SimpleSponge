package jackyy.simplesponge.registry;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfigs {

    public static class CommonConfig {

        public ForgeConfigSpec.IntValue spongeRange;
        public ForgeConfigSpec.IntValue spongeOnAStickRange;

        public ForgeConfigSpec.IntValue magmaticSpongeRange;
        public ForgeConfigSpec.IntValue magmaticSpongeOnAStickRange;

        public ForgeConfigSpec.BooleanValue enableEnergizedSpongeOnAStick;
        public ForgeConfigSpec.IntValue energizedSpongeOnAStickMaxEnergy;
        public ForgeConfigSpec.IntValue energizedSpongeOnAStickPerRightClickUse;
        public ForgeConfigSpec.IntValue energizedSpongeOnAStickRange;

        public ForgeConfigSpec.IntValue compressedSpongeOnAStickRange;
        public ForgeConfigSpec.IntValue compressedMagmaticSpongeOnAStickRange;

        public ForgeConfigSpec.IntValue creativeSpongeRange;
        public ForgeConfigSpec.IntValue creativeSpongeOnAStickRange;
        public ForgeConfigSpec.IntValue compressedCreativeSpongeOnAStickRange;

        public ForgeConfigSpec.BooleanValue regularSpongeAbsorbHotLiquid;
        public ForgeConfigSpec.BooleanValue openBlocksIntegration;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Simple Sponge Config")
                    .push("sponge");
            spongeRange = builder
                    .comment("Set the range for a Sponge")
                    .defineInRange("spongeRange", 3, 1, 64);
            spongeOnAStickRange = builder
                    .comment("Set the range for a Sponge On A Stick")
                    .defineInRange("spongeOnAStickRange", 3, 1, 64);
            builder.pop();

            builder.push("magmatic_sponge");
            magmaticSpongeRange = builder
                    .comment("Set the range for a Magmatic Sponge")
                    .defineInRange("magmaticSpongeRange", 5, 1, 64);
            magmaticSpongeOnAStickRange = builder
                    .comment("Set the range for a Magmatic Sponge On A Stick")
                    .defineInRange("magmaticSpongeOnAStickRange", 5, 1, 64);
            builder.pop();

            builder.push("energized_sponge");
            enableEnergizedSpongeOnAStick = builder
                    .comment("Set to true to enable the Energized Sponge On A Stick")
                    .define("enableEnergizedSpongeOnAStick", true);
            energizedSpongeOnAStickMaxEnergy = builder
                    .comment("Set the max energy for an Energized Sponge On A Stick")
                    .defineInRange("energizedSpongeOnAStickMaxEnergy", 500000, 1, Integer.MAX_VALUE);
            energizedSpongeOnAStickPerRightClickUse = builder
                    .comment("Set the per right click energy use for an Energized Sponge On A Stick")
                    .defineInRange("energizedSpongeOnAStickPerRightClickUse", 1000, 1, Integer.MAX_VALUE);
            energizedSpongeOnAStickRange = builder
                    .comment("Set the range for an Energized Sponge On A Stick")
                    .defineInRange("energizedSpongeOnAStickRange", 7, 1, 64);
            builder.pop();

            builder.push("compressed_sponge");
            compressedSpongeOnAStickRange = builder
                    .comment("Set the range (multiplied by 2) for a Compressed Sponge On A Stick")
                    .defineInRange("compressedSpongeOnAStickRange", 3, 1, 64);
            compressedMagmaticSpongeOnAStickRange = builder
                    .comment("Set the range (multiplied by 2) for a Compressed Magmatic Sponge On A Stick")
                    .defineInRange("compressedMagmaticSpongeOnAStickRange", 5, 1, 64);
            builder.pop();

            builder.push("creative_sponge");
            creativeSpongeRange = builder
                    .comment("Set the range for a Creative Sponge")
                    .defineInRange("creativeSpongeRange", 12, 1, 64);
            creativeSpongeOnAStickRange = builder
                    .comment("Set the range for a Creative Sponge On A Stick")
                    .defineInRange("creativeSpongeOnAStickRange", 12, 1, 64);
            compressedCreativeSpongeOnAStickRange = builder
                    .comment("Set the range (multiplied by 2) for a Compressed Creative Sponge On A Stick")
                    .defineInRange("compressedCreativeSpongeOnAStickRange", 12, 1, 64);
            builder.pop();

            builder.push("misc");
            regularSpongeAbsorbHotLiquid = builder
                    .comment(
                            "By default, regular (non-magmatic) Sponges and Sponge On A Sticks can absorb hot liquid (e.g. Lava) once then breaks.",
                            "Set this to false if you don't want regular Sponges and Sponge On A Sticks to absorb hot liquid at all."
                    )
                    .define("regularSpongeAbsorbHotLiquid", true);
            openBlocksIntegration = builder
                    .comment(
                            "When OpenBlocks is detected, certain crafting recipes will be changed / disabled.",
                            "Set this to false if you wish to use the Sponges from this mod.",
                            "You'll have to use CraftTweaker to prevent recipe conflicts."
                    )
                    .define("openBlocksIntegration", true);
            builder.pop();
        }

    }

    public static final ForgeConfigSpec SPEC;
    public static final CommonConfig CONFIG;
    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

}
