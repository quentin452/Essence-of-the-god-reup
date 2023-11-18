package net.essence.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.slayer.api.EnumMaterialTypes;

import java.util.Random;

public class BlockMossyEssenceStone extends Block {

    protected EnumMaterialTypes blockType;
    protected Item drop;
    protected Random rand;
    public int boostBrightnessLow;
    public int boostBrightnessHigh;
    public boolean enhanceBrightness;
    public BlockMossyEssenceStone(final String name, final float hardness) {
        this(EnumMaterialTypes.STONE, name, hardness, (CreativeTabs) EssenceTabs.blocks);
    }

    public BlockMossyEssenceStone(final EnumMaterialTypes type, final String name, final float hardness) {
        this(type, name, hardness, (CreativeTabs)EssenceTabs.blocks);
    }

    public BlockMossyEssenceStone(final String name, final boolean breakable, final CreativeTabs tab) {
        this(EnumMaterialTypes.STONE, name, tab);
    }

    public BlockMossyEssenceStone(final EnumMaterialTypes blockType, final String name, final CreativeTabs tab) {
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

    public BlockMossyEssenceStone(final EnumMaterialTypes t, final String texture, final String name) {
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

    public BlockMossyEssenceStone(final EnumMaterialTypes blockType, final String name, final float hardness, final CreativeTabs tab) {
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
}
