package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_GENERAL = "config";

    public static int spongeMaxDamage;
    public static int spongeRange;
    public static int spongeOnAStickRange;
    public static int magmaticSpongeMaxDamage;
    public static int magmaticSpongeRange;
    public static int magmaticSpongeOnAStickRange;

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
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "Simple Sponge Config");

        spongeMaxDamage = cfg.getInt("Sponge On A Stick Max Durability", CATEGORY_GENERAL, 256, 1, 2147483647, "Set the durability for a Sponge On A Stick");
        magmaticSpongeMaxDamage = cfg.getInt("Magmatic Sponge On A Stick Max Durability", CATEGORY_GENERAL, 256, 1, 2147483647, "Set the durability for a Magmatic Sponge On A Stick");

        spongeRange = cfg.getInt("Sponge Block Range", CATEGORY_GENERAL, 3, 1, 64, "Set the range for a Sponge");
        spongeOnAStickRange = cfg.getInt("Sponge On A Stick Range", CATEGORY_GENERAL, 3, 1, 64, "Set the range for a Sponge On A Stick");

        magmaticSpongeRange = cfg.getInt("Magmatic Sponge Block Range", CATEGORY_GENERAL, 3, 1, 64, "Set the range for a Magmatic Sponge");
        magmaticSpongeOnAStickRange = cfg.getInt("Magmatic Sponge On A Stick Range", CATEGORY_GENERAL, 3, 1, 64, "Set the range for a Magmatic Sponge On A Stick");
    }

}
