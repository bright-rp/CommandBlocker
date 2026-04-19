package me.yourname.commandblocker;

import org.bukkit.plugin.java.JavaPlugin;

public class CommandBlocker extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);
    }
}
