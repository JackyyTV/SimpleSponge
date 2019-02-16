package jackyy.simplesponge.item;

import net.minecraft.item.ItemStack;

public class ItemSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemSpongeOnAStick() {
        setRegistryName("sponge_on_a_stick");
        setDamage(new ItemStack(this), getDmg());
    }

    @Override
    public int getDmg() {
        //return ModConfig.sponge.spongeOnAStickMaxDamage;
        return 1;
    }

    @Override
    public int getRange() {
        //return ModConfig.sponge.spongeOnAStickRange;
        return 1;
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

    /*
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab)) {
            if (Loader.isModLoaded("openblocks")) {
                if (ModConfig.misc.openBlocksIntegration) {
                    if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick")) == null) {
                        list.add(new ItemStack(this));
                    }
                } else {
                    list.add(new ItemStack(this));
                }
            } else {
                list.add(new ItemStack(this));
            }
        }
    }
    */

}
