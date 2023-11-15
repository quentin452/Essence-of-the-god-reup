package net.essence.blocks;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.essence.util.*;
import net.essence.*;
import net.essence.dimension.*;
import net.minecraft.world.*;
import net.essence.client.render.particles.*;
import cpw.mods.fml.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockBoilPortal extends BlockBreakable
{
    public static final int[][] sides;
    
    public BlockBoilPortal(final String name) {
        super("eotg:boilPortal", Material.portal, false);
        this.setTickRandomly(true);
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        this.setBlockName(name);
        this.setBlockUnbreakable();
        GameRegistry.registerBlock((Block)this, name);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World w, final int x, final int y, final int z) {
        return null;
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess w, final int x, final int y, final int z) {
        int l = getMeta(w.getBlockMetadata(x, y, z));
        if (l == 0) {
            if (w.getBlock(x - 1, y, z) != this && w.getBlock(x + 1, y, z) != this) {
                l = 2;
            }
            else {
                l = 1;
            }
            if (w instanceof World && !((World)w).isRemote) {
                ((World)w).setBlockMetadataWithNotify(x, y, z, l, 2);
            }
        }
        float f = 0.125f;
        float f2 = 0.125f;
        if (l == 1) {
            f = 0.5f;
        }
        if (l == 2) {
            f2 = 0.5f;
        }
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f2, 0.5f + f, 1.0f, 0.5f + f2);
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public boolean makePortal(final World w, final int x, final int y, final int z) {
        final Size size = new Size(w, x, y, z, 1);
        final Size size2 = new Size(w, x, y, z, 2);
        if (size.checkSides() && size.value == 0) {
            size.checkDirection();
            return true;
        }
        if (size2.checkSides() && size2.value == 0) {
            size2.checkDirection();
            return true;
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess w, final int x, final int y, final int z, final int i) {
        int i2 = 0;
        if (w.getBlock(x, y, z) == this) {
            i2 = getMeta(w.getBlockMetadata(x, y, z));
            if (i2 == 0) {
                return false;
            }
            if (i2 == 2 && i != 5 && i != 4) {
                return false;
            }
            if (i2 == 1 && i != 3 && i != 2) {
                return false;
            }
        }
        final boolean flag = w.getBlock(x - 1, y, z) == this && w.getBlock(x - 2, y, z) != this;
        final boolean flag2 = w.getBlock(x + 1, y, z) == this && w.getBlock(x + 2, y, z) != this;
        final boolean flag3 = w.getBlock(x, y, z - 1) == this && w.getBlock(x, y, z - 2) != this;
        final boolean flag4 = w.getBlock(x, y, z + 1) == this && w.getBlock(x, y, z + 2) != this;
        final boolean flag5 = flag || flag2 || i2 == 1;
        final boolean flag6 = flag3 || flag4 || i2 == 2;
        return (flag5 && i == 4) || (flag5 && i == 5) || (flag6 && i == 2) || (flag6 && i == 3);
    }
    
    public int quantityDropped(final Random p_149745_1_) {
        return 0;
    }
    
    public void onEntityCollidedWithBlock(final World world, final int xPos, final int yPos, final int zPos, final Entity entity) {
        if (entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP) {
            final EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
            final int dimensionID = Config.boil;
            final Block blockFrame = EssenceBlocks.boilPortalFrame;
            if (thePlayer.timeUntilPortal > 0) {
                thePlayer.timeUntilPortal = 10;
            }
            else if (thePlayer.dimension != dimensionID) {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, dimensionID, (Teleporter)new ModTeleporter(thePlayer.mcServer.worldServerForDimension(dimensionID), dimensionID, (Block)this, blockFrame));
            }
            else {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, (Teleporter)new ModTeleporter(thePlayer.mcServer.worldServerForDimension(0), 0, (Block)this, blockFrame));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World world, final int xPos, final int yPos, final int zPos, final Random rand) {
        for (int l = 0; l < 5; ++l) {
            double d0 = xPos + rand.nextFloat();
            final double d2 = yPos + rand.nextFloat();
            double d3 = zPos + rand.nextFloat();
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            final int i1 = rand.nextInt(2) * 2 - 1;
            d4 = (rand.nextFloat() - 0.5) * 0.5;
            d5 = (rand.nextFloat() - 0.5) * 0.5;
            d6 = (rand.nextFloat() - 0.5) * 0.5;
            if (world.getBlock(xPos - 1, yPos, zPos) != this && world.getBlock(xPos + 1, yPos, zPos) != this) {
                d0 = xPos + 0.5 + 0.25 * i1;
                d4 = rand.nextFloat() * 2.0f * i1;
            }
            else {
                d3 = zPos + 0.5 + 0.25 * i1;
                d6 = rand.nextFloat() * 2.0f * i1;
            }
            final EntityBoilPotalFX var20 = new EntityBoilPotalFX(world, d0, d2, d3, d4, d5, d6);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)var20);
        }
    }
    
    public static int getMeta(final int m) {
        return m & 0x3;
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(final World w, final int x, final int y, final int z) {
        return Item.getItemFromBlock((Block)this);
    }
    
    static {
        sides = new int[][] { new int[0], { 3, 1 }, { 2, 0 } };
    }
    
    public static class Size
    {
        private final World w;
        private final int x;
        private final int y;
        private final int z;
        private int value;
        private ChunkCoordinates coords;
        private int direc;
        private int sides;
        
        public Size(final World w, final int x, int y, final int z, final int i) {
            this.value = 0;
            this.w = w;
            this.x = i;
            this.z = BlockBoilPortal.sides[i][0];
            this.y = BlockBoilPortal.sides[i][1];
            for (int i2 = y; y > i2 - 21 && y > 0 && this.getMat(w.getBlock(x, y - 1, z)); --y) {}
            final int j1 = this.setDirection(x, y, z, this.z) - 1;
            if (j1 >= 0) {
                this.coords = new ChunkCoordinates(x + j1 * Direction.offsetX[this.z], y, z + j1 * Direction.offsetZ[this.z]);
                this.sides = this.setDirection(this.coords.posX, this.coords.posY, this.coords.posZ, this.y);
                if (this.sides < 2 || this.sides > 21) {
                    this.coords = null;
                    this.sides = 0;
                }
            }
            if (this.coords != null) {
                this.direc = this.idk();
            }
        }
        
        protected int setDirection(final int x, final int y, final int z, final int dir) {
            final int j1 = Direction.offsetX[dir];
            final int k1 = Direction.offsetZ[dir];
            int i1;
            for (i1 = 0; i1 < 22; ++i1) {
                final Block block = this.w.getBlock(x + j1 * i1, y, z + k1 * i1);
                if (!this.getMat(block)) {
                    break;
                }
                final Block block2 = this.w.getBlock(x + j1 * i1, y - 1, z + k1 * i1);
                if (block2 != EssenceBlocks.boilPortalFrame) {
                    break;
                }
            }
            final Block block = this.w.getBlock(x + j1 * i1, y, z + k1 * i1);
            return (block == EssenceBlocks.boilPortalFrame) ? i1 : 0;
        }
        
        protected int idk() {
            this.direc = 0;
        Label_0272:
            while (this.direc < 21) {
                final int i = this.coords.posY + this.direc;
                for (int j = 0; j < this.sides; ++j) {
                    final int k = this.coords.posX + j * Direction.offsetX[BlockBoilPortal.sides[this.x][1]];
                    final int l = this.coords.posZ + j * Direction.offsetZ[BlockBoilPortal.sides[this.x][1]];
                    Block block = this.w.getBlock(k, i, l);
                    if (!this.getMat(block)) {
                        break Label_0272;
                    }
                    if (block == EssenceBlocks.boilPortal) {
                        ++this.value;
                    }
                    if (j == 0) {
                        block = this.w.getBlock(k + Direction.offsetX[BlockBoilPortal.sides[this.x][0]], i, l + Direction.offsetZ[BlockBoilPortal.sides[this.x][0]]);
                        if (block != EssenceBlocks.boilPortalFrame) {
                            break Label_0272;
                        }
                    }
                    else if (j == this.sides - 1) {
                        block = this.w.getBlock(k + Direction.offsetX[BlockBoilPortal.sides[this.x][1]], i, l + Direction.offsetZ[BlockBoilPortal.sides[this.x][1]]);
                        if (block != EssenceBlocks.boilPortalFrame) {
                            break Label_0272;
                        }
                    }
                }
                ++this.direc;
            }
            for (int i = 0; i < this.sides; ++i) {
                final int j = this.coords.posX + i * Direction.offsetX[BlockBoilPortal.sides[this.x][1]];
                final int k = this.coords.posY + this.direc;
                final int l = this.coords.posZ + i * Direction.offsetZ[BlockBoilPortal.sides[this.x][1]];
                if (this.w.getBlock(j, k, l) != EssenceBlocks.boilPortalFrame) {
                    this.direc = 0;
                    break;
                }
            }
            if (this.direc <= 21 && this.direc >= 3) {
                return this.direc;
            }
            this.coords = null;
            this.sides = 0;
            return this.direc = 0;
        }
        
        protected boolean getMat(final Block b) {
            return b.getMaterial() == Material.air || b == EssenceBlocks.fire || b == EssenceBlocks.boilPortal;
        }
        
        public boolean checkSides() {
            return this.coords != null && this.sides >= 2 && this.sides <= 21 && this.direc >= 3 && this.direc <= 21;
        }
        
        public void checkDirection() {
            for (int i = 0; i < this.sides; ++i) {
                final int j = this.coords.posX + Direction.offsetX[this.y] * i;
                final int k = this.coords.posZ + Direction.offsetZ[this.y] * i;
                for (int l = 0; l < this.direc; ++l) {
                    final int i2 = this.coords.posY + l;
                    this.w.setBlock(j, i2, k, (Block)EssenceBlocks.boilPortal, this.x, 2);
                }
            }
        }
    }
}
