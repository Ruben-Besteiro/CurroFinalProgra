package CurroFinal;

public class Bandido extends Personaje {
	
	public Bandido(String herramienta) {
		this.clase = "bandido";
		this.vida = 40;
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
