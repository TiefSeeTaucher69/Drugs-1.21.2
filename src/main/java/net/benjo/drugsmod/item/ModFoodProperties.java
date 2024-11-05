package net.benjo.drugsmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties COCAINE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 400), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 400), 0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400), 0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 400), 0.25f).build();



}
