package com.lazzzzz.mispacecraft.core.registry;

import com.lazzzzz.mispacecraft.MiSpaceCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Registry for creative mode tabs.
 * All mod items will be displayed in a single tab.
 */
public class ModCreativeTabs {
    
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = 
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MiSpaceCraft.MOD_ID);
    
    /**
     * Main creative tab for all Mi-SpaceCraft items.
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = CREATIVE_TABS.register("main_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + MiSpaceCraft.MOD_ID))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.EXAMPLE_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        // Add all mod items here
                        // Items
                        output.accept(ModItems.EXAMPLE_ITEM.get());
                        
                        // Blocks
                        output.accept(ModBlocks.EXAMPLE_BLOCK.get());
                        output.accept(ModBlocks.EXAMPLE_MACHINE.get());
                    })
                    .build());
    
    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
