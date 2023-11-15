package net.essence.client.render.mob.model.statue;

import net.minecraftforge.client.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.essence.*;
import net.slayer.api.*;
import net.minecraft.item.*;

public class ItemRendererStatue implements IItemRenderer
{
    private String texture;
    
    public ItemRendererStatue(final String tex) {
        this.texture = tex;
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return true;
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return true;
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack i, final Object... data) {
        final Item item = i.getItem();
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("eotg:textures/models/statues/" + this.texture + ".png"));
        float scale = 1.0f;
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 4.0f);
        if (item == SlayerAPI.toItem(EssenceBlocks.witheringBeastStatue)) {
            switch (type) {
                case EQUIPPED: {
                    scale = 1.5f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(-0.6f, -1.0f, 0.4f);
                    break;
                }
                case ENTITY: {
                    scale = 3.0f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -1.5f, 0.0f);
                    break;
                }
                case INVENTORY: {
                    scale = 0.8f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -0.5f, 0.0f);
                    break;
                }
                case EQUIPPED_FIRST_PERSON: {
                    scale = 1.5f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -1.0f, 0.4f);
                    break;
                }
            }
            new ModelWitheringBeastStatue().render(0.0625f);
        }
        if (item == SlayerAPI.toItem(EssenceBlocks.netherBeastStatue)) {
            switch (type) {
                case EQUIPPED: {
                    scale = 1.5f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotatef(-180.0f, 0.0f, 40.0f, 5.0f);
                    GL11.glRotatef(90.0f, 0.0f, 4.0f, 0.0f);
                    GL11.glTranslatef(0.3f, -0.8f, 0.4f);
                    break;
                }
                case ENTITY: {
                    scale = 3.0f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -1.5f, 0.0f);
                    break;
                }
                case INVENTORY: {
                    scale = 0.6f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -0.4f, 0.0f);
                    break;
                }
                case EQUIPPED_FIRST_PERSON: {
                    scale = 1.5f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -1.0f, 0.4f);
                    break;
                }
            }
            new ModelNetherBeastStatue().render(0.0625f);
        }
        if (item == SlayerAPI.toItem(EssenceBlocks.calciaStatue)) {
            switch (type) {
                case EQUIPPED: {
                    scale = 2.0f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotatef(-180.0f, 0.0f, 40.0f, 5.0f);
                    GL11.glRotatef(90.0f, 0.0f, 2.0f, 0.0f);
                    GL11.glTranslatef(0.3f, -0.6f, 0.4f);
                    break;
                }
                case ENTITY: {
                    scale = 3.0f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -1.5f, 0.0f);
                    break;
                }
                case INVENTORY: {
                    scale = 1.0f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -0.7f, 0.0f);
                    break;
                }
                case EQUIPPED_FIRST_PERSON: {
                    scale = 1.7f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -1.0f, 0.7f);
                    GL11.glRotatef(90.0f, 0.0f, 2.0f, 0.0f);
                    break;
                }
            }
            new ModelCalciaStatue().render(0.0625f);
        }
        if (item == SlayerAPI.toItem(EssenceBlocks.eudorStatue)) {
            switch (type) {
                case EQUIPPED: {
                    scale = 2.0f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glRotatef(-180.0f, 0.0f, 40.0f, 5.0f);
                    GL11.glRotatef(90.0f, 0.0f, 2.0f, 0.0f);
                    GL11.glTranslatef(0.3f, -0.6f, 0.4f);
                    break;
                }
                case ENTITY: {
                    scale = 3.0f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -1.5f, 0.0f);
                    break;
                }
                case INVENTORY: {
                    scale = 0.8f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -0.5f, 0.0f);
                    break;
                }
                case EQUIPPED_FIRST_PERSON: {
                    scale = 1.7f;
                    GL11.glScalef(scale, scale, scale);
                    GL11.glTranslatef(0.0f, -1.0f, 0.7f);
                    GL11.glRotatef(90.0f, 0.0f, 2.0f, 0.0f);
                    break;
                }
            }
            new ModelEudorStatue().render(0.0625f);
        }
        GL11.glPopMatrix();
    }
}
