package dev.terra.duelevent.commands;

import dev.terra.duelevent.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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

    public String player1;
    public String player2;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (command.getName().equalsIgnoreCase("duel")) {

            player1 = strings[0];
            player2 = strings[1];

            Bukkit.getPlayer(player1).teleport(main.locationData.getConfig().getLocation("location1"));
            Bukkit.getPlayer(player1).setGameMode(GameMode.SURVIVAL);

            Bukkit.getPlayer(player2).teleport(main.locationData.getConfig().getLocation("location2"));
            Bukkit.getPlayer(player2).setGameMode(GameMode.SURVIVAL);

        }

        return false;

    }

}
