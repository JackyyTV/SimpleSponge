package jackyy.simplesponge.block;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMagmaticSponge extends BlockSpongeBase {

    public BlockMagmaticSponge() {
        setRegistryName(SimpleSponge.MODID + ":magmatic_sponge");
        setTranslationKey(SimpleSponge.MODID + ".magmatic_sponge");
        setCreativeTab(SimpleSponge.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getRange() {
        return ModConfig.magneticSponge.magmaticSpongeRange;
    }

}
