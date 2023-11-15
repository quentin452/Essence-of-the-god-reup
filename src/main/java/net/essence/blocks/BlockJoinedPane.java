package net.essence.blocks;

import net.slayer.api.block.*;
import net.slayer.api.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraftforge.common.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockJoinedPane extends BlockMod
{
    private String[] textures;
    private IIcon[] icons;
    
    public BlockJoinedPane(final String name) {
        super(EnumMaterialTypes.GLASS, name + "Pane", 0.2f);
        this.textures = new String[16];
        this.icons = new IIcon[16];
        this.textures[0] = "eotg:glass/" + name + "/glass";
        this.textures[1] = "eotg:glass/" + name + "/glass_1_d";
        this.textures[2] = "eotg:glass/" + name + "/glass_1_u";
        this.textures[3] = "eotg:glass/" + name + "/glass_1_l";
        this.textures[4] = "eotg:glass/" + name + "/glass_1_r";
        this.textures[5] = "eotg:glass/" + name + "/glass_2_h";
        this.textures[6] = "eotg:glass/" + name + "/glass_2_v";
        this.textures[7] = "eotg:glass/" + name + "/glass_2_dl";
        this.textures[8] = "eotg:glass/" + name + "/glass_2_dr";
        this.textures[9] = "eotg:glass/" + name + "/glass_2_ul";
        this.textures[10] = "eotg:glass/" + name + "/glass_2_ur";
        this.textures[11] = "eotg:glass/" + name + "/glass_3_d";
        this.textures[12] = "eotg:glass/" + name + "/glass_3_u";
        this.textures[13] = "eotg:glass/" + name + "/glass_3_l";
        this.textures[14] = "eotg:glass/" + name + "/glass_3_r";
        this.textures[15] = "eotg:glass/" + name + "/glass_4";
    }
    
    public void addCollisionBoxesToList(final World p_149743_1_, final int p_149743_2_, final int p_149743_3_, final int p_149743_4_, final AxisAlignedBB p_149743_5_, final List p_149743_6_, final Entity p_149743_7_) {
        final boolean flag = this.canPaneConnectTo((IBlockAccess)p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ - 1, ForgeDirection.NORTH);
        final boolean flag2 = this.canPaneConnectTo((IBlockAccess)p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ + 1, ForgeDirection.SOUTH);
        final boolean flag3 = this.canPaneConnectTo((IBlockAccess)p_149743_1_, p_149743_2_ - 1, p_149743_3_, p_149743_4_, ForgeDirection.WEST);
        final boolean flag4 = this.canPaneConnectTo((IBlockAccess)p_149743_1_, p_149743_2_ + 1, p_149743_3_, p_149743_4_, ForgeDirection.EAST);
        if ((!flag3 || !flag4) && (flag3 || flag4 || flag || flag2)) {
            if (flag3 && !flag4) {
                this.setBlockBounds(0.0f, 0.0f, 0.4375f, 0.5f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
            }
            else if (!flag3 && flag4) {
                this.setBlockBounds(0.5f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
                super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
            }
        }
        else {
            this.setBlockBounds(0.0f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }
        if ((!flag || !flag2) && (flag3 || flag4 || flag || flag2)) {
            if (flag && !flag2) {
                this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 0.5f);
                super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
            }
            else if (!flag && flag2) {
                this.setBlockBounds(0.4375f, 0.0f, 0.5f, 0.5625f, 1.0f, 1.0f);
                super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
            }
        }
        else {
            this.setBlockBounds(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 1.0f);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }
    }
    
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess p_149719_1_, final int p_149719_2_, final int p_149719_3_, final int p_149719_4_) {
        float f = 0.4375f;
        float f2 = 0.5625f;
        float f3 = 0.4375f;
        float f4 = 0.5625f;
        final boolean flag = this.canPaneConnectTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1, ForgeDirection.NORTH);
        final boolean flag2 = this.canPaneConnectTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1, ForgeDirection.SOUTH);
        final boolean flag3 = this.canPaneConnectTo(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_, ForgeDirection.WEST);
        final boolean flag4 = this.canPaneConnectTo(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_, ForgeDirection.EAST);
        if ((!flag3 || !flag4) && (flag3 || flag4 || flag || flag2)) {
            if (flag3 && !flag4) {
                f = 0.0f;
            }
            else if (!flag3 && flag4) {
                f2 = 1.0f;
            }
        }
        else {
            f = 0.0f;
            f2 = 1.0f;
        }
        if ((!flag || !flag2) && (flag3 || flag4 || flag || flag2)) {
            if (flag && !flag2) {
                f3 = 0.0f;
            }
            else if (!flag && flag2) {
                f4 = 1.0f;
            }
        }
        else {
            f3 = 0.0f;
            f4 = 1.0f;
        }
        this.setBlockBounds(f, 0.0f, f3, f2, 1.0f, f4);
    }
    
    public boolean canPaneConnectTo(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection dir) {
        return this.canPaneConnectToBlock(world.getBlock(x, y, z)) || world.isSideSolid(x, y, z, dir.getOpposite(), false);
    }
    
    public final boolean canPaneConnectToBlock(final Block b) {
        return b.func_149730_j() || b == this || b == Blocks.glass || b == Blocks.stained_glass || b == Blocks.stained_glass_pane || b instanceof BlockPane || b instanceof BlockJoinedGlass || b instanceof BlockJoinedPane;
    }
    
    public boolean shouldConnectTo(final IBlockAccess w, final int x, final int y, final int z, final Block b) {
        return b == this;
    }
    
    private IIcon getConnectedTexture(final IBlockAccess w, final int x, final int y, final int z, final int side) {
        boolean isOpenUp = false;
        boolean isOpenDown = false;
        boolean isOpenLeft = false;
        boolean isOpenRight = false;
        switch (side) {
            case 0: {
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x - 1, y, z))) {
                    isOpenDown = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x + 1, y, z))) {
                    isOpenUp = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y, z - 1))) {
                    isOpenLeft = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y, z + 1))) {
                    isOpenRight = true;
                }
                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[15];
                }
                if (isOpenUp && isOpenDown && isOpenLeft) {
                    return this.icons[11];
                }
                if (isOpenUp && isOpenDown && isOpenRight) {
                    return this.icons[12];
                }
                if (isOpenUp && isOpenLeft && isOpenRight) {
                    return this.icons[13];
                }
                if (isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[14];
                }
                if (isOpenDown && isOpenUp) {
                    return this.icons[5];
                }
                if (isOpenLeft && isOpenRight) {
                    return this.icons[6];
                }
                if (isOpenDown && isOpenLeft) {
                    return this.icons[8];
                }
                if (isOpenDown && isOpenRight) {
                    return this.icons[10];
                }
                if (isOpenUp && isOpenLeft) {
                    return this.icons[7];
                }
                if (isOpenUp && isOpenRight) {
                    return this.icons[9];
                }
                if (isOpenDown) {
                    return this.icons[3];
                }
                if (isOpenUp) {
                    return this.icons[4];
                }
                if (isOpenLeft) {
                    return this.icons[2];
                }
                if (isOpenRight) {
                    return this.icons[1];
                }
                break;
            }
            case 1: {
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x - 1, y, z))) {
                    isOpenDown = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x + 1, y, z))) {
                    isOpenUp = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y, z - 1))) {
                    isOpenLeft = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y, z + 1))) {
                    isOpenRight = true;
                }
                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[15];
                }
                if (isOpenUp && isOpenDown && isOpenLeft) {
                    return this.icons[11];
                }
                if (isOpenUp && isOpenDown && isOpenRight) {
                    return this.icons[12];
                }
                if (isOpenUp && isOpenLeft && isOpenRight) {
                    return this.icons[13];
                }
                if (isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[14];
                }
                if (isOpenDown && isOpenUp) {
                    return this.icons[5];
                }
                if (isOpenLeft && isOpenRight) {
                    return this.icons[6];
                }
                if (isOpenDown && isOpenLeft) {
                    return this.icons[8];
                }
                if (isOpenDown && isOpenRight) {
                    return this.icons[10];
                }
                if (isOpenUp && isOpenLeft) {
                    return this.icons[7];
                }
                if (isOpenUp && isOpenRight) {
                    return this.icons[9];
                }
                if (isOpenDown) {
                    return this.icons[3];
                }
                if (isOpenUp) {
                    return this.icons[4];
                }
                if (isOpenLeft) {
                    return this.icons[2];
                }
                if (isOpenRight) {
                    return this.icons[1];
                }
                break;
            }
            case 2: {
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y - 1, z))) {
                    isOpenDown = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y + 1, z))) {
                    isOpenUp = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x - 1, y, z))) {
                    isOpenLeft = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x + 1, y, z))) {
                    isOpenRight = true;
                }
                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[15];
                }
                if (isOpenUp && isOpenDown && isOpenLeft) {
                    return this.icons[13];
                }
                if (isOpenUp && isOpenDown && isOpenRight) {
                    return this.icons[14];
                }
                if (isOpenUp && isOpenLeft && isOpenRight) {
                    return this.icons[11];
                }
                if (isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[12];
                }
                if (isOpenDown && isOpenUp) {
                    return this.icons[6];
                }
                if (isOpenLeft && isOpenRight) {
                    return this.icons[5];
                }
                if (isOpenDown && isOpenLeft) {
                    return this.icons[9];
                }
                if (isOpenDown && isOpenRight) {
                    return this.icons[10];
                }
                if (isOpenUp && isOpenLeft) {
                    return this.icons[7];
                }
                if (isOpenUp && isOpenRight) {
                    return this.icons[8];
                }
                if (isOpenDown) {
                    return this.icons[1];
                }
                if (isOpenUp) {
                    return this.icons[2];
                }
                if (isOpenLeft) {
                    return this.icons[4];
                }
                if (isOpenRight) {
                    return this.icons[3];
                }
                break;
            }
            case 3: {
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y - 1, z))) {
                    isOpenDown = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y + 1, z))) {
                    isOpenUp = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x - 1, y, z))) {
                    isOpenLeft = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x + 1, y, z))) {
                    isOpenRight = true;
                }
                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[15];
                }
                if (isOpenUp && isOpenDown && isOpenLeft) {
                    return this.icons[14];
                }
                if (isOpenUp && isOpenDown && isOpenRight) {
                    return this.icons[13];
                }
                if (isOpenUp && isOpenLeft && isOpenRight) {
                    return this.icons[11];
                }
                if (isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[12];
                }
                if (isOpenDown && isOpenUp) {
                    return this.icons[6];
                }
                if (isOpenLeft && isOpenRight) {
                    return this.icons[5];
                }
                if (isOpenDown && isOpenLeft) {
                    return this.icons[10];
                }
                if (isOpenDown && isOpenRight) {
                    return this.icons[9];
                }
                if (isOpenUp && isOpenLeft) {
                    return this.icons[8];
                }
                if (isOpenUp && isOpenRight) {
                    return this.icons[7];
                }
                if (isOpenDown) {
                    return this.icons[1];
                }
                if (isOpenUp) {
                    return this.icons[2];
                }
                if (isOpenLeft) {
                    return this.icons[3];
                }
                if (isOpenRight) {
                    return this.icons[4];
                }
                break;
            }
            case 4: {
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y - 1, z))) {
                    isOpenDown = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y + 1, z))) {
                    isOpenUp = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y, z - 1))) {
                    isOpenLeft = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y, z + 1))) {
                    isOpenRight = true;
                }
                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[15];
                }
                if (isOpenUp && isOpenDown && isOpenLeft) {
                    return this.icons[14];
                }
                if (isOpenUp && isOpenDown && isOpenRight) {
                    return this.icons[13];
                }
                if (isOpenUp && isOpenLeft && isOpenRight) {
                    return this.icons[11];
                }
                if (isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[12];
                }
                if (isOpenDown && isOpenUp) {
                    return this.icons[6];
                }
                if (isOpenLeft && isOpenRight) {
                    return this.icons[5];
                }
                if (isOpenDown && isOpenLeft) {
                    return this.icons[10];
                }
                if (isOpenDown && isOpenRight) {
                    return this.icons[9];
                }
                if (isOpenUp && isOpenLeft) {
                    return this.icons[8];
                }
                if (isOpenUp && isOpenRight) {
                    return this.icons[7];
                }
                if (isOpenDown) {
                    return this.icons[1];
                }
                if (isOpenUp) {
                    return this.icons[2];
                }
                if (isOpenLeft) {
                    return this.icons[3];
                }
                if (isOpenRight) {
                    return this.icons[4];
                }
                break;
            }
            case 5: {
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y - 1, z))) {
                    isOpenDown = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y + 1, z))) {
                    isOpenUp = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y, z - 1))) {
                    isOpenLeft = true;
                }
                if (this.shouldConnectTo(w, x, y, z, w.getBlock(x, y, z + 1))) {
                    isOpenRight = true;
                }
                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[15];
                }
                if (isOpenUp && isOpenDown && isOpenLeft) {
                    return this.icons[13];
                }
                if (isOpenUp && isOpenDown && isOpenRight) {
                    return this.icons[14];
                }
                if (isOpenUp && isOpenLeft && isOpenRight) {
                    return this.icons[11];
                }
                if (isOpenDown && isOpenLeft && isOpenRight) {
                    return this.icons[12];
                }
                if (isOpenDown && isOpenUp) {
                    return this.icons[6];
                }
                if (isOpenLeft && isOpenRight) {
                    return this.icons[5];
                }
                if (isOpenDown && isOpenLeft) {
                    return this.icons[9];
                }
                if (isOpenDown && isOpenRight) {
                    return this.icons[10];
                }
                if (isOpenUp && isOpenLeft) {
                    return this.icons[7];
                }
                if (isOpenUp && isOpenRight) {
                    return this.icons[8];
                }
                if (isOpenDown) {
                    return this.icons[1];
                }
                if (isOpenUp) {
                    return this.icons[2];
                }
                if (isOpenLeft) {
                    return this.icons[4];
                }
                if (isOpenRight) {
                    return this.icons[3];
                }
                break;
            }
        }
        return this.icons[0];
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    protected boolean canSilkHarvest() {
        return true;
    }
    
    public void registerBlockIcons(final IIconRegister r) {
        for (int i = 0; i < this.textures.length; ++i) {
            this.icons[i] = r.registerIcon(this.textures[i]);
        }
    }
    
    @Override
    public Item getItemDropped(final int par1, final Random par2, final int par3) {
        return null;
    }
    
    public boolean canPlaceTorchOnTop(final World world, final int x, final int y, final int z) {
        return true;
    }
    
    public IIcon getIcon(final int s, final int m) {
        return this.icons[0];
    }
    
    public boolean shouldSideBeRendered(final IBlockAccess w, final int x, final int y, final int z, final int s) {
        return w.getBlock(x, y, z) != this && super.shouldSideBeRendered(w, x, y, z, s);
    }
    
    public IIcon getIcon(final IBlockAccess w, final int x, final int y, final int z, final int s) {
        return this.getConnectedTexture(w, x, y, z, s);
    }
}
