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

public class ItemMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemMagmaticSpongeOnAStick() {
        setRegistryName(SimpleSponge.MODID + ":magmatic_sponge_on_a_stick");
        setTranslationKey(SimpleSponge.MODID + ".magmatic_sponge_on_a_stick");
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
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getDmg() {
        return ModConfig.magneticSponge.magmaticSpongeOnAStickMaxDamage;
    }

    @Override
    public int getRange() {
        return ModConfig.magneticSponge.magmaticSpongeOnAStickRange;
    }

}
