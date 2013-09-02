package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(
        description = "Use admin commands on someone by hash. Use mode 'list' to get a player's hash. Other modes are kick, nameban, ipban, ban, op, deop, ci",
        usage = "/<command> [list]")
public class Command_gadmin extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            return false;
        }

        String mode = args[0].toLowerCase();

        if (mode.equals("list"))
        {
            playerMsg("[ Real Name ] : [ Display Name ]");
        }

        for (Player player : server.getOnlinePlayers())
        {
            String hash = player.getUniqueId().toString().substring(0, 4);
            if (mode.equals("list"))
            {
                sender.sendMessage(ChatColor.GRAY + String.format("[ %s ] : [ %s ]",
                        player.getName(),
                        ChatColor.stripColor(player.getDisplayName()),
                        hash));
            }
            
        }

        if (!mode.equals("list"))
        {
            playerMsg("Invalid hash.", ChatColor.RED);
        }

        return true;
    }
}
