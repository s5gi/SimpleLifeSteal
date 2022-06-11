package com.the5gi.events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class LifeStealerEvent implements Listener {
    @EventHandler
    public void DeathListener(EntityDamageByEntityEvent e) {
        if ((e.getEntity() instanceof Player) && (e.getDamager() instanceof Player)) {
            Player Stealer = (Player) e.getDamager();
            Player StolenFrom = (Player) e.getEntity();

            if (StolenFrom.getHealth() == 1) {
                StolenFrom.setHealth(0);
                StolenFrom.setHealthScale(StolenFrom.getHealthScale() - 2);
                Stealer.setHealthScale(Stealer.getHealthScale() + 2);
                Stealer.playSound(Stealer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 12, 0);
                StolenFrom.playSound(StolenFrom.getLocation(), Sound.BLOCK_ANVIL_LAND, 12, 0);

                Stealer.sendMessage("§a[LifeSteal] You have gained one heart from killing  " + StolenFrom.getDisplayName() + "!");

            }

        }
    }
}
