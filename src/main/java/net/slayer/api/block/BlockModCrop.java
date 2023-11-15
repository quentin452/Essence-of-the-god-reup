package net.slayer.api.block;

import cpw.mods.fml.relauncher.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraftforge.common.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.item.*;

public abstract class BlockModCrop extends BlockBush implements IGrowable
{
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    private int amountOfStages;
    private String cropName;
    
    public BlockModCrop(final String name, final int stages, final String crop) {
        this.setTickRandomly(true);
        final float f = 0.5f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.setCreativeTab((CreativeTabs)null);
        this.setHardness(0.0f);
        this.setStepSound(BlockModCrop.soundTypeGrass);
        this.disableStats();
        GameRegistry.registerBlock((Block)this, name);
        this.amountOfStages = stages;
        this.cropName = crop;
    }
    
    protected boolean canPlaceBlockOn(final Block block) {
        return block == Blocks.farmland;
    }
    
    public void updateTick(final World w, final int x, final int y, final int z, final Random r) {
        super.updateTick(w, x, y, z, r);
        if (w.getBlockLightValue(x, y + 1, z) >= 9) {
            int l = w.getBlockMetadata(x, y, z);
            if (l < this.amountOfStages) {
                final float f = this.grow(w, x, y, z);
                if (r.nextInt((int)(25.0f / f) + 1) == 0) {
                    ++l;
                    w.setBlockMetadataWithNotify(x, y, z, l, 2);
                }
            }
        }
    }
    
    public void boneMeal(final World w, final int x, final int y, final int z) {
        int meta = w.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(w.rand, 2, 5);
        if (meta > this.amountOfStages) {
            meta = this.amountOfStages;
        }
        w.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
    
    private float grow(final World w, final int x, final int y, final int z) {
        float f = 1.0f;
        final Block block = w.getBlock(x, y, z - 1);
        final Block block2 = w.getBlock(x, y, z + 1);
        final Block block3 = w.getBlock(x - 1, y, z);
        final Block block4 = w.getBlock(x + 1, y, z);
        final Block block5 = w.getBlock(x - 1, y, z - 1);
        final Block block6 = w.getBlock(x + 1, y, z - 1);
        final Block block7 = w.getBlock(x + 1, y, z + 1);
        final Block block8 = w.getBlock(x - 1, y, z + 1);
        final boolean flag = block3 == this || block4 == this;
        final boolean flag2 = block == this || block2 == this;
        final boolean flag3 = block5 == this || block6 == this || block7 == this || block8 == this;
        for (int l = x - 1; l <= x + 1; ++l) {
            for (int i1 = z - 1; i1 <= z + 1; ++i1) {
                float f2 = 0.0f;
                if (w.getBlock(l, y - 1, i1).canSustainPlant((IBlockAccess)w, l, y - 1, i1, ForgeDirection.UP, (IPlantable)this)) {
                    f2 = 1.0f;
                    if (w.getBlock(l, y - 1, i1).isFertile(w, l, y - 1, i1)) {
                        f2 = 3.0f;
                    }
                }
                if (l != x || i1 != z) {
                    f2 /= 4.0f;
                }
                f += f2;
            }
        }
        if (flag3 || (flag && flag2)) {
            f /= 2.0f;
        }
        return f;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int p_149691_1_, int meta) {
        if (meta < 0 || meta > this.amountOfStages) {
            meta = this.amountOfStages;
        }
        return this.icons[meta];
    }
    
    public boolean func_149851_a(final World w, final int x, final int y, final int z, final boolean b) {
        return w.getBlockMetadata(x, y, z) != this.amountOfStages;
    }
    
    public boolean func_149852_a(final World w, final Random r, final int x, final int y, final int z) {
        return true;
    }
    
    public void dropBlockAsItemWithChance(final World w, final int x, final int y, final int z, final int m, final float f, final int i) {
        super.dropBlockAsItemWithChance(w, x, y, z, m, f, 0);
    }
    
    public Item getItemDropped(final int meta, final Random r, final int i) {
        return (meta == this.amountOfStages) ? this.getDropItem() : this.getSeeds();
    }
    
    public int quantityDropped(final Random r) {
        return r.nextInt(2) + 1;
    }
    
    public abstract Item getDropItem();
    
    public abstract Item getSeeds();
    
    @SideOnly(Side.CLIENT)
    public Item getItem(final World w, final int x, final int y, final int z) {
        return this.getSeeds();
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister icon) {
        this.icons = new IIcon[this.amountOfStages + 1];
        for (int i = 0; i < this.icons.length; ++i) {
            this.icons[i] = icon.registerIcon("eotg:" + this.cropName + "_" + i);
        }
    }
    
    public void func_149853_b(final World w, final Random r, final int x, final int y, final int z) {
        this.boneMeal(w, x, y, z);
    }
    
    public ArrayList<ItemStack> getDrops(final World world, final int x, final int y, final int z, final int metadata, final int fortune) {
        final ArrayList<ItemStack> ret = (ArrayList<ItemStack>)super.getDrops(world, x, y, z, metadata, fortune);
        if (metadata >= this.amountOfStages) {
            for (int i = 0; i < 3 + fortune; ++i) {
                if (world.rand.nextInt(15) <= metadata) {
                    ret.add(new ItemStack(this.getSeeds(), 1, 0));
                }
            }
        }
        return ret;
    }
}
