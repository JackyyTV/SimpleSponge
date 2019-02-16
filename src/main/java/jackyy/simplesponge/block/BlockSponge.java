package jackyy.simplesponge.block;

public class BlockSponge extends BlockSpongeBase {

    public BlockSponge() {
        setRegistryName("sponge");
    }

    /*
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (Loader.isModLoaded("openblocks")) {
            if (ModConfig.misc.openBlocksIntegration) {
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge")) == null) {
                    list.add(new ItemStack(this));
                }
            } else {
                list.add(new ItemStack(this));
            }
        } else {
            list.add(new ItemStack(this));
        }
    }
    */

    @Override
    public boolean isMagmatic() {
        return false;
    }

    @Override
    public int getRange() {
        //return ModConfig.sponge.spongeRange;
        return 1;
    }

}
