package me.jacky1356400.simplesponge.block;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.util.Data;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Loader;

public class BlockSponge extends BlockSpongeBase {

    public BlockSponge() {
        setRegistryName(Data.MODID + ":sponge");
        setUnlocalizedName(Data.MODID + ".sponge");
        setCreativeTab(Data.TAB);
        Data.BLOCKS.add(this);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (!Loader.isModLoaded("openblocks")) {
            list.add(new ItemStack(this));
        } else if (Loader.isModLoaded("openblocks") && !Config.openBlocksIntegration) {
            list.add(new ItemStack(this));
        }
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

    @Override
    public int getRange() {
        return Config.spongeRange;
    }

}
