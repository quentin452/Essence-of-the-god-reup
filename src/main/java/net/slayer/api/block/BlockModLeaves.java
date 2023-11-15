package net.slayer.api.block;

import net.minecraftforge.common.*;
import net.slayer.api.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.client.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import java.util.*;

public class BlockModLeaves extends BlockMod implements IShearable
{
    protected int[] adjacentTreeBlocks;
    
    public BlockModLeaves(final String name, final float hardness) {
        super(EnumMaterialTypes.LEAVES, name, hardness);
        this.setHardness(0.3f);
        this.setLightOpacity(1);
        this.setTickRandomly(true);
    }
    
    public void breakBlock(final World world, final int x, final int y, final int z, final Block par5Block, final int par6) {
        final byte b0 = 1;
        final int i1 = b0 + 1;
        if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1)) {
            for (int j1 = -b0; j1 <= b0; ++j1) {
                for (int k1 = -b0; k1 <= b0; ++k1) {
                    for (int l1 = -b0; l1 <= b0; ++l1) {
                        final Block block = world.getBlock(x + j1, y + k1, z + l1);
                        if (block.isLeaves((IBlockAccess)world, x + j1, y + k1, z + l1)) {
                            block.beginLeavesDecay(world, x + j1, y + k1, z + l1);
                        }
                    }
                }
            }
        }
    }
    
    public void updateTick(final World world, final int x, final int y, final int z, final Random rand) {
        if (!world.isRemote) {
            final int l = world.getBlockMetadata(x, y, z);
            if ((l & 0x8) != 0x0 && (l & 0x4) == 0x0) {
                final byte b0 = 4;
                final int i1 = b0 + 1;
                final byte b2 = 32;
                final int j1 = b2 * b2;
                final int k1 = b2 / 2;
                if (this.adjacentTreeBlocks == null) {
                    this.adjacentTreeBlocks = new int[b2 * b2 * b2];
                }
                int l2 = 0;
                if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1)) {
                    int i2 = 0;
                    int j2 = 0;
                    for (l2 = -b0; l2 <= b0; ++l2) {
                        for (i2 = -b0; i2 <= b0; ++i2) {
                            for (j2 = -b0; j2 <= b0; ++j2) {
                                final Block block = world.getBlock(x + l2, y + i2, z + j2);
                                if (!block.canSustainLeaves((IBlockAccess)world, x + l2, y + i2, z + j2)) {
                                    if (block.isLeaves((IBlockAccess)world, x + l2, y + i2, z + j2)) {
                                        this.adjacentTreeBlocks[(l2 + k1) * j1 + (i2 + k1) * b2 + j2 + k1] = -2;
                                    }
                                    else {
                                        this.adjacentTreeBlocks[(l2 + k1) * j1 + (i2 + k1) * b2 + j2 + k1] = -1;
                                    }
                                }
                                else {
                                    this.adjacentTreeBlocks[(l2 + k1) * j1 + (i2 + k1) * b2 + j2 + k1] = 0;
                                }
                            }
                        }
                    }
                    for (l2 = 1; l2 <= 4; ++l2) {
                        for (i2 = -b0; i2 <= b0; ++i2) {
                            for (j2 = -b0; j2 <= b0; ++j2) {
                                for (int k2 = -b0; k2 <= b0; ++k2) {
                                    if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b2 + k2 + k1] == l2 - 1) {
                                        if (this.adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b2 + k2 + k1] == -2) {
                                            this.adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b2 + k2 + k1] = l2;
                                        }
                                        if (this.adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b2 + k2 + k1] == -2) {
                                            this.adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b2 + k2 + k1] = l2;
                                        }
                                        if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b2 + k2 + k1] == -2) {
                                            this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b2 + k2 + k1] = l2;
                                        }
                                        if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b2 + k2 + k1] == -2) {
                                            this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b2 + k2 + k1] = l2;
                                        }
                                        if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b2 + (k2 + k1 - 1)] == -2) {
                                            this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b2 + (k2 + k1 - 1)] = l2;
                                        }
                                        if (this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b2 + k2 + k1 + 1] == -2) {
                                            this.adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b2 + k2 + k1 + 1] = l2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                l2 = this.adjacentTreeBlocks[k1 * j1 + k1 * b2 + k1];
                if (l2 >= 0) {
                    world.setBlockMetadataWithNotify(x, y, z, l & 0xFFFFFFF7, 4);
                }
                else {
                    this.removeLeaves(world, x, y, z);
                }
            }
        }
    }
    
    protected void removeLeaves(final World world, final int x, final int y, final int z) {
        this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
        world.setBlockToAir(x, y, z);
    }
    
    public void beginLeavesDecay(final World world, final int x, final int y, final int z) {
        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 0x8, 4);
    }
    
    public boolean isLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess w, final int x, final int y, final int z, final int meta) {
        final Block block = w.getBlock(x, y, z);
        return (Minecraft.getMinecraft().gameSettings.fancyGraphics || block != this) && super.shouldSideBeRendered(w, x, y, z, meta);
    }
    
    public Item getItemDropped(final int par1, final Random rand, final int par3) {
        return null;
    }
    
    public boolean isShearable(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z, final int fortune) {
        final ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack((Block)this, 1, world.getBlockMetadata(x, y, z) & 0x3));
        return ret;
    }
}
