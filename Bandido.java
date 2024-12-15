package CurroFinal;
import javax.swing.JOptionPane;

public class Bandido extends Personaje {
	
	public Bandido(String herramienta, int i) {
		this.setClase("bandido");
		this.setVida(40);
		this.setHerramienta(herramienta);
		
		switch(herramienta) {
		case "hacha":
			this.setDaño(50);
			break;
		case "espada":
			this.setDaño(40);
			break;
		case "lanza":
			this.setDaño(30);
			break;
		case "cuchillo":
			this.setDaño(20);
		}
	}
	
	public void habilidad(int i) {
		for (int j = 0; j < CrearPersonajes.personajes.size(); j++) {
			try {
				if (j != CrearPersonajes.personajes.indexOf(this)) {
					CrearPersonajes.personajes.get(i).setVida(CrearPersonajes.personajes.get(j).getVida()-2);		// Hace 2 de daño a todo el lobby excepto a uno mismo (también a tu dúo / squad)				}
				}
			} catch (NullPointerException e) {
				// No hace nada
			}
		}
		JOptionPane.showMessageDialog(null, "El jugador " + i + " (bandido) ha apuñalado a todo el mundo y ha hecho 2 de daño");
		this.setBolaDeFuego(false);
	}
}
