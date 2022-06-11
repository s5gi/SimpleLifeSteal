package com.simplelifesteal.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.simplelifesteal.SimpleLifeSteal.logger;

public class SetHeartsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 2) {
                Player getPlayer = sender.getServer().getPlayer(args[0]);
                double toHealth = Double.parseDouble(args[1]);

                getPlayer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(toHealth * 2);
                getPlayer.setHealthScale(toHealth * 2);
                getPlayer.setHealth(toHealth * 2);

            } else {
                sender.sendMessage("§a[SimpleLifeSteal] Not enough arguments. Ex: \"/sethearts §oplayer§r amount\" ");
            }
        } else {
            if (args.length == 2) {
                Player getPlayer = sender.getServer().getPlayer(args[0]);
                double toHealth = Double.parseDouble(args[1]);


                getPlayer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(toHealth * 2);
                getPlayer.setHealthScale(toHealth * 2);
                getPlayer.setHealth(toHealth * 2);

            } else {
                logger.info("Not enough arguments. Ex: \"/sethearts §oplayer§r amount\" ");
            }
        }
        return true;
    }
}
