package com.simplelifesteal.events;

import com.simplelifesteal.items.Scrolls;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class PlayerInteractEntityEvent implements Listener {
    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event)
    {
        if (event.getHand() == EquipmentSlot.OFF_HAND) {
            return; // off hand packet, ignore.
        }
        if ((event.getPlayer().getInventory().getItemInMainHand().isSimilar(Scrolls.getHeartScroll(5)))
                | (event.getPlayer().getInventory().getItemInMainHand().isSimilar(Scrolls.getHeartScroll(4)))
                | (event.getPlayer().getInventory().getItemInMainHand().isSimilar(Scrolls.getHeartScroll(3)))
                | (event.getPlayer().getInventory().getItemInMainHand().isSimilar(Scrolls.getHeartScroll(2)))
                | (event.getPlayer().getInventory().getItemInMainHand().isSimilar(Scrolls.getHeartScroll(1)))) {
            if (event.getRightClicked().getType().equals(EntityType.PLAYER)) {
                Player User = event.getPlayer();
                Player Effected = (Player) event.getRightClicked();
                Scrolls.useHeartScroll(User, Effected, User.getInventory().getItemInMainHand());
            }
        }
    }
}
