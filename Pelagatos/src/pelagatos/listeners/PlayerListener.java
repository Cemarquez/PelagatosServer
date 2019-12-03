package pelagatos.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.md_5.bungee.api.ChatColor;
import pelagatos.main.Jugador;

public class PlayerListener implements Listener {
	public static Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage(getMessageJoin(e.getPlayer().getName()) + ChatColor.WHITE + e.getPlayer().getName()
				+ ChatColor.YELLOW + " Ha entrado.");

		Jugador j = Jugador.getJugador(e.getPlayer());

		onJoin(e.getPlayer());
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		e.setQuitMessage(getMessageJoin(e.getPlayer().getName()) + ChatColor.WHITE + e.getPlayer().getName()
				+ ChatColor.YELLOW + " Ha salido.");
		Jugador.removeJugador(e.getPlayer().getName());
		scoreboard.getTeam(e.getPlayer().getName()).unregister();
	}

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {

		if (e.getMessage().equals("/home")) {
			Jugador j = Jugador.getJugador(e.getPlayer());
			j.setBackLocation(e.getPlayer().getLocation());
		}
	}

	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		if (e.getCause() == TeleportCause.COMMAND) {
			Location back = e.getFrom();
			Jugador j = Jugador.getJugador(e.getPlayer());
			j.setBackLocation(back);
		}

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage().replace("%", "");
		String n = p.getName();

		if (n.equalsIgnoreCase("Cemarquez")) {
			e.setFormat(ChatColor.BLUE + "" + ChatColor.BOLD + "(César) " + ChatColor.WHITE + n + ChatColor.DARK_GRAY
					+ " » " + ChatColor.GRAY + msg);
		} else if (n.equalsIgnoreCase("DONMDASH")) {
			e.setFormat(ChatColor.BLUE + "" + ChatColor.BOLD + "(Miguel) " + ChatColor.AQUA + n + ChatColor.DARK_GRAY
					+ " » " + ChatColor.GRAY + msg);

		} else if (n.equalsIgnoreCase("Ghostbit09")) {
			e.setFormat(ChatColor.BLUE + "" + ChatColor.BOLD + "(Braian) " + ChatColor.RED + n + ChatColor.DARK_GRAY
					+ " » " + ChatColor.GRAY + msg);

		} else if (n.equalsIgnoreCase("Sebas2123")) {
			e.setFormat(ChatColor.BLUE + "" + ChatColor.BOLD + "(Sebastián) " + ChatColor.LIGHT_PURPLE + n
					+ ChatColor.DARK_GRAY + " » " + ChatColor.GRAY + msg);

		} else if (n.equalsIgnoreCase("RyanDeep")) {
			e.setFormat(ChatColor.BLUE + "" + ChatColor.BOLD + "(Brian) " + ChatColor.AQUA + n + ChatColor.DARK_GRAY
					+ " » " + ChatColor.GRAY + msg);

		} else if (n.equalsIgnoreCase("Esteban")) {
			e.setFormat(ChatColor.BLUE + "" + ChatColor.BOLD + "(Esteban) " + ChatColor.GOLD + n + ChatColor.DARK_GRAY
					+ " » " + ChatColor.GRAY + msg);

		}
	}

	public void onJoin(Player p) {
		String n = p.getName();
		try {
			Team tm = scoreboard.registerNewTeam(p.getName());
			if (n.equalsIgnoreCase("Cemarquez")) {

				tm.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "(César) " + ChatColor.WHITE);
			} else if (n.equalsIgnoreCase("DONMDASH")) {

				tm.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "(Miguel) " + ChatColor.AQUA);
			} else if (n.equalsIgnoreCase("Ghostbit09")) {

				tm.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "(Braian) " + ChatColor.RED);
			} else if (n.equalsIgnoreCase("Sebas2123")) {

				tm.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "(Sebastián) " + ChatColor.LIGHT_PURPLE);
			} else if (n.equalsIgnoreCase("RyanDeep")) {

				tm.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "(Brian) " + ChatColor.AQUA);
			} else if (n.equalsIgnoreCase("Esteban")) {
				tm.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "(Esteban) " + ChatColor.GOLD);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		p.setScoreboard(scoreboard);
	}

	public String getMessageJoin(String n) {
		if (n.equalsIgnoreCase("Cemarquez")) {

			return ChatColor.BLUE + "" + ChatColor.BOLD + "(César) ";
		} else if (n.equalsIgnoreCase("DONMDASH")) {

			return ChatColor.BLUE + "" + ChatColor.BOLD + "(Miguel) ";
		} else if (n.equalsIgnoreCase("Ghostbit09")) {

			return ChatColor.BLUE + "" + ChatColor.BOLD + "(Braian) ";
		} else if (n.equalsIgnoreCase("Sebas2123")) {

			return ChatColor.BLUE + "" + ChatColor.BOLD + "(Sebastián) ";
		} else if (n.equalsIgnoreCase("RyanDeep")) {

			return ChatColor.BLUE + "" + ChatColor.BOLD + "(Brian) ";
		} else if (n.equalsIgnoreCase("Esteban")) {
			return ChatColor.BLUE + "" + ChatColor.BOLD + "(Esteban) ";
		}

		return null;
	}
}
