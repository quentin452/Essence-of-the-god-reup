package net.essence.client;

import net.minecraftforge.common.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class EssenceBar implements IExtendedEntityProperties
{
    private static int essence;
    private static int regenDelay;
    
    public void saveNBTData(final NBTTagCompound n) {
        n.setInteger("essence", 400);
        n.setInteger("Regen", 20);
    }
    
    public void loadNBTData(final NBTTagCompound n) {
        EssenceBar.essence = n.getInteger("essence");
        EssenceBar.regenDelay = n.getInteger("Regen");
    }
    
    public static void updateAllBars() {
        if (EssenceBar.essence != 400) {
            regen(1);
        }
        else {
            regen(0);
        }
        if (EssenceBar.essence >= 400) {
            EssenceBar.essence = 400;
        }
    }
    
    public static boolean useBar(final int amount) {
        if (EssenceBar.essence < amount) {
            EssenceBar.regenDelay = 20;
            return false;
        }
        EssenceBar.essence -= amount;
        EssenceBar.regenDelay = 20;
        return true;
    }
    
    public static void regen(final int amount) {
        if (EssenceBar.regenDelay == 0) {
            EssenceBar.essence += amount;
        }
        else {
            --EssenceBar.regenDelay;
        }
    }
    
    public static float getBarValue() {
        return (float)EssenceBar.essence;
    }
    
    public static void addBarPoints(final int i) {
        EssenceBar.essence += i;
    }
    
    public static void removeBarPoints(final int i) {
        EssenceBar.regenDelay = 20;
        EssenceBar.essence -= i;
    }
    
    public void init(final Entity entity, final World world) {
    }
}
