package jackyy.simplesponge.registry;

import jackyy.simplesponge.SimpleSponge;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;

public class ModRecipes {

    public static void registerConditions() {
        CraftingHelper.register(
                new ResourceLocation(SimpleSponge.MODID, "energized_sponge_on_a_stick"),
                json -> () -> ModConfigs.CONFIG.enableEnergizedSpongeOnAStick.get() == JsonUtils.getBoolean(json, "enabled", true)
        );
        CraftingHelper.register(
                new ResourceLocation(SimpleSponge.MODID, "openblocks_integration"),
                json -> () -> ModConfigs.CONFIG.openBlocksIntegration.get() == JsonUtils.getBoolean(json, "enabled", true)
        );
    }

}
