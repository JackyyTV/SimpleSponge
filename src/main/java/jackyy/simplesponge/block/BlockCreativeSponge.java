package jackyy.simplesponge.block;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCreativeSponge extends BlockSpongeBase {

    public BlockCreativeSponge() {
        setRegistryName(SimpleSponge.MODID + ":creative_sponge");
        setTranslationKey(SimpleSponge.MODID + ".creative_sponge");
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
        return ModConfig.creativeSponge.creativeSpongeRange;
    }

}
