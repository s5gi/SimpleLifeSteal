package com.simplelifesteal.items;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Scrolls {


    public static ItemStack getDrainedScroll() {
        ItemStack rippedScroll = new ItemStack(Material.LEATHER);
        ItemMeta rippedScrollMeta = rippedScroll.getItemMeta();

        rippedScrollMeta.setDisplayName(ChatColor.RED + "Drained Scroll");
        List<String> rippedScrollLore = new ArrayList<>();
        rippedScrollLore.add("§4§oSacrifice an item to refill the scroll.");
        rippedScrollMeta.setLore(rippedScrollLore);
        rippedScroll.setItemMeta(rippedScrollMeta);

        return rippedScroll;
    }


    public static ItemStack getHeartScroll(int Durability) {
        ItemStack heartScroll = new ItemStack(Material.PAPER);
        ItemMeta heartScrollMeta = heartScroll.getItemMeta();

        heartScrollMeta.setDisplayName("" + ChatColor.DARK_PURPLE + ChatColor.MAGIC + "o" + ChatColor.DARK_PURPLE + " Heart Scroll [" + Durability + "] " + ChatColor.DARK_PURPLE + ChatColor.MAGIC + "o");
        List<String> heartScrollLore = new ArrayList<>();
        heartScrollLore.add("§b§oUsed as a way to grant others health.");
        heartScrollLore.add(" ");
        heartScrollLore.add("§cRight Click a player with it and they will be healed! (-1 Durability, -2 Health)");
        heartScrollLore.add(" ");
        heartScrollLore.add("§4Put the scroll in your offhand, crouch, and right click");
        heartScrollLore.add("§4and it will heal everyone in a radius of 50 blocks...");
        heartScrollLore.add("§4At the expense of your life, the scroll, and 3 hearts.");
        heartScrollLore.add(" ");
        heartScrollLore.add("§9§o[DO NOT STACK. WILL BREAK ITEM ON USE]");
        heartScrollMeta.setLore(heartScrollLore);
        heartScroll.setItemMeta(heartScrollMeta);

        return heartScroll;
    }




    public static void useHeartScroll(Player User, Player Effected, ItemStack Scroll) {
        Scroll.getItemMeta().getDisplayName();
        int UsesLeft = Integer.parseInt(Scroll.getItemMeta().getDisplayName().substring(22, 23).trim() /*"5"*/);
        Location effectedLocation = new Location(Effected.getWorld(), Effected.getLocation().getX(), Effected.getLocation().getY() + 2, Effected.getLocation().getZ());
        if (UsesLeft == 1) {
            Effected.getWorld().playSound(effectedLocation, Sound.BLOCK_BEACON_ACTIVATE, 30, 1);
            Effected.getWorld().spawnParticle(Particle.HEART, effectedLocation, 20);
            User.getInventory().getItemInMainHand().setAmount(0);
            User.getInventory().addItem(getDrainedScroll());
        } else if ((UsesLeft > 1)) {
            Effected.getWorld().playSound(effectedLocation, Sound.BLOCK_BEACON_ACTIVATE, 30, 1);
            Effected.getWorld().spawnParticle(Particle.HEART, effectedLocation, 20);
            User.getInventory().getItemInMainHand().setAmount(0);
            User.getInventory().addItem(getHeartScroll(UsesLeft - 1));


        }
        Effected.setHealth(Effected.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        if(User.getHealth() <= 4) {
            User.setHealth(0);
        } else {
            User.setHealth(User.getHealth() - 4);
        }
    }

    public static void useHeartScrollUltimate(Player User, List<Player> Effected, ItemStack Scroll) {
        User.getInventory().getItemInMainHand().setAmount(0);
        User.setHealth(0);
        User.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, User.getLocation(), 20);
        User.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(User.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() - 2);
        for (Player effectedEach : Effected) {
            effectedEach.setHealth(effectedEach.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            effectedEach.playSound(effectedEach, Sound.BLOCK_BEACON_ACTIVATE, 30, 1);
            effectedEach.spawnParticle(Particle.HEART, effectedEach.getLocation(), 20);
            effectedEach.sendMessage("§aYou Have been given full health by §b" + User.getName() + "§a but unfortunately... §4§lIt cost them their life.");
        }
    }
}
