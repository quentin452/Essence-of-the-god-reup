package net.essence.client.render.mob;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderModBiped extends RenderBiped
{
    private ResourceLocation tex;
    
    public RenderModBiped(final ModelBiped m, final ResourceLocation tex) {
        super(m, 0.5f);
        this.tex = tex;
    }
    
    protected ResourceLocation getEntityTexture(final Entity e) {
        return this.tex;
    }
}
