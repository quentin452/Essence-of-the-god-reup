package net.essence.event;

import net.minecraftforge.event.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.slayer.api.*;
import java.net.*;
import java.io.*;
import cpw.mods.fml.common.eventhandler.*;
import cpw.mods.fml.relauncher.*;

public class UpdateCheckerEvent
{
    public boolean hasSeen;
    
    public UpdateCheckerEvent() {
        this.hasSeen = false;
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onPlayerLogin(final EntityJoinWorldEvent e) {
        if (e.entity instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)e.entity;
            if (p.worldObj.isRemote) {
                if (!this.hasSeen) {
                    try {
                        if (!UpdateChecker.isOnline()) {
                            SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.AQUA, "[Version: 1.7]");
                            SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.DARK_AQUA, "Unable to check for latest version, you may want to check your internet connection!");
                        }
                        if (UpdateChecker.isUpdateAvailable() && UpdateChecker.isOnline()) {
                            final BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/TheSlayerMC/Essence/master/Version.txt").openStream()));
                            final String curVersion = versionFile.readLine();
                            SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.AQUA, "[Version: 1.7]");
                            SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.RED, "An Essence Of The Gods update is avaliable.");
                            SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.AQUA, "[New Version: " + curVersion + "]");
                        }
                        if (!UpdateChecker.isUpdateAvailable() && UpdateChecker.isOnline()) {
                            SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.AQUA, "[Version: 1.7]");
                            SlayerAPI.addChatMessageWithColour(p, EnumChatFormatting.GREEN, "Essence Of The Gods is up to date.");
                        }
                    }
                    catch (MalformedURLException e2) {
                        e2.printStackTrace();
                    }
                    catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                this.hasSeen = true;
            }
        }
    }
}
