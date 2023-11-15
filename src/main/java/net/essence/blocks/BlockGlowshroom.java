package net.essence.blocks;

import net.minecraft.block.*;
import net.slayer.api.*;
import net.essence.*;
import net.minecraft.creativetab.*;
import net.essence.items.block.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.init.*;

public class BlockGlowshroom extends Block
{
    public static String[] names;
    private String[] textures;
    private IIcon[] icons;
    
    public BlockGlowshroom(final String name) {
        super(EnumMaterialTypes.PLANT.getMaterial());
        this.textures = new String[] { "eotg:glowshroom_bottom", "eotg:glowshroom_top" };
        this.setStepSound(EnumMaterialTypes.PLANT.getSound());
        this.setCreativeTab((CreativeTabs)EssenceTabs.decoraton);
        this.setHardness(0.0f);
        this.setLightLevel(0.6f);
        this.setTickRandomly(true);
        GameRegistry.registerBlock((Block)this, (Class)ItemBlockGlowshroom.class, name);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World w, final int x, final int y, final int z) {
        return null;
    }
    
    public void registerBlockIcons(final IIconRegister i) {
        (this.icons = new IIcon[2])[0] = i.registerIcon(this.textures[0]);
        this.icons[1] = i.registerIcon(this.textures[1]);
    }
    
    public void getSubBlocks(final Item it, final CreativeTabs c, final List l) {
        l.add(new ItemStack(it, 1, 0));
        l.add(new ItemStack(it, 1, 1));
    }
    
    public int getRenderBlockPass() {
        return 1;
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
    
    public void onBlockPlacedBy(final World w, final int x, final int y, final int z, final EntityLivingBase e, final ItemStack i) {
        w.setBlock(x, y, z, (Block)this, i.getItemDamage(), 2);
    }
    
    public int getMixedBrightnessForBlock(final IBlockAccess w, final int x, final int y, final int z) {
        return 900;
    }
    
    public void onBlockDestroyedByPlayer(final World w, final int x, final int y, final int z, final int m) {
        if (m == 0 && w.getBlock(x, y + 1, z) == this) {
            w.setBlock(x, y + 1, z, Blocks.air);
        }
        if (m == 1 && w.getBlock(x, y - 1, z) == this) {
            w.setBlock(x, y - 1, z, Blocks.air);
        }
    }
    
    public boolean canPlaceBlockAt(final World w, final int x, final int y, final int z) {
        return w.getBlock(x, y - 1, z) == Blocks.stone || w.getBlock(x, y - 1, z) == this;
    }
    
    public boolean canBlockStay(final World w, final int x, final int y, final int z) {
        return this.canPlaceBlockAt(w, x, y, z);
    }
    
    public IIcon getIcon(final int s, final int m) {
        return (m == 0) ? this.icons[0] : ((m == 1) ? this.icons[1] : this.icons[0]);
    }
    
    public int damageDropped(final int m) {
        return 1;
    }
    
    static {
        BlockGlowshroom.names = new String[] { "glowshroom_bottom", "glowshroom_top" };
    }
}
