package CurroFinal;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class DUO {

	private ArrayList<Personaje> personajes = CrearPersonajes.personajes;
	private int numHumanos = 2;		//He puesto 2 humanos para trabajar pero esto no estaría
	
	public DUO() {		//Constructor llama a SimulacionDeJuego
		
		SimulacionDeJuego();
		
	}

	public void SimulacionDeJuego() {		//Se escoge aleatoriamente el duo contrincante
		
		Random rand = new Random();
		int randNum = rand.nextInt(13) + 2;
		int pos1 = 0;
		int pos2 = 0;
		
		ArrayList<Personaje> DUOContrincante = new ArrayList<Personaje>();
		
		if(randNum % 2 == 0) {
			
			DUOContrincante.add(personajes.get(randNum));
			DUOContrincante.add(personajes.get(randNum + 1));
			
			pos1 = randNum;
			pos2 = randNum + 1;
			
			JOptionPane.showMessageDialog(null, "Os encontráis con otro duo formado por:\n" + DUOContrincante.get(0).ToString(randNum) + "\n" + DUOContrincante.get(1).ToString((randNum) + 1) + "\n TOCA LUCHAR!");
			
			Decision(pos1, pos2);
			
		}else {
			
			DUOContrincante.add(personajes.get(randNum));
			DUOContrincante.add(personajes.get(randNum - 1));
			
			pos1 = randNum;
			pos2 = randNum - 1;
			
			JOptionPane.showMessageDialog(null, "Os encontráis con otro duo formado por:\n" + DUOContrincante.get(0).ToString(randNum) + "\n" + DUOContrincante.get(1).ToString((randNum) - 1) + "\n TOCA LUCHAR!");
				
			Decision(pos1, pos2);
			
			}
			
			
	}
	
	
	public void Decision(int pos1, int pos2) {		//Se gestiona mediante turno los ataques y habilidades
	
		while((personajes.get(0).getVida() > 0 || personajes.get(1).getVida() > 0) && personajes.get(pos1).getVida() > 0 || personajes.get(pos2).getVida() > 0) {
		
			String[] opciones = {"ATACAR", "HABILIDAD"};
			Random rand = new Random();
		
			for(int i = 0; i < 2; i++) {
		
				int decision = JOptionPane.showOptionDialog(null, "Jugador "+ Integer.toString(i) + ", que deseas hacer?:\n", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
		
				if(decision == JOptionPane.YES_OPTION) {
			
					String[] op = {"Jugador "+ Integer.toString(pos1), "Jugador "+ Integer.toString(pos2)};
					int decision2 = JOptionPane.showOptionDialog(null, "Jugador 1, a que jugador del duo contrincante deseas atacar?:\n", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, null);
			
					if(decision2 == JOptionPane.YES_OPTION) {
				
						personajes.get(i).ataque(pos1);
				
					}else {
				
						personajes.get(i).ataque(pos2);
				
					}
			
				}else {
			
					String[] op = {"Jugador "+ Integer.toString(pos1), "Jugador "+ Integer.toString(pos2)};
					int decision2 = JOptionPane.showOptionDialog(null, "Jugador 1, a que jugador del duo contrincante deseas atacar con tu habilidad?:\n", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, null);
				
					if(decision2 == JOptionPane.YES_OPTION) {
					
					personajes.get(i).ataque(pos1);//habilidad
				
					}else {
				
						personajes.get(i).ataque(pos2);//habilidad
				
					}
				
				}
			
			}
		
			JOptionPane.showMessageDialog(null, "TURNO DE LOS CONTRINCANTES");
		
			if(pos1 < pos2) {
		
				for(int i = pos1; i < (pos2 + 1); i++) {
				
					int decision3 = rand.nextInt(2);
		
					if(decision3 == 0) {
			
						int decision4 = rand.nextInt(2);
						personajes.get(i).ataque(decision4);
			
					}else {
				
						int decision4 = rand.nextInt(2);
						personajes.get(i).ataque(decision4);//habilidad
				
					}
				}
			
			}else {
			
				for(int i = pos2; i < (pos1 + 1); i++) {
				
					int decision3 = rand.nextInt(2);
		
					if(decision3 == 0) {
			
						int decision4 = rand.nextInt(2);
						personajes.get(i).ataque(decision4);
			
					}else {
				
						int decision4 = rand.nextInt(2);
						personajes.get(i).ataque(decision4);//habilidad
				
					}
				}
			
			}
		}
		
		if(personajes.get(0).getVida() <= 0 && personajes.get(1).getVida() <= 0) {
			
			JOptionPane.showMessageDialog(null, "HABÉIS MUERTO\nOs ha matado el duo formado por: Jugador "+ pos1 +" y Jugador "+ pos2);
			
		}else if(personajes.get(pos1).getVida() <= 0 && personajes.get(pos2).getVida() <= 0) {
			
			JOptionPane.showMessageDialog(null, "HABÉIS CONSEGUIDO MATAR A VUESTROS CONTRINCANTES");
			
		}
		
	}
	
}
