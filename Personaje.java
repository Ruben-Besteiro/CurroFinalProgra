package CurroFinal;

import javax.swing.JOptionPane;

public class Personaje {
	private String clase;		// Todas estas cosas van a ir cambiando según el personaje
	private String herramienta;
	private int vida;
	private int daño;
	
	void ataque(int numJugador) {		// La función de ataque es la misma para todas las clases
		CrearPersonajes.personajes.get(numJugador).vida -= this.daño;
		JOptionPane.showMessageDialog(null, "El " + this.clase + " ha atacado al jugador " + numJugador + " con un daño de " + this.daño + ". Le queda " + CrearPersonajes.personajes.get(numJugador).vida + " de vida");
	}
	
	void habilidad() {
		// Esto está vacío porque cada clase tiene su propia habilidad
	}
	
	public String toString() {
		return ("Se ha creado un jugador cuya clase es " + this.clase + " (" + this.vida + " de vida) y cuya herramienta es " + this.herramienta + " (" + this.daño + " de daño) exitosamente");
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
}
