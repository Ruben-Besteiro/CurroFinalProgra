package CurroFinal;

public class Personaje extends PersonajeSuper {

	public Personaje(String clase, String herramienta) {
		this.clase = clase;
		this.herramienta = herramienta;
		
		switch(clase) {
		case "caballero":
			this.vida = 100;
			break;
		case "duende":
			this.vida = 80;
			break;
		case "mago":
			this.vida = 60;
			break;
		case "bandido":
			this.vida = 40;
		}
		
		switch(herramienta) {
		case "hacha":
			this.daño = 100;
			break;
		case "espada":
			this.daño = 80;
			break;
		case "lanza":
			this.daño = 60;
			break;
		case "cuchillo":
			this.daño = 40;
		}
		
		super.toString();
	}

}
