package net.essence.client.render.mob.model.statue;

import net.minecraft.client.model.*;
import net.essence.util.*;
import java.util.*;

public abstract class ModelStatue extends ModelBase
{
    protected ArrayList<ModelRenderer> parts;
    
    public ModelStatue() {
        this.parts = new ArrayList<ModelRenderer>();
    }
    
    public void render(final float rotation) {
        if (this.parts == null || this.parts.isEmpty()) {
            LogHelper.debug("Nothing to rotate in type: " + this.getClass().getName());
            return;
        }
        for (final ModelRenderer model : this.parts) {
            model.render(rotation);
        }
    }
    
    public void addPart(final ModelRenderer model) {
        this.parts.add(model);
    }
    
    protected void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
