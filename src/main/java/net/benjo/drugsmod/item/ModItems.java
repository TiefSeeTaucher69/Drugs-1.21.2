package net.benjo.drugsmod.item;

import net.benjo.drugsmod.DrugsMod;
import net.benjo.drugsmod.DrugsMod;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DrugsMod.MOD_ID);

    public static final DeferredItem<Item> COCAINE = ITEMS.register("cocaine",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("drugsmod", "cocaine"))).component(DataComponents.CONSUMABLE,
                    Consumable.builder()
                            .consumeSeconds(1.6f) // Will use the item in 1.6 seconds, or 32 ticks
                            .animation(ItemUseAnimation.EAT) // The animation to play while using
                            .sound(SoundEvents.GENERIC_EAT) // The sound to play while using the consumable
                            .hasConsumeParticles(true) // Sets whether to display particles
                            .onConsume(
                                    // When finished consuming, applies the effects with a 30% chance
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 1.0F)
                            )
                            .onConsume(
                                    // When finished consuming, applies the effects with a 30% chance
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 400), 1.0F)
                            )
                            .onConsume(
                                    // When finished consuming, applies the effects with a 30% chance
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONFUSION, 400), 1.0F)
                            )
                            .onConsume(
                                    // When finished consuming, applies the effects with a 30% chance
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 400), 0.25F)
                            )
                            .onConsume(
                                    // When finished consuming, applies the effects with a 30% chance
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HARM, 400), 0.25F)
                            )
                            .onConsume(
                                    // When finished consuming, applies the effects with a 30% chance
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400), 0.25F)
                            )
                            .build()
            )));

    public static final DeferredItem<Item> RAW_COCAINE = ITEMS.register("raw_cocaine",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("drugsmod", "raw_cocaine")))));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
