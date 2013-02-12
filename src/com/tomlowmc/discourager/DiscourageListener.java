package com.tomlowmc.discourager;

import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class DiscourageListener implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
    }
}
