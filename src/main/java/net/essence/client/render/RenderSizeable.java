package net.essence.client.render;

import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderSizeable extends RenderModMob
{
    protected float scale;
    
    public RenderSizeable(final ModelBase model, final float shadow, final float size, final ResourceLocation texture) {
        super(model, shadow, texture);
        this.scale = size;
    }
    
    protected void preRenderCallback(final EntityLivingBase var1, final float var2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
}
