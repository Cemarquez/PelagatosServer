package pelagatos.main;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Jugador {

	private String name;
	private Player player;
	private Location homeLocation;
	private Location backLocation;
	private static HashMap<String, Jugador> Jugadores = new HashMap<>();

	public static Jugador getJugador(String pl) {
		if (Jugadores.containsKey(pl.toLowerCase()))
			return Jugadores.get(pl.toLowerCase());

		return new Jugador(pl);
	}

	public static Jugador getJugador(Player pl) {
		if (Jugadores.containsKey(pl.getName().toLowerCase()))
			return Jugadores.get(pl.getName().toLowerCase());

		return new Jugador(pl);
	}

	public static void removeJugador(String pl) {
		if (Jugadores.containsKey(pl.toLowerCase()))
			Jugadores.remove(pl.toLowerCase());
	}

	public Jugador(String s) {
		player = null;
		name = s.toLowerCase();

		Jugadores.put(s.toLowerCase(), this);
	}

	public Jugador(Player p) {
		player = p;
		name = p.getName().toLowerCase();
		Jugadores.put(p.getName().toLowerCase(), this);
	}

	public String getPlayerName() {
		return name;
	}

	public Player getBukkitPlayer() {
		return player;
	}

	public void setBukkitPlayer(Player bplayer) {
		player = bplayer;
	}

	public Location getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(Location homeLocation) {
		this.homeLocation = homeLocation;
	}

	public Location getBackLocation() {
		return backLocation;
	}

	public void setBackLocation(Location backLocation) {
		this.backLocation = backLocation;
	}

}
