package CurroFinal;
import javax.swing.JOptionPane;

public class Caballero extends Personaje {
	
	public Caballero(String herramienta) {
		this.setClase("caballero");
		this.setVida(100);
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
	
	void ataque(int numJugador) {		// El ataque básico del caballero es distinto según si el ataque es o no cargado
		if (!this.getBolaDeFuego()) {
			try {
				if (this.getHabilidadActivada()) {			// Esto se ejecuta si el ataque está cargado (hace daño doble)
					CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida() - CrearPersonajes.personajes.get(numJugador).getDaño() * 2);
					JOptionPane.showMessageDialog(null, "El " + this.getClase() + " ha atacado al jugador " + numJugador + " con un daño de " + (this.getDaño() * 2) + ". Le queda " + CrearPersonajes.personajes.get(numJugador).getVida() + " de vida");
					this.setHabilidadActivada(false);
				} else {							// Esto se ejecuta si no está cargado
					CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida() - this.getDaño());
					JOptionPane.showMessageDialog(null, "El " + this.getClase() + " ha atacado al jugador " + numJugador + " con un daño de " + this.getDaño() + ". Le queda " + CrearPersonajes.personajes.get(numJugador).getVida() + " de vida");
				}
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Has intentado atacarle a un cadáver, por lo que se te saltará el turno");
			}
		} else {			// Si el jugador está quemado, el ataque no surte efecto y recibes daño
			this.setVida(this.getVida()-30);
			JOptionPane.showMessageDialog(null, "Has intentado atacar estando quemado, por lo que recibes 30 de daño. Te queda " + this.getVida() + " de vida");
		}
	}
	
	void habilidad() {
		JOptionPane.showMessageDialog(null, "El caballero ha cargado su ataque y hará el doble de daño en el siguiente turno");
		this.setHabilidadActivada(true);
		this.setBolaDeFuego(false);
	}
}
