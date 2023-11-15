package net.essence.util;

public final class EssenceBossStatus
{
    public static float healthScale;
    public static int statusBarTime;
    public static int id;
    public static boolean hasColorModifier;
    
    public static void setStatus(final IEssenceBoss boss, final int id1) {
        EssenceBossStatus.healthScale = boss.getModHealth() / boss.getModMaxHealth();
        EssenceBossStatus.statusBarTime = 100;
        EssenceBossStatus.id = id1;
    }
}
