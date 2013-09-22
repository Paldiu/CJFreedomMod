package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Enable, disable, and reload plugins. You can also reload all plugins at once.", usage = "/<command> <enable | disable | reload> <plugin>", aliases = "plm")
public class Command_plugin extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if(args[0].equalsIgnoreCase("reload"))
        {
                    if(args.length > 2)
                    {
                        playerMsg("Invalid Usage.");
                        return true;
                    }
                    if(args.length == 1)
                    {
                        Bukkit.broadcastMessage("[CJFreedomMod]" + ChatColor.RED + " Server Reloading.");
                        TFM_Util.reloadServer();
                        TFM_Log.info("Server Reloaded.");
                        Bukkit.broadcastMessage("[CJFreedomMod]" + ChatColor.GREEN + " Server Reloaded.");
                        return true;
                    }
                    if(args.length == 2)
                    {
                        if (!Bukkit.getPluginManager().isPluginEnabled(args[1]))
                        {
                            playerMsg(ChatColor.RED + "[CJFreedomMod] Plugin Invalid.");
                            return true;
                        }
                        Plugin tPlugin = Bukkit.getPluginManager().getPlugin(args[1]);
                        TFM_Util.reloadPlugin(tPlugin);
                        playerMsg(ChatColor.GREEN + "[CJFreedomMod] Plugin %a reloaded.".replaceAll("%a", tPlugin.getName()));
                        return true;
                   }
                }
                
         if(args[0].equalsIgnoreCase("enable"))
         {
            if(args.length > 2|| args.length == 0)
            {
                playerMsg("Invalid Usage.");
                return false;
            }
            if(Bukkit.getPluginManager().isPluginEnabled(args[1]))
            {
                playerMsg(ChatColor.RED + "[CJFreedomMod] Plugin Already Enabled.");
                return true;
            }
            else
            {
                Plugin tPlugin = Bukkit.getPluginManager().getPlugin(args[1]);
                TFM_Util.enablePlugin(tPlugin);
                playerMsg(ChatColor.GREEN + "[CJFreedomMod] Plugin " + tPlugin + " is enabled.");
                return true;
            }
         }
                if(args[0].equalsIgnoreCase("disable"))
                {
                    if(args.length > 2 || args.length == 0)
                    {
                        playerMsg("Invalid Usage.");
                        return false;
                    }
                    if(!Bukkit.getPluginManager().isPluginEnabled(args[1]))
                    {
                        playerMsg(ChatColor.RED + "[CJFreedomMod] Plugin Already Disabled.");
                        return true;
                    }
                    else
                    {
                        Plugin tPlugin = Bukkit.getPluginManager().getPlugin(args[1]);
                        TFM_Util.disablePlugin(tPlugin);
                        playerMsg(ChatColor.RED + "[CJFreedomMod] Plugin " + tPlugin + " is disabled.");
                    }
                    return true;
                }
        return true;
    }
}
