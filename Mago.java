package CurroFinal;

public class Mago extends Personaje {
	
	public Mago(String herramienta) {
		this.clase = "mago";
		this.vida = 60;
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
