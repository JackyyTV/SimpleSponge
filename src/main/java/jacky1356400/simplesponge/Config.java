package jacky1356400.simplesponge;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Config {

    public static Configuration config;
    public static List<String> categories = new ArrayList<>();

    public static int spongeMaxDamage;
    public static int spongeRange;
    public static int spongeOnAStickRange;

    @SubscribeEvent
    public void configChanged(ConfigChangedEvent event) {
        if (event.getModID().equals(jacky1356400.simplesponge.Main.MODID)) {
            syncConfig();
        }
    }

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        categories.clear();

        String category;

        category = "Durability Tweaks";
        categories.add(category);
        
        spongeMaxDamage = config.getInt("Sponge On A Stick Max Durability", category, 256, 1, 10000, "Set the durability for a Sponge On A Stick");
        spongeRange = config.getInt("Sponge Block Range", category, 3, 1, 10000, "Set the range for a Sponge");
        spongeOnAStickRange = config.getInt("Sponge On A Stick Range", category, 3, 1, 10000, "Set the range for a Sponge On A Stick");
        
        if (config.hasChanged())
            config.save();
    }

}