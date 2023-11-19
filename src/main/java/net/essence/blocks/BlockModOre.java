package net.essence.blocks;

import net.slayer.api.block.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.init.*;
import cpw.mods.fml.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import net.essence.client.render.particles.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.essence.*;

public class BlockModOre extends BlockMod
{
    public int boostBrightnessLow;
    public int boostBrightnessHigh;
    public boolean enhanceBrightness;

    public BlockModOre(final String name, final float hardness) {
        super(name, hardness);
    }
    @SideOnly(Side.CLIENT)
    public boolean addHitEffects(final World w, final MovingObjectPosition target, final EffectRenderer effectRenderer) {
        final int x = target.blockX;
        final int y = target.blockY;
        final int z = target.blockZ;
        this.renderParticle(w, x, y, z);
        final Random random = new Random();
        Block particle = Blocks.stone;
        if (this == EssenceBlocks.celestiumOre) {
            particle = EssenceBlocks.eucaStone;
        }
        if (this == EssenceBlocks.flairiumOre) {
            particle = EssenceBlocks.depthsStone;
        }
        if (this == EssenceBlocks.hellstoneOre) {
            particle = Blocks.netherrack;
        }
        final double d0 = 0.0625;
        for (int l = 0; l < 2; ++l) {
            double d2 = x + random.nextFloat();
            double d3 = y + random.nextFloat();
            double d4 = z + random.nextFloat();
            if (l == 0 && !w.getBlock(x, y + 1, z).isOpaqueCube()) {
                d3 = y + 1 + d0;
            }
            if (l == 1 && !w.getBlock(x, y - 1, z).isOpaqueCube()) {
                d3 = y + 0 - d0;
            }
            if (l == 2 && !w.getBlock(x, y, z + 1).isOpaqueCube()) {
                d4 = z + 1 + d0;
            }
            if (l == 3 && !w.getBlock(x, y, z - 1).isOpaqueCube()) {
                d4 = z + 0 - d0;
            }
            if (l == 4 && !w.getBlock(x + 1, y, z).isOpaqueCube()) {
                d2 = x + 1 + d0;
            }
            if (l == 5 && !w.getBlock(x - 1, y, z).isOpaqueCube()) {
                d2 = x + 0 - d0;
            }
            if (d2 < x || d2 > x + 1 || d3 < 0.0 || d3 > y + 1 || d4 < z || d4 > z + 1) {
                final EntityDiggingFX fx = new EntityDiggingFX(w, d2, d3, d4, 0.0, 0.0, 0.0, Blocks.stone, 0);
                FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)fx);
            }
        }
        return super.addHitEffects(w, target, effectRenderer);
    }
    @SideOnly(Side.CLIENT)
    public boolean addDestroyEffects(final World w, final int x, final int y, final int z, final int meta, final EffectRenderer effectRenderer) {
        this.renderParticle(w, x, y, z);
        final Random random = new Random();
        Block particle = Blocks.stone;
        if (this == EssenceBlocks.celestiumOre) {
            particle = EssenceBlocks.eucaStone;
        }
        if (this == EssenceBlocks.flairiumOre) {
            particle = EssenceBlocks.depthsStone;
        }
        if (this == EssenceBlocks.hellstoneOre) {
            particle = Blocks.netherrack;
        }
        final double d0 = 0.0625;
        for (int l = 0; l < 6; ++l) {
            double d2 = x + random.nextFloat();
            double d3 = y + random.nextFloat();
            double d4 = z + random.nextFloat();
            if (l == 0 && !w.getBlock(x, y + 1, z).isOpaqueCube()) {
                d3 = y + 1 + d0;
            }
            if (l == 1 && !w.getBlock(x, y - 1, z).isOpaqueCube()) {
                d3 = y + 0 - d0;
            }
            if (l == 2 && !w.getBlock(x, y, z + 1).isOpaqueCube()) {
                d4 = z + 1 + d0;
            }
            if (l == 3 && !w.getBlock(x, y, z - 1).isOpaqueCube()) {
                d4 = z + 0 - d0;
            }
            if (l == 4 && !w.getBlock(x + 1, y, z).isOpaqueCube()) {
                d2 = x + 1 + d0;
            }
            if (l == 5 && !w.getBlock(x - 1, y, z).isOpaqueCube()) {
                d2 = x + 0 - d0;
            }
            if (d2 < x || d2 > x + 1 || d3 < 0.0 || d3 > y + 1 || d4 < z || d4 > z + 1) {
                final EntityDiggingFX fx = new EntityDiggingFX(w, d2, d3, d4, 0.0, 0.0, 0.0, Blocks.stone, 0);
                FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)fx);
            }
        }
        return super.addDestroyEffects(w, x, y, z, meta, effectRenderer);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(final World w, final int x, final int y, final int z, final Random rand) {
        this.renderParticle(w, x, y, z);
    }
    @SideOnly(Side.CLIENT)
    private void renderParticle(final World w, final int x, final int y, final int z) {
        float r = 0.0f;
        float g = 0.0f;
        float b = 0.0f;
        if (this == EssenceBlocks.celestiumOre || this == EssenceBlocks.celestiumBlock) {
            r = 0.0f;
            g = 1.0f;
            b = 0.0f;
        }
        if (this == EssenceBlocks.shadiumOre || this == EssenceBlocks.shadiumBlock) {
            r = 0.0f;
            g = 0.0f;
            b = 1.0f;
        }
        if (this == EssenceBlocks.luniumOre || this == EssenceBlocks.luniumBlock) {
            r = 1.0f;
            g = 1.0f;
            b = 0.0f;
        }
        if (this == EssenceBlocks.flairiumOre || this == EssenceBlocks.flairiumBlock) {
            r = 1.0f;
            g = 0.5f;
            b = 0.0f;
        }
        if (this == EssenceBlocks.hellstoneBlock || this == EssenceBlocks.hellstoneOre) {
            r = 1.0f;
            g = 0.0f;
            b = 0.0f;
        }
        if (this == EssenceBlocks.sapphireOre || this == EssenceBlocks.sapphireBlock) {
            r = 0.5f;
            g = 0.0f;
            b = 1.0f;
        }
        final Random random = w.rand;
        final double d0 = 0.0625;
        for (int l = 0; l < 6; ++l) {
            double d2 = x + random.nextFloat();
            double d3 = y + random.nextFloat();
            double d4 = z + random.nextFloat();
            if (l == 0 && !w.getBlock(x, y + 1, z).isOpaqueCube()) {
                d3 = y + 1 + d0;
            }
            if (l == 1 && !w.getBlock(x, y - 1, z).isOpaqueCube()) {
                d3 = y + 0 - d0;
            }
            if (l == 2 && !w.getBlock(x, y, z + 1).isOpaqueCube()) {
                d4 = z + 1 + d0;
            }
            if (l == 3 && !w.getBlock(x, y, z - 1).isOpaqueCube()) {
                d4 = z + 0 - d0;
            }
            if (l == 4 && !w.getBlock(x + 1, y, z).isOpaqueCube()) {
                d2 = x + 1 + d0;
            }
            if (l == 5 && !w.getBlock(x - 1, y, z).isOpaqueCube()) {
                d2 = x + 0 - d0;
            }
            if (d2 < x || d2 > x + 1 || d3 < 0.0 || d3 > y + 1 || d4 < z || d4 > z + 1) {
                final OreParticleFX var20 = new OreParticleFX(w, d2, d3, d4, r, g, b);
                FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)var20);
            }
        }
    }

    @Override
    public Item getItemDropped(final int par1, final Random par2, final int par3) {
        if (this == EssenceBlocks.ashual) {
            return EssenceItems.ash;
        }
        if (this == EssenceBlocks.sapphireOre) {
            return EssenceItems.sapphire;
        }
        return Item.getItemFromBlock(this);
    }
}
