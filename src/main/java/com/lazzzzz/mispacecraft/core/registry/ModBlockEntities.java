package com.lazzzzz.mispacecraft.core.registry;

import com.lazzzzz.mispacecraft.MiSpaceCraft;
import com.lazzzzz.mispacecraft.blockentity.ExampleMachineBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;

/**
 * Registry for all mod block entities.
 */
public class ModBlockEntities {
    
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MiSpaceCraft.MOD_ID);
    
    // ========== EXAMPLE BLOCK ENTITIES ==========
    
    /**
     * Block entity type for the example machine.
     * Has inventory and energy storage capabilities.
     */
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ExampleMachineBlockEntity>> EXAMPLE_MACHINE = 
            BLOCK_ENTITIES.register("example_machine",
                    () -> new BlockEntityType<>(
                            ExampleMachineBlockEntity::new,
                            Set.of(ModBlocks.EXAMPLE_MACHINE.get())
                    ));
    
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
