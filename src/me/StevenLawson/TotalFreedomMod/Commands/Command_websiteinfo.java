package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Shows the website and forum info.", usage = "/<command>")
public class Command_websiteinfo extends TFM_Command {

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {

        playerMsg(ChatColor.RED  + "The main website is at thecjgcjg.com");
        playerMsg(ChatColor.BLUE + "The forums are based at: thecjgcjg.com/forum");
        return true;

    }
}
