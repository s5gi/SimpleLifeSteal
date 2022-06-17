package com.simplelifesteal.commands;

import com.simplelifesteal.SimpleLifeSteal;
import com.simplelifesteal.util.Config;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RevivePlayerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (!(args[0].equals("NoOneAvailable"))) {
                    Player revivedPlayer = player.getServer().getPlayer(args[0]);
                    if (Config.getDeadPlayers().contains(revivedPlayer.getUniqueId().toString())) {
                        if (player.getInventory().getItemInMainHand().equals(SimpleLifeSteal.heart)) {
                            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                            revivedPlayer.sendMessage("§a[SimpleLifeSteal] You have been revived by: " + player.getName());
                            revivedPlayer.teleport(player.getLocation());
                            revivedPlayer.setGameMode(GameMode.SURVIVAL);
                            Config.getDeadPlayers().remove(revivedPlayer.getUniqueId().toString());
                            Config.loadConfig();
                            if (Config.getDeadPlayers().isEmpty()) {
                                Config.getDeadPlayers().add("none");
                            }
                        }
                    } else {
                        player.sendMessage("§c[SimpleLifeSteal] Player is not Dead!");
                    }
                }
            } else {
                player.sendMessage("§c[SimpleLifeSteal] Not enough arguments! Usage: /reviveplayer *player*");
            }
        } else {
            sender.sendMessage("You cannot execute this as console!");
        }

        return true;
    }
}
