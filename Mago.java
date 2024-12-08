package CurroFinal;

public class Mago extends Personaje {
	
	public Mago(String herramienta) {
		this.setClase("mago");
		this.setVida(60);
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
