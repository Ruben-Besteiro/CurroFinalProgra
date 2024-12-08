package CurroFinal;

public class Duende extends Personaje {
	
	public Duende(String herramienta) {
		this.setClase("duende");
		this.setVida(80);
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
