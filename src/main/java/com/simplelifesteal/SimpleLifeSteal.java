package com.simplelifesteal;

import com.simplelifesteal.commands.*;
import com.simplelifesteal.events.*;
import com.simplelifesteal.items.CustomItems;
import com.simplelifesteal.items.Scrolls;
import com.simplelifesteal.util.Config;
import com.simplelifesteal.util.tabcompletion.CustomItemTabComplete;
import com.simplelifesteal.util.tabcompletion.GiveScrollTabComplete;
import com.simplelifesteal.util.tabcompletion.RevivePlayerTabComplete;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class SimpleLifeSteal extends JavaPlugin {

    public static String version = "1.1.2";
    public static String dataPath;

    public static Logger logger;

    @Override
    public void onEnable() {
        dataPath = this.getDataFolder().getPath();
        Config.loadConfig();
        logger = this.getServer().getLogger();
        // Plugin startup logic


        //recipeHearts
        ShapedRecipe recipe = new ShapedRecipe( new NamespacedKey(this, "heart"), CustomItems.getHeart());
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
        this.getCommand("givescroll").setExecutor(new GiveScrollCommand());
        this.getCommand("givescroll").setTabCompleter(new GiveScrollTabComplete());
        this.getCommand("customitem").setExecutor(new CustomItemCommand());
        this.getCommand("customitem").setTabCompleter(new CustomItemTabComplete());


        //this.getCommand("reviveplayer").setExecutor(new RevivePlayerCommand());
        //this.getCommand("reviveplayer").setTabCompleter(new RevivePlayerTabComplete());
        //this.getCommand("adminrevive").setExecutor(new AdminReviveCommand());
        //this.getCommand("adminrevive").setTabCompleter(new RevivePlayerTabComplete());

        //this.getCommand("getdeadplayers").setExecutor(new GetDeadPlayers());


        if (Config.getScrollEnabledStatus()) {
            this.getServer().getPluginManager().registerEvents(new PlayerInteractEntityEvent(), this);
            this.getServer().getPluginManager().registerEvents(new ScrollUseEvent(), this);
            this.getServer().getPluginManager().registerEvents(new RandomDropEvent(), this);

            ShapelessRecipe heartScrollRecipe = new ShapelessRecipe(new NamespacedKey(this, "heartscroll"), Scrolls.getHeartScroll(5));
            heartScrollRecipe.addIngredient(new RecipeChoice.ExactChoice(Scrolls.getDrainedScroll()));
            heartScrollRecipe.addIngredient(new RecipeChoice.ExactChoice(CustomItems.getHeart()));
            this.getServer().addRecipe(heartScrollRecipe);

            ShapelessRecipe leapingScrollRecipe = new ShapelessRecipe(new NamespacedKey(this, "leapingscroll"), Scrolls.getLeapingScroll(5));
            leapingScrollRecipe.addIngredient(new RecipeChoice.ExactChoice(Scrolls.getDrainedScroll()));
            leapingScrollRecipe.addIngredient(new RecipeChoice.ExactChoice(CustomItems.getMagicFoot()));
            this.getServer().addRecipe(leapingScrollRecipe);


            ShapedRecipe magicFootRecipe = new ShapedRecipe(new NamespacedKey(this, "magicfoot"), CustomItems.getMagicFoot());
            magicFootRecipe.shape("abc", "def", "ghi");
            magicFootRecipe.setIngredient('a', Material.RABBIT_FOOT);
            magicFootRecipe.setIngredient('b', Material.RABBIT_FOOT);
            magicFootRecipe.setIngredient('c', Material.RABBIT_FOOT);
            magicFootRecipe.setIngredient('d', Material.RABBIT_FOOT);
            magicFootRecipe.setIngredient('e', Material.EMERALD_BLOCK);
            magicFootRecipe.setIngredient('f', Material.RABBIT_FOOT);
            magicFootRecipe.setIngredient('g', Material.RABBIT_FOOT);
            magicFootRecipe.setIngredient('h', Material.RABBIT_FOOT);
            magicFootRecipe.setIngredient('i', Material.RABBIT_FOOT);
            this.getServer().addRecipe(magicFootRecipe);

        }


        this.getServer().getPluginManager().registerEvents(new LifeStealerEvent() , this);
        this.getServer().getPluginManager().registerEvents(new HeartUseEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
