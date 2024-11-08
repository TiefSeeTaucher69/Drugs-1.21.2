package net.benjo.drugsmod.datagen;

import net.benjo.drugsmod.DrugsMod;
import net.benjo.drugsmod.DrugsMod;
import net.benjo.drugsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DrugsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.RAW_BISMUTH.get());

        handheldItem(ModItems.BISMUTH_SWORD.getId());
        handheldItem(ModItems.BISMUTH_PICKAXE.getId());
        handheldItem(ModItems.BISMUTH_SHOVEL.getId());
        handheldItem(ModItems.BISMUTH_AXE.getId());
        handheldItem(ModItems.BISMUTH_HOE.getId());
        handheldItem(ModItems.BISMUTH_HAMMER.getId());
    }
}
