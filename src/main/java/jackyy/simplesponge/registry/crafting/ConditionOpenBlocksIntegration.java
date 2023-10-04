package jackyy.simplesponge.registry.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jackyy.simplesponge.registry.ModConfigs;
import net.minecraftforge.common.crafting.conditions.ICondition;

public record ConditionOpenBlocksIntegration(boolean enabled) implements ICondition {

    public static final Codec<ConditionOpenBlocksIntegration> CODEC = RecordCodecBuilder.create(
            (b) -> b.group(Codec.BOOL.fieldOf("enabled").forGetter(ConditionOpenBlocksIntegration::enabled)).apply(b, ConditionOpenBlocksIntegration::new)
    );

    @Override
    public boolean test(IContext context) {
        return ModConfigs.CONFIG.openBlocksIntegration.get() == enabled;
    }

    @Override
    public Codec<? extends ICondition> codec() {
        return CODEC;
    }

    public boolean enabled() {
        return this.enabled;
    }

}
