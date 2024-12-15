package CurroFinal;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class DUO {

	private ArrayList<Personaje> personajes = CrearPersonajes.personajes;
	private int numHumanos = 2;
	private int numBots = 14;
	
	public DUO() {		//Constructor de DUO que llama a las funciones necesarias para simular la batalla
		try {
			
			while(personajes.get(0).getVida() > 0 || personajes.get(1).getVida() > 0) {
		
				SimulacionDeJuego();
				SimulacionCombateBots();
				MostrarPersonajes();
			
			}
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la simulación del juego: " + e.getMessage());
	        e.printStackTrace();
			
		}
	}

	public void SimulacionDeJuego() {		//Metodo que simula la partida generando los duos y llamando al metodo decision para que el usuario decida
		
		Random rand = new Random();
		int randNum = rand.nextInt(personajes.size() - 2) + 2;
		int pos1 = 0;
		int pos2 = 0;
		
		ArrayList<Personaje> DUOContrincante = new ArrayList<Personaje>();
		
		if(personajes.get(randNum) != null) {
		
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
			
		}else {
			
		SimulacionDeJuego();
			
		}	
		
	}
	
	
	public void Decision(int pos1, int pos2) {
	
		//Metodo decisión que sirve para que el usuario decida a quien atacar y si atacarle o usar la habilidad
		
		try {
		
			while((personajes.get(0).getVida() > 0 || personajes.get(1).getVida() > 0) && personajes.get(pos1).getVida() > 0 || personajes.get(pos2).getVida() > 0) {
		
				String[] opciones = {"ATACAR", "HABILIDAD"};
				Random rand = new Random();
		
				for(int i = 0; i < 2; i++) {
				
					if(personajes.get(pos1).getVida() > 0 || personajes.get(pos2).getVida() > 0) {
					
						if(personajes.get(i).getVida() <= 0) {
						
							continue;
						
						}
					
						int decision = JOptionPane.showOptionDialog(null, "Jugador "+ Integer.toString(i) + ", que deseas hacer?:\n", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
						OpcionesJugadores(decision, i, pos1, pos2);
					
					}else {
					
						continue;
					
					}
				}
			
				DecisionContrincantes(pos1, pos2);
			
			}
		
			if(personajes.get(0).getVida() <= 0 && personajes.get(1).getVida() <= 0) {
			
				JOptionPane.showMessageDialog(null, "HABÉIS MUERTO\nOs ha matado el duo formado por: Jugador "+ pos1 +" y Jugador "+ pos2);
				JOptionPane.showMessageDialog(null, "Los jugadores "+Integer.toString(0)+" y "+Integer.toString(1)+" han muerto");
				Matar(0, 1);
			
			}else if(personajes.get(pos1).getVida() <= 0 && personajes.get(pos2).getVida() <= 0) {
			
				JOptionPane.showMessageDialog(null, "HABÉIS CONSEGUIDO MATAR A VUESTROS CONTRINCANTES");
				JOptionPane.showMessageDialog(null, "Los jugadores "+Integer.toString(pos1)+" y "+Integer.toString(pos2)+" han muerto");
				Matar(pos1, pos2);
			
			}
		
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error en la decisión: " + e.getMessage());
	        e.printStackTrace();
			
		}
			
	}
	
	
	private void Atacar(int posPlayer, int pos) {		//Metodo para atacar que llama al ataque de cada personaje
		
		personajes.get(posPlayer).ataque(pos, posPlayer);
		
	}
	
	public void DecisionContrincantes(int pos1, int pos2) {		//Metodo que de manera aleatoria decide que hace cada contrincante a los que te enfrentas
		
		if(personajes.get(pos1).getVida() <= 0 && personajes.get(pos2).getVida() <= 0) {
			
			return;
			
		}else {
		
			Random rand = new Random();
			
			JOptionPane.showMessageDialog(null, "TURNO DE LOS CONTRINCANTES");

				if(pos1 < pos2) {

					for(int j = pos1; j < (pos2 + 1); j++) {
		
						if(personajes.get(j).getVida() > 0) {
					
							int decision3 = rand.nextInt(2);

							if(decision3 == 0) {
	
								int decision4 = rand.nextInt(2);
								Atacar(j, decision4);
	
							}else {
		
								personajes.get(j).habilidad(j);
		
							}
						}
					}
	
				}else {
	
					for(int j = pos2; j < (pos1 + 1); j++) {
		
						if(personajes.get(j).getVida() > 0) {
					
							int decision3 = rand.nextInt(2);
					
							if(decision3 == 0) {
	
								int decision4 = rand.nextInt(2);
								Atacar(j, decision4);
	
							}else {
		
								personajes.get(j).habilidad(j);
		
							}
						}
	
					}
				}	
				
		}
				
	}
	
	public void Matar(int pos1, int pos2) {		//Metodo para matar a los personajes cuando no tengan vida suficiente
		
		personajes.set(pos1, null);
		personajes.set(pos2, null);

	}
	
	public void OpcionesJugadores(int decision, int i, int pos1, int pos2) {		//Metodo para que los jugadores decidan a que jugador quieren atacar 
		
		if(decision == JOptionPane.YES_OPTION && personajes.get(pos1).getVida() > 0 && personajes.get(pos2).getVida() > 0) {
			
			String[] op = {"Jugador "+ Integer.toString(pos1), "Jugador "+ Integer.toString(pos2)};
			int decision2 = JOptionPane.showOptionDialog(null, "Jugador "+Integer.toString(i)+", a que jugador del duo contrincante deseas atacar?:\n", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, null);
	
			if(decision2 == JOptionPane.YES_OPTION) {
		
				Atacar(i, pos1);
		
			}else {
		
				Atacar(i, pos2);
				
			}
	
		}else if(decision == JOptionPane.YES_OPTION && personajes.get(pos1).getVida() > 0 && personajes.get(pos2).getVida() <= 0){
			
			String[] op = {"Jugador "+ Integer.toString(pos1)};
			JOptionPane.showOptionDialog(null, "Jugador "+Integer.toString(i)+", a que jugador del duo contrincante deseas atacar?:\n", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op);
			Atacar(i, pos1);
			
		}else if(decision == JOptionPane.YES_OPTION && personajes.get(pos1).getVida() <= 0 && personajes.get(pos2).getVida() > 0) {
		
			String[] op = {"Jugador "+ Integer.toString(pos2)};
			JOptionPane.showOptionDialog(null, "Jugador "+Integer.toString(i)+", a que jugador del duo contrincante deseas atacar?:\n", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op);
			Atacar(i, pos2);
		
		}else {
	
			personajes.get(i).habilidad(i);
	
		}
		
	}
	
	public void SimulacionCombateBots() {		//Metodo que simula en cada ronda lo que hacen los bots contra los que no te enfrentas
		
		ArrayList<Integer> BotsDisponibles = new ArrayList<>();
		Random rand = new Random();
		
		for(int i = 2; i < personajes.size(); i++) {
			
			if(personajes.get(i) != null && personajes.get(i).getVida() > 0) {
				
				BotsDisponibles.add(i);
				
			}
			
		}
		
		while(BotsDisponibles.size() >= 4) {
			
			int Bot1 = BotsDisponibles.remove(rand.nextInt(BotsDisponibles.size()));
			int Bot2 = BotsDisponibles.remove(rand.nextInt(BotsDisponibles.size()));
			int Bot3 = BotsDisponibles.remove(rand.nextInt(BotsDisponibles.size()));
			int Bot4 = BotsDisponibles.remove(rand.nextInt(BotsDisponibles.size()));
			
			CombateBots(Bot1, Bot2, Bot3, Bot4);
			
		}
		
	}
	
	public void CombateBots(int bot1, int bot2, int bot3, int bot4) {		//Metodo que simula que harían los bots contra los que no te enfrentas en cada ronda (atacar o habilidad)
		
		Random rand = new Random();
		
		while((personajes.get(bot1).getVida() > 0 || personajes.get(bot2).getVida() > 0) && (personajes.get(bot3).getVida() > 0 || personajes.get(bot4).getVida() > 0)) {
			
			if(personajes.get(bot1).getVida() > 0) {
				
				personajes.get(bot1).ataquePeroSinJOptionPanes(rand.nextBoolean() ? bot3 : bot4);
				
			}
			
			if(personajes.get(bot2).getVida() > 0) {
				
				personajes.get(bot2).ataquePeroSinJOptionPanes(rand.nextBoolean() ? bot3 : bot4);
				
			}
			
			if(personajes.get(bot3).getVida() > 0) {
				
				personajes.get(bot3).ataquePeroSinJOptionPanes(rand.nextBoolean() ? bot3 : bot4);
				
			}
			
			if(personajes.get(bot4).getVida() > 0) {
				
				personajes.get(bot4).ataquePeroSinJOptionPanes(rand.nextBoolean() ? bot3 : bot4);
				
			}
			
		}
		
		if(personajes.get(bot1).getVida() <= 0 && personajes.get(bot2).getVida() <= 0) {
			
			JOptionPane.showMessageDialog(null, "Los jugadores "+ bot3 +" y "+bot4+" han matado a los jugadores "+bot1+ " y "+bot2);
			Matar(bot1, bot2);
			
		}else {
			
			JOptionPane.showMessageDialog(null, "Los jugadores "+ bot1 +" y "+bot2+" han matado a los jugadores "+bot3+ " y "+bot4);
			Matar(bot3, bot4);
			
		}
		
	}
	
	public void MostrarPersonajes() {		//Metodo para mostrar los personajes restantes
		
		String pers = "";
		pers += "Los jugadores restantes son:\n\n";
		
		for(int i = 0; i < personajes.size(); i++) {
			
			if(personajes.get(i) == null || personajes.get(i).getVida() <= 0) {
				
				continue;
				
			}
			
			pers += personajes.get(i).ToString(i)+"\n";
			
		}
		
		JOptionPane.showMessageDialog(null, pers);
		
	}
	
}
