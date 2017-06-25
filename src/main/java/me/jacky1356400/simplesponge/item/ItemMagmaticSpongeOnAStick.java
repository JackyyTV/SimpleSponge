package me.jacky1356400.simplesponge.item;

import me.jacky1356400.simplesponge.Config;
import me.jacky1356400.simplesponge.util.Data;
import me.jacky1356400.simplesponge.util.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemMagmaticSpongeOnAStick extends Item implements IHasModel {

    public ItemMagmaticSpongeOnAStick(){
        setRegistryName(Data.MODID + ":magmatic_sponge_on_a_stick");
        setUnlocalizedName(Data.MODID + ".magmatic_sponge_on_a_stick");
        setMaxStackSize(1);
        setMaxDamage(Config.magmaticSpongeMaxDamage);
        setCreativeTab(Data.TAB);
        Data.ITEMS.add(this);
    }

    public boolean showDurabilityBar(ItemStack stack){
        return stack.isItemDamaged();
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return soakUp(world, pos, player, player.getHeldItem(hand))? EnumActionResult.SUCCESS : EnumActionResult.FAIL;

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        boolean result = soakUp(world, player.getPosition(), player, player.getHeldItem(hand));
        return ActionResult.newResult(result? EnumActionResult.SUCCESS : EnumActionResult.FAIL, player.getHeldItem(hand));
    }

    private static boolean soakUp(World world, BlockPos pos, EntityPlayer player, ItemStack stack) {
        boolean absorbedAnything = false;
        int damage = stack.getItemDamage();

        for (int x = -Config.magmaticSpongeOnAStickRange; x <= Config.magmaticSpongeOnAStickRange; x++) {
            for (int y = -Config.magmaticSpongeOnAStickRange; y <= Config.magmaticSpongeOnAStickRange; y++) {
                for (int z = -Config.magmaticSpongeOnAStickRange; z <= Config.magmaticSpongeOnAStickRange; z++) {
                    final BlockPos targetPos = pos.add(x, y, z);

                    Material material = world.getBlockState(targetPos).getMaterial();
                    if (material.isLiquid()) {
                        absorbedAnything = true;
                        world.setBlockToAir(targetPos);
                        if (++damage >= Config.magmaticSpongeMaxDamage) break;
                    }

                }
            }
        }

        if (absorbedAnything) {
            if (damage >= Config.magmaticSpongeMaxDamage) {
                stack.setCount(0);
            } else if(!player.isCreative()) {
                stack.setItemDamage(damage);
            }
            return true;
        }

        return false;
    }

}
