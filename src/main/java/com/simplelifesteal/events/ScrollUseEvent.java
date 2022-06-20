package com.simplelifesteal.events;

import com.simplelifesteal.items.Scrolls;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;

import static com.simplelifesteal.SimpleLifeSteal.heart;

public class ScrollUseEvent implements Listener {
    @EventHandler
    public void ScrollUseEvent(PlayerInteractEvent e) {
        if ((e.getPlayer().getInventory().getItemInMainHand().isSimilar(Scrolls.getHeartScroll(5))) && (e.getPlayer().isSneaking()) && ((e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() >= 4)) && (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            List<Entity> entityList = e.getPlayer().getNearbyEntities(50,50,50);
            List<Player> Effected = new ArrayList<>();
            for (Entity entity : entityList) {
                if (entity instanceof Player) {
                    Effected.add((Player) entity);
                }
            }


            Scrolls.useHeartScrollUltimate(e.getPlayer(), Effected, e.getPlayer().getInventory().getItem(EquipmentSlot.OFF_HAND));
        }
    }
}
