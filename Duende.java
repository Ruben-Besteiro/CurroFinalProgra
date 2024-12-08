package CurroFinal;

public class Duende extends Personaje {
	
	public Duende(String herramienta) {
		this.clase = "duende";
		this.vida = 80;
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
