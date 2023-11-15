package net.slayer.api;

import net.minecraft.block.material.*;
import net.minecraft.block.*;

public enum EnumMaterialTypes
{
    STONE(Material.rock, Block.soundTypeStone), 
    LEAVES(Material.leaves, Block.soundTypeGrass), 
    DIRT(Material.ground, Block.soundTypeGravel), 
    WOOD(Material.wood, Block.soundTypeWood), 
    GRASS(Material.grass, Block.soundTypeGrass), 
    GLASS(Material.glass, Block.soundTypeGlass), 
    PORTAL(Material.portal, Block.soundTypeStone), 
    VINES(Material.vine, Block.soundTypeGrass), 
    PLANT(Material.plants, Block.soundTypeGrass), 
    SNOW(Material.snow, Block.soundTypeSnow), 
    WOOL(Material.cloth, Block.soundTypeCloth), 
    METAL_SOUND(Material.rock, Block.soundTypeMetal);
    
    private Material m;
    private Block.SoundType s;
    
    private EnumMaterialTypes(final Material m, final Block.SoundType s) {
        this.m = m;
        this.s = s;
    }
    
    public Material getMaterial() {
        return this.m;
    }
    
    public Block.SoundType getSound() {
        return this.s;
    }
}
