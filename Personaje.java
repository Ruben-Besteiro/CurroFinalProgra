package CurroFinal;
import javax.swing.JOptionPane;


public class Personaje {
	private boolean habilidadActivada = false;		// Este booleano lo usarán las habilidades que afectan al siguiente turno
	private boolean bolaDeFuego = false;			// Si en el turno anterior un mago usó su habilidad contra el jugador, esto es true
	
	private String clase;		// Todas estas cosas van a ir cambiando según el personaje
	private String herramienta;
	private int vida;
	private int daño;
	
	void ataque(int numJugador) {
		//int numJugador = Integer.parseInt(JOptionPane.showInputDialog(null, "Elige a quién atacar"));
		
		if (!this.bolaDeFuego && !(CrearPersonajes.personajes.get(numJugador).getClase() == "duende" && CrearPersonajes.personajes.get(numJugador).getHabilidadActivada())) {
			try {			// Esto se ejecuta cuando el jugador ataca
				CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida() - this.getDaño());
				JOptionPane.showMessageDialog(null, "El " + this.getClase() + " ha atacado al jugador " + numJugador + " con un daño de " + this.getDaño() + ". Le queda " + CrearPersonajes.personajes.get(numJugador).getVida() + " de vida");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Has intentado atacarle a un cadáver, por lo que se te saltará el turno");
			}
		} else if (this.bolaDeFuego) {			// Si el jugador está quemado, el ataque no surte efecto y recibes daño
			this.setVida(this.getVida()-30);
			JOptionPane.showMessageDialog(null, "Has intentado atacar estando quemado, por lo que recibes 30 de daño. Te queda " + this.getVida() + " de vida");
			this.setBolaDeFuego(false);
		} else if (CrearPersonajes.personajes.get(numJugador).getClase() == "duende" && CrearPersonajes.personajes.get(numJugador).getHabilidadActivada()) {
			JOptionPane.showMessageDialog(null, "Has elegido atacarle a un duende usando su escudo, por lo que tu ataque ha sido en vano");
		}
	}
	
	public void habilidad() {
		// Esto está vacío porque cada clase tiene su propia habilidad
	}
	
	
	// GETTERS Y SETTERS
	
	public String getClase() {
		return this.clase;
	}
	
	public void setClase(String clase) {
		this.clase = clase;
	}
	
	public String getHerramienta() {
		return this.herramienta;
	}
	
	public void setHerramienta(String herramienta) {
		this.herramienta = herramienta;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	public boolean getHabilidadActivada() {
		return this.habilidadActivada;
	}
	
	public void setHabilidadActivada(boolean habilidadActivada) {
		this.habilidadActivada = habilidadActivada;
	}
	
	public boolean getBolaDeFuego() {
		return this.bolaDeFuego;
	}
	
	public void setBolaDeFuego(boolean bolaDeFuego) {
		this.bolaDeFuego = bolaDeFuego;
	}
	
	// OTROS MÉTODOS
	
	public String ToString(int posicion) {
		return ("El jugador " + posicion + " es un " + this.clase + " (" + this.vida + " de vida) cuya herramienta es " + this.herramienta + " (" + this.daño + " de daño)");
	}
	
	public void Equals(int posicion) {
		for (int i = 0; i < (posicion-1); i++) {
			if (this.getClase() == CrearPersonajes.personajes.get(i).getClase() && this.getHerramienta() == CrearPersonajes.personajes.get(i).getHerramienta()) {
				JOptionPane.showMessageDialog(null, "El personaje que se acaba de crear es igual al que hay en la posición " + i);
				return;
			}
		}
	}
}