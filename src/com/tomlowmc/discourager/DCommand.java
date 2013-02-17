package com.tomlowmc.discourager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DCommand implements CommandExecutor {
    
    private Discourager plugin;
    
    public DCommand(Discourager plugin)
    {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(args.length > 0)
        {
            if(args[0].equalsIgnoreCase("reload"))
            {
                plugin.reloadConfigs(sender);
            }
            return true;
        }
            return false;
    }
}
