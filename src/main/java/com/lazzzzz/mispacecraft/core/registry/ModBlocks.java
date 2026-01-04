package com.lazzzzz.mispacecraft.core.registry;

import com.lazzzzz.mispacecraft.MiSpaceCraft;
import com.lazzzzz.mispacecraft.block.ExampleBlock;
import com.lazzzzz.mispacecraft.block.ExampleMachineBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Registry for all mod blocks.
 * Use the helper methods to register blocks with their corresponding items.
 */
public class ModBlocks {
    
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MiSpaceCraft.MOD_ID);
    
    // ========== EXAMPLE BLOCKS ==========
    
    /**
     * A simple example block with basic properties.
     */
    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerBlock(
            "example_block",
            ExampleBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(3.0f, 3.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
    );
    
    /**
     * An example machine block with a block entity.
     * This block has an inventory and can be interacted with.
     */
    public static final DeferredBlock<Block> EXAMPLE_MACHINE = BLOCKS.registerBlock(
            "example_machine",
            ExampleMachineBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(4.0f, 6.0f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
    );
    
    // Register block items
    static {
        ModItems.ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);
        ModItems.ITEMS.registerSimpleBlockItem("example_machine", EXAMPLE_MACHINE);
    }
    
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
