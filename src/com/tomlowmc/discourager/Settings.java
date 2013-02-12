package com.tomlowmc.discourager;

import java.io.File;
import org.bukkit.configuration.file.*;
import lombok.Getter;

public class Settings
{
    private Discourager plugin;
    private FileConfiguration config;
    
    private @Getter double randomnessBlockPlace;
    private @Getter double randomnessBlockBreak;
    private @Getter double randomnessChat;
    private @Getter double randomnessMovement;
    private @Getter boolean discourageBlockPlace;
    private @Getter boolean discourageBlockBreak;
    private @Getter boolean discourageChat;
    private @Getter boolean discourageMovement;
    
    
    public Settings(Discourager pl)
    {
        this.plugin = pl;
        this.config = plugin.getConfig();
        if (!new File(plugin.getDataFolder(), "config.yml").exists()) {
            plugin.getLogger().info(String.format("Config not found, creating a new one."));
            plugin.saveDefaultConfig();
        }
    }
    
    public void reloadConfig()
    {
        randomnessBlockPlace = config.getDouble("BlockPlace.randomness", 0.01);
        randomnessBlockBreak = config.getDouble("BlockBreak.randomness", 0.01);
        randomnessChat = config.getDouble("Chat.randomness", 0.01);
        randomnessMovement = config.getDouble("Movement.randomness", 0.01);
    }
}
