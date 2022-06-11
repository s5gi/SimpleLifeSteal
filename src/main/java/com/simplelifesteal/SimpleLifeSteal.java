package com.simplelifesteal;

import com.simplelifesteal.commands.GiveHeartItemCommand;
import com.simplelifesteal.commands.ResetHeartsCommand;
import com.simplelifesteal.commands.SetHeartsCommand;
import com.simplelifesteal.commands.SimpleLifeStealCommand;
import com.simplelifesteal.events.HeartUseEvent;
import com.simplelifesteal.events.LifeStealerEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class SimpleLifeSteal extends JavaPlugin {

    public static String version = "1.0.0";

    public static Logger logger;
    public static ItemStack heart = new ItemStack(Material.BRICK); {
        ItemMeta heartMeta = heart.getItemMeta();
        heartMeta.setDisplayName(ChatColor.RED + "Heart");
        List<String> lore = new ArrayList<>();
        lore.add("§aUsed to regain hearts you have lost");
        lore.add("§aBut don't waste them! They are quite expensive!");
        heartMeta.setLore(lore);
        heartMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        heart.addUnsafeEnchantment(Enchantment.DURABILITY, 100);
        heart.setItemMeta(heartMeta);
    }

    @Override
    public void onEnable() {
        logger = this.getServer().getLogger();
        // Plugin startup logic


        //recipeHearts
        ShapedRecipe recipe = new ShapedRecipe( heart );
        recipe.shape( "GRG", "OAO", "DDD" );
        recipe.setIngredient( 'G', Material.GOLD_BLOCK );
        recipe.setIngredient( 'O', Material.OBSIDIAN );
        recipe.setIngredient( 'D', Material.DIAMOND_BLOCK);
        recipe.setIngredient( 'R', Material.REDSTONE_BLOCK);
        recipe.setIngredient( 'A', Material.GOLDEN_APPLE);
        this.getServer().addRecipe(recipe);
        //recipeHearts




        this.getCommand("simplelifesteal").setExecutor(new SimpleLifeStealCommand());
        this.getCommand("resethearts").setExecutor(new ResetHeartsCommand());
        this.getCommand("sethearts").setExecutor(new SetHeartsCommand());
        this.getCommand("giveheartitem").setExecutor(new GiveHeartItemCommand());

        this.getServer().getPluginManager().registerEvents(new LifeStealerEvent() , this);
        this.getServer().getPluginManager().registerEvents(new HeartUseEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
