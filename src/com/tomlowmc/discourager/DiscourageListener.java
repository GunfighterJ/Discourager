package com.tomlowmc.discourager;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class DiscourageListener implements Listener, Reloader
{

    private final Discourager plugin;
    List<String> players = new ArrayList<>();

    public DiscourageListener(Discourager pl)
    {
        this.plugin = pl;
        players = plugin.getSettings().getPlayers();
    }

    @Override
    public void reloadConfig(final CommandSender sender)
    {
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin,
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        players = plugin.getSettings().getPlayers();
                        sender.sendMessage(ChatColor.YELLOW + "Reload complete");
                    }
                });
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
    }
}
