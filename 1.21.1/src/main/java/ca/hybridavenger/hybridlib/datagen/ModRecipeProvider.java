package ca.hybridavenger.hybridlib.datagen;

import ca.hybridavenger.hybridlib.HybridLib;
import ca.hybridavenger.hybridlib.block.BlockRegistry;
import ca.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> TECH_SMELTABLES = List.of(ItemRegistry.RAW_TECH.get(),
                BlockRegistry.TECH_ORE.get(), BlockRegistry.DEEPSLATE_TECH_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.TECH_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ItemRegistry.TECH_INGOT.get())
                .unlockedBy(getHasName(ItemRegistry.TECH_INGOT.get()), has(ItemRegistry.TECH_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.AETHERIUM_GEM.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ItemRegistry.AETHERIUM_GEM_FRAGMENT.get())
                .unlockedBy(getHasName(ItemRegistry.AETHERIUM_GEM_FRAGMENT.get()), has(ItemRegistry.AETHERIUM_GEM_FRAGMENT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.EUCLASE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ItemRegistry.EUCLASE_GEM.get())
                .unlockedBy(getHasName(ItemRegistry.EUCLASE_GEM.get()), has(ItemRegistry.EUCLASE_GEM.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.TECH_INGOT.get(), 9)
                .requires(BlockRegistry.TECH_BLOCK.get())
                .unlockedBy("has_tech_block", has(BlockRegistry.TECH_BLOCK.get()))
                .save(pRecipeOutput, "hybridlib:tech_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.EUCLASE_GEM.get(), 9)
                .requires(BlockRegistry.EUCLASE_BLOCK.get())
                .unlockedBy("has_euclase_block", has(BlockRegistry.EUCLASE_BLOCK.get()))
                .save(pRecipeOutput, "hybridlib:euclase_gem_from_block");

        oreSmelting(pRecipeOutput, TECH_SMELTABLES, RecipeCategory.MISC, ItemRegistry.TECH_INGOT.get(), 0.25f, 200, "tech");
        oreBlasting(pRecipeOutput, TECH_SMELTABLES, RecipeCategory.MISC, ItemRegistry.TECH_INGOT.get(), 0.25f, 100, "tech");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockRegistry.COMPRESSED_OBSIDIAN.get())
                .requires(Blocks.OBSIDIAN)
                .requires(Blocks.OBSIDIAN)
                .unlockedBy("obsidian", has(BlockRegistry.COMPRESSED_OBSIDIAN.get()))
                .save(pRecipeOutput);

        //ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.FUSION_CHAMBER.get())
        //        .pattern("NAN")
          //      .pattern("AFA")
          //      .pattern("NAN")
           //     .define('N', ItemRegistry.NETHER_INGOT.get())
           //     .define('A', ItemRegistry.AETHERIUM_GEM.get())
            //    .define('F', Blocks.BLAST_FURNACE)
             //   .unlockedBy("has_nether", has(ItemRegistry.NETHER_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.NETHER_INGOT.get())
                .requires(Items.NETHER_STAR)
                .requires(ItemRegistry.DOUBLE_NETHERITE_INGOT.get())
                .unlockedBy("netherite", has(ItemRegistry.DOUBLE_NETHERITE_INGOT.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.DOUBLE_NETHERITE_INGOT.get())
                .requires(Items.NETHERITE_INGOT, 2)
                .unlockedBy("netherite", has(Items.NETHERITE_INGOT))
                .save(pRecipeOutput);



    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }



    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, HybridLib.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }


    }

}