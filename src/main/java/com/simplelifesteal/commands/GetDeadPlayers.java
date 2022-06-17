package com.simplelifesteal.commands;

import com.simplelifesteal.util.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GetDeadPlayers implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (String dp : Config.getDeadPlayers()) {
            sender.sendMessage(dp);
            Config.loadConfig();
        }
        return true;
    }
}
