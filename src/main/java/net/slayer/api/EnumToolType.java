package net.slayer.api;

import net.minecraft.item.*;

public enum EnumToolType
{
    WOOD_PICK("pickaxe", Item.ToolMaterial.WOOD.getHarvestLevel()), 
    GOLD_PICK("pickaxe", Item.ToolMaterial.GOLD.getHarvestLevel()), 
    STONE_PICK("pickaxe", Item.ToolMaterial.STONE.getHarvestLevel()), 
    IRON_PICK("pickaxe", Item.ToolMaterial.IRON.getHarvestLevel()), 
    DIAMOND_PICK("pickaxe", Item.ToolMaterial.EMERALD.getHarvestLevel());
    
    private String toolType;
    private int harvestLevel;
    
    private EnumToolType(final String toolType, final int harvestLevel) {
        this.toolType = toolType;
        this.harvestLevel = harvestLevel;
    }
    
    public String getType() {
        return this.toolType;
    }
    
    public int getLevel() {
        return this.harvestLevel;
    }
}
