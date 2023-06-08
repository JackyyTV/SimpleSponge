package jackyy.simplesponge.registry.crafting;

import com.google.gson.JsonObject;
import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionOpenBlocksIntegration implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(SimpleSponge.MODID, "openblocks_integration");
    private final boolean value;

    public ConditionOpenBlocksIntegration(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override @SuppressWarnings("removal")
    public boolean test() {
        return ModConfigs.CONFIG.openBlocksIntegration.get() == value;
    }

    public static final IConditionSerializer<ConditionOpenBlocksIntegration> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, ConditionOpenBlocksIntegration condition) {
            json.addProperty("enabled", condition.value);
        }

        @Override
        public ConditionOpenBlocksIntegration read(JsonObject json) {
            return new ConditionOpenBlocksIntegration(json.get("enabled").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
