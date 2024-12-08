package CurroFinal;

public class Caballero extends Personaje {
	
	public Caballero(String herramienta) {
		this.clase = "caballero";
		this.vida = 100;
		this.herramienta = herramienta;
		
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
