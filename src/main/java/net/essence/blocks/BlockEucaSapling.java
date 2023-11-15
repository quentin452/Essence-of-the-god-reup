package net.essence.blocks;

import net.slayer.api.block.*;
import net.slayer.api.*;
import java.util.*;
import net.essence.dimension.euca.gen.trees.*;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.common.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraftforge.common.*;
import net.minecraft.block.*;

public class BlockEucaSapling extends BlockMod implements IGrowable, IPlantable
{
    public BlockEucaSapling(final String name) {
        super(EnumMaterialTypes.PLANT, name, 0.0f);
        this.setTickRandomly(true);
        final float f = 0.4f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
    }
    
    public void updateTick(final World w, final int x, final int y, final int z, final Random r) {
        if (!w.isRemote) {
            super.updateTick(w, x, y, z, r);
            if (w.getBlockLightValue(x, y + 1, z) >= 9 && r.nextInt(12) == 0) {
                this.generate(w, x, y, z, r);
            }
        }
    }
    
    private void generate(final World w, final int x, final int y, final int z, final Random r) {
        Object tree = new WorldGenBigEucaTree();
        switch (r.nextInt(2)) {
            case 0: {
                tree = new WorldGenBigEucaTree();
                break;
            }
            case 1: {
                tree = new WorldGenSmallEucaTree();
                break;
            }
        }
        ((WorldGenerator)tree).generate(w, r, x, y, z);
    }
    
    public boolean canPlaceBlockAt(final World w, final int x, final int y, final int z) {
        return super.canPlaceBlockAt(w, x, y, z) && this.canBlockStay(w, x, y, z);
    }
    
    public boolean canBlockStay(final World w, final int x, final int y, final int z) {
        return w.getBlock(x, y - 1, z).canSustainPlant((IBlockAccess)w, x, y - 1, z, ForgeDirection.UP, (IPlantable)this);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World w, final int x, final int y, final int z) {
        return null;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public int getRenderType() {
        return 1;
    }
    
    public boolean func_149851_a(final World w, final int x, final int y, final int z, final boolean b) {
        return true;
    }
    
    public boolean func_149852_a(final World w, final Random r, final int x, final int y, final int z) {
        return r.nextFloat() < 0.45;
    }
    
    public void func_149853_b(final World w, final Random r, final int x, final int y, final int z) {
        this.generate(w, x, y, z, r);
    }
    
    public EnumPlantType getPlantType(final IBlockAccess world, final int x, final int y, final int z) {
        return EnumPlantType.Plains;
    }
    
    public Block getPlant(final IBlockAccess world, final int x, final int y, final int z) {
        return this;
    }
    
    public int getPlantMetadata(final IBlockAccess world, final int x, final int y, final int z) {
        return world.getBlockMetadata(x, y, z);
    }
}
