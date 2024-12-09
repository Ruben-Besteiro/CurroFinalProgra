package CurroFinal;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CrearPersonajes {					// Todo esto es hecho por Rubi
	public static ArrayList<Personaje> personajes;
	
	public static void CreacionDePersonajes() {
		int numHumanos = 0;
		personajes = new ArrayList<Personaje>();
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
		
		for (int i = 0; i < numHumanos; i++) {		// Esto es para que los humanos escojan su clase
			clase = Integer.parseInt(JOptionPane.showInputDialog(null, "Jugador " + i + ", elige personaje\n" + "0: Caballero con espada\n" + "1: Mago con lanza\n" + "2: Bandido con hacha\n" + "3: Duende con cuchillo\n" + "4: Mago con hacha\n" + "5: Duende con hacha\n" + "6: Caballero con lanza\n" + "7: Bandido con cuchillo\n" + "8: Mago con espada\n" + "9: Caballero con hacha"));
			switchClase(clase, i);
		}
		
		for (int i = numHumanos; i < (10-numHumanos); i++) {		// Y esto es para que la máquina escoja su clase aleatoriamente
			clase = (int) (Math.random() * 10) + 1;
			switchClase(clase, i);
		}
		
		BattleRoyale.Batalla();			// Una vez que se crean los personajes, da comienzo la batalla
	}
	
	static void switchClase(int clase, int i) {
		switch(clase) {
		case 0:
			personajes.add(new Caballero("espada"));
			break;
		case 1:
			personajes.add(new Mago("lanza"));
			break;
		case 2:
			personajes.add(new Bandido("hacha"));
			break;
		case 3:
			personajes.add(new Duende("cuchillo"));
			break;
		case 4:
			personajes.add(new Mago("hacha"));
			break;
		case 5:
			personajes.add(new Duende("hacha"));
			break;
		case 6:
			personajes.add(new Caballero("lanza"));
			break;
		case 7:
			personajes.add(new Bandido("cuchillo"));
			break;
		case 8:
			personajes.add(new Mago("espada"));
			break;
		case 9:
			personajes.add(new Caballero("hacha"));
			break;
		default:
			personajes.add(new Caballero("espada"));		// Si por la razón que sea hay un error, seleccionará esta opción
		}
		JOptionPane.showMessageDialog(null, personajes.get(i).ToString(i));
	}
}