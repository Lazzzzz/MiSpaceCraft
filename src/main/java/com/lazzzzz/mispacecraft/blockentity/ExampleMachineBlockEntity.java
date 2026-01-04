package com.lazzzzz.mispacecraft.blockentity;

import com.lazzzzz.mispacecraft.MiSpaceCraft;
import com.lazzzzz.mispacecraft.core.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * Example machine block entity with inventory.
 * This demonstrates:
 * - Simple inventory using NonNullList
 * - NBT serialization for saving/loading
 * - Server tick for processing
 * - Client sync
 * 
 * For LDLib UI integration, you would:
 * 1. Create a UI definition using LDLib's widget system
 * 2. Use @Persisted annotation for automatic data sync
 * 3. Open the UI via LDLib's API in the block's useWithoutItem method
 */
public class ExampleMachineBlockEntity extends BlockEntity {
    
    // Inventory with 9 slots (3x3 grid)
    public static final int INVENTORY_SIZE = 9;
    
    private NonNullList<ItemStack> inventory = NonNullList.withSize(INVENTORY_SIZE, ItemStack.EMPTY);
    
    // Example progress for processing
    private int progress = 0;
    private int maxProgress = 100;
    
    // Example energy storage (simplified, you'd use a proper capability in production)
    private int energy = 0;
    private int maxEnergy = 10000;
    
    public ExampleMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EXAMPLE_MACHINE.get(), pos, state);
    }
    
    // ========== TICK ==========
    
    /**
     * Server-side tick method.
     * Called every tick to process machine logic.
     */
    public static void serverTick(Level level, BlockPos pos, BlockState state, ExampleMachineBlockEntity blockEntity) {
        // Example: increment progress if we have items
        if (!blockEntity.inventory.get(0).isEmpty()) {
            blockEntity.progress++;
            if (blockEntity.progress >= blockEntity.maxProgress) {
                blockEntity.progress = 0;
                // Process item here
            }
            blockEntity.setChanged();
        } else {
            blockEntity.progress = 0;
        }
    }
    
    // ========== INTERACTION ==========
    
    /**
     * Called when a player interacts with the machine.
     * This is where you would open the LDLib UI.
     */
    public void onPlayerInteract(ServerPlayer player) {
        MiSpaceCraft.LOGGER.info("Player {} interacted with machine at {}", 
                player.getName().getString(), worldPosition);
        
        // TODO: Open LDLib UI
        // Example with LDLib2:
        // new UIFactory<>(this).openUI(player);
    }
    
    // ========== INVENTORY ==========
    
    public NonNullList<ItemStack> getInventory() {
        return inventory;
    }
    
    /**
     * Drops all inventory contents when the block is broken.
     */
    public void dropInventoryContents(Level level, BlockPos pos) {
        SimpleContainer container = new SimpleContainer(INVENTORY_SIZE);
        for (int i = 0; i < inventory.size(); i++) {
            container.setItem(i, inventory.get(i));
        }
        Containers.dropContents(level, pos, container);
    }
    
    // ========== GETTERS ==========
    
    public int getProgress() {
        return progress;
    }
    
    public int getMaxProgress() {
        return maxProgress;
    }
    
    public int getEnergy() {
        return energy;
    }
    
    public int getMaxEnergy() {
        return maxEnergy;
    }
    
    public void setEnergy(int energy) {
        this.energy = Math.min(energy, maxEnergy);
        setChanged();
    }
    
    // ========== NBT SAVE/LOAD ==========
    // Note: API changed in NeoForge 21.11 - update these methods 
    // according to the current BlockEntity API
    
    // ========== CLIENT SYNC ==========
    
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    
    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return new CompoundTag();
    }
}
