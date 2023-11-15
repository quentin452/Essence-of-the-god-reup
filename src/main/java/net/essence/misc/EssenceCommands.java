package net.essence.misc;

import net.minecraft.command.*;
import net.essence.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.essence.util.*;
import net.essence.*;
import net.essence.dimension.*;
import net.minecraft.block.*;
import java.util.*;

public class EssenceCommands extends CommandBase
{
    public String getCommandName() {
        return "essence";
    }
    
    public String getCommandUsage(final ICommandSender var1) {
        return "/essence";
    }
    
    public void processCommand(final ICommandSender var1, final String[] var2) {
        final EntityPlayerMP p = getCommandSenderAsPlayer(var1);
        if (var2[0].equalsIgnoreCase("Heal")) {
            if (p.getHealth() < p.getMaxHealth()) {
                p.heal(20.0f);
            }
            if (p.getFoodStats().needFood()) {
                p.getFoodStats().addStats(20, 1.0f);
            }
            EssenceBar.addBarPoints(400);
            DarkEnergyBar.addBarPoints(400);
        }
        final EntityPlayerMP playerMP = (EntityPlayerMP)var1;
        if (!playerMP.worldObj.isRemote) {
            if (var2[0].equalsIgnoreCase("Overworld") && playerMP.dimension != 0) {
                playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, new Teleporter(playerMP.mcServer.worldServerForDimension(0)));
            }
            if (var2[0].equalsIgnoreCase("Nether") && playerMP.dimension != -1) {
                playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, -1, new Teleporter(playerMP.mcServer.worldServerForDimension(-1)));
            }
            if (var2[0].equalsIgnoreCase("End") && playerMP.dimension != 1) {
                playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 1, new Teleporter(playerMP.mcServer.worldServerForDimension(1)));
            }
            if (var2[0].equalsIgnoreCase("Euca") && playerMP.dimension != Config.euca) {
                playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.euca, (Teleporter)new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.euca), Config.euca, (Block)EssenceBlocks.eucaPortal, EssenceBlocks.eucaPortalFrame));
            }
            if (var2[0].equalsIgnoreCase("BoilingPoint") && playerMP.dimension != Config.euca) {
                playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.boil, (Teleporter)new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.boil), Config.boil, (Block)EssenceBlocks.boilPortal, EssenceBlocks.boilPortalFrame));
            }
            if (var2[0].equalsIgnoreCase("Depths") && playerMP.dimension != Config.depths) {
                playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.depths, (Teleporter)new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.depths), Config.depths, (Block)EssenceBlocks.depthsPortal, EssenceBlocks.depthsPortalFrame));
            }
        }
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public List addTabCompletionOptions(final ICommandSender par1ICommandSender, final String[] par2) {
        return (par2.length == 1) ? getListOfStringsMatchingLastWord(par2, new String[] { "heal", "overworld", "nether", "end", "euca", "boilingpoint", "depths" }) : null;
    }
}
