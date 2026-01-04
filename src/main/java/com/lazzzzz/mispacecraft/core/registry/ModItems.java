package com.lazzzzz.mispacecraft.core.registry;

import com.lazzzzz.mispacecraft.MiSpaceCraft;
import com.lazzzzz.mispacecraft.item.ExampleItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Registry for all mod items.
 * Block items are registered in ModBlocks.
 */
public class ModItems {
    
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MiSpaceCraft.MOD_ID);
    
    // ========== EXAMPLE ITEMS ==========
    
    /**
     * A simple example item with custom use behavior.
     */
    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerItem("example_item",
            ExampleItem::new,
            new Item.Properties().stacksTo(64));
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
