package com.simplelifesteal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.simplelifesteal.SimpleLifeSteal.logger;

public class SimpleLifeStealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("SimpleLifeSteal");
        } else {
            logger.info("SimpleLifeSteal");
        }
        return true;
    }
}
