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
	
	void habilidad() {		// La habilidad del mago es diferente porque hay que especificar a qué oponente va a afectar
		/* Aquí habría que pedirle al usuario a quién hay que castearle la bola
		
		CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida()-50);
		JOptionPane.showMessageDialog(null, "El mago ha casteado una bola de fuego en el jugador " + numJugador + " y le ha hecho 50 de daño. Le queda " + CrearPersonajes.personajes.get(numJugador).getVida());
		CrearPersonajes.personajes.get(numJugador).bolaDeFuego = true;*/
		this.bolaDeFuego = false;
	}
}
