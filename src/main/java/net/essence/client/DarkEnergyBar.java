package net.essence.client;

import net.minecraftforge.common.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class DarkEnergyBar implements IExtendedEntityProperties
{
    private static int darkMagic;
    private static int regenDelay;
    
    public void saveNBTData(final NBTTagCompound n) {
        n.setInteger("darkMagic", 400);
        n.setInteger("Regen", 20);
    }
    
    public void loadNBTData(final NBTTagCompound n) {
        DarkEnergyBar.darkMagic = n.getInteger("darkMagic");
        DarkEnergyBar.regenDelay = n.getInteger("Regen");
    }
    
    public static void updateAllBars() {
        if (DarkEnergyBar.darkMagic != 400) {
            regen(1);
        }
        else {
            regen(0);
        }
        if (DarkEnergyBar.darkMagic >= 400) {
            DarkEnergyBar.darkMagic = 400;
        }
    }
    
    public static boolean useBar(final int amount) {
        if (DarkEnergyBar.darkMagic < amount) {
            DarkEnergyBar.regenDelay = 20;
            return false;
        }
        DarkEnergyBar.darkMagic -= amount;
        DarkEnergyBar.regenDelay = 20;
        return true;
    }
    
    public static void regen(final int amount) {
        if (DarkEnergyBar.regenDelay == 0) {
            DarkEnergyBar.darkMagic += amount;
        }
        else {
            --DarkEnergyBar.regenDelay;
        }
    }
    
    public static float getBarValue() {
        return (float)DarkEnergyBar.darkMagic;
    }
    
    public static void addBarPoints(final int i) {
        DarkEnergyBar.darkMagic += i;
    }
    
    public static void removeBarPoints(final int i) {
        DarkEnergyBar.regenDelay = 20;
        DarkEnergyBar.darkMagic -= i;
    }
    
    public void init(final Entity entity, final World world) {
    }
}
