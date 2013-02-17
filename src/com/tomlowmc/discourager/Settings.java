package com.tomlowmc.discourager;

import java.io.File;
import java.util.List;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.*;

public class Settings implements Reloader
{

    private Discourager plugin;
    private FileConfiguration config;
    private @Getter
    double randomnessBlockPlace;
    private @Getter
    double randomnessBlockBreak;
    private @Getter
    double randomnessChat;
    private @Getter
    double randomnessMovement;
    private @Getter
    boolean discourageBlockPlace;
    private @Getter
    boolean discourageBlockBreak;
    private @Getter
    boolean discourageChat;
    private @Getter
    boolean discourageMovement;
    private @Getter
    List<String> players;

    public Settings(Discourager pl)
    {
        this.plugin = pl;
        this.config = plugin.getConfig();
        if (!new File(plugin.getDataFolder(), "config.yml").exists())
        {
            plugin.getLogger().info(String.format("Config not found, creating a new one."));
            plugin.saveDefaultConfig();
        }
    }

    @Override
    public void reloadConfig(CommandSender sender)
    {
        randomnessBlockPlace = config.getDouble("BlockPlace.randomness", 0.01);
        randomnessBlockBreak = config.getDouble("BlockBreak.randomness", 0.01);
        randomnessChat = config.getDouble("Chat.randomness", 0.01);
        randomnessMovement = config.getDouble("Movement.randomness", 0.01);
        players = config.getStringList("players");

        sender.sendMessage(ChatColor.YELLOW + "Reloading Discourager");
    }

    public boolean addToList(String name)
    {
        if (players.contains(name))
        {
            return false;
        }
        players.add(name);
        config.set("players", players);
        plugin.saveConfig();
        return true;
    }

    public boolean removeFromList(String name)
    {
        if (!players.contains(name))
        {
            return false;
        }
        players.remove(name);
        config.set("players", players);
        plugin.saveConfig();
        return true;
    }
}
