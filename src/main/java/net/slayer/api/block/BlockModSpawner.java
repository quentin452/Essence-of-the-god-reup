package net.slayer.api.block;

import net.minecraft.block.material.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import java.util.*;

public class BlockModSpawner extends BlockContainer
{
    protected String name;
    protected String mobName;
    
    public BlockModSpawner(final String name, final String mobName) {
        this(name, mobName, "spawner");
    }
    
    public BlockModSpawner(final String name, final String mobName, final String textureName) {
        super(Material.rock);
        this.name = name;
        this.mobName = mobName;
        this.setBlockName(name);
        this.setBlockTextureName("eotg:" + textureName);
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        GameRegistry.registerBlock((Block)this, name);
    }
    
    public TileEntity createNewTileEntity(final World world, final int par1) {
        final TileEntityMobSpawner spawner = new TileEntityMobSpawner();
        this.setEntityName(spawner);
        return (TileEntity)spawner;
    }
    
    protected void setEntityName(final TileEntityMobSpawner spawner) {
        spawner.func_145881_a().setEntityName(this.mobName);
    }
    
    public int quantityDropped(final Random par1Random) {
        return 0;
    }
    
    public void dropBlockAsItemWithChance(final World world, final int x, final int y, final int z, final int par5, final float par6, final int par7) {
        super.dropBlockAsItemWithChance(world, x, y, z, par5, par6, par7);
        final int var8 = 15 + world.rand.nextInt(15) + world.rand.nextInt(15);
        this.dropXpOnBlockBreak(world, x, y, z, var8);
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
}
