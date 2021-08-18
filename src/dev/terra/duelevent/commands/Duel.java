package dev.terra.duelevent.commands;

import dev.terra.duelevent.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.Bukkit.getServer;

public class Duel implements CommandExecutor {

    private final Main main;

    public Duel(Main main) {
        this.main = main;
    }

    Location location1 = new Location(getServer().getWorld("world"), 32, 4, 8);
    Location location2 = new Location(getServer().getWorld("world"), -16, 4, 8);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("duel")) {

            Bukkit.getPlayer(strings[0].toString()).teleport(main.locationData.getConfig().getLocation("location1"));

            Bukkit.getPlayer(strings[1].toString()).teleport(main.locationData.getConfig().getLocation("location2"));

        }

        return false;

    }

}
