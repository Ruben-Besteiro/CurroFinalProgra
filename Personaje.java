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
		if (!this.bolaDeFuego) {
			try {			// Esto se ejecuta cuando el jugador ataca
				CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida() - this.getDaño());
				JOptionPane.showMessageDialog(null, "El " + this.getClase() + " ha atacado al jugador " + numJugador + " con un daño de " + this.getDaño() + ". Le queda " + CrearPersonajes.personajes.get(numJugador).getVida() + " de vida");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Has intentado atacarle a un cadáver, por lo que se te saltará el turno");
			}
		} else {			// Si el jugador está quemado, el ataque no surte efecto y recibes daño
			this.setVida(this.getVida()-30);
			JOptionPane.showMessageDialog(null, "Has intentado atacar estando quemado, por lo que recibes 30 de daño. Te queda " + this.getVida() + " de vida");
			this.setBolaDeFuego(false);
		}
	}
	
	void habilidad() {
		// Esto está vacío porque cada clase tiene su propia habilidad
	}
	
	void checkVida() {
		if (this.getVida() <= 0) {
			// Código para borrar el objeto
		}
	}
	
	// GETTERS Y SETTERS
	
	String getClase() {
		return this.clase;
	}
	
	void setClase(String clase) {
		this.clase = clase;
	}
	
	String getHerramienta() {
		return this.herramienta;
	}
	
	void setHerramienta(String herramienta) {
		this.herramienta = herramienta;
	}
	
	int getVida() {
		return this.vida;
	}
	
	void setVida(int vida) {
		this.vida = vida;
	}
	
	int getDaño() {
		return daño;
	}
	
	void setDaño(int daño) {
		this.daño = daño;
	}
	
	boolean getHabilidadActivada() {
		return this.habilidadActivada;
	}
	
	void setHabilidadActivada(boolean habilidadActivada) {
		this.habilidadActivada = habilidadActivada;
	}
	
	boolean getBolaDeFuego() {
		return this.bolaDeFuego;
	}
	
	void setBolaDeFuego(boolean bolaDeFuego) {
		this.bolaDeFuego = bolaDeFuego;
	}
	
	// OTROS MÉTODOS
	
	public String ToString(int posicion) {
		return ("El jugador " + posicion + " es un " + this.clase + " (" + this.vida + " de vida) cuya herramienta es " + this.herramienta + " (" + this.daño + " de daño)");
	}
}
