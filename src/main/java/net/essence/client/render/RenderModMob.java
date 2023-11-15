package net.essence.client.render;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderModMob extends RenderLiving
{
    private ResourceLocation texture;
    
    public RenderModMob(final ModelBase model, final float shadow, final ResourceLocation tex) {
        super(model, shadow);
        this.texture = tex;
    }
    
    public RenderModMob(final ModelBase model, final ResourceLocation tex) {
        this(model, 0.5f, tex);
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return this.texture;
    }
}
