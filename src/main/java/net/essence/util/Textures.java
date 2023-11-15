package net.essence.util;

import net.minecraft.util.*;

public class Textures
{
    public static final String prefix = "eotg:textures/models/mobs/";
    public static final String projectilePrefix = "eotg:textures/projectile/";
    public static final String modelPrefix = "eotg:textures/models/";
    public static final String slotPrefix = "eotg:textures/gui/slot";
    public static final ResourceLocation basic;
    public static final ResourceLocation bouncingProjectile;
    public static final ResourceLocation magmaBall;
    public static final ResourceLocation robot;
    public static final ResourceLocation blank;
    public static final ResourceLocation spyclops;
    public static final ResourceLocation spikedBeast;
    public static final ResourceLocation magmaGiant;
    public static final ResourceLocation insecto;
    public static final ResourceLocation psyollom;
    public static final ResourceLocation depthsBeast;
    public static final ResourceLocation darknessCrawler;
    public static final ResourceLocation netherBeast;
    public static final ResourceLocation witheringBeast;
    public static final ResourceLocation calcia;
    public static final ResourceLocation eudor;
    public static final ResourceLocation boom;
    public static final ResourceLocation boomArmor;
    public static final ResourceLocation wraith;
    public static final ResourceLocation bigHongo;
    public static final ResourceLocation mediumHongo;
    public static final ResourceLocation smallHongo;
    public static final ResourceLocation eucaFighter;
    public static final ResourceLocation eucaHopper;
    public static final ResourceLocation eucaHopperTamed;
    public static final ResourceLocation magmaBlaze;
    public static final ResourceLocation crisp;
    public static final ResourceLocation burntMiner;
    public static final ResourceLocation exposedFlame;
    public static final ResourceLocation burningLight;
    public static final ResourceLocation ashHoarder;
    public static final ResourceLocation burntAsh;
    public static final ResourceLocation reaper;
    public static final ResourceLocation depthsHunter;
    public static final ResourceLocation eucaCharger;
    public static final ResourceLocation bunny;
    public static final ResourceLocation sandCrawler;
    public static final ResourceLocation turtle;
    
    private static ResourceLocation addMob(final String tex) {
        return new ResourceLocation("eotg:textures/models/mobs/" + tex + ".png");
    }
    
    private static ResourceLocation addProjectile(final String tex) {
        return new ResourceLocation("eotg:textures/projectile/" + tex + ".png");
    }
    
    private static ResourceLocation addModel(final String tex) {
        return new ResourceLocation("eotg:textures/models/" + tex + ".png");
    }
    
    private static ResourceLocation addSlot(final String tex) {
        return new ResourceLocation("eotg:textures/gui/slot" + tex + ".png");
    }
    
    static {
        basic = addProjectile("grey");
        bouncingProjectile = addProjectile("bouncing");
        magmaBall = addProjectile("magmaBall");
        robot = addMob("robot");
        blank = addMob("blank");
        spyclops = addMob("spyclops");
        spikedBeast = addMob("spikedBeast");
        magmaGiant = addMob("magmaGiant");
        insecto = addMob("insecto");
        psyollom = addMob("psyollom");
        depthsBeast = addMob("depthsBeast");
        darknessCrawler = addMob("darknessCrawler");
        netherBeast = addMob("netherBeast");
        witheringBeast = addMob("witheringBeast");
        calcia = addMob("calcia");
        eudor = addMob("eudor");
        boom = addMob("boom");
        boomArmor = addMob("boomArmor");
        wraith = addMob("wraith");
        bigHongo = addMob("bigHongo");
        mediumHongo = addMob("mediumHongo");
        smallHongo = addMob("smallHongo");
        eucaFighter = addMob("eucaFighter");
        eucaHopper = addMob("eucaHopper");
        eucaHopperTamed = addMob("eucaHopperTamed");
        magmaBlaze = addMob("magmaBlaze");
        crisp = addMob("crisp");
        burntMiner = addMob("burntMiner");
        exposedFlame = addMob("exposedFlame");
        burningLight = addMob("burningLight");
        ashHoarder = addMob("ashHoarder");
        burntAsh = addMob("burntAsh");
        reaper = addMob("reaper");
        depthsHunter = addMob("depthsHunter");
        eucaCharger = addMob("eucaCharger");
        bunny = addMob("bunny");
        sandCrawler = addMob("sandCrawler");
        turtle = addMob("turtle");
    }
}
