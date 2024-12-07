package CurroFinal;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Main {
	
	public static void main(String args[]) {
		ArrayList<PersonajeSuper> personajes = new ArrayList<PersonajeSuper>();
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
				personajes.add(new Personaje("caballero", "espada"));
				break;
			case 2:
				personajes.add(new Personaje("mago", "lanza"));
				break;
			case 3:
				personajes.add(new Personaje("mago", "lanza"));
				break;
			case 4:
				// Código para construir el duende con 5 de daño y 150 de vida
				break;
			case 5:
				// Código para construir el mago de 10 daño y 50 de vida
				break;
			case 6:
				// Código para construir el duende de 7 de daño y 100 de vida
				break;
			case 7:
				// Código para construir el caballero de 12 de daño y 80 de vida
				break;
			case 8:
				// Código para construir el bandido de 4 de daño y 10 de vida
				break;
			case 9:
				// Código para construir el mago de 5 de daño y 150 de vida
				break;
			case 10:
				// Código para construir el caballero de 8 de daño y 120 de vida
				break;
			default:
				JOptionPane.showMessageDialog(null, "No has introducido un número válido, por lo que se te asignará el caballero de 10 de daño y 100 de vida");
			}
			JOptionPane.showMessageDialog(null, personajes.get(i).toString());
		}
	}
}