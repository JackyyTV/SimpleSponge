package me.jacky1356400.simplesponge.item;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.SimpleSponge;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemSpongeOnAStick(){
        setRegistryName(SimpleSponge.MODID + ":sponge_on_a_stick");
        setUnlocalizedName(SimpleSponge.MODID + ".sponge_on_a_stick");
        setMaxDamage(Config.spongeMaxDamage);
        setCreativeTab(SimpleSponge.spongeCreativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
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
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
        if (!Loader.isModLoaded("openblocks")) {
            list.add(new ItemStack(item));
        } else if (Loader.isModLoaded("openblocks") && !Config.openBlocksIntegration) {
            list.add(new ItemStack(item));
        }
    }

}
