package jackyy.simplesponge.item;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IRarity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCompressedMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemCompressedMagmaticSpongeOnAStick() {
        setRegistryName(SimpleSponge.MODID + ":compressed_magmatic_sponge_on_a_stick");
        setTranslationKey(SimpleSponge.MODID + ".compressed_magmatic_sponge_on_a_stick");
        setMaxDamage(getDmg());
        setCreativeTab(SimpleSponge.TAB);
    }

    @Override
    public IRarity getForgeRarity(ItemStack stack) {
        return EnumRarity.UNCOMMON;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getDmg() {
        return ModConfig.compressedSponge.compressedMagmaticSpongeOnAStickMaxDamage * 9;
    }

    @Override
    public int getRange() {
        return ModConfig.compressedSponge.compressedMagmaticSpongeOnAStickRange * 2;
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

}