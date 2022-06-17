package com.simplelifesteal.commands;

import com.simplelifesteal.SimpleLifeSteal;
import com.simplelifesteal.util.Config;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminReviveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            Player playerForceRevived = sender.getServer().getPlayer(args[0]);
            if (Config.getDeadPlayers().contains(playerForceRevived.getUniqueId().toString())) {
                playerForceRevived.setHealth(0);
                playerForceRevived.setGameMode(GameMode.SURVIVAL);
                Config.getDeadPlayers().remove(playerForceRevived.getUniqueId().toString());
                Config.loadConfig();
                if (Config.getDeadPlayers().isEmpty()) {
                    Config.getDeadPlayers().add("none");
                }
            }


        } else {
            sender.sendMessage("§c[SimpleLifeSteal] Not enough arguments! Usage: /adminrevive player");
        }


        return true;
    }
}
