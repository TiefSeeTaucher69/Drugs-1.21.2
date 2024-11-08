package net.benjo.drugsmod.item;

import net.benjo.drugsmod.datagen.ModItemTagProvider;
import net.benjo.drugsmod.util.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final ToolMaterial BISMUTH = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
            1400, 4f, 3f, 28, ModTags.Items.TRANSFORMABLE_ITEMS);

}