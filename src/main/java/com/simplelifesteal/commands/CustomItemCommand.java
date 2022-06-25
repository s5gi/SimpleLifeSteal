package com.simplelifesteal.commands;

import com.simplelifesteal.items.CustomItems;
import com.simplelifesteal.items.Scrolls;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player) && (args.length == 1)) {
            Player player = (Player) sender;

            if (args[0].equals("heart")) {
                player.getInventory().addItem(CustomItems.getHeart());
            }

            if (args[0].equals("magicfoot")) {
                player.getInventory().addItem(CustomItems.getMagicFoot());
            }

        }
        return true;
    }
}
