package jackyy.simplesponge.item;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCompressedMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedMagmaticSpongeOnAStick() {
        setRegistryName(SimpleSponge.MODID + ":compressed_magmatic_sponge_on_a_stick");
        setUnlocalizedName(SimpleSponge.MODID + ".compressed_magmatic_sponge_on_a_stick");
        setMaxDamage(getDmg());
        setCreativeTab(SimpleSponge.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getDmg() {
        return ModConfig.CompressedSponge.compressedMagmaticSpongeOnAStickMaxDamage * 9;
    }

    @Override
    public int getRange() {
        return ModConfig.CompressedSponge.compressedMagmaticSpongeOnAStickRange * 2;
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

}