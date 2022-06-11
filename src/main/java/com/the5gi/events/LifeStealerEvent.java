package com.the5gi.events;

import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class LifeStealerEvent implements Listener {
    @EventHandler
    public void DeathListener(PlayerDeathEvent e) {
        final LivingEntity entity = e.getEntity();
        if ((e.getEntity() instanceof Player) && (entity.getKiller() instanceof Player)) {
            Player Stealer = entity.getKiller();
            Player StolenFrom = e.getEntity();


            if ((Stealer.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() < 40) && (!(StolenFrom.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() == 2))) {
                StolenFrom.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(StolenFrom.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 2);
                Stealer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(Stealer.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + 2);
                Stealer.playSound(Stealer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 12, 0);
                StolenFrom.playSound(StolenFrom.getLocation(), Sound.BLOCK_ANVIL_LAND, 12, 0);

                Stealer.sendMessage("§a[LifeSteal] You have gained one heart from killing " + StolenFrom.getDisplayName() + "!");
                StolenFrom.sendMessage("§c[LifeSteal] You have lost a heart from being slain by " + Stealer.getDisplayName() + "!");
            } else {
                Stealer.sendMessage("§c[LifeSteal] You did not receive a heart because you either have 20 hearts or the opponent only has 1 heart!");
            }

        }
    }
}
