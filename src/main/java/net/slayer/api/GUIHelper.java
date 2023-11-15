package net.slayer.api;

import net.minecraft.client.gui.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class GUIHelper extends Gui
{
    private void drawItemOrBlock(final ItemStack stack, final Minecraft mc, final int x, final int y) {
        final RenderItem itemRender = new RenderItem();
        if (stack != null && stack.getItem() != null) {
            GL11.glDisable(2896);
            GL11.glScaled(2.0, 2.0, 0.0);
            GL11.glPushMatrix();
            this.zLevel = 50.0f;
            itemRender.zLevel = 50.0f;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            RenderHelper.enableGUIStandardItemLighting();
            GL11.glEnable(2929);
            itemRender.renderItemIntoGUI(mc.fontRenderer, mc.renderEngine, stack, x, y);
            RenderHelper.disableStandardItemLighting();
            itemRender.zLevel = 0.0f;
            this.zLevel = 0.0f;
            GL11.glPopMatrix();
        }
    }
}
