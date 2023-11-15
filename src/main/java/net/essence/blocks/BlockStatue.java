package net.essence.blocks;

import net.slayer.api.block.*;
import net.essence.client.render.mob.model.statue.*;
import net.essence.client.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.essence.blocks.tileentity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockStatue extends BlockMod
{
    protected ModelStatue model;
    protected ResourceLocation texture;
    protected EnumSounds sound;
    
    public BlockStatue(final String name, final ModelStatue model, final EnumSounds s) {
        super(name, 3.0f);
        this.setCreativeTab((CreativeTabs)EssenceTabs.decoraton);
        this.setBlockTextureName("cobblestone");
        this.texture = new ResourceLocation("eotg:textures/models/statues/" + name + ".png");
        this.model = model;
        this.sound = s;
    }
    
    public AxisAlignedBB getSelectedBoundingBoxFromPool(final World w, final int x, final int y, final int z) {
        final Block b = w.getBlock(x, y, z);
        final float f = 0.0625f;
        final AxisAlignedBB bb = null;
        return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1.0f), (double)(y + 1.9f), (double)(z + 1.0f));
    }
    
    public boolean onBlockActivated(final World w, final int x, final int y, final int z, final EntityPlayer p, final int i, final float f, final float f1, final float f2) {
        if (!w.isRemote) {
            EnumSounds.playSound(this.sound.getPrefixedName(), w, (EntityLivingBase)p);
        }
        return true;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World w, final int x, final int y, final int z) {
        final Block b = w.getBlock(x, y, z);
        final float f = 0.0625f;
        final AxisAlignedBB bb = null;
        return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1.0f), (double)(y + 1.9f), (double)(z + 1.0f));
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public TileEntity createTileEntity(final World world, final int metadata) {
        return new TileEntityStatue(this.texture, this.model);
    }
    
    @Override
    public int getRenderType() {
        return -1;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    public void onBlockPlacedBy(final World w, final int x, final int y, final int z, final EntityLivingBase entity, final ItemStack item) {
        final int l = ((MathHelper.floor_double(entity.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3) + 1) % 4;
        final int i1 = w.getBlockMetadata(x, y, z);
        if (l == 0) {
            w.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (l == 1) {
            w.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (l == 2) {
            w.setBlockMetadataWithNotify(x, y, z, 1, 2);
        }
        if (l == 3) {
            w.setBlockMetadataWithNotify(x, y, z, 0, 2);
        }
    }
}
