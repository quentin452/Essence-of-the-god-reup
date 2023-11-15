package net.essence.client.render.mob;

import net.essence.client.render.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.essence.entity.mob.boss.*;
import net.essence.util.*;

public class RenderCalcia extends RenderBoss
{
    private ResourceLocation texture;
    
    public RenderCalcia(final ModelBase model, final float shadow, final float size, final ResourceLocation tex, final int bossID) {
        super(model, shadow, size, tex, bossID);
        this.texture = tex;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity var1) {
        final EntityCalcia calcia = (EntityCalcia)var1;
        return calcia.isInv() ? Textures.blank : this.texture;
    }
}
