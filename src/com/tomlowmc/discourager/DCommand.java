package com.tomlowmc.discourager;

import java.util.List;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class DCommand {

    private transient Discourager plugin;

    public void run(final Server server, final Player player, final Command cmd, final String commandLabel, final String[] args) throws CommandException {
        run(server, (CommandSender)player, cmd, commandLabel, args);
    }

    public void run(final Server server, final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) throws CommandException {
        throw new CommandException("This command is for players only");
    }

    public static String getFinalArg(final String[] args, final int start) {
        final StringBuilder bldr = new StringBuilder();
        for (int i = start; i < args.length; i++) {
            if (i != start) {
                bldr.append(" ");
            }
            bldr.append(args[i]);
        }
        return bldr.toString();
    }

    protected Player getPlayer(final String arg, final boolean getOffline) throws CommandException {

        final Server server = plugin.getServer();

        if (arg.isEmpty()) {
            throw new CommandException("Player not found");
        }

        final Player user = server.getPlayer(arg);

        if (user != null) {
            if (!getOffline && !user.isOnline()) {
                throw new CommandException("Player not found");
            }
            return user;
        }

        final List<Player> matches = server.matchPlayer(arg);

        if (!matches.isEmpty()) {

            for (Player player : matches) {
                final Player userMatch = server.getPlayer(player.getName());
                if (userMatch.getDisplayName().startsWith(arg) && getOffline) {
                    return userMatch;
                }
            }

            final Player userMatch = server.getPlayer(matches.get(0).getName());

            if (getOffline) {
                return userMatch;
            }
        }
        throw new CommandException("Player not found");
    }


    public Discourager getPlugin() {
        return plugin;
    }

    public void setPlugin(Discourager plugin) {
        this.plugin = plugin;
    }
}
