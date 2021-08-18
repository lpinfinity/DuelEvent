package dev.terra.duelevent.events;

import dev.terra.duelevent.Main;
import dev.terra.duelevent.commands.Duel;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerDeathEvent extends Duel implements Listener  {

    public PlayerDeathEvent(Main main) {
        super(main);
    }

    @EventHandler
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent event) {

        Bukkit.getPlayer(player1).setGameMode(GameMode.SPECTATOR);
        Bukkit.getPlayer(player2).setGameMode(GameMode.SPECTATOR);

    }

}
