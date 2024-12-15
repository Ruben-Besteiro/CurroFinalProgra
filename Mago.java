package CurroFinal;
import javax.swing.JOptionPane;

public class Mago extends Personaje {
	
	public Mago(String herramienta, int i) {
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
	
	public void habilidad(int i) {
		int numHumanos = CrearPersonajes.numHumanos;
		System.out.println(numHumanos);
		int numJugador = 0;
		
		if (CrearPersonajes.personajes.indexOf(this) < numHumanos) {		// Esto es si la habilidad del mago la castea un jugador
			numJugador = Integer.parseInt(JOptionPane.showInputDialog(null, "Elige a qué jugador lanzarle una bola de fuego"));
		} else {		// Y esto es si la castea un bot
			do {
				numJugador = (int) (Math.random() * 16);		// Escogen un jugador al azar siempre que no esté muerto
			}
			while (CrearPersonajes.personajes.get(numJugador).getVida() <= 0 || CrearPersonajes.personajes.get(numJugador) == null);
		}
		
		try {
			CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida()-50);
			JOptionPane.showMessageDialog(null, "El jugador " + i + " (mago) le ha lanzado una bola de fuego al jugador " + numJugador + " y le ha hecho 50 de daño. Le queda " + CrearPersonajes.personajes.get(numJugador).getVida());
			CrearPersonajes.personajes.get(numJugador).setBolaDeFuego(true);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Has elegido lanzarle una bola de fuego a un cadáver, por lo que se te ha saltado el turno");
		}
		
		this.setBolaDeFuego(false);
	}
}
