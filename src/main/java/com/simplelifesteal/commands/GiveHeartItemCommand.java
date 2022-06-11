package com.simplelifesteal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.simplelifesteal.SimpleLifeSteal.heart;
import static com.simplelifesteal.SimpleLifeSteal.logger;

public class GiveHeartItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 2) {
                Player player = (Player) sender;
                Player getPlayer = sender.getServer().getPlayer(args[0]);
                int amount = 0;
                try {
                    amount = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    player.sendMessage("§cCould not pass argument 2. Please use format: /giveheartitem player amount.");
                }
                if (!getPlayer.equals(null)) {
                    for (int i = 0; i<amount; i++) {
                        getPlayer.getInventory().addItem(heart);
                    }
                }
            } else {
               ((Player) sender).getPlayer().sendMessage("§cCould not pass arguments. Please use format: /giveheartitem player amount.");
            }
        } else {
            logger.info("You cannot execute this command in console. I recommend using /sethearts.");
        }
        return true;
    }
}
