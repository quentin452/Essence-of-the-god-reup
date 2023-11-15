package net.essence.client.render;

import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import net.essence.*;
import org.lwjgl.opengl.*;
import net.minecraft.world.*;
import cpw.mods.fml.client.registry.*;

public class OtherBlockRenderer implements ISimpleBlockRenderingHandler
{
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        final Tessellator tess = Tessellator.instance;
        block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);
        Block render = Blocks.mossy_cobblestone;
        if (block == EssenceBlocks.christmasLights) {
            render = (Block)Blocks.leaves;
        }
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        tess.startDrawingQuads();
        tess.setNormal(0.0f, -1.0f, 0.0f);
        renderer.renderFaceYNeg(block, 0.0, 0.0, 0.0, render.getBlockTextureFromSide(0));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(0.0f, -1.0f, 0.0f);
        renderer.renderFaceYNeg(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSide(block, 0));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(0.0f, 1.0f, 0.0f);
        renderer.renderFaceYPos(block, 0.0, 0.0, 0.0, render.getBlockTextureFromSide(1));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(0.0f, 1.0f, 0.0f);
        renderer.renderFaceYPos(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSide(block, 1));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(0.0f, 0.0f, -1.0f);
        renderer.renderFaceZNeg(block, 0.0, 0.0, 0.0, render.getBlockTextureFromSide(2));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(0.0f, 0.0f, -1.0f);
        renderer.renderFaceZNeg(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSide(block, 2));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(0.0f, 0.0f, 1.0f);
        renderer.renderFaceZPos(block, 0.0, 0.0, 0.0, render.getBlockTextureFromSide(3));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(0.0f, 0.0f, 1.0f);
        renderer.renderFaceZPos(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSide(block, 3));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(-1.0f, 0.0f, 0.0f);
        renderer.renderFaceXNeg(block, 0.0, 0.0, 0.0, render.getBlockTextureFromSide(4));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(-1.0f, 0.0f, 0.0f);
        renderer.renderFaceXNeg(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSide(block, 4));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(1.0f, 0.0f, 0.0f);
        renderer.renderFaceXPos(block, 0.0, 0.0, 0.0, render.getBlockTextureFromSide(5));
        tess.draw();
        tess.startDrawingQuads();
        tess.setNormal(1.0f, 0.0f, 0.0f);
        renderer.renderFaceXPos(block, 0.0, 0.0, 0.0, renderer.getBlockIconFromSide(block, 5));
        tess.draw();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        if (block == EssenceBlocks.mossyEssenceStone) {
            renderer.renderStandardBlock(Blocks.cobblestone, x, y, z);
            renderer.renderStandardBlock(EssenceBlocks.mossyEssenceStone, x, y, z);
            return true;
        }
        if (block == EssenceBlocks.christmasLights) {
            renderer.renderStandardBlock(EssenceBlocks.christmasLights, x, y, z);
            renderer.renderStandardBlock((Block)Blocks.leaves, x, y, z);
            return true;
        }
        return false;
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return RenderingRegistry.getNextAvailableRenderId();
    }
}
