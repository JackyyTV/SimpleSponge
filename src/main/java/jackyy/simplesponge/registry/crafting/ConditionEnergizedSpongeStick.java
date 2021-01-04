package jackyy.simplesponge.registry.crafting;

import com.google.gson.JsonObject;
import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConditionEnergizedSpongeStick implements ICondition {

    public static final ResourceLocation ID = new ResourceLocation(SimpleSponge.MODID, "energized_sponge_on_a_stick");
    private final boolean value;

    public ConditionEnergizedSpongeStick(boolean value) {
        this.value = value;
    }

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public boolean test() {
        return ModConfigs.CONFIG.enableEnergizedSpongeOnAStick.get() == value;
    }

    public static final IConditionSerializer<ConditionEnergizedSpongeStick> SERIALIZER = new IConditionSerializer<ConditionEnergizedSpongeStick>() {
        @Override
        public void write(JsonObject json, ConditionEnergizedSpongeStick condition) {
            json.addProperty("enabled", condition.value);
        }

        @Override
        public ConditionEnergizedSpongeStick read(JsonObject json) {
            return new ConditionEnergizedSpongeStick(json.get("enabled").getAsBoolean());
        }

        @Override
        public ResourceLocation getID() {
            return ID;
        }
    };

}
