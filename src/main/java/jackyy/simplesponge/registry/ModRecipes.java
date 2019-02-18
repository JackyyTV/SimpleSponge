package jackyy.simplesponge.registry;

import jackyy.simplesponge.SimpleSponge;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;

public class ModRecipes {

    public static void registerConditions() {
        CraftingHelper.register(
                new ResourceLocation(SimpleSponge.MODID, "sponge"),
                json -> () -> JsonUtils.getBoolean(json, "enabled", true)
        );
        CraftingHelper.register(
                new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge"),
                json -> () -> JsonUtils.getBoolean(json, "enabled", true)
        );
        CraftingHelper.register(
                new ResourceLocation(SimpleSponge.MODID, "sponge_on_a_stick"),
                json -> () -> JsonUtils.getBoolean(json, "enabled", true)
        );
        CraftingHelper.register(
                new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge_on_a_stick"),
                json -> () -> JsonUtils.getBoolean(json, "enabled", true)
        );
        CraftingHelper.register(
                new ResourceLocation(SimpleSponge.MODID, "compressed_sponge_on_a_stick"),
                json -> () -> JsonUtils.getBoolean(json, "enabled", true)
        );
        CraftingHelper.register(
                new ResourceLocation(SimpleSponge.MODID, "compressed_magmatic_sponge_on_a_stick"),
                json -> () -> JsonUtils.getBoolean(json, "enabled", true)
        );
        CraftingHelper.register(
                new ResourceLocation(SimpleSponge.MODID, "energized_sponge_on_a_stick"),
                json -> () -> JsonUtils.getBoolean(json, "enabled", true)
        );
    }

    public static void init() {
        /*
        if (ModList.get().isLoaded("openblocks")) {
            if (ModConfig.misc.openBlocksIntegration) {
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge")) != null) {
                    GameRegistry.addShapelessRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge_ob"),
                            null,
                            new ItemStack(ModBlocks.magmaticSponge),
                            Ingredient.fromItem(Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge"))),
                            Ingredient.fromItem(Items.MAGMA_CREAM)
                    );
                }
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge")) == null) {
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
                            Ingredient.fromStacks(ModUtils.getStacksFromOreDict("slimeball"))
                    );
                }
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick")) != null) {
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(SimpleSponge.MODID, "compressed_sponge_on_a_stick_ob"),
                            null,
                            new ItemStack(ModItems.compressedSpongeOnAStick),
                            "sss", "sss", "sss", 's', Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick"))
                    );
                }
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick")) == null) {
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
                            " s ", " w ", " w ",
                            's', ModBlocks.sponge, 'w', "stickWood"
                    );
                }
            } else {
                GameRegistry.addShapelessRecipe(
                        new ResourceLocation(SimpleSponge.MODID, "sponge"),
                        null,
                        new ItemStack(ModBlocks.sponge),
                        Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE)),
                        Ingredient.fromStacks(ModUtils.getStacksFromOreDict("slimeball"))
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(SimpleSponge.MODID, "sponge_on_a_stick"),
                        null,
                        new ItemStack(ModItems.spongeOnAStick),
                        " s ", " w ", " w ",
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
            }
        } else {
            GameRegistry.addShapelessRecipe(
                    new ResourceLocation(SimpleSponge.MODID, "sponge"),
                    null,
                    new ItemStack(ModBlocks.sponge),
                    Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE)),
                    Ingredient.fromStacks(ModUtils.getStacksFromOreDict("slimeball"))
            );
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(SimpleSponge.MODID, "sponge_on_a_stick"),
                    null,
                    new ItemStack(ModItems.spongeOnAStick),
                    " s ", " w ", " w ",
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
        }
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SimpleSponge.MODID, "magmatic_sponge_on_a_stick"),
                null,
                new ItemStack(ModItems.magmaticSpongeOnAStick),
                " s ", " w ", " w ", 's', ModBlocks.magmaticSponge, 'w', "stickWood"
        );
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SimpleSponge.MODID, "compressed_magmatic_sponge_on_a_stick"),
                null,
                new ItemStack(ModItems.compressedMagmaticSpongeOnAStick),
                "sss", "sss", "sss",
                's', ModItems.magmaticSpongeOnAStick
        );
        if (ModList.get().isLoaded("redstoneflux")) {
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(SimpleSponge.MODID, "energized_sponge_on_a_stick"),
                    null,
                    new ItemStack(ModItems.energizedSpongeOnAStick),
                    " s ", " b ", " r ",
                    's', ModItems.magmaticSpongeOnAStick, 'b', Items.BLAZE_ROD, 'r', "blockRedstone"
            );
        }
        */
    }

}
