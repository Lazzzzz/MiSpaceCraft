package com.lazzzzz.mispacecraft.item;

import com.lazzzzz.mispacecraft.MiSpaceCraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Example item with custom behavior.
 * This demonstrates:
 * - Custom use action
 * - Adding tooltips
 * - Custom item properties
 */
public class ExampleItem extends Item {
    
    public ExampleItem(Properties properties) {
        super(properties);
    }
    
    /**
     * Called when the player right-clicks with this item.
     */
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        
        if (!level.isClientSide()) {
            // Server-side logic
            player.displayClientMessage(
                    Component.translatable("message." + MiSpaceCraft.MOD_ID + ".example_item_use"),
                    true
            );
            
            // Example: Add some cooldown (using the item stack)
            player.getCooldowns().addCooldown(stack, 20); // 1 second cooldown
        }
        
        return InteractionResult.SUCCESS;
    }
    
    /**
     * Makes the item glow like enchanted items.
     */
    @Override
    public boolean isFoil(ItemStack stack) {
        return false; // Set to true for enchanted glow effect
    }
}
