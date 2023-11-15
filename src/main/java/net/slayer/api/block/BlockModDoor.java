package net.slayer.api.block;

import cpw.mods.fml.relauncher.*;
import net.minecraft.creativetab.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.util.*;

public class BlockModDoor extends BlockMod
{
    @SideOnly(Side.CLIENT)
    protected IIcon[] topIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon[] bottomIcon;
    protected Item key;
    protected boolean canOpenByHand;

    public BlockModDoor(final String name, final float hardness, final Item key) {
        super(name, hardness);
        this.setCreativeTab((CreativeTabs)null);
        this.canOpenByHand = (key == null);
        this.key = key;
        this.setTickRandomly(true);
        final float f = 0.5f;
        final float f2 = 1.0f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return this.bottomIcon[0];
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if (side == 1 || side == 0) {
            return this.bottomIcon[0];
        }

        int metadata = this.getBlockMetadata(blockAccess, x, y, z);
        int rotation = metadata & 0x3;
        boolean isFlipped = (metadata & 0x4) != 0;
        boolean isTop = (metadata & 0x8) != 0;

        boolean flag2 = false;

        if (isFlipped) {
            switch (rotation) {
                case 0: flag2 = side == 2; break;
                case 1: flag2 = side == 5; break;
                case 2: flag2 = side == 3; break;
                case 3: flag2 = side == 4; break;
            }
        } else {
            switch (rotation) {
                case 0: flag2 = side == 5; break;
                case 1: flag2 = side == 3; break;
                case 2: flag2 = side == 4; break;
                case 3: flag2 = side == 2; break;
            }

            if ((metadata & 0x10) != 0) {
                flag2 = !flag2;
            }
        }

        return isTop ? this.topIcon[flag2 ? 1 : 0] : this.bottomIcon[flag2 ? 1 : 0];
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.topIcon = new IIcon[2];
        this.bottomIcon = new IIcon[2];
        this.topIcon[0] = icon.registerIcon(this.textureName + "_top");
        this.bottomIcon[0] = icon.registerIcon(this.textureName + "_bottom");
        this.topIcon[1] = (IIcon)new IconFlipped(this.topIcon[0], true, false);
        this.bottomIcon[1] = (IIcon)new IconFlipped(this.bottomIcon[0], true, false);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean getBlocksMovement(final IBlockAccess blockAccess, final int x, final int y, final int z) {
        final int l = this.getBlockMetadata(blockAccess, x, y, z);
        return (l & 0x4) != 0x0;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 7;
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(final World world, final int x, final int y, final int z) {
        this.setBlockBoundsBasedOnState((IBlockAccess)world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World world, final int x, final int y, final int z) {
        this.setBlockBoundsBasedOnState((IBlockAccess)world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    public void setBlockBoundsBasedOnState(final IBlockAccess blockAccess, final int x, final int y, final int z) {
        this.setRotation(this.getBlockMetadata(blockAccess, x, y, z));
    }

    protected void setRotation(final int meta) {
        final float f = 0.1875f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        final int j = meta & 0x3;
        final boolean flag = (meta & 0x4) != 0x0;
        final boolean flag2 = (meta & 0x10) != 0x0;
        switch (j) {
            case 0: {
                if (!flag) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                    break;
                }
                if (!flag2) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                    break;
                }
                this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 1: {
                if (!flag) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                    break;
                }
                if (!flag2) {
                    this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                break;
            }
            case 2: {
                if (!flag) {
                    this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                if (!flag2) {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
                break;
            }
            case 3: {
                if (!flag) {
                    this.setBlockBounds(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                if (!flag2) {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
                    break;
                }
                this.setBlockBounds(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
        }
    }

    public void onBlockClicked(final World world, final int x, final int y, final int z, final EntityPlayer player) {
    }

    protected void notifyAndUpdateBlock(final World world, final int x, final int y, final int z, final int j1, final boolean flag, final EntityPlayer player) {
        final int yOffset = flag ? 0 : 1;
        world.setBlockMetadataWithNotify(x, y - yOffset, z, j1, 2);
        world.markBlockRangeForRenderUpdate(x, y - yOffset, z, x, y, z);
        world.playAuxSFXAtEntity(player, 1003, x, y, z, 0);
    }

    public boolean onBlockActivated(final World world, final int x, final int y, final int z, final EntityPlayer player, final int side, final float hitX, final float hitY, final float hitZ) {
        final int i1 = this.getBlockMetadata((IBlockAccess)world, x, y, z);
        final int j1 = (i1 & 0x7) ^ 0x4;
        final boolean flag = (i1 & 0x8) == 0x0;
        if (this.canOpenByHand) {
            this.notifyAndUpdateBlock(world, x, y, z, j1, flag, player);
            return true;
        }
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == this.key) {
            final ItemStack getHeldItem = player.getHeldItem();
            --getHeldItem.stackSize;
            this.notifyAndUpdateBlock(world, x, y, z, j1, flag, player);
            return true;
        }
        return false;
    }

    public void setBlockMetadata(final World world, final int x, final int y, final int z, final boolean flag) {
        final int l = this.getBlockMetadata((IBlockAccess)world, x, y, z);
        final boolean flag2 = (l & 0x4) != 0x0;
        if (flag2 != flag) {
            int i1 = l & 0x7;
            i1 ^= 0x4;
            if ((l & 0x8) == 0x0) {
                world.setBlockMetadataWithNotify(x, y, z, i1, 2);
                world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            }
            else {
                world.setBlockMetadataWithNotify(x, y - 1, z, i1, 2);
                world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
            }
            world.playAuxSFXAtEntity((EntityPlayer)null, 1003, x, y, z, 0);
        }
    }

    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block block) {
        final int l = world.getBlockMetadata(x, y, z);
        if ((l & 0x8) == 0x0) {
            boolean flag = false;
            if (world.getBlock(x, y + 1, z) != this) {
                world.setBlockToAir(x, y, z);
                flag = true;
            }
            if (!World.doesBlockHaveSolidTopSurface((IBlockAccess)world, x, y - 1, z)) {
                world.setBlockToAir(x, y, z);
                flag = true;
                if (world.getBlock(x, y + 1, z) == this) {
                    world.setBlockToAir(x, y + 1, z);
                }
            }
            if (flag) {
                if (!world.isRemote) {
                    this.dropBlockAsItem(world, x, y, z, l, 0);
                }
            }
            else {
                final boolean flag2 = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y + 1, z);
                if ((flag2 || block.canProvidePower()) && block != this) {
                    this.setBlockMetadata(world, x, y, z, flag2);
                }
            }
        }
        else {
            if (world.getBlock(x, y - 1, z) != this) {
                world.setBlockToAir(x, y, z);
            }
            if (block != this) {
                this.onNeighborBlockChange(world, x, y - 1, z, block);
            }
        }
    }

    public Item getItemDropped(final int par1, final Random par2Rand, final int par3) {
        return null;
    }

    public MovingObjectPosition collisionRayTrace(final World world, final int x, final int y, final int z, final Vec3 startVector, final Vec3 endVector) {
        this.setBlockBoundsBasedOnState((IBlockAccess)world, x, y, z);
        return super.collisionRayTrace(world, x, y, z, startVector, endVector);
    }

    public boolean canPlaceBlockAt(final World world, final int x, final int y, final int z) {
        return y < 255 && (World.doesBlockHaveSolidTopSurface((IBlockAccess)world, x, y - 1, z) && super.canPlaceBlockAt(world, x, y, z) && super.canPlaceBlockAt(world, x, y + 1, z));
    }

    public int getMobilityFlag() {
        return 1;
    }

    public int getBlockMetadata(final IBlockAccess blockAccess, final int x, final int y, final int z) {
        final int l = blockAccess.getBlockMetadata(x, y, z);
        final boolean flag = (l & 0x8) != 0x0;
        int i1;
        int j1;
        if (flag) {
            i1 = blockAccess.getBlockMetadata(x, y - 1, z);
            j1 = l;
        }
        else {
            i1 = l;
            j1 = blockAccess.getBlockMetadata(x, y + 1, z);
        }
        final boolean flag2 = (j1 & 0x1) != 0x0;
        return (i1 & 0x7) | (flag ? 8 : 0) | (flag2 ? 16 : 0);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(final World world, final int x, final int y, final int z) {
        return null;
    }

    public void onBlockHarvested(final World world, final int x, final int y, final int z, final int par5, final EntityPlayer player) {
        if (player.capabilities.isCreativeMode && (par5 & 0x8) != 0x0 && world.getBlock(x, y - 1, z) == this) {
            world.setBlockToAir(x, y - 1, z);
        }
    }
}
