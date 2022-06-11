package com.the5gi.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.the5gi.SimpleLifeSteal.logger;

public class ResetHeartsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                Player getPlayer = sender.getServer().getPlayer(args[0]);
                getPlayer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                getPlayer.setHealthScale(20);
                getPlayer.setHealth(20);
                player.sendMessage("§a[SimpleLifeSteal] " + getPlayer.getDisplayName() + "'s hearts were reset.");
            } else {
                player.sendMessage("§a[SimpleLifeSteal] Not enough arguments. Ex: \"/resethearts §oplayer§r\" ");
            }
        } else {
            if (args.length == 1) {
                Player getPlayer = sender.getServer().getPlayer(args[0]);
                getPlayer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
                getPlayer.setHealthScale(20);
                getPlayer.setHealth(20);
                logger.info(getPlayer.getDisplayName() + "'s hearts were reset.");
            } else {
                logger.info("§a[SimpleLifeSteal] Not enough arguments. Ex: \"/resethearts §oplayer§r\" ");
            }
        }
        return true;
    }
}
