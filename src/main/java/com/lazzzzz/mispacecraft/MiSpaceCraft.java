package com.lazzzzz.mispacecraft;

import com.lazzzzz.mispacecraft.core.registry.*;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

/**
 * Main mod class for Mi-SpaceCraft.
 * A modern space exploration mod for Minecraft.
 */
@Mod(MiSpaceCraft.MOD_ID)
public class MiSpaceCraft {
    
    public static final String MOD_ID = "mispacecraft";
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public MiSpaceCraft(IEventBus modEventBus, ModContainer modContainer) {
        // Register mod lifecycle events
        modEventBus.addListener(this::commonSetup);
        
        // Register all deferred registers
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        
        // Register for game events
        NeoForge.EVENT_BUS.register(this);
        
        LOGGER.info("Mi-SpaceCraft is loading...");
    }
    
    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Mi-SpaceCraft common setup complete!");
    }
    
    @net.neoforged.bus.api.SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Mi-SpaceCraft server starting...");
    }
}
