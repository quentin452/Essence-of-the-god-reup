package net.slayer.api.block;

import net.minecraft.block.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.common.registry.*;
import net.essence.*;
import net.slayer.api.*;
import net.minecraft.world.*;
import net.essence.util.*;

public class BlockMod extends Block
{
    protected EnumMaterialTypes blockType;
    protected Item drop;
    protected Random rand;
    public int boostBrightnessLow;
    public int boostBrightnessHigh;
    public boolean enhanceBrightness;
    
    public BlockMod(final String name, final float hardness) {
        this(EnumMaterialTypes.STONE, name, hardness, (CreativeTabs)EssenceTabs.blocks);
    }
    
    public BlockMod(final EnumMaterialTypes type, final String name, final float hardness) {
        this(type, name, hardness, (CreativeTabs)EssenceTabs.blocks);
    }
    
    public BlockMod(final String name, final boolean breakable, final CreativeTabs tab) {
        this(EnumMaterialTypes.STONE, name, tab);
    }
    
    public BlockMod(final EnumMaterialTypes blockType, final String name, final CreativeTabs tab) {
        super(blockType.getMaterial());
        this.blockType = blockType;
        this.setHardness(2.0f);
        this.rand = new Random();
        this.setBlockTextureName("eotg:" + name);
        this.setStepSound(blockType.getSound());
        this.setCreativeTab(tab);
        this.setBlockName(name);
        GameRegistry.registerBlock((Block)this, name);
    }
    
    public BlockMod(final EnumMaterialTypes t, final String texture, final String name) {
        super(t.getMaterial());
        this.blockType = t;
        this.rand = new Random();
        this.setHardness(2.0f);
        this.setBlockTextureName("eotg:" + texture);
        this.setStepSound(this.blockType.getSound());
        this.setCreativeTab((CreativeTabs)EssenceTabs.blocks);
        this.setBlockName(texture);
        GameRegistry.registerBlock((Block)this, name);
    }
    
    public BlockMod(final EnumMaterialTypes blockType, final String name, final float hardness, final CreativeTabs tab) {
        super(blockType.getMaterial());
        this.blockType = blockType;
        this.rand = new Random();
        this.setBlockTextureName("eotg:" + name);
        this.setStepSound(blockType.getSound());
        this.setCreativeTab(tab);
        this.setBlockName(name);
        this.setHardness(hardness);
        GameRegistry.registerBlock((Block)this, name);
    }
    
    public int getMixedBrightnessForBlock(final IBlockAccess par1iBlockAccess, final int par2, final int par3, final int par4) {
        if (this == EssenceBlocks.mossyEssenceStone || this == EssenceBlocks.christmasLights) {
            return 900;
        }
        return super.getMixedBrightnessForBlock(par1iBlockAccess, par2, par3, par4);
    }
    
    public Item getItemDropped(final int par1, final Random par2, final int par3) {
        if (this.drop == null) {
            return SlayerAPI.toItem(this);
        }
        return this.drop;
    }
    
    public BlockMod setHarvestLevel(final EnumToolType type) {
        this.setHarvestLevel(type.getType(), type.getLevel());
        return this;
    }
    
    public boolean isOpaqueCube() {
        return this != EssenceBlocks.christmasLights;
    }
    
    public int getRenderType() {
        return (this == EssenceBlocks.mossyEssenceStone) ? 173 : 0;
    }
    
    public int quantityDropped(final Random rand) {
        return 1;
    }
    
    public void randomDisplayTick(final World w, final int x, final int y, final int z, final Random r) {
        if (Config.boilBlockSpawnSmoke && w.getBlock(x, y, z) == EssenceBlocks.hotBlock) {
            for (int i = 0; i < 1; ++i) {
                final float f = x + r.nextFloat();
                final float f2 = y + r.nextFloat() + 0.5f;
                final float f3 = z + r.nextFloat();
                w.spawnParticle("largesmoke", (double)f, (double)f2, (double)f3, 0.0, 0.0, 0.0);
            }
        }
    }
}
