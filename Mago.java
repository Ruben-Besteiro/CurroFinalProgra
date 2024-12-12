package CurroFinal;

import javax.swing.JOptionPane;

public class Mago extends Personaje {
	
	public Mago(String herramienta) {
		this.setClase("mago");
		this.setVida(60);
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
		int numJugador = Integer.parseInt(JOptionPane.showInputDialog(null, "Elige a qué jugador lanzarle una bola de fuego"));
		try {
			CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida()-50);
			JOptionPane.showMessageDialog(null, "El mago le ha lanzado una bola de fuego al jugador " + numJugador + " y le ha hecho 50 de daño. Le queda " + CrearPersonajes.personajes.get(numJugador).getVida());
			CrearPersonajes.personajes.get(numJugador).setBolaDeFuego(true);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Has elegido lanzarle una bola de fuego a un cadáver, por lo que se te ha saltado el turno");
		}
		
		this.setBolaDeFuego(false);
	}
}
