package CurroFinal;
import javax.swing.JOptionPane;

public class Bandido extends Personaje {
	
	public Bandido(String herramienta) {
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
	
	public void habilidad() {
		for (int i = 0; i < CrearPersonajes.personajes.size(); i++) {
			if (i != CrearPersonajes.personajes.indexOf(this)) {
				CrearPersonajes.personajes.get(i).setVida(CrearPersonajes.personajes.get(i).getVida()-2);		// Hace 2 de daño a todo el lobby excepto a uno mismo (también a tu dúo / squad)
				JOptionPane.showMessageDialog(null, "El " + this.getClase() + " ha atacado al jugador " + i + " con un daño de " + this.getDaño() + ". Le queda " + CrearPersonajes.personajes.get(i).getVida() + " de vida");
			}
		}
		this.setBolaDeFuego(false);
	}
}
