package com.tomlowmc.discourager;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Discourager extends JavaPlugin
{

    Settings settings;
    DiscourageListener listener;
    private List<Reloader> configs;

    @Override
    public void onEnable()
    {
            getCommand("discourage").setExecutor(new DCommand(this));
        
        configs = new ArrayList<>();
        PluginManager pm = getServer().getPluginManager();
        settings = new Settings(this);
        listener = new DiscourageListener(this);
        pm.registerEvents(listener, this);
        configs.add(settings);
        configs.add(listener);
    }

    @Override
    public void onDisable()
    {

    }

    public Settings getSettings()
    {
        return settings;
    }

    public DiscourageListener getListener()
    {
        return listener;
    }

    public void reloadConfigs(CommandSender sender)
    {
        for(Reloader reload : configs)
        {
            reload.reloadConfig(sender);
        }
    }
}
