package pelagatos.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import pelagatos.commands.BackCommand;
import pelagatos.listeners.PlayerListener;

public class Main extends JavaPlugin {

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		getCommand("back").setExecutor(new BackCommand());
	}
}
