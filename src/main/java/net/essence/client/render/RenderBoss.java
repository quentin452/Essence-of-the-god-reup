package net.essence.client.render;

import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.slayer.api.entity.*;
import net.essence.util.*;

public class RenderBoss extends RenderSizeable
{
    private int bossID;
    
    public RenderBoss(final ModelBase model, final float shadow, final float size, final ResourceLocation tex, final int bossID) {
        super(model, shadow, size, tex);
        this.bossID = bossID;
    }
    
    public void doRender(final EntityLiving par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        EssenceBossStatus.setStatus((IEssenceBoss)par1Entity, this.bossID);
        super.doRender((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
    }
}
