package jackyy.simplesponge.registry.crafting;

import com.mojang.serialization.Codec;
import jackyy.simplesponge.SimpleSponge;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModCrafting {

    public static final DeferredRegister<Codec<? extends ICondition>> CONDITION_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.CONDITION_SERIALIZERS, SimpleSponge.MODID);

    static {
        CONDITION_SERIALIZERS.register("energized_sponge_on_a_stick", () -> ConditionEnergizedSpongeOnAStick.CODEC);
        CONDITION_SERIALIZERS.register("openblocks_integration", () -> ConditionOpenBlocksIntegration.CODEC);
    }

    public static void registerConditions() {
        CONDITION_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
