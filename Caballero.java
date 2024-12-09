package CurroFinal;
import javax.swing.JOptionPane;

public class Caballero extends Personaje {
	
	public Caballero(String herramienta) {
		this.setClase("caballero");
		this.setVida(100);
		this.setHerramienta(herramienta);
		
		switch(herramienta) {
		case "hacha":
			this.setDaño(100);
			break;
		case "espada":
			this.setDaño(80);
			break;
		case "lanza":
			this.setDaño(60);
			break;
		case "cuchillo":
			this.setDaño(40);
		}
	}
	
	@Override
	void ataque(int numJugador) {		// El ataque básico del caballero es distinto según si el ataque es o no cargado
		try {
			if (habilidadActivada) {
				CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida() - CrearPersonajes.personajes.get(numJugador).getDaño() * 2);
				JOptionPane.showMessageDialog(null, "El " + this.getClase() + " ha atacado al jugador " + numJugador + " con un daño de " + (this.getDaño() * 2) + ". Le queda " + CrearPersonajes.personajes.get(numJugador).getVida() + " de vida");
				this.habilidadActivada = false;
			} else {
				CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida() - this.getDaño());
				JOptionPane.showMessageDialog(null, "El " + this.getClase() + " ha atacado al jugador " + numJugador + " con un daño de " + this.getDaño() + ". Le queda " + CrearPersonajes.personajes.get(numJugador).getVida() + " de vida");
			}
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null, "Has intentado atacarle a un jugador muerto, por lo que se te saltará el turno");
		}
	}
	
	void habilidad() {
		JOptionPane.showMessageDialog(null, "El caballero ha cargado su ataque y hará el doble de daño en el siguiente turno");
		this.habilidadActivada = true;
	}
}
