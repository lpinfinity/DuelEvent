package dev.terra.duelevent;

import dev.terra.duelevent.commands.Duel;
import dev.terra.duelevent.commands.SetLocation1;
import dev.terra.duelevent.commands.SetLocation2;
import dev.terra.duelevent.filemanagers.LocationDataFileManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public LocationDataFileManager locationData;

    @Override
    public void onEnable() {
        this.locationData = new LocationDataFileManager(this);
        this.getCommand("duel").setExecutor(new Duel(this));
        this.getCommand("setlocation1").setExecutor(new SetLocation1(this));
        this.getCommand("setlocation2").setExecutor(new SetLocation2(this));
        System.out.println("DuelEvent has started");
    }

}
