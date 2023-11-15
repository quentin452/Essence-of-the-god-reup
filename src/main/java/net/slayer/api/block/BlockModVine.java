package net.slayer.api.block;

import net.minecraftforge.common.*;
import net.slayer.api.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.entity.*;

public class BlockModVine extends BlockMod implements IShearable
{
    public BlockModVine(final String name) {
        super(EnumMaterialTypes.VINES, name, 0.0f);
        this.setTickRandomly(true);
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
    }
    
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public int getRenderType() {
        return 20;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess blockAccess, final int x, final int y, final int z) {
        final float f = 0.0625f;
        final int l = blockAccess.getBlockMetadata(x, y, z);
        float f2 = 1.0f;
        float f3 = 1.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean flag = l > 0;
        if ((l & 0x2) != 0x0) {
            f5 = Math.max(f5, 0.0625f);
            f2 = 0.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            f4 = 0.0f;
            f7 = 1.0f;
            flag = true;
        }
        if ((l & 0x8) != 0x0) {
            f2 = Math.min(f2, 0.9375f);
            f5 = 1.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            f4 = 0.0f;
            f7 = 1.0f;
            flag = true;
        }
        if ((l & 0x4) != 0x0) {
            f7 = Math.max(f7, 0.0625f);
            f4 = 0.0f;
            f2 = 0.0f;
            f5 = 1.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            flag = true;
        }
        if ((l & 0x1) != 0x0) {
            f4 = Math.min(f4, 0.9375f);
            f7 = 1.0f;
            f2 = 0.0f;
            f5 = 1.0f;
            f3 = 0.0f;
            f6 = 1.0f;
            flag = true;
        }
        if (!flag && this.canBePlacedOnBlock(blockAccess.getBlock(x, y + 1, z))) {
            f3 = Math.min(f3, 0.9375f);
            f6 = 1.0f;
            f2 = 0.0f;
            f5 = 1.0f;
            f4 = 0.0f;
            f7 = 1.0f;
        }
        this.setBlockBounds(f2, f3, f4, f5, f6, f7);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World world, final int x, final int y, final int z) {
        return null;
    }
    
    public boolean canPlaceBlockOnSide(final World world, final int x, final int y, final int z, final int side) {
        switch (side) {
            case 1: {
                return this.canBePlacedOnBlock(world.getBlock(x, y + 1, z));
            }
            case 2: {
                return this.canBePlacedOnBlock(world.getBlock(x, y, z + 1));
            }
            case 3: {
                return this.canBePlacedOnBlock(world.getBlock(x, y, z - 1));
            }
            case 4: {
                return this.canBePlacedOnBlock(world.getBlock(x + 1, y, z));
            }
            case 5: {
                return this.canBePlacedOnBlock(world.getBlock(x - 1, y, z));
            }
            default: {
                return false;
            }
        }
    }
    
    protected boolean canBePlacedOnBlock(final Block block) {
        return block.renderAsNormalBlock() && block.getMaterial().blocksMovement();
    }
    
    protected boolean areVinesOnBlock(final World world, final int x, final int y, final int z) {
        int i1;
        final int l = i1 = world.getBlockMetadata(x, y, z);
        if (l > 0) {
            for (int j1 = 0; j1 <= 3; ++j1) {
                final int k1 = 1 << j1;
                if ((l & k1) != 0x0 && !this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[j1], y, z + Direction.offsetZ[j1])) && (world.getBlock(x, y + 1, z) != this || (world.getBlockMetadata(x, y + 1, z) & k1) == 0x0)) {
                    i1 &= ~k1;
                }
            }
        }
        if (i1 == 0 && !this.canBePlacedOnBlock(world.getBlock(x, y + 1, z))) {
            return false;
        }
        if (i1 != l) {
            world.setBlockMetadataWithNotify(x, y, z, i1, 2);
        }
        return true;
    }
    
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        if (!world.isRemote && !this.areVinesOnBlock(world, x, y, z)) {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }
    
    public void updateTick(final World world, final int x, final int y, final int z, final Random rand) {
        if (!world.isRemote && world.rand.nextInt(4) == 0) {
            final byte b0 = 4;
            int l = 5;
            boolean flag = false;
            int i1 = 0;
            int j1 = 0;
            int k1 = 0;
        Label_0127:
            for (i1 = x - b0; i1 <= x + b0; ++i1) {
                for (j1 = z - b0; j1 <= z + b0; ++j1) {
                    for (k1 = y - 1; k1 <= y + 1; ++k1) {
                        if (world.getBlock(i1, k1, j1) == this && --l <= 0) {
                            flag = true;
                            break Label_0127;
                        }
                    }
                }
            }
            i1 = world.getBlockMetadata(x, y, z);
            j1 = world.rand.nextInt(6);
            k1 = Direction.facingToDirection[j1];
            int l2 = 0;
            if (j1 == 1 && y < 255 && world.isAirBlock(x, y + 1, z)) {
                if (flag) {
                    return;
                }
                int j2 = world.rand.nextInt(16) & i1;
                if (j2 > 0) {
                    for (l2 = 0; l2 <= 3; ++l2) {
                        if (!this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[l2], y + 1, z + Direction.offsetZ[l2]))) {
                            j2 &= ~(1 << l2);
                        }
                    }
                    if (j2 > 0) {
                        world.setBlock(x, y + 1, z, (Block)this, j2, 2);
                    }
                }
            }
            else {
                Block block = null;
                int i2 = 0;
                if (j1 >= 2 && j1 <= 5 && (i1 & 1 << k1) == 0x0) {
                    if (flag) {
                        return;
                    }
                    block = world.getBlock(x + Direction.offsetX[k1], y, z + Direction.offsetZ[k1]);
                    if (block.getMaterial() == Material.air) {
                        l2 = (k1 + 1 & 0x3);
                        i2 = (k1 + 3 & 0x3);
                        if ((i1 & 1 << l2) != 0x0 && this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[k1] + Direction.offsetX[l2], y, z + Direction.offsetZ[k1] + Direction.offsetZ[l2]))) {
                            world.setBlock(x + Direction.offsetX[k1], y, z + Direction.offsetZ[k1], (Block)this, 1 << l2, 2);
                        }
                        else if ((i1 & 1 << i2) != 0x0 && this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[k1] + Direction.offsetX[i2], y, z + Direction.offsetZ[k1] + Direction.offsetZ[i2]))) {
                            world.setBlock(x + Direction.offsetX[k1], y, z + Direction.offsetZ[k1], (Block)this, 1 << i2, 2);
                        }
                        else if ((i1 & 1 << l2) != 0x0 && world.isAirBlock(x + Direction.offsetX[k1] + Direction.offsetX[l2], y, z + Direction.offsetZ[k1] + Direction.offsetZ[l2]) && this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[l2], y, z + Direction.offsetZ[l2]))) {
                            world.setBlock(x + Direction.offsetX[k1] + Direction.offsetX[l2], y, z + Direction.offsetZ[k1] + Direction.offsetZ[l2], (Block)this, 1 << (k1 + 2 & 0x3), 2);
                        }
                        else if ((i1 & 1 << i2) != 0x0 && world.isAirBlock(x + Direction.offsetX[k1] + Direction.offsetX[i2], y, z + Direction.offsetZ[k1] + Direction.offsetZ[i2]) && this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[i2], y, z + Direction.offsetZ[i2]))) {
                            world.setBlock(x + Direction.offsetX[k1] + Direction.offsetX[i2], y, z + Direction.offsetZ[k1] + Direction.offsetZ[i2], (Block)this, 1 << (k1 + 2 & 0x3), 2);
                        }
                        else if (this.canBePlacedOnBlock(world.getBlock(x + Direction.offsetX[k1], y + 1, z + Direction.offsetZ[k1]))) {
                            world.setBlock(x + Direction.offsetX[k1], y, z + Direction.offsetZ[k1], (Block)this, 0, 2);
                        }
                    }
                    else if (block.getMaterial().isOpaque() && block.renderAsNormalBlock()) {
                        world.setBlockMetadataWithNotify(x, y, z, i1 | 1 << k1, 2);
                    }
                }
                else if (y > 1) {
                    block = world.getBlock(x, y - 1, z);
                    if (block.getMaterial() == Material.air) {
                        l2 = (world.rand.nextInt(16) & i1);
                        if (l2 > 0) {
                            world.setBlock(x, y - 1, z, (Block)this, l2, 2);
                        }
                    }
                    else if (block == this) {
                        l2 = (world.rand.nextInt(16) & i1);
                        i2 = world.getBlockMetadata(x, y - 1, z);
                        if (i2 != (i2 | l2)) {
                            world.setBlockMetadataWithNotify(x, y - 1, z, i2 | l2, 2);
                        }
                    }
                }
            }
        }
    }
    
    public int onBlockPlaced(final World world, final int x, final int y, final int z, final int side, final float hitX, final float hitY, final float hitZ, final int meta) {
        byte b0 = 0;
        switch (side) {
            case 2: {
                b0 = 1;
                break;
            }
            case 3: {
                b0 = 4;
                break;
            }
            case 4: {
                b0 = 8;
                break;
            }
            case 5: {
                b0 = 2;
                break;
            }
        }
        return (b0 != 0) ? b0 : meta;
    }
    
    public Item getItemDropped(final int par1, final Random rand, final int par3) {
        return null;
    }
    
    public int quantityDropped(final Random rand) {
        return 0;
    }
    
    public boolean isShearable(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public ArrayList<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final int x, final int y, final int z, final int fortune) {
        final ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack((Block)this, 1));
        return ret;
    }
    
    public boolean isLadder(final IBlockAccess world, final int x, final int y, final int z, final EntityLivingBase entity) {
        return true;
    }
}
