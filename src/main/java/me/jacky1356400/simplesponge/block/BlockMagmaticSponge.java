package me.jacky1356400.simplesponge.block;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.util.Data;

public class BlockMagmaticSponge extends BlockSpongeBase {

    public BlockMagmaticSponge() {
        setRegistryName(Data.MODID + ":magmatic_sponge");
        setUnlocalizedName(Data.MODID + ".magmatic_sponge");
        setCreativeTab(Data.TAB);
        Data.BLOCKS.add(this);
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getRange() {
        return Config.magmaticSpongeRange;
    }

}
