package com.simplelifesteal.commands;

import com.simplelifesteal.items.Scrolls;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveScrollCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                if (args[0].equals("ripped")) {
                    player.getInventory().addItem(Scrolls.getDrainedScroll());
                }
                if (args[0].equals("heart")) {
                    player.getInventory().addItem(Scrolls.getHeartScroll(5));
                }
            }

        }

        return true;
    }
}
