package jackyy.simplesponge.item;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemSpongeOnAStick() {
        setRegistryName(SimpleSponge.MODID + ":sponge_on_a_stick");
        setUnlocalizedName(SimpleSponge.MODID + ".sponge_on_a_stick");
        setMaxDamage(ModConfig.sponge.spongeOnAStickMaxDamage);
        setCreativeTab(SimpleSponge.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getDmg() {
        return ModConfig.sponge.spongeOnAStickMaxDamage;
    }

    @Override
    public int getRange() {
        return ModConfig.sponge.spongeOnAStickRange;
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(tab)) {
            if (!Loader.isModLoaded("openblocks")) {
                list.add(new ItemStack(this));
            } else if (Loader.isModLoaded("openblocks") && !ModConfig.misc.openBlocksIntegration) {
                list.add(new ItemStack(this));
            }
        }
    }

}
