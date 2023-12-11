package net.Destiny.destinymod.item;

import net.Destiny.destinymod.DestinyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DestinyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DESTINY_MOD = CREATIVE_MODE_TABS.register("destiny_mod",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.destiny_mod"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Moditems.RAW_SAPPHIRE.get());
                        pOutput.accept(Moditems.SAPPHIRE.get());
                        pOutput.accept(Moditems.ORE_DETECTOR.get());
                        pOutput.accept(Moditems.STRAWBERRY.get());
                        pOutput.accept(Moditems.SAPPHIRE_STAFF.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
