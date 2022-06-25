package com.simplelifesteal.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItems {

    public static ItemStack getHeart() {
        ItemStack heart = new ItemStack(Material.BRICK);
        ItemMeta heartMeta = heart.getItemMeta();
        heartMeta.setDisplayName(ChatColor.RED + "Heart");
        List<String> lore = new ArrayList<>();
        lore.add("§aUsed to regain hearts you have lost");
        lore.add("§aBut don't waste them! They are quite expensive!");
        heartMeta.setLore(lore);
        heartMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        heart.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        heart.setItemMeta(heartMeta);

        return heart;
    }

    public static ItemStack getMagicFoot() {
        ItemStack foot = new ItemStack(Material.RABBIT_FOOT);
        foot.addUnsafeEnchantment(Enchantment.LURE, 1);
        ItemMeta footMeta = foot.getItemMeta();

        footMeta.setDisplayName("" + ChatColor.GREEN + ChatColor.MAGIC + "o" + ChatColor.GREEN + " Magic Foot "+ ChatColor.GREEN + ChatColor.MAGIC + "o");
        List<String> lore = new ArrayList<>();
        lore.add("§2A foot that comes in handy with scrolls :)");
        footMeta.setLore(lore);
        footMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        foot.setItemMeta(footMeta);

        return foot;
    }


}