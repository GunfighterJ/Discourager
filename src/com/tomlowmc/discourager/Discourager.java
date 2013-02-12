package com.tomlowmc.discourager;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Discourager extends JavaPlugin
{

    Settings settings;
   
    @Override
    public void onEnable()
    {
        PluginManager pm = getServer().getPluginManager();
        settings = new Settings(this);
    }

    @Override
    public void onDisable()
    {
    }
}
