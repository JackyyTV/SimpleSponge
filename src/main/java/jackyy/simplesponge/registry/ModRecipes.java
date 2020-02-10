package jackyy.simplesponge.registry;

import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.simplesponge.SimpleSponge;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {

    public static void init() {
        if (Loader.isModLoaded("openblocks")) {
            if (ModConfig.misc.openBlocksIntegration) {
                if (ObjectHelper.getItemByName("openblocks", "sponge")  != null) {
                    GameRegistry.addShapelessRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge_ob"),
                            null,
                            new ItemStack(ModBlocks.magmaticSponge),
                            Ingredient.fromItem(ObjectHelper.getItemByName("openblocks", "sponge")),
                            Ingredient.fromItem(Items.MAGMA_CREAM)
                    );
                }
                if (ObjectHelper.getItemByName("openblocks", "sponge") == null) {
                    GameRegistry.addShapelessRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge"),
                            null,
                            new ItemStack(ModBlocks.magmaticSponge),
                            Ingredient.fromStacks(new ItemStack(ModBlocks.sponge)),
                            Ingredient.fromItem(Items.MAGMA_CREAM)
                    );
                    GameRegistry.addShapelessRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "sponge"),
                            null,
                            new ItemStack(ModBlocks.sponge),
                            Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE)),
                            Ingredient.fromStacks(ObjectHelper.getStacksFromOreDict("slimeball"))
                    );
                }
                if (ObjectHelper.getItemByName("openblocks", "sponge_on_a_stick") != null) {
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "compressed_sponge_on_a_stick_ob"),
                            null,
                            new ItemStack(ModItems.compressedSpongeOnAStick),
                            "sss", "sss", "sss", 's', ObjectHelper.getItemByName("openblocks", "sponge_on_a_stick")
                    );
                    GameRegistry.addShapelessRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge_on_a_stick_upgrade_ob"),
                            null,
                            new ItemStack(ModItems.magmaticSpongeOnAStick),
                            Ingredient.fromStacks(ObjectHelper.getItemStackByName("openblocks", "sponge_on_a_stick", 1 , 0)),
                            Ingredient.fromItem(Items.MAGMA_CREAM)
                    );
                }
                if (ObjectHelper.getItemByName("openblocks", "sponge_on_a_stick") == null) {
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "compressed_sponge_on_a_stick"),
                            null,
                            new ItemStack(ModItems.compressedSpongeOnAStick),
                            "sss", "sss", "sss", 's', ModItems.spongeOnAStick
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "sponge_on_a_stick"),
                            null,
                            new ItemStack(ModItems.spongeOnAStick),
                            "s", "w", "w",
                            's', ModBlocks.sponge, 'w', "stickWood"
                    );
                    GameRegistry.addShapelessRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge_on_a_stick_upgrade"),
                            null,
                            new ItemStack(ModItems.magmaticSpongeOnAStick),
                            Ingredient.fromStacks(new ItemStack(ModItems.spongeOnAStick)),
                            Ingredient.fromItem(Items.MAGMA_CREAM)
                    );
                }
            } else {
                addAllDefaultRecipes();
            }
        } else {
            addAllDefaultRecipes();
        }
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge_on_a_stick"),
                null,
                new ItemStack(ModItems.magmaticSpongeOnAStick),
                "s", "w", "w", 's', ModBlocks.magmaticSponge, 'w', "stickWood"
        );
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SimpleSponge.MODID, "compressed_magmatic_sponge_on_a_stick"),
                null,
                new ItemStack(ModItems.compressedMagmaticSpongeOnAStick),
                "sss", "sss", "sss",
                's', ModItems.magmaticSpongeOnAStick
        );
        if (ModConfig.energizedSponge.enableEnergizedSpongeOnAStick) {
            if (Loader.isModLoaded("redstoneflux")) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(SimpleSponge.MODID, "energized_sponge_on_a_stick"),
                        null,
                        new ItemStack(ModItems.energizedSpongeOnAStick),
                        "rsr", "gbg", "rbr",
                        's', ModItems.magmaticSpongeOnAStick, 'b', Items.BLAZE_ROD, 'r', "dustRedstone", 'g', "ingotGold"
                );
            }
        }
    }

    private static void addAllDefaultRecipes() {
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(SimpleSponge.MODID, "sponge"),
                null,
                new ItemStack(ModBlocks.sponge),
                Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE)),
                Ingredient.fromStacks(ObjectHelper.getStacksFromOreDict("slimeball"))
        );
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SimpleSponge.MODID, "sponge_on_a_stick"),
                null,
                new ItemStack(ModItems.spongeOnAStick),
                "s", "w", "w",
                's', ModBlocks.sponge, 'w', "stickWood"
        );
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SimpleSponge.MODID, "compressed_sponge_on_a_stick"),
                null,
                new ItemStack(ModItems.compressedSpongeOnAStick),
                "sss", "sss", "sss", 's', ModItems.spongeOnAStick
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge"),
                null,
                new ItemStack(ModBlocks.magmaticSponge),
                Ingredient.fromStacks(new ItemStack(ModBlocks.sponge)),
                Ingredient.fromItem(Items.MAGMA_CREAM)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge_on_a_stick_upgrade"),
                null,
                new ItemStack(ModItems.magmaticSpongeOnAStick),
                Ingredient.fromStacks(new ItemStack(ModItems.spongeOnAStick)),
                Ingredient.fromItem(Items.MAGMA_CREAM)
        );
    }

}
