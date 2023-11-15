package net.essence.blocks.tileentity;

import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.essence.client.render.mob.model.statue.*;

public class TileEntityStatue extends TileEntity
{
    public ResourceLocation texture;
    public ModelStatue model;
    
    public TileEntityStatue(final ResourceLocation texture, final ModelStatue model) {
        this.model = model;
        this.texture = texture;
    }
}
