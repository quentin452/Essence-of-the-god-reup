package net.essence.client;

import net.minecraft.world.*;
import net.minecraft.entity.*;

public enum EnumSounds
{
    ROBOT("eotg:robot"), 
    ROBOT_HURT("eotg:robotHurt"), 
    PSYOLLOM("eotg:psyollom"), 
    PSYOLLOM_HURT("eotg:psyollomHurt"), 
    INSECTO("eotg:insecto"), 
    INSECTO_HURT("eotg:insectoHurt"), 
    SPIKED_BEAST("eotg:spikedBeast"), 
    SPIKED_BEAST_HURT("eotg:spikedBeastHurt"), 
    MAGMA_GIANT("eotg:magmaGiant"), 
    MAGMA_GIANT_HURT("eotg:magmaGiantHurt"), 
    SPYCLOPS("eotg:spyclops"), 
    SPYCLOPS_HURT("eotg:spyclopsHurt"), 
    TURTLE("eotg:turtle"), 
    TURTLE_HURT("eotg:turtleHurt"), 
    BUNNY("eotg:bunny"), 
    BUNNY_HURT("eotg:bunnyHurt"), 
    HONGO("eotg:hongo"), 
    SMALL_HONGO("eotg:smallHongo"), 
    SMALL_HONGO_HURT("eotg:smallHongoHurt"), 
    HONGO_HURT("eotg:hongoHurt"), 
    REAPER("eotg:reaper"), 
    REAPER_HURT("eotg:reaperHurt"), 
    SAND_CRAWLER("eotg:sandCrawler"), 
    DEPTHS_HUNTER("eotg:depthsHunter"), 
    DEPTHS_HUNTER_HURT("eotg:depthsHunterHurt"), 
    NETHER_BEAST("eotg:netherBeast"), 
    NETHER_BEAST_HURT("eotg:netherBeastHurt"), 
    CALCIA("eotg:calcia"), 
    CALCIA_HURT("eotg:calciaHurt"), 
    IRON_GOLEM_HURT("mob.irongolem.hit"), 
    IRON_GOLEM_DEATH("mob.irongolem.death"), 
    BLAZE("mob.blaze.breathe"), 
    BLAZE_HURT("mob.blaze.hit"), 
    BLAZE_DEATH("mob.blaze.death"), 
    WITHER("mob.wither.idle"), 
    WITHER_HURT("mob.wither.hurt"), 
    WITHER_DEATH("mob.wither.death"), 
    STAFF("eotg:staff");
    
    private String sound;
    
    private EnumSounds(final String sound) {
        this.sound = sound;
    }
    
    public String getPrefixedName() {
        return this.sound;
    }
    
    public String getNonPrefixedName() {
        return this.sound;
    }
    
    public static void playSound(final String sound, final World w, final EntityLivingBase e) {
        w.playSoundAtEntity((Entity)e, sound, 1.0f, 1.0f);
    }
    
    public static void playSound(final String sound, final World w, final EntityLivingBase e, final float volume, final float pitch) {
        w.playSoundAtEntity((Entity)e, sound, volume, pitch);
    }
}
