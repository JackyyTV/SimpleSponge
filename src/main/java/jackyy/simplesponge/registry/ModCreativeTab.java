package jackyy.simplesponge.registry;

import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.simplesponge.SimpleSponge;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = SimpleSponge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTab {

    public static CreativeModeTab tab = CreativeModeTab.builder()
            .title(Component.translatable("item_group." + SimpleSponge.MODID + ".main_creative_tab"))
            .icon(() -> new ItemStack(ModItems.SPONGE_ON_A_STICK.get()))
            .displayItems((params, output) -> {
                if (ModList.get().isLoaded("openblocks")) {
                    if (ModConfigs.CONFIG.openBlocksIntegration.get()) {
                        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation("openblocks", "sponge")) == null) {
                            output.accept(ModItems.SPONGE_BLOCK_ITEM.get());
                        }
                        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation("openblocks", "sponge_on_a_stick")) == null) {
                            output.accept(ModItems.SPONGE_ON_A_STICK.get());
                        }
                    } else {
                        output.accept(ModItems.SPONGE_BLOCK_ITEM.get());
                        output.accept(ModItems.SPONGE_ON_A_STICK.get());
                    }
                } else {
                    output.accept(ModItems.SPONGE_BLOCK_ITEM.get());
                    output.accept(ModItems.SPONGE_ON_A_STICK.get());
                }

                output.accept(ModItems.COMPRESSED_SPONGE_ON_A_STICK.get());
                output.accept(ModItems.MAGMATIC_SPONGE_BLOCK_ITEM.get());
                output.accept(ModItems.MAGMATIC_SPONGE_ON_A_STICK.get());
                output.accept(ModItems.COMPRESSED_MAGMATIC_SPONGE_ON_A_STICK.get());

                if (ModConfigs.CONFIG.enableEnergizedSpongeOnAStick.get()) {
                    output.accept(ModItems.ENERGIZED_SPONGE_ON_A_STICK.get());
                    ItemStack full = new ItemStack(ModItems.ENERGIZED_SPONGE_ON_A_STICK.get());
                    EnergyHelper.setDefaultEnergyTag(full, EnergyHelper.getMaxEnergyStored(full));
                    output.accept(full);
                }
            })
            .build();

    @SubscribeEvent
    public static void registerCreativeModeTab(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB,
                helper -> helper.register(new ResourceLocation(SimpleSponge.MODID, "main_creative_tab"), tab)
        );
    }

}
