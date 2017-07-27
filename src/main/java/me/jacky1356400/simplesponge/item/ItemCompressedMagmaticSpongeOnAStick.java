package me.jacky1356400.simplesponge.item;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.SimpleSponge;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCompressedMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedMagmaticSpongeOnAStick(){
        setRegistryName(SimpleSponge.MODID + ":compressed_magmatic_sponge_on_a_stick");
        setUnlocalizedName(SimpleSponge.MODID + ".compressed_magmatic_sponge_on_a_stick");
        setMaxDamage(getDmg());
        setCreativeTab(SimpleSponge.spongeCreativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getDmg() {
        return Config.compressedMagmaticSpongeOnAStickMaxDamage * 9;
    }

    @Override
    public int getRange() {
        return Config.compressedMagmaticSpongeOnAStickRange * 2;
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

}