package net.essence.blocks;

import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.slayer.api.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.essence.blocks.tileentity.*;
import net.essence.*;
import net.essence.client.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.tileentity.*;

public class BlockIncubator extends BlockContainer
{
    protected boolean active;
    protected static boolean keepInventory;
    protected Random rand;
    
    public BlockIncubator(final String name, final boolean act) {
        super(Material.rock);
        this.rand = new Random();
        this.setStepSound(Block.soundTypeStone);
        if (!act) {
            this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        }
        this.setBlockName(name);
        GameRegistry.registerBlock((Block)this, name);
        this.active = act;
        if (act) {
            this.setLightLevel(0.875f);
        }
    }
    
    public Item getItemDropped(final int i, final Random r, final int j) {
        return SlayerAPI.toItem((Block)this);
    }
    
    public void onBlockAdded(final World w, final int x, final int y, final int z) {
        super.onBlockAdded(w, x, y, z);
        if (!w.isRemote) {
            int meta = 3;
            final Block block = w.getBlock(x, y, z - 1);
            final Block block2 = w.getBlock(x, y, z + 1);
            final Block block3 = w.getBlock(x - 1, y, z);
            final Block block4 = w.getBlock(x + 1, y, z);
            if (block.func_149730_j() && !block2.func_149730_j()) {
                meta = 3;
            }
            if (block2.func_149730_j() && !block.func_149730_j()) {
                meta = 2;
            }
            if (block3.func_149730_j() && !block4.func_149730_j()) {
                meta = 5;
            }
            if (block4.func_149730_j() && !block3.func_149730_j()) {
                meta = 4;
            }
            w.setBlockMetadataWithNotify(x, y, z, meta, 2);
        }
    }
    
    public boolean onBlockActivated(final World w, final int x, final int y, final int z, final EntityPlayer p, final int i, final float j, final float k, final float f) {
        final TileEntityIncubator furnace = (TileEntityIncubator)w.getTileEntity(x, y, z);
        if (!w.isRemote && furnace != null && !p.isSneaking()) {
            p.openGui((Object)Essence.instance, GuiHandler.GuiIDs.INCUBATOR.ordinal(), w, x, y, z);
        }
        return false;
    }
    
    public static void update(final boolean active, final World w, final int x, final int y, final int z) {
    }
    
    public void onBlockPlacedBy(final World w, final int x, final int y, final int z, final EntityLivingBase living, final ItemStack item) {
        final int meta = MathHelper.floor_double(living.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        if (meta == 0) {
            w.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (meta == 1) {
            w.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (meta == 2) {
            w.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (meta == 3) {
            w.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
        if (item.hasDisplayName()) {
            ((TileEntityIncubator)w.getTileEntity(x, y, z)).setCustomName(item.getDisplayName());
        }
    }
    
    public void breakBlock(final World w, final int x, final int y, final int z, final Block b, final int meta) {
        if (!BlockIncubator.keepInventory) {
            final TileEntityIncubator entity = (TileEntityIncubator)w.getTileEntity(x, y, z);
            if (entity != null) {
                for (int i1 = 0; i1 < entity.getSizeInventory(); ++i1) {
                    final ItemStack itemstack = entity.getStackInSlot(i1);
                    if (itemstack != null) {
                        final float f = this.rand.nextFloat() * 0.8f + 0.1f;
                        final float f2 = this.rand.nextFloat() * 0.8f + 0.1f;
                        final float f3 = this.rand.nextFloat() * 0.8f + 0.1f;
                        while (itemstack.stackSize > 0) {
                            int j1 = this.rand.nextInt(21) + 10;
                            if (j1 > itemstack.stackSize) {
                                j1 = itemstack.stackSize;
                            }
                            final ItemStack itemStack = itemstack;
                            itemStack.stackSize -= j1;
                            final EntityItem entityitem = new EntityItem(w, (double)(x + f), (double)(y + f2), (double)(z + f3), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                            if (itemstack.hasTagCompound()) {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }
                            final float f4 = 0.05f;
                            entityitem.motionX = (float)this.rand.nextGaussian() * f4;
                            entityitem.motionY = (float)this.rand.nextGaussian() * f4 + 0.2f;
                            entityitem.motionZ = (float)this.rand.nextGaussian() * f4;
                            w.spawnEntityInWorld((Entity)entityitem);
                        }
                    }
                }
                w.func_147453_f(x, y, z, b);
            }
        }
        super.breakBlock(w, x, y, z, b, meta);
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World w, final int x, final int y, final int z, final Random r) {
        if (this.active) {
            final int meta = w.getBlockMetadata(x, y, z);
            final float f = x + 0.5f;
            final float f2 = y + 1.1f;
            final float f3 = z + 0.5f;
            final float f4 = r.nextFloat() * 0.6f - 0.2f;
            w.spawnParticle("smoke", (double)(f + f4), (double)f2, (double)(f3 + f4), 0.0, 0.0, 0.0);
            w.spawnParticle("flame", (double)(f + f4), (double)f2, (double)(f3 + f4), 0.0, 0.0, 0.0);
            w.spawnParticle("smoke", (double)(f - f4), (double)f2, (double)(f3 - f4), 0.0, 0.0, 0.0);
            w.spawnParticle("flame", (double)(f - f4), (double)f2, (double)(f3 - f4), 0.0, 0.0, 0.0);
        }
    }
    
    public Item getItem(final World w, final int x, final int y, final int z) {
        return SlayerAPI.toItem((Block)this);
    }
    
    public TileEntity createNewTileEntity(final World p_149915_1_, final int p_149915_2_) {
        return new TileEntityIncubator();
    }
}
