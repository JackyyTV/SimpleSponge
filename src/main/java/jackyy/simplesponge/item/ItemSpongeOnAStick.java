package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemSpongeOnAStick() {
        super(new Properties().maxDamage(512));
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
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (isInGroup(group)) {
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
