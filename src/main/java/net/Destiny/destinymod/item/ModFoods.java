package net.Destiny.destinymod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(20).alwaysEat().fast()
            .saturationMod(30).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 5), 1).build();
}
