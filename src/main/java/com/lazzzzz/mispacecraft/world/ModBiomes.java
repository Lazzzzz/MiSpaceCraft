package com.lazzzzz.mispacecraft.world;

import com.lazzzzz.mispacecraft.MiSpaceCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biome;

/**
 * Registry for custom biomes in Mi-SpaceCraft.
 */
public class ModBiomes {

    // Moon Biome - Flat terrain with craters
    public static final ResourceKey<Biome> MOON_SURFACE = ResourceKey.create(
            Registries.BIOME,
            Identifier.fromNamespaceAndPath(MiSpaceCraft.MOD_ID, "moon_surface"));

    public static void register() {
        MiSpaceCraft.LOGGER.info("Registering biomes for Mi-SpaceCraft...");
    }
}
