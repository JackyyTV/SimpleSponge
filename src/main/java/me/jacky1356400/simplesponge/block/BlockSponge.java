package me.jacky1356400.simplesponge.block;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.SimpleSponge;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockSponge extends BlockSpongeBase {

    public BlockSponge() {
        setRegistryName(SimpleSponge.MODID + ":sponge");
        setUnlocalizedName(SimpleSponge.MODID + ".sponge");
        setCreativeTab(SimpleSponge.spongeCreativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        if (Loader.isModLoaded("openblocks") && Config.openBlocksIntegration){
            tooltip.add(TextFormatting.RED + I18n.format("tooltip." + SimpleSponge.MODID + ".warning.openblocks"));
        }
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

    @Override
    public int getRange() {
        return Config.spongeRange;
    }

}
