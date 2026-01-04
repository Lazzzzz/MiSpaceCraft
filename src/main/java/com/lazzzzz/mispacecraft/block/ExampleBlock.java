package com.lazzzzz.mispacecraft.block;

import net.minecraft.world.level.block.Block;

/**
 * A simple example block.
 * This demonstrates the basic structure for creating custom blocks.
 * 
 * To create a new simple block:
 * 1. Extend Block (or a subclass like FallingBlock, SlabBlock, etc.)
 * 2. Register it in ModBlocks using registerBlockWithItem()
 * 3. Create a blockstate JSON, block model, item model, and texture
 * 4. Add datagen providers for loot tables, recipes, and tags
 */
public class ExampleBlock extends Block {
    
    public ExampleBlock(Properties properties) {
        super(properties);
    }
    
    // Override methods here to customize behavior:
    // - onPlace() for when the block is placed
    // - playerDestroy() for custom drop behavior
    // - stepOn() for entity stepping on the block
    // - etc.
}
