package net.essence.blocks;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import net.essence.*;
import net.minecraft.world.*;
import net.minecraftforge.common.util.*;
import net.minecraft.client.renderer.texture.*;

public class BlockModFire extends BlockFire
{
    @SideOnly(Side.CLIENT)
    private IIcon[] tex;
    
    public BlockModFire(final String name) {
        this.setLightLevel(1.0f);
        this.setBlockName(name);
        GameRegistry.registerBlock((Block)this, name);
    }
    
    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        if (world.provider.dimensionId > 0 || !EssenceBlocks.eucaPortal.makePortal(world, x, y, z)) {
            if (!World.doesBlockHaveSolidTopSurface((IBlockAccess)world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) {
                world.setBlockToAir(x, y, z);
            }
            else {
                world.scheduleBlockUpdate(x, y, z, (Block)this, this.tickRate(world) + world.rand.nextInt(10));
            }
        }
        if (world.provider.dimensionId > 0 || !EssenceBlocks.depthsPortal.makePortal(world, x, y, z)) {
            if (!World.doesBlockHaveSolidTopSurface((IBlockAccess)world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) {
                world.setBlockToAir(x, y, z);
            }
            else {
                world.scheduleBlockUpdate(x, y, z, (Block)this, this.tickRate(world) + world.rand.nextInt(10));
            }
        }
        if (world.provider.dimensionId > 0 || !EssenceBlocks.boilPortal.makePortal(world, x, y, z)) {
            if (!World.doesBlockHaveSolidTopSurface((IBlockAccess)world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) {
                world.setBlockToAir(x, y, z);
            }
            else {
                world.scheduleBlockUpdate(x, y, z, (Block)this, this.tickRate(world) + world.rand.nextInt(10));
            }
        }
        if (world.provider.dimensionId > 0 || !EssenceBlocks.frozenPortal.makePortal(world, x, y, z)) {
            if (!World.doesBlockHaveSolidTopSurface((IBlockAccess)world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) {
                world.setBlockToAir(x, y, z);
            }
            else {
                world.scheduleBlockUpdate(x, y, z, (Block)this, this.tickRate(world) + world.rand.nextInt(10));
            }
        }
    }
    
    protected boolean canNeighborBurn(final World world, final int x, final int y, final int z) {
        return this.canCatchFire((IBlockAccess)world, x + 1, y, z, ForgeDirection.WEST) || this.canCatchFire((IBlockAccess)world, x - 1, y, z, ForgeDirection.EAST) || this.canCatchFire((IBlockAccess)world, x, y - 1, z, ForgeDirection.UP) || this.canCatchFire((IBlockAccess)world, x, y + 1, z, ForgeDirection.DOWN) || this.canCatchFire((IBlockAccess)world, x, y, z - 1, ForgeDirection.SOUTH) || this.canCatchFire((IBlockAccess)world, x, y, z + 1, ForgeDirection.NORTH);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return this.tex[0];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getFireIcon(final int meta) {
        return this.tex[meta];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.tex = new IIcon[] { icon.registerIcon("fire_layer_0"), icon.registerIcon("fire_layer_1") };
    }
}
