package com.the5gi;

import com.the5gi.commands.ResetHeartsCommand;
import com.the5gi.commands.SetHeartsCommand;
import com.the5gi.commands.SimpleLifeStealCommand;
import com.the5gi.events.LifeStealerEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class SimpleLifeSteal extends JavaPlugin {

    public static String version = "1.0.0";

    public static Logger logger;

    @Override
    public void onEnable() {
        logger = this.getServer().getLogger();
        // Plugin startup logic



        this.getCommand("simplelifesteal").setExecutor(new SimpleLifeStealCommand());
        this.getCommand("resethearts").setExecutor(new ResetHeartsCommand());
        this.getCommand("sethearts").setExecutor(new SetHeartsCommand());

        this.getServer().getPluginManager().registerEvents(new LifeStealerEvent() , this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
