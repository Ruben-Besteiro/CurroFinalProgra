package CurroFinal;

public class Bandido extends Personaje {
	
	public Bandido(String herramienta) {
		this.setClase("bandido");
		this.setVida(40);
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
