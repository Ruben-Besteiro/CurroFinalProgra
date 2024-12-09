package CurroFinal;
import javax.swing.JOptionPane;


public class Personaje {
	boolean habilidadActivada = false;		// Este booleano lo usarán las habilidades que afectan al siguiente turno
	
	private String clase;		// Todas estas cosas van a ir cambiando según el personaje
	private String herramienta;
	private int vida;
	private int daño;
	
	void ataque(int numJugador) {
		try {
			CrearPersonajes.personajes.get(numJugador).setVida(CrearPersonajes.personajes.get(numJugador).getVida() - this.getDaño());
			JOptionPane.showMessageDialog(null, "El " + this.getClase() + " ha atacado al jugador " + numJugador + " con un daño de " + this.getDaño() + ". Le queda " + CrearPersonajes.personajes.get(numJugador).getVida() + " de vida");
		} catch (Throwable e) {		// Quise poner NullPointerException pero no se quería resolver como un tipo
			JOptionPane.showMessageDialog(null, "Has intentado atacarle a un jugador muerto, por lo que se te saltará el turno");
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
	
	public String ToString(int posicion) {
		return ("Se ha creado un jugador cuya clase es " + this.clase + " (" + this.vida + " de vida) y cuya herramienta es " + this.herramienta + " (" + this.daño + " de daño) en la posición " + (posicion+1) + " exitosamente");
	}
}
