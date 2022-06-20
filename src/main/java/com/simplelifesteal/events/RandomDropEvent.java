package com.simplelifesteal.events;

import com.simplelifesteal.items.Scrolls;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

import static java.lang.System.out;


public class RandomDropEvent implements Listener {
    @EventHandler
    public void RandomDropEvent(EntityDeathEvent e) {
        if (e.getEntity() instanceof Evoker) {
            Random rand = new Random();
            int random_integer1 = rand.nextInt(4) + 1;
            int random_integer2 = rand.nextInt(4) + 1;
            if (random_integer1 == random_integer2) {
                e.getEntity().getKiller().getWorld().dropItem(e.getEntity().getLocation(), Scrolls.getDrainedScroll());
            }
        }
    }
}
