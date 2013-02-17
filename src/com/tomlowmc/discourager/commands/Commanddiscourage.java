package com.tomlowmc.discourager.commands;

import com.tomlowmc.discourager.CommandException;
import com.tomlowmc.discourager.DCommand;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Commanddiscourage extends DCommand
{

    public Commanddiscourage()
    {
        super();
    }

    @Override
    public void run(Server server, CommandSender sender, Command cmd, String label, String[] args) throws CommandException
    {
        if(args.length > 0)
        {
            if(args[0].equalsIgnoreCase("reload"))
            {
                getPlugin().reloadConfigs(sender);
            }
        }
        else
        {
            throw new CommandException("Not enough arguments");
        }
    }
}
