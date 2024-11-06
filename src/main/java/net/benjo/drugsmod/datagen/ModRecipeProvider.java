package net.benjo.drugsmod.datagen;

import net.benjo.drugsmod.block.ModBlocks;
import net.benjo.drugsmod.item.ModItems;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    // The parameters are stored in protected fields
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        // Register recipes here
        List<ItemLike> COCAINE_SMELTABLES = List.of(ModItems.RAW_COCAINE,
                ModBlocks.COCAINE_ORE);

        // 1. Hole den HolderGetter für Items
        HolderGetter<Item> itemGetter = registries.lookupOrThrow(Registries.ITEM);

        // 2. Hole den ResourceKey des Items für den COCAINE_BLOCK
        ResourceKey<Item> cocaineBlockKey = BuiltInRegistries.ITEM.getResourceKey(ModBlocks.COCAINE_BLOCK.get().asItem())
                .orElseThrow(() -> new IllegalStateException("ResourceKey für COCAINE_BLOCK nicht gefunden."));

        ItemLike cocaineBlockItemLike = ModBlocks.COCAINE_BLOCK.get().asItem();

        ShapedRecipeBuilder.shaped(itemGetter, RecipeCategory.MISC, cocaineBlockItemLike)
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.COCAINE.get())
                .unlockedBy("has_cocaine", has(ModItems.COCAINE))
                .save(output, "cocaine_block_from_cocaine");

        ShapelessRecipeBuilder.shapeless(itemGetter, RecipeCategory.MISC, ModItems.COCAINE, 9)
                .requires(ModBlocks.COCAINE_BLOCK)
                .unlockedBy("has_cocaine_block", has(ModBlocks.COCAINE_BLOCK))
                .save(output, "cocaine_from_cocaine_block");

        oreSmelting(COCAINE_SMELTABLES, RecipeCategory.MISC, ModItems.COCAINE.get(), 0.25f, 200, "cocaine");
        oreBlasting(COCAINE_SMELTABLES, RecipeCategory.MISC, ModItems.COCAINE.get(), 0.25f, 100, "cocaine");
    }

    // The runner class, this should be added to the DataGenerator as a DataProvider
    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }
}
