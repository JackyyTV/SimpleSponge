package me.jacky1356400.simplesponge.item;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.util.Data;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Loader;

public class ItemSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemSpongeOnAStick(){
        setRegistryName(Data.MODID + ":sponge_on_a_stick");
        setUnlocalizedName(Data.MODID + ".sponge_on_a_stick");
        setMaxDamage(Config.spongeMaxDamage);
        setCreativeTab(Data.TAB);
        Data.ITEMS.add(this);
    }

    @Override
    public int getDmg() {
        return Config.spongeMaxDamage;
    }

    @Override
    public int getRange() {
        return Config.magmaticSpongeOnAStickRange;
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab)) {
            if (!Loader.isModLoaded("openblocks")) {
                list.add(new ItemStack(this));
            } else if (Loader.isModLoaded("openblocks") && !Config.openBlocksIntegration) {
                list.add(new ItemStack(this));
            }
        }
    }

}
