package net.benjo.drugsmod.item;

import net.benjo.drugsmod.DrugsMod;
import net.benjo.drugsmod.DrugsMod;
import net.benjo.drugsmod.block.ModBlocks;
import net.benjo.drugsmod.item.custom.HammerItem;
import net.benjo.drugsmod.util.ModTags;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DrugsMod.MOD_ID);


    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("drugsmod", "bismuth")))));

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("drugsmod", "raw_bismuth")))));


    public static final DeferredItem<HammerItem> BISMUTH_HAMMER = ITEMS.register("bismuth_hammer",
            () -> new HammerItem(ModToolTiers.BISMUTH, 7F, -3.5f, ModToolTiers.BISMUTH.applyToolProperties(
                    new Item.Properties().setId(
                            ResourceKey.create(Registries.ITEM,
                                    ResourceLocation.fromNamespaceAndPath("drugsmod", "bismuth_hammer")
                            )
                    ),
                    ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
                    7F,
                    -3.5f
            )));

    public static final DeferredItem<SwordItem> BISMUTH_SWORD = ITEMS.register("bismuth_sword",
            () -> new SwordItem(ModToolTiers.BISMUTH, 5F, -2.4f, ModToolTiers.BISMUTH.applyToolProperties(
                    new Item.Properties().setId(
                            ResourceKey.create(Registries.ITEM,
                                    ResourceLocation.fromNamespaceAndPath("drugsmod", "bismuth_sword")
                            )
                    ),
                    ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
                    5F,
                    -2.4f
            )));

    public static final DeferredItem<PickaxeItem> BISMUTH_PICKAXE = ITEMS.register("bismuth_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BISMUTH, 1.0F, -2.8f, ModToolTiers.BISMUTH.applyToolProperties(
                    new Item.Properties().setId(
                            ResourceKey.create(Registries.ITEM,
                                    ResourceLocation.fromNamespaceAndPath("drugsmod", "bismuth_pickaxe")
                            )
                    ),
                    ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
                    1.0F,
                    -2.8f
            )));

    public static final DeferredItem<ShovelItem> BISMUTH_SHOVEL = ITEMS.register("bismuth_shovel",
            () -> new ShovelItem(ModToolTiers.BISMUTH, 1.5F, -3.0f, ModToolTiers.BISMUTH.applyToolProperties(
                    new Item.Properties().setId(
                            ResourceKey.create(Registries.ITEM,
                                    ResourceLocation.fromNamespaceAndPath("drugsmod", "bismuth_shovel")
                            )
                    ),
                    ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
                    1.5F,
                    -3.0f
            )));

    public static final DeferredItem<AxeItem> BISMUTH_AXE = ITEMS.register("bismuth_axe",
            () -> new AxeItem(ModToolTiers.BISMUTH, 6.0F, -3.2f, ModToolTiers.BISMUTH.applyToolProperties(
                    new Item.Properties().setId(
                            ResourceKey.create(Registries.ITEM,
                                    ResourceLocation.fromNamespaceAndPath("drugsmod", "bismuth_axe")
                            )
                    ),
                    ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
                    6.0F,
                    -3.2f
            )));

    public static final DeferredItem<HoeItem> BISMUTH_HOE = ITEMS.register("bismuth_hoe",
            () -> new HoeItem(ModToolTiers.BISMUTH, 0F, -3.0f, ModToolTiers.BISMUTH.applyToolProperties(
                    new Item.Properties().setId(
                            ResourceKey.create(Registries.ITEM,
                                    ResourceLocation.fromNamespaceAndPath("drugsmod", "bismuth_hoe")
                            )
                    ),
                    ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
                    0F,
                    -3.0f
            )));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
