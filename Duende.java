package CurroFinal;
import javax.swing.JOptionPane;

public class Duende extends Personaje {
	
	public Duende(String herramienta) {
		this.setClase("duende");
		this.setVida(80);
		this.setHerramienta(herramienta);
		
		switch(herramienta) {
		case "hacha":
			this.setDaño(50);
			break;
		case "espada":
			this.setDaño(40);
			break;
		case "lanza":
			this.setDaño(30);
			break;
		case "cuchillo":
			this.setDaño(20);
		}
	}
	
	public void habilidad() {
		JOptionPane.showMessageDialog(null, "El duende ha activado su escudo y será inmune al daño el próximo turno");
		if (!this.getHabilidadActivada()) {
			this.setHabilidadActivada(true);
		}
		this.setHabilidadActivada(false);
		this.setBolaDeFuego(false);
	}
}
