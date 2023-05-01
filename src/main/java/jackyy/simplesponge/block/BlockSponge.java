package jackyy.simplesponge.block;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockSponge extends BlockSpongeBase {

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.spongeRange.get();
    }

    @Override
    public boolean isMagnetic() {
        return false;
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> items) {
        if (ModList.get().isLoaded("openblocks")) {
            if (ModConfigs.CONFIG.openBlocksIntegration.get()) {
                if (ForgeRegistries.ITEMS.getValue(new ResourceLocation("openblocks", "sponge")) == null) {
                    items.add(new ItemStack(this));
                }
            } else {
                items.add(new ItemStack(this));
            }
        } else {
            items.add(new ItemStack(this));
        }
    }

}
