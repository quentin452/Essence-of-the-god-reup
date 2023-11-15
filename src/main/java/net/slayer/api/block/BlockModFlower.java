package net.slayer.api.block;

import net.slayer.api.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraftforge.common.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraftforge.common.*;

public class BlockModFlower extends BlockMod implements IPlantable
{
    public BlockModFlower(final String name) {
        super(EnumMaterialTypes.PLANT, name, 0.0f);
        this.setTickRandomly(true);
        final float f = 0.2f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 3.0f, 0.5f + f);
        this.setCreativeTab((CreativeTabs)EssenceTabs.decoraton);
    }
    
    public boolean canPlaceBlockAt(final World w, final int x, final int y, final int z) {
        return super.canPlaceBlockAt(w, x, y, z) && this.canBlockStay(w, x, y, z);
    }
    
    public void onNeighborBlockChange(final World w, final int x, final int y, final int z, final Block b) {
        super.onNeighborBlockChange(w, x, y, z, b);
        this.checkAndDropBlock(w, x, y, z);
    }
    
    public void updateTick(final World w, final int x, final int y, final int z, final Random p_149674_5_) {
        this.checkAndDropBlock(w, x, y, z);
    }
    
    protected void checkAndDropBlock(final World w, final int x, final int y, final int z) {
        if (!this.canBlockStay(w, x, y, z)) {
            this.dropBlockAsItem(w, x, y, z, w.getBlockMetadata(x, y, z), 0);
            w.setBlock(x, y, z, getBlockById(0), 0, 2);
        }
    }
    
    public boolean canBlockStay(final World w, final int x, final int y, final int z) {
        return w.getBlock(x, y - 1, z).canSustainPlant((IBlockAccess)w, x, y - 1, z, ForgeDirection.UP, (IPlantable)this);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World p_149668_1_, final int p_149668_2_, final int p_149668_3_, final int p_149668_4_) {
        return null;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return 1;
    }
    
    public EnumPlantType getPlantType(final IBlockAccess world, final int x, final int y, final int z) {
        return EnumPlantType.Plains;
    }
    
    public Block getPlant(final IBlockAccess world, final int x, final int y, final int z) {
        return (Block)this;
    }
    
    public int getPlantMetadata(final IBlockAccess world, final int x, final int y, final int z) {
        return world.getBlockMetadata(x, y, z);
    }
}
