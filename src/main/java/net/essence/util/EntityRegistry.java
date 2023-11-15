package net.essence.util;

import net.slayer.api.*;
import net.essence.entity.projectile.*;
import net.essence.entity.mob.boiling.*;
import net.essence.entity.mob.depths.*;
import net.essence.entity.mob.euca.*;
import net.essence.entity.mob.vanilla.*;
import net.essence.entity.mob.boss.*;

public class EntityRegistry
{
    public static void init() {
        SlayerAPI.registerProjectile(EntityBasicProjectile.class, "basic");
        SlayerAPI.registerProjectile(EntityBouncingProjectile.class, "bouncing");
        SlayerAPI.registerProjectile(EntityChaosProjectile.class, "chaos");
        SlayerAPI.registerProjectile(EntityDoomsBringer.class, "doom");
        SlayerAPI.registerProjectile(EntityConjuring.class, "conjuring");
        SlayerAPI.registerProjectile(EntityEnlightment.class, "enlightment");
        SlayerAPI.registerProjectile(EntityGreenpace.class, "greenpace");
        SlayerAPI.registerProjectile(EntityWizardsStar.class, "wizardsstar");
        SlayerAPI.registerProjectile(EntityMagmaFireball.class, "magmaball");
        SlayerAPI.registerMob(EntityRobot.class, "Robot", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntitySpyclops.class, "Spyclops", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntitySpikedBeast.class, "Spiked Beast", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityMagmaGiant.class, "Magma Giant", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityInsecto.class, "Insecto", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityPsyollom.class, "Psyollom", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityDarknessCrawler.class, "Darkness Crawler", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityDepthsBeast.class, "Depths Beast", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityBoom.class, "Boom Boom", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityBigHongo.class, "Big Hongo", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityMediumHongo.class, "Medium Hongo", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntitySmallHongo.class, "Small Hongo", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityEucaFighter.class, "Euca Fighter", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityEucaHopper.class, "Euca Hopper", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityMagmaBlaze.class, "Magma Blaze", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityCrisp.class, "Crisp", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityBurntMiner.class, "Burnt Miner", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityExposedFlame.class, "Exposed Flame", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityBurningLight.class, "Burning Light", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityAshHoarder.class, "Ash Hoarder", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityBurntAsh.class, "Burnt Ash", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityReaper.class, "Reaper", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityDepthsHunter.class, "Depths Hunter", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityEucaCharger.class, "Euca Charger", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityBunny.class, "Bunny", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntitySandCrawler.class, "Sand Crawler", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityTurtle.class, "Essence Turtle", SlayerAPI.mobID++);
        SlayerAPI.registerMob(EntityFish.class, "Fish", SlayerAPI.mobID++);
        SlayerAPI.registerBossMob(EntityNetherBeast.class, "Beast of the Nether", SlayerAPI.mobID++);
        SlayerAPI.registerBossMob(EntityWitheringBeast.class, "Withering Beast", SlayerAPI.mobID++);
        SlayerAPI.registerBossMob(EntityCalcia.class, "Calcia", SlayerAPI.mobID++);
    }
}
