package jackyy.simplesponge.item;

import jackyy.simplesponge.registry.ModConfigs;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemSpongeOnAStick extends ItemSpongeOnAStickBase {

    private static int dmg;
    private static int range;
    static {
        try {
            dmg = ModConfigs.CONFIG.spongeOnAStickMaxDamage.get();
            range = ModConfigs.CONFIG.spongeOnAStickRange.get();
        } catch (NullPointerException e) {
            dmg = 256;
            range = 3;
        }
    }

    public ItemSpongeOnAStick() {
        super(new Properties().defaultMaxDamage(dmg));
        setRegistryName("sponge_on_a_stick");
    }

    @Override
    public int getDmg() {
        return dmg;
    }

    @Override
    public int getRange() {
        return range;
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
