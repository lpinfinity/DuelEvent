package dev.terra.duelevent.commands;

import dev.terra.duelevent.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetLocation1 implements CommandExecutor {

    private final Main main;

    public SetLocation1(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(command.getName().equalsIgnoreCase("setlocation1")) {
            if(main.locationData.getConfig().getLocation("location1") != null) {
                main.locationData.getConfig().set("location1", Bukkit.getPlayer(commandSender.getName()).getLocation());
                main.locationData.saveConfig();
            }else{
                main.locationData.getConfig().addDefault("location1", Bukkit.getPlayer(commandSender.getName()).getLocation());
                main.locationData.saveDefaultConfig();
            }
        }

        return false;

    }

}
