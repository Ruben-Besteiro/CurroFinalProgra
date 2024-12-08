package CurroFinal;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CrearPersonajes {
	
	public static void CreacionDePersonajes() {
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		// Antes de empezar la batalla tendría que pasar lo siguiente:
		// El programa chequearía la clase
		
		int numHumanos = 0;
		try {
			numHumanos = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciona cuántos jugadores humanos quieres que haya"));
		} catch (Exception IllegalArgumentException) {
			JOptionPane.showMessageDialog(null, "Hay que poner un número");
			System.exit(1);
		}
		
		if (numHumanos > 10) {
			numHumanos = 10;
		}
		JOptionPane.showMessageDialog(null, "Has elegido " + numHumanos + " jugadores humanos\nHabrá " + (10-numHumanos) + " bots");
		// De momento mejor hacer 10 jugadores por simplicidad
		
		int clase;
		
		for (int i = 0; i < numHumanos; i++) {
			clase = Integer.parseInt(JOptionPane.showInputDialog(null, "Jugador " + (i+1) + ", elige personaje\n" + "1: Caballero con espada\n" + "2: Mago con lanza\n" + "3: Bandido con hacha\n" + "4: Duende con cuchillo\n" + "5: Mago con hacha\n" + "6: Duende con hacha\n" + "7: Caballero con lanza\n" + "8: Bandido con cuchillo\n" + "9: Mago con espada\n" + "10: Caballero con hacha"));
			switch(clase) {
			case 1:
				personajes.add(new Caballero("espada"));
				break;
			case 2:
				personajes.add(new Mago("lanza"));
				break;
			case 3:
				personajes.add(new Bandido("hacha"));
				break;
			case 4:
				personajes.add(new Duende("cuchillo"));
				break;
			case 5:
				personajes.add(new Mago("hacha"));
				break;
			case 6:
				personajes.add(new Duende("hacha"));
				break;
			case 7:
				personajes.add(new Caballero("lanza"));
				break;
			case 8:
				personajes.add(new Bandido("cuchillo"));
				break;
			case 9:
				personajes.add(new Mago("espada"));
				break;
			case 10:
				personajes.add(new Caballero("hacha"));
				break;
			default:
				JOptionPane.showMessageDialog(null, "No has introducido un número válido, por lo que se te asignará el caballero de 10 de daño y 100 de vida");
			}
			JOptionPane.showMessageDialog(null, personajes.get(i).toString());
		}
	}
}