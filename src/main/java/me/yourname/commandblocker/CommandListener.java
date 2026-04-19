package me.yourname.commandblocker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    private final CommandBlocker plugin;

    public CommandListener(CommandBlocker plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        if (player.isOp()) return;

        String cmd = event.getMessage().toLowerCase().split(" ")[0].replace("/", "");

        for (String blocked : plugin.getConfig().getStringList("black-list-command")) {
            if (cmd.equalsIgnoreCase(blocked)) {
                player.sendMessage(plugin.getConfig().getString("message"));
                event.setCancelled(true);
                return;
            }
        }
    }
}
