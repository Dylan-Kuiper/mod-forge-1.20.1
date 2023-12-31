package net.Destiny.destinymod.enchantment;

import net.Destiny.destinymod.DestinyMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
    DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DestinyMod.MOD_ID);

    public static final RegistryObject<Enchantment> LIGHTNINGSTRIKER =
        ENCHANTMENTS.register("lightning_striker",
                () -> new LightningStrikerEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON,
                        EquipmentSlot.MAINHAND));

    public static final  RegistryObject<Enchantment> BITE =
            ENCHANTMENTS.register("bite",
                    () -> new BiteEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON,
                            EquipmentSlot.MAINHAND));
   public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
