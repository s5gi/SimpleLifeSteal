package com.simplelifesteal.events;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.simplelifesteal.SimpleLifeSteal.heart;

public class HeartUseEvent implements Listener {
    @EventHandler
    public void HeartUse(PlayerInteractEvent e) {
        if (e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() < 40) {
            if ((e.getPlayer().getInventory().getItemInMainHand().isSimilar(heart)) && (!e.getPlayer().getInventory().getItemInMainHand().equals(null))) {
                Player player = e.getPlayer();
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + 2);
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.sendMessage("§aYou have gained a heart from using a §c§lCrafted Heart§r§a!");
            }
        } else {
            e.getPlayer().sendMessage("§cYou already have the maximum health!");
        }
    }
}
