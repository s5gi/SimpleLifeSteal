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


    //Heart Scroll
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
        heartScrollMeta.setLore(heartScrollLore);
        heartScroll.setItemMeta(heartScrollMeta);

        return heartScroll;
    }




    public static void useHeartScroll(Player User, Player Effected, ItemStack Scroll) {
        int UsesLeft = Integer.parseInt(Scroll.getItemMeta().getDisplayName().substring(22, 23).trim() /*"5"*/);
        Location effectedLocation = new Location(Effected.getWorld(), Effected.getLocation().getX(), Effected.getLocation().getY() + 2, Effected.getLocation().getZ());
        if (UsesLeft == 1) {
            Effected.getWorld().playSound(effectedLocation, Sound.BLOCK_BEACON_ACTIVATE, 30, 1);
            Effected.getWorld().spawnParticle(Particle.HEART, effectedLocation, 20);
            User.getInventory().getItemInMainHand().setAmount(User.getInventory().getItemInMainHand().getAmount() - 1);
            User.getInventory().addItem(getDrainedScroll());
        } else if ((UsesLeft > 1)) {
            Effected.getWorld().playSound(effectedLocation, Sound.BLOCK_BEACON_ACTIVATE, 30, 1);
            Effected.getWorld().spawnParticle(Particle.HEART, effectedLocation, 20);
            User.getInventory().getItemInMainHand().setAmount(User.getInventory().getItemInMainHand().getAmount() - 1);
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
        if (User.getInventory().getItemInMainHand().getAmount() > 1) {
            User.getInventory().getItemInMainHand().setAmount(User.getInventory().getItemInMainHand().getAmount() - 1);
        } else if (User.getInventory().getItemInMainHand().getAmount() == 1) {
            User.getInventory().getItemInMainHand().setAmount(0);
        }
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

    //Heart Scroll


    //Leaping Scroll


    public static ItemStack getLeapingScroll(int Durability) {
        ItemStack leapingScroll = new ItemStack(Material.PAPER);
        ItemMeta leapingScrollMeta = leapingScroll.getItemMeta();

        //leapingScrollMeta.setDisplayName("" + ChatColor.GREEN + ChatColor.MAGIC + "o" + ChatColor.GREEN + " Heart Scroll [" + Durability + "] " + ChatColor.GREEN + ChatColor.MAGIC + "o");
        leapingScrollMeta.setDisplayName("" + ChatColor.GREEN + ChatColor.MAGIC + "o" + ChatColor.GREEN + " Leaping Scroll [" + Durability + "] " + ChatColor.GREEN + ChatColor.MAGIC + "o");
        List<String> leapingScrollLore = new ArrayList<>();
        leapingScrollLore.add("§b§oUsed as a way to boost yourself in a direction.");
        leapingScrollLore.add(" ");
        leapingScrollLore.add("§2Right click to be boosted (-1 Durability)");
        leapingScrollMeta.setLore(leapingScrollLore);
        leapingScroll.setItemMeta(leapingScrollMeta);

        return leapingScroll;
    }
    public static void useLeapingScroll(Player User, ItemStack Scroll) {
        User.setVelocity(User.getLocation().getDirection().multiply(1.5));
        int UsesLeft = Integer.parseInt(Scroll.getItemMeta().getDisplayName().substring(24, 25).trim() /*"5"*/);
        if (UsesLeft == 1) {
            User.getInventory().getItemInMainHand().setAmount(User.getInventory().getItemInMainHand().getAmount() - 1);
            User.getInventory().addItem(getDrainedScroll());
        } else if ((UsesLeft > 1)) {
            User.getInventory().getItemInMainHand().setAmount(User.getInventory().getItemInMainHand().getAmount() - 1);
            User.getInventory().addItem(getLeapingScroll(UsesLeft - 1));
        }
    }


    //Leaping Scroll

}
