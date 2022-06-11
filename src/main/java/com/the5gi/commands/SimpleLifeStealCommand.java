package com.the5gi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.the5gi.SimpleLifeSteal.logger;
import static com.the5gi.SimpleLifeSteal.version;

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
