package jackyy.simplesponge.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {

    public static void init() {
        if (Loader.isModLoaded("openblocks")) {
            if (ModConfig.misc.openBlocksIntegration) {
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge")) != null) {
                    GameRegistry.addRecipe(
                            new ShapelessOreRecipe(
                                    new ItemStack(ModBlocks.magmaticSponge),
                                    Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge")),
                                    Items.MAGMA_CREAM
                            )
                    );
                }
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge")) == null) {
                    GameRegistry.addRecipe(
                            new ShapelessOreRecipe(
                                    new ItemStack(ModBlocks.magmaticSponge),
                                    ModBlocks.sponge,
                                    Items.MAGMA_CREAM
                            )
                    );
                    GameRegistry.addRecipe(
                            new ShapelessOreRecipe(
                                    new ItemStack(ModBlocks.sponge),
                                    new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE),
                                    "slimeball"
                            )
                    );
                }
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick")) != null) {
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(
                                    new ItemStack(ModItems.compressedSpongeOnAStick),
                                    "sss", "sss", "sss",
                                    's', Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick"))
                            )
                    );
                }
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick")) == null) {
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(
                                    new ItemStack(ModItems.compressedSpongeOnAStick),
                                    "sss", "sss", "sss", 's', ModItems.spongeOnAStick
                            )
                    );
                    GameRegistry.addRecipe(
                            new ShapedOreRecipe(
                                    new ItemStack(ModItems.spongeOnAStick),
                                    " s ", " w ", " w ",
                                    's', ModBlocks.sponge, 'w', "stickWood"
                            )
                    );
                }
            } else {
                GameRegistry.addRecipe(
                        new ShapelessOreRecipe(
                                new ItemStack(ModBlocks.sponge),
                                new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE),
                                "slimeball"
                        )
                );
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(
                                new ItemStack(ModItems.spongeOnAStick),
                                " s ", " w ", " w ",
                                's', ModBlocks.sponge, 'w', "stickWood"
                        )
                );
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(
                                new ItemStack(ModItems.compressedSpongeOnAStick),
                                "sss", "sss", "sss", 's', ModItems.spongeOnAStick
                        )
                );
                GameRegistry.addRecipe(
                        new ShapelessOreRecipe(
                                new ItemStack(ModBlocks.magmaticSponge),
                                ModBlocks.sponge,
                                Items.MAGMA_CREAM
                        )
                );
            }
        } else {
            GameRegistry.addRecipe(
                    new ShapelessOreRecipe(
                            new ItemStack(ModBlocks.sponge),
                            new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE),
                            "slimeball"
                    )
            );
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                            new ItemStack(ModItems.spongeOnAStick),
                            " s ", " w ", " w ",
                            's', ModBlocks.sponge, 'w', "stickWood"
                    )
            );
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                            new ItemStack(ModItems.compressedSpongeOnAStick),
                            "sss", "sss", "sss", 's', ModItems.spongeOnAStick
                    )
            );
            GameRegistry.addRecipe(
                    new ShapelessOreRecipe(
                            new ItemStack(ModBlocks.magmaticSponge),
                            ModBlocks.sponge,
                            Items.MAGMA_CREAM
                    )
            );
        }
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(ModItems.magmaticSpongeOnAStick),
                        " s ", " w ", " w ", 's', ModBlocks.magmaticSponge, 'w', "stickWood"
                )
        );
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(ModItems.compressedMagmaticSpongeOnAStick),
                        "sss", "sss", "sss",
                        's', ModItems.magmaticSpongeOnAStick
                )
        );
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(ModItems.energizedSpongeOnAStick),
                        " s ", " b ", " r ",
                        's', ModItems.magmaticSpongeOnAStick, 'b', Items.BLAZE_ROD, 'r', "blockRedstone"
                )
        );
    }

}
