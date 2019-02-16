package jackyy.simplesponge.item;

import net.minecraft.item.ItemStack;

public class ItemMagmaticSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemMagmaticSpongeOnAStick() {
        setRegistryName("magmatic_sponge_on_a_stick");
        setDamage(new ItemStack(this), getDmg());
    }

    @Override
    public boolean isMagmatic() {
        return true;
    }

    @Override
    public int getDmg() {
        //return ModConfig.magneticSponge.magmaticSpongeOnAStickMaxDamage;
        return 1;
    }

    @Override
    public int getRange() {
        //return ModConfig.magneticSponge.magmaticSpongeOnAStickRange;
        return 1;
    }

}
