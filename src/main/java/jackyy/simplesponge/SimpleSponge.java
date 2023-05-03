package jackyy.simplesponge;

import jackyy.simplesponge.registry.ModBlocks;
import jackyy.simplesponge.registry.ModConfigs;
import jackyy.simplesponge.registry.ModItems;
import jackyy.simplesponge.registry.crafting.ModCrafting;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(SimpleSponge.MODID)
public class SimpleSponge {

    public static final String MODID = "simplesponge";

    public SimpleSponge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.SPEC);
        ModCrafting.registerConditions();
        ModBlocks.init();
        ModItems.init();
    }

}
