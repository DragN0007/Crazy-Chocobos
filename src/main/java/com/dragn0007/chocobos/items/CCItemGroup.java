package com.dragn0007.chocobos.items;

import com.dragn0007.chocobos.CrazyChocobos;
import com.dragn0007.chocobos.blocks.CCBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CCItemGroup {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrazyChocobos.MODID);

    public static final RegistryObject<CreativeModeTab> CHOCOBO_GROUP = CREATIVE_MODE_TABS.register("chocobos",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CCItems.CHOCOBO_ICON.get())).title(Component.translatable("itemGroup.chocobos"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(CCItems.CHOCOBO_SPAWN_EGG.get());
                        output.accept(CCItems.CHOCOBO_EGG.get());
                        output.accept(CCItems.CHOCOBO.get());
                        output.accept(CCItems.COOKED_CHOCOBO.get());
                        output.accept(CCBlocks.CHOCOBO_NEST.get());

                        output.accept(CCItems.LEATHER_CHOCOBO_ARMOR.get());
                        output.accept(CCItems.IRON_CHOCOBO_ARMOR.get());
                        output.accept(CCItems.GOLD_CHOCOBO_ARMOR.get());
                        output.accept(CCItems.DIAMOND_CHOCOBO_ARMOR.get());
                        output.accept(CCItems.NETHERITE_CHOCOBO_ARMOR.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
