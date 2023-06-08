package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemSpongeOnAStick() {
        super(new Properties().durability(512));
    }

    @Override
    public int getRange() {
        return ModConfigs.CONFIG.spongeOnAStickRange.get();
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

    @Override
    public boolean isPowered() {
        return false;
    }


    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> items) {
        if (this.allowdedIn(tab)) {
            if (ModList.get().isLoaded("openblocks")) {
                if (ModConfigs.CONFIG.openBlocksIntegration.get()) {
                    if (ForgeRegistries.ITEMS.getValue(new ResourceLocation("openblocks", "sponge_on_a_stick")) == null) {
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

}
