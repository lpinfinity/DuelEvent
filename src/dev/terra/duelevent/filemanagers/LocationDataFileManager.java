package dev.terra.duelevent.filemanagers;

import dev.terra.duelevent.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class LocationDataFileManager {

    private Main plugin;
    private FileConfiguration playerKillsConfig = null;
    private File configFile = null;

    public LocationDataFileManager(Main plugin) {
        this.plugin = plugin;
        saveDefaultConfig();
    }

    public void reloadConfig() {
        if(this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), "locationdata.db");

        this.playerKillsConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("locationdata.db");

        if(defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.playerKillsConfig.setDefaults(defaultConfig);
        }

    }

    public FileConfiguration getConfig() {
        if(this.playerKillsConfig == null)
            reloadConfig();
        return this.playerKillsConfig;
    }

    public void saveConfig() {
        if(this.playerKillsConfig == null || this.configFile == null)
            return;

        try {
            this.getConfig().save(this.configFile);
        } catch (IOException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Could not save locationdata.db to " + this.configFile, e);
        }
    }

    public void saveDefaultConfig() {
        if(this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), "locationdata.db");

        if(!this.configFile.exists()) {
            this.plugin.saveResource("locationdata.db", false);
        }
    }

}

