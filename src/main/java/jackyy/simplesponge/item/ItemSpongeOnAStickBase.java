package jackyy.simplesponge.item;

import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfig;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ItemSpongeOnAStickBase extends Item {

    public ItemSpongeOnAStickBase() {
        setMaxStackSize(1);
    }

    public boolean isPowered() {
        return false;
    }

    public boolean isMagmatic() {
        return this.isMagmatic();
    }

    public boolean isCreative() {
        return false;
    }

    public int getRange() {
        return this.getRange();
    }

    public int getDmg() {
        return this.getDmg();
    }

    public int getEnergy() {
        return this.getEnergy();
    }

    public int getPerRightClickUse() {
        return this.getPerRightClickUse();
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack){
        return stack.isItemDamaged();
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        if (!isPowered()){
            tooltip.add(StringHelper.formatNumber(stack.getMaxDamage() - stack.getItemDamage()) + " / " + StringHelper.formatNumber(stack.getMaxDamage()) + " " + I18n.format("tooltip." + SimpleSponge.MODID + ".durability"));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return soakUp(world, pos, player, player.getHeldItemMainhand())? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        boolean result = soakUp(world, player.getPosition(), player, player.getHeldItemMainhand());
        return ActionResult.newResult(result? EnumActionResult.SUCCESS : EnumActionResult.FAIL, player.getHeldItemMainhand());
    }

    private boolean soakUp(World world, BlockPos pos, EntityPlayer player, ItemStack stack) {
        boolean succ = false;
        boolean hitLava = false;
        boolean allowHotLiquid = ModConfig.misc.regularSpongeAbsorbHotLiquid;
        int dmg = stack.getItemDamage();
        int maxDmg = stack.getMaxDamage();

        for (int x = -getRange(); x <= getRange(); x++) {
            for (int y = -getRange(); y <= getRange(); y++) {
                for (int z = -getRange(); z <= getRange(); z++) {
                    final BlockPos targetPos = pos.add(x, y, z);

                    Material material = world.getBlockState(targetPos).getMaterial();
                    if (material.isLiquid()) {
                        succ = true;
                        hitLava |= material == Material.LAVA;
                        if (hitLava && !isMagmatic() && !allowHotLiquid) break;
                        world.setBlockToAir(targetPos);
                        if (!player.isCreative() && !isCreative()) {
                            if (!isPowered() && ++dmg >= maxDmg) break;
                            else if (isPowered() && EnergyHelper.getEnergyStored(stack) < getPerRightClickUse()) break;
                        }
                    }

                }
            }
        }

        if (hitLava && !isMagmatic() && allowHotLiquid) {
            stack.setCount(0);
            player.setFire(6);
        }

        if (succ) {
            if (!player.isCreative() && !isCreative()) {
                if (isPowered()) {
                    if (EnergyHelper.getEnergyStored(stack) >= getPerRightClickUse()) {
                        NBTHelper.setInt(stack, EnergyHelper.ENERGY_NBT, EnergyHelper.getEnergyStored(stack) - getPerRightClickUse());
                    }
                } else {
                    if (dmg >= maxDmg) {
                        stack.setCount(0);
                    }
                    stack.setItemDamage(dmg);
                }
            }
            return true;
        }

        return false;
    }

}
