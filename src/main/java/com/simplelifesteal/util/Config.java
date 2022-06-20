package com.simplelifesteal.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.simplelifesteal.SimpleLifeSteal.dataPath;
import static com.simplelifesteal.SimpleLifeSteal.version;

public class Config {

    public static YamlFile config;

    public static void loadConfig() {
        config = new YamlFile(dataPath + "/" + "config.yml");
        // Plugin startup logic
        try {
            if (!config.exists()) {
                config.createNewFile(true);
            } else {
            }
            config.load();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        config.setComment("config.scrollsenabled", "Enables the magical scrolls. See https://www.spigotmc.org/resources/simplelifesteal.102533/ for info.");
        config.addDefault("config.scrollsenabled", false);


        List<String> r = new ArrayList<>();
        r.add("gold_block:1");
        r.add("redstone_block:1");
        r.add("gold_block:1");
        r.add("obsidian:1");
        r.add("golden_apple:1");
        r.add("obsidian:1");
        r.add("diamond_block:1");
        r.add("diamond_block:1");
        r.add("diamond_block:1");
        config.setComment("storage.recipe", "The Crafting recipe for the heart. If you want a slot empty put: \"air:1\"");
        config.addDefault("storage.recipe", r);



        try {
            config.save();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }


    public static YamlFile getMCConfig() {
        return config;
    }

    public static boolean getScrollEnabledStatus() {
        return getMCConfig().getBoolean("config.scrollsenabled");
    }


    public static List<String> getDeadPlayers() {
        return getMCConfig().getStringList("storage.deadlist");
    }



    public static List<RecipeChoice> getCraftingRecipeHeart() {
        List<String> items = getMCConfig().getStringList("storage.recipe");

        List<RecipeChoice> itemStackList = new ArrayList<>();

        for(int i = 0; i <= 8; i++) {
            String itemGet = items.get(i);

            String[] itemData = itemGet.split(":");

            String item = itemData[0];
            int itemAmount = Integer.parseInt(itemData[1]);

            RecipeChoice stack = new RecipeChoice.ExactChoice(new ItemStack(Material.valueOf(item.toUpperCase()), itemAmount));

            itemStackList.add(stack);
        }


        return itemStackList;
    }


}
