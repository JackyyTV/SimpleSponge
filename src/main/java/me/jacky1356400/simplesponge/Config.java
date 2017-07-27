package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import scala.Int;

public class Config {

    private static final String CATEGORY_SPONGE = "sponge";
    private static final String CATEGORY_MAGSPONGE = "magmatic sponge";
    private static final String CATEGORY_ENSPONGE = "energized sponge";
    private static final String CATEGORY_COMPRESSED = "compressed sponge";

    public static int spongeMaxDamage;
    public static int spongeRange;
    public static int spongeOnAStickRange;
    public static int magmaticSpongeOnAStickMaxDamage;
    public static int magmaticSpongeRange;
    public static int magmaticSpongeOnAStickRange;
    public static int energizedSpongeOnAStickMaxEnergy;
    public static int energizedSpongeOnAStickPerBlockUse;
    public static int energizedSpongeOnAStickRange;
    public static int compressedSpongeOnAStickMaxDamage;
    public static int compressedSpongeOnAStickRange;
    public static int compressedMagmaticSpongeOnAStickMaxDamage;
    public static int compressedMagmaticSpongeOnAStickRange;

    public static void readConfig(){
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initConfig(cfg);
        } catch (Exception e) {
            SimpleSponge.logger.error("ERROR LOADING CONFIG", e);
        } finally {
            if(cfg.hasChanged()){
                cfg.save();
            }
        }
    }

    private static void initConfig(Configuration cfg){
        spongeMaxDamage = cfg.getInt("spongeMaxDamage", CATEGORY_SPONGE, 256, 1, Integer.MAX_VALUE, "Set the durability for a Sponge On A Stick");
        spongeRange = cfg.getInt("spongeRange", CATEGORY_SPONGE, 3, 1, 64, "Set the range for a Sponge");
        spongeOnAStickRange = cfg.getInt("spongeOnAStickRange", CATEGORY_SPONGE, 3, 1, 64, "Set the range for a Sponge On A Stick");

        magmaticSpongeOnAStickMaxDamage = cfg.getInt("magmaticSpongeOnAStickMaxDamage", CATEGORY_MAGSPONGE, 256, 1, Integer.MAX_VALUE, "Set the durability for a Magmatic Sponge On A Stick");
        magmaticSpongeRange = cfg.getInt("magmaticSpongeRange", CATEGORY_MAGSPONGE, 3, 1, 64, "Set the range for a Magmatic Sponge");
        magmaticSpongeOnAStickRange = cfg.getInt("magmaticSpongeOnAStickRange", CATEGORY_MAGSPONGE, 3, 1, 64, "Set the range for a Magmatic Sponge On A Stick");

        energizedSpongeOnAStickMaxEnergy = cfg.getInt("energizedSpongeOnAStickMaxEnergy", CATEGORY_ENSPONGE, 500000, 1, Integer.MAX_VALUE, "Set the max energy for an Energized Sponge On A Stick");
        energizedSpongeOnAStickPerBlockUse = cfg.getInt("energizedSpongeOnAStickPerBlockUse", CATEGORY_ENSPONGE, 100, 1, 10000, "Set the per block energy use for an Energized Sponge On A Stick");
        energizedSpongeOnAStickRange = cfg.getInt("energizedSpongeOnAStickRange", CATEGORY_ENSPONGE, 7, 1, 64, "Set the range for an Energized Sponge On A Stick");

        compressedSpongeOnAStickMaxDamage = cfg.getInt("compressedSpongeOnAStickMaxDamage", CATEGORY_COMPRESSED, 256, 1, Integer.MAX_VALUE, "Set the durability (multiplied by 9) for a Compressed Sponge On A Stick");
        compressedSpongeOnAStickRange = cfg.getInt("compressedSpongeOnAStickRange", CATEGORY_COMPRESSED, 3, 1, 64, "Set the range (multiplied by 2) for a Compressed Sponge On A Stick");
        compressedMagmaticSpongeOnAStickMaxDamage = cfg.getInt("compressedMagmaticSpongeOnAStickMaxDamage", CATEGORY_COMPRESSED, 256, 1, Integer.MAX_VALUE, "Set the durability (multiplied by 9) for a Compressed Magmatic Sponge On A Stick");
        compressedMagmaticSpongeOnAStickRange = cfg.getInt("compressedMagmaticSpongeOnAStickRange", CATEGORY_COMPRESSED, 3, 1, 64, "Set the range (multiplied by 2) for a Compressed Magmatic Sponge On A Stick");
    }

}
