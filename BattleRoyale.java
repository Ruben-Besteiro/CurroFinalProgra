package CurroFinal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BattleRoyale {
	public static ArrayList<Personaje> personajes;
	
	public static void Batalla() {
		personajes = CrearPersonajes.personajes;
		
		int numJugador;
		while(personajes.size() > 1) {		// Esto que hay dentro del while es de prueba
			numJugador = Integer.parseInt(JOptionPane.showInputDialog(null, "Jugador 1, elige a quién quieres atacar"));
			personajes.get(0).ataque(numJugador);
			
			// ...
		}
		System.exit(0);
	}
}
