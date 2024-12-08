package CurroFinal;

public class Personaje {
	String clase;		// Todas estas cosas van a ir cambiando según el personaje
	String herramienta;
	int vida;
	int daño;
	
	void habilidad() {
		// Esto está vacío porque cada clase tiene su propia habilidad
	}
	
	public String toString() {
		return ("Se ha creado un jugador cuya clase es " + this.clase + " (" + this.vida + " de vida) y cuya herramienta es " + this.herramienta + " (" + this.daño + " de daño) exitosamente");
	}
}
