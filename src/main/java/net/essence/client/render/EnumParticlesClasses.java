package net.essence.client.render;

import net.minecraft.client.particle.*;

public enum EnumParticlesClasses
{
    LAVA((Class)EntityLavaFX.class), 
    SMOKE((Class)EntitySmokeFX.class), 
    FLAME((Class)EntityFlameFX.class), 
    SNOWBALL_POOF((Class)EntitySnowShovelFX.class);
    
    private Class particle;
    
    private EnumParticlesClasses(final Class name) {
        this.particle = name;
    }
    
    public Class getParticle() {
        return this.particle;
    }
}
