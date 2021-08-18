package dev.terra.duelevent.events;

import dev.terra.duelevent.Main;
import dev.terra.duelevent.commands.Duel;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerDeathEvent implements Listener  {

    @EventHandler
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent event) {

        for(Player player : Bukkit.getOnlinePlayers()) {

            player.setGameMode(GameMode.SPECTATOR);

        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setGameMode(GameMode.SPECTATOR);
    }

}
