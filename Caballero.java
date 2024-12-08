package CurroFinal;

public class Caballero extends Personaje {
	
	public Caballero(String herramienta) {
		this.setClase("caballero");
		this.setVida(100);
		this.setHerramienta(herramienta);
		
		switch(herramienta) {
		case "hacha":
			this.setDaño(100);
			break;
		case "espada":
			this.setDaño(80);
			break;
		case "lanza":
			this.setDaño(60);
			break;
		case "cuchillo":
			this.setDaño(40);
		}
		
		super.toString();
	}
}
