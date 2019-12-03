package pelagatos.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import pelagatos.main.Jugador;

public class BackCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		Player p;
		if (sender instanceof Player) {
			p = (Player) sender;
			Jugador j = Jugador.getJugador(p);
			if (j.getBackLocation() != null) {
				if (!j.getBackLocation().getChunk().isLoaded()) {
					j.getBackLocation().getChunk().load();
				}
				Location aux = p.getLocation();

				p.teleport(j.getBackLocation());
				j.setBackLocation(aux);
				p.sendMessage(ChatColor.GOLD + "Fuiste enviado a tu ubicacion anterior.");
				return true;
			} else {
				p.sendMessage(ChatColor.RED + "No tienes una ubicación anterior.");
				return true;
			}
		} else {

			sender.sendMessage(ChatColor.RED + "No puedes usar este comando");
			return true;
		}

	}

}
