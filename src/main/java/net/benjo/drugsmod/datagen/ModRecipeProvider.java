package net.benjo.drugsmod.datagen;

import net.benjo.drugsmod.DrugsMod;
import net.benjo.drugsmod.block.ModBlocks;
import net.benjo.drugsmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> COCAINE_SMELTABLES = List.of(ModItems.RAW_COCAINE,
                ModBlocks.COCAINE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COCAINE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.COCAINE.get())
                .unlockedBy("has_cocaine", has(ModItems.COCAINE))
                .save(recipeOutput, "tutorialmod:cocaine_block_from_cocaine");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COCAINE.get(), 9)
                .requires(ModBlocks.COCAINE_BLOCK)
                .unlockedBy("has_bismuth_block", has(ModBlocks.COCAINE_BLOCK))
                .save(recipeOutput, "tutorialmod:cocaine_from_cocaine_block");

        oreSmelting(recipeOutput, COCAINE_SMELTABLES, RecipeCategory.MISC, ModItems.COCAINE.get(), 0.25f, 200, "cocaine");
        oreBlasting(recipeOutput, COCAINE_SMELTABLES, RecipeCategory.MISC, ModItems.COCAINE.get(), 0.25f, 100, "cocaine");

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
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
