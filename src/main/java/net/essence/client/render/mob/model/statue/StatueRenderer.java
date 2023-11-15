package net.essence.client.render.mob.model.statue;

import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.tileentity.*;
import net.essence.blocks.tileentity.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;

public class StatueRenderer extends TileEntitySpecialRenderer
{
    public void renderTileEntityAt(final TileEntity te, final double x, final double y, final double z, final float tick) {
        float scale = 0.0f;
        if (te instanceof TileEntityStatue) {
            final TileEntityStatue tes = (TileEntityStatue)te;
            int rotation = 0;
            if (tes.getWorldObj() != null) {
                rotation = tes.getBlockMetadata();
            }
            Minecraft.getMinecraft().getTextureManager().bindTexture(tes.texture);
            GL11.glPushMatrix();
            GL11.glDisable(2896);
            scale = 1.0f;
            if (tes.model instanceof ModelWraithStatue) {
                scale = 0.5f;
                GL11.glTranslatef((float)x + 0.5f, (float)y + 0.7f, (float)z + 0.5f);
            }
            else if (tes.model instanceof ModelEnderChampionStatue) {
                scale = 0.6f;
                GL11.glTranslatef((float)x + 0.5f, (float)y + 1.0f, (float)z + 0.5f);
            }
            else {
                GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
            }
            GL11.glScalef(scale, scale, scale);
            GL11.glRotatef((float)(rotation * 90), 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
            tes.model.render(0.0625f);
            GL11.glEnable(2896);
            GL11.glPopMatrix();
        }
    }
}
