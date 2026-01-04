package com.lazzzzz.mispacecraft;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Client-side initialization for Mi-SpaceCraft.
 * This class only loads on the client, not on dedicated servers.
 */
@Mod(value = MiSpaceCraft.MOD_ID, dist = Dist.CLIENT)
public class MiSpaceCraftClient {
    
    public MiSpaceCraftClient(ModContainer container) {
        MiSpaceCraft.LOGGER.info("Mi-SpaceCraft client initialization...");
    }
    
    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        MiSpaceCraft.LOGGER.info("Mi-SpaceCraft client setup complete!");
        
        // Register client-side things here:
        // - Block entity renderers
        // - Entity renderers
        // - Keybindings
        // - Screens
    }
}
