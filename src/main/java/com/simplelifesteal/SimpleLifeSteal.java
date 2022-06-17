package com.simplelifesteal;

import com.simplelifesteal.commands.*;
import com.simplelifesteal.events.HeartUseEvent;
import com.simplelifesteal.events.LifeStealerEvent;
import com.simplelifesteal.util.Config;
import com.simplelifesteal.util.tabcompletion.RevivePlayerTabComplete;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class SimpleLifeSteal extends JavaPlugin {

    public static String version = "1.0.0";
    public static String dataPath;

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
        dataPath = this.getDataFolder().getPath();
        Config.loadConfig();
        logger = this.getServer().getLogger();
        // Plugin startup logic


        //recipeHearts
        ShapedRecipe recipe = new ShapedRecipe( new NamespacedKey(this, "heart"), heart );
        //recipe.shape( "GRG", "OAO", "DDD" );
        recipe.shape("abc", "def", "ghi");

        List<RecipeChoice> items = Config.getCraftingRecipeHeart();
        recipe.setIngredient('a' , items.get(0));
        recipe.setIngredient('b' , items.get(1));
        recipe.setIngredient('c' , items.get(2));
        recipe.setIngredient('d' , items.get(3));
        recipe.setIngredient('e' , items.get(4));
        recipe.setIngredient('f' , items.get(5));
        recipe.setIngredient('g' , items.get(6));
        recipe.setIngredient('h' , items.get(7));
        recipe.setIngredient('i' , items.get(8));
        this.getServer().addRecipe(recipe);
        //recipeHearts




        this.getCommand("simplelifesteal").setExecutor(new SimpleLifeStealCommand());
        this.getCommand("resethearts").setExecutor(new ResetHeartsCommand());
        this.getCommand("sethearts").setExecutor(new SetHeartsCommand());
        this.getCommand("giveheartitem").setExecutor(new GiveHeartItemCommand());
        //this.getCommand("reviveplayer").setExecutor(new RevivePlayerCommand());
        //this.getCommand("reviveplayer").setTabCompleter(new RevivePlayerTabComplete());
        //this.getCommand("adminrevive").setExecutor(new AdminReviveCommand());
        //this.getCommand("adminrevive").setTabCompleter(new RevivePlayerTabComplete());

        //this.getCommand("getdeadplayers").setExecutor(new GetDeadPlayers());

        this.getServer().getPluginManager().registerEvents(new LifeStealerEvent() , this);
        this.getServer().getPluginManager().registerEvents(new HeartUseEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
