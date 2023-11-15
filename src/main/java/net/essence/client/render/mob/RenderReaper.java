package net.essence.client.render.mob;

import net.essence.client.render.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderReaper extends RenderModMob
{
    public RenderReaper(final ModelBase model, final ResourceLocation tex) {
        super(model, tex);
    }
    
    protected void renderEquippedItems(final EntityLivingBase e, final float f) {
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        final float f2 = 0.225f;
        GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
        GL11.glRotatef(-100.0f, 1.0f, 0.5f, 0.0f);
        GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
    }
}
