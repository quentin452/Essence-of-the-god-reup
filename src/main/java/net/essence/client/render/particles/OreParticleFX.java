package net.essence.client.render.particles;

import net.minecraft.client.particle.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

@SideOnly(Side.CLIENT)
public class OreParticleFX extends EntityFX
{
    private float reddustParticleScale;
    
    public OreParticleFX(final World w, final double x, final double y, final double z, final float r, final float g, final float b) {
        this(w, x, y, z, 1.0f, r, g, b);
    }
    
    public OreParticleFX(final World w, final double x, final double y, final double z, final float scale, final float r, final float g, final float b) {
        super(w, x, y, z, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        final float f4 = (float)Math.random() * 0.4f + 0.6f;
        this.setRBGColorF(r, g, b);
        this.particleScale *= 0.75f;
        this.particleScale *= scale;
        this.reddustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.noClip = false;
    }
    
    public void renderParticle(final Tessellator t, final float x, final float y, final float z, final float f, final float f1, final float f2) {
        float f3 = (this.particleAge + x) / this.particleMaxAge * 32.0f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.particleScale = this.reddustParticleScale * f3;
        super.renderParticle(t, x, y, z, f, f1, f2);
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
}
