package jacky1356400.simplesponge.items;

import jacky1356400.simplesponge.Config;
import jacky1356400.simplesponge.Main;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSpongeOnAStick extends Item {

	public ItemSpongeOnAStick() {
		setMaxStackSize(1);
		setMaxDamage(Config.spongeMaxDamage);
		this.setUnlocalizedName("Sponge_On_A_Stick");
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return soakUp(world, pos, player, stack)? EnumActionResult.SUCCESS : EnumActionResult.FAIL;

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		boolean result = soakUp(world, player.getPosition(), player, stack);
		return ActionResult.newResult(result? EnumActionResult.SUCCESS : EnumActionResult.FAIL, stack);
	}

	private static boolean soakUp(World world, BlockPos pos, EntityPlayer player, ItemStack stack) {
		boolean absorbedAnything = false;
		boolean hitLava = false;
		int damage = stack.getItemDamage();

		for (int x = -Config.spongeOnAStickRange; x <= Config.spongeOnAStickRange; x++) {
			for (int y = -Config.spongeOnAStickRange; y <= Config.spongeOnAStickRange; y++) {
				for (int z = -Config.spongeOnAStickRange; z <= Config.spongeOnAStickRange; z++) {
					final BlockPos targetPos = pos.add(x, y, z);

					Material material = world.getBlockState(targetPos).getMaterial();
					if (material.isLiquid()) {
						absorbedAnything = true;
						hitLava |= material == Material.LAVA;
						world.setBlockToAir(targetPos);
						if (++damage >= Config.spongeMaxDamage) break;
					}

				}
			}
		}

		if (hitLava) {
			stack.stackSize = 0;
			player.setFire(6);
		}

		if (absorbedAnything) {
			if (damage >= Config.spongeMaxDamage) stack.stackSize = 0;
			else stack.setItemDamage(damage);
			return true;
		}

		return false;
	}

}