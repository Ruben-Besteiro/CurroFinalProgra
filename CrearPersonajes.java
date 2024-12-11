package CurroFinal;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CrearPersonajes {					// Todo esto es hecho por Rubi
	public static ArrayList<Personaje> personajes = new ArrayList<>();
	
	public static void CreacionDePersonajes(int numHumanos) {	
		int clase;
		
		for (int i = 0; i < numHumanos; i++) {		// Esto es para que los humanos escojan su clase
			clase = Integer.parseInt(JOptionPane.showInputDialog(null, "Jugador " + i + ", elige personaje\n" + "0-3: Caballero\n" + "4-7: Mago\n" + "8-11: Bandido\n" + "12-15: Duende\n" + "El número que escojas dentro de cada intervalo determinará\ntu herramienta (espada, hacha, lanza o cuchillo)"));
			switchClase(clase, i);
		}
		
		for (int i = numHumanos; i < 16; i++) {		// Y esto es para que la máquina escoja su clase aleatoriamente
			clase = (int) (Math.random() * 16);
			switchClase(clase, i);
		}
	}
	
	static void switchClase(int clase, int i) {
		try {
			switch(clase) {
			case 0:
				personajes.add(new Caballero("espada"));
				break;
			case 1:
				personajes.add(new Caballero("hacha"));
				break;
			case 2:
				personajes.add(new Caballero("lanza"));
				break;
			case 3:
				personajes.add(new Caballero("cuchillo"));
				break;
			case 4:
				personajes.add(new Mago("espada"));
				break;
			case 5:
				personajes.add(new Mago("hacha"));
				break;
			case 6:
				personajes.add(new Mago("lanza"));
				break;
			case 7:
				personajes.add(new Mago("cuchillo"));
				break;
			case 8:
				personajes.add(new Bandido("espada"));
				break;
			case 9:
				personajes.add(new Bandido("hacha"));
				break;
			case 10:
				personajes.add(new Bandido("lanza"));
				break;
			case 11:
				personajes.add(new Bandido("cuchillo"));
				break;
			case 12:
				personajes.add(new Duende("espada"));
				break;
			case 13:
				personajes.add(new Duende("hacha"));
				break;
			case 14:
				personajes.add(new Duende("lanza"));
				break;
			case 15:
				personajes.add(new Duende("cuchillo"));
				break;
			default:
				personajes.add(new Caballero("Espada"));
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Lo que has introducido no es válido, por lo que se te ha asignado un caballero con una espada");
			personajes.add(new Caballero("espada"));
		}
		JOptionPane.showMessageDialog(null, personajes.get(i).ToString(i));
	}
}