package com.lazzzzz.mispacecraft.core.util;

import com.lazzzzz.mispacecraft.MiSpaceCraft;

/**
 * Helper class for generating consistent translation keys.
 * Use these methods to ensure all lang keys follow the same format.
 */
public final class LanguageHelper {
    
    private LanguageHelper() {
        // Utility class, no instantiation
    }
    
    // ========== BLOCKS ==========
    
    /**
     * Generates a translation key for a block.
     * Format: block.mispacecraft.block_name
     */
    public static String block(String blockName) {
        return "block." + MiSpaceCraft.MOD_ID + "." + blockName;
    }
    
    // ========== ITEMS ==========
    
    /**
     * Generates a translation key for an item.
     * Format: item.mispacecraft.item_name
     */
    public static String item(String itemName) {
        return "item." + MiSpaceCraft.MOD_ID + "." + itemName;
    }
    
    // ========== CREATIVE TABS ==========
    
    /**
     * Generates a translation key for a creative tab.
     * Format: itemGroup.mispacecraft.tab_name or itemGroup.mispacecraft
     */
    public static String creativeTab(String tabName) {
        if (tabName == null || tabName.isEmpty()) {
            return "itemGroup." + MiSpaceCraft.MOD_ID;
        }
        return "itemGroup." + MiSpaceCraft.MOD_ID + "." + tabName;
    }
    
    /**
     * Generates the default creative tab translation key.
     */
    public static String creativeTab() {
        return creativeTab(null);
    }
    
    // ========== TOOLTIPS ==========
    
    /**
     * Generates a translation key for a tooltip.
     * Format: tooltip.mispacecraft.name
     */
    public static String tooltip(String name) {
        return "tooltip." + MiSpaceCraft.MOD_ID + "." + name;
    }
    
    // ========== MESSAGES ==========
    
    /**
     * Generates a translation key for a chat message.
     * Format: message.mispacecraft.name
     */
    public static String message(String name) {
        return "message." + MiSpaceCraft.MOD_ID + "." + name;
    }
    
    // ========== GUI ==========
    
    /**
     * Generates a translation key for GUI elements.
     * Format: gui.mispacecraft.name
     */
    public static String gui(String name) {
        return "gui." + MiSpaceCraft.MOD_ID + "." + name;
    }
    
    /**
     * Generates a translation key for container/screen titles.
     * Format: container.mispacecraft.name
     */
    public static String container(String name) {
        return "container." + MiSpaceCraft.MOD_ID + "." + name;
    }
    
    // ========== ENTITIES ==========
    
    /**
     * Generates a translation key for an entity.
     * Format: entity.mispacecraft.entity_name
     */
    public static String entity(String entityName) {
        return "entity." + MiSpaceCraft.MOD_ID + "." + entityName;
    }
    
    // ========== BIOMES ==========
    
    /**
     * Generates a translation key for a biome.
     * Format: biome.mispacecraft.biome_name
     */
    public static String biome(String biomeName) {
        return "biome." + MiSpaceCraft.MOD_ID + "." + biomeName;
    }
    
    // ========== EFFECTS ==========
    
    /**
     * Generates a translation key for a potion effect.
     * Format: effect.mispacecraft.effect_name
     */
    public static String effect(String effectName) {
        return "effect." + MiSpaceCraft.MOD_ID + "." + effectName;
    }
    
    // ========== ENCHANTMENTS ==========
    
    /**
     * Generates a translation key for an enchantment.
     * Format: enchantment.mispacecraft.enchantment_name
     */
    public static String enchantment(String enchantmentName) {
        return "enchantment." + MiSpaceCraft.MOD_ID + "." + enchantmentName;
    }
    
    // ========== ADVANCEMENTS ==========
    
    /**
     * Generates a translation key for an advancement title.
     * Format: advancement.mispacecraft.name.title
     */
    public static String advancementTitle(String name) {
        return "advancement." + MiSpaceCraft.MOD_ID + "." + name + ".title";
    }
    
    /**
     * Generates a translation key for an advancement description.
     * Format: advancement.mispacecraft.name.description
     */
    public static String advancementDescription(String name) {
        return "advancement." + MiSpaceCraft.MOD_ID + "." + name + ".description";
    }
    
    // ========== CONFIG ==========
    
    /**
     * Generates a translation key for config options.
     * Format: config.mispacecraft.name
     */
    public static String config(String name) {
        return "config." + MiSpaceCraft.MOD_ID + "." + name;
    }
    
    // ========== KEYBINDINGS ==========
    
    /**
     * Generates a translation key for keybindings.
     * Format: key.mispacecraft.name
     */
    public static String key(String name) {
        return "key." + MiSpaceCraft.MOD_ID + "." + name;
    }
    
    /**
     * Generates a translation key for keybinding categories.
     * Format: key.categories.mispacecraft
     */
    public static String keyCategory() {
        return "key.categories." + MiSpaceCraft.MOD_ID;
    }
}
