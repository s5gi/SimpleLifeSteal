package com.simplelifesteal.util.tabcompletion;

import com.simplelifesteal.util.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class RevivePlayerTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> deadPlayers;
            {
                deadPlayers = new ArrayList<>();
                for (String p : Config.getDeadPlayers()) {
                    try {
                        String name = sender.getServer().getPlayer(p).getName();
                        deadPlayers.add(name);
                    } catch (NullPointerException e) {
                    }
                }
            }

            if (!Config.getDeadPlayers().isEmpty()) {
                return deadPlayers;
            }

            if (deadPlayers.isEmpty()) {
                List<String> list = new ArrayList<>();
                list.add("NoOneAvailable");
                return list;
            }
        }
        return null;
    }
}
