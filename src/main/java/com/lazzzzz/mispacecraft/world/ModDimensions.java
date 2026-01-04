package com.lazzzzz.mispacecraft.world;

import com.lazzzzz.mispacecraft.MiSpaceCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

/**
 * Registry for custom dimensions in Mi-SpaceCraft.
 */
public class ModDimensions {

    // Moon Dimension
    public static final ResourceKey<Level> MOON_LEVEL = ResourceKey.create(
            Registries.DIMENSION,
            Identifier.fromNamespaceAndPath(MiSpaceCraft.MOD_ID, "moon"));

    public static final ResourceKey<DimensionType> MOON_TYPE = ResourceKey.create(
            Registries.DIMENSION_TYPE,
            Identifier.fromNamespaceAndPath(MiSpaceCraft.MOD_ID, "moon"));

    public static void register() {
        MiSpaceCraft.LOGGER.info("Registering dimensions for Mi-SpaceCraft...");
    }
}
