package jackyy.simplesponge.registry;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfigs {

    public static class CommonConfig {

        public final ForgeConfigSpec.IntValue spongeOnAStickMaxDamage;
        public final ForgeConfigSpec.IntValue spongeRange;
        public final ForgeConfigSpec.IntValue spongeOnAStickRange;

        public final ForgeConfigSpec.IntValue magmaticSpongeOnAStickMaxDamage;
        public final ForgeConfigSpec.IntValue magmaticSpongeRange;
        public final ForgeConfigSpec.IntValue magmaticSpongeOnAStickRange;

        public final ForgeConfigSpec.BooleanValue enableEnergizedSpongeOnAStick;
        public final ForgeConfigSpec.IntValue energizedSpongeOnAStickMaxEnergy;
        public final ForgeConfigSpec.IntValue energizedSpongeOnAStickPerRightClickUse;
        public final ForgeConfigSpec.IntValue energizedSpongeOnAStickRange;

        public final ForgeConfigSpec.IntValue compressedSpongeOnAStickMaxDamage;
        public final ForgeConfigSpec.IntValue compressedSpongeOnAStickRange;
        public final ForgeConfigSpec.IntValue compressedMagmaticSpongeOnAStickMaxDamage;
        public final ForgeConfigSpec.IntValue compressedMagmaticSpongeOnAStickRange;

        public final ForgeConfigSpec.BooleanValue openBlocksIntegration;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Simple Sponge Config")
                    .push("sponge");
            spongeOnAStickMaxDamage = builder
                    .comment("Set the durability for a Sponge On A Stick")
                    .defineInRange("spongeOnAStickMaxDamage", 256, 1, Integer.MAX_VALUE);
            spongeRange = builder
                    .comment("Set the range for a Sponge")
                    .defineInRange("spongeRange", 3, 1, 64);
            spongeOnAStickRange = builder
                    .comment("Set the range for a Sponge On A Stick")
                    .defineInRange("spongeOnAStickRange", 3, 1, 64);
            builder.pop();

            builder.push("magmatic_sponge");
            magmaticSpongeOnAStickMaxDamage = builder
                    .comment("Set the durability for a Magmatic Sponge On A Stick")
                    .defineInRange("magmaticSpongeOnAStickMaxDamage", 256, 1, Integer.MAX_VALUE);
            magmaticSpongeRange = builder
                    .comment("Set the range for a Magmatic Sponge")
                    .defineInRange("magmaticSpongeRange", 3, 1, 64);
            magmaticSpongeOnAStickRange = builder
                    .comment("Set the range for a Magmatic Sponge On A Stick")
                    .defineInRange("magmaticSpongeOnAStickRange", 3, 1, 64);
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
                    .defineInRange("energizedSpongeOnAStickPerRightClickUse", 100, 1, 10000);
            energizedSpongeOnAStickRange = builder
                    .comment("Set the range for an Energized Sponge On A Stick")
                    .defineInRange("energizedSpongeOnAStickRange", 7, 1, 64);
            builder.pop();

            builder.push("compressed_sponge");
            compressedSpongeOnAStickMaxDamage = builder
                    .comment("Set the durability (multiplied by 9) for a Compressed Sponge On A Stick")
                    .defineInRange("compressedSpongeOnAStickMaxDamage", 256, 1, Integer.MAX_VALUE);
            compressedSpongeOnAStickRange = builder
                    .comment("Set the range (multiplied by 2) for a Compressed Sponge On A Stick")
                    .defineInRange("compressedSpongeOnAStickRange", 3, 1, 64);
            compressedMagmaticSpongeOnAStickMaxDamage = builder
                    .comment("Set the durability (multiplied by 9) for a Compressed Magmatic Sponge On A Stick")
                    .defineInRange("compressedMagmaticSpongeOnAStickMaxDamage", 256, 1, Integer.MAX_VALUE);
            compressedMagmaticSpongeOnAStickRange = builder
                    .comment("Set the range (multiplied by 2) for a Compressed Magmatic Sponge On A Stick")
                    .defineInRange("compressedMagmaticSpongeOnAStickRange", 3, 1, 64);
            builder.pop();

            builder.push("misc");
            openBlocksIntegration = builder
                    .comment(
                            "When OpenBlocks is detected, certain crafting recipes will be changed / disabled.",
                            "Set this to false if you wish to use the sponges from this mod.",
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
