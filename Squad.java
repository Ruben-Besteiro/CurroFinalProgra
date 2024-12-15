package CurroFinal;

import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Squad {

    public Squad() {
        mostrarSquad(16);
        Batalla();
    }

    public void mostrarSquad(int numHumanos) {
        if (numHumanos > CrearPersonajes.personajes.size() || numHumanos < 0) {
            JOptionPane.showMessageDialog(null, "Número de jugadores en la partida incorrecto"); //esto es por si acaso
            return;
        }

        JOptionPane.showMessageDialog(null, "¡Ya se han formado los equipos!");

        int contador = 1;
        String info = "";

        for (int i = 0; i < numHumanos; i++) {
            if (i % 4 == 0) {  // Cada 4 personajes muestro un nuevo squad
                if (i != 0) {
                    info = info + "\n";  // Añado un salto de línea entre los squads
                }
                // Agrego  el nombre de la squad
                if (i < 4) {
                    info = info + "Squad " + contador + " (Mi equipo):\n";
                } else {
                    info = info + "Squad " + contador + " (Bots):\n";
                }
                contador++;  // Incremento el contador para el siguiente squad
            }

            // Agrego las características del personaje al mensaje
            info = info + "Personaje " + (i + 1) + ": "
                    + "Clase: " + CrearPersonajes.personajes.get(i).getClase() + ", "
                    + "Vida: " + CrearPersonajes.personajes.get(i).getVida() + ", "
                    + "Daño: " + CrearPersonajes.personajes.get(i).getDaño() + ", "
                    + "Herramienta: " + CrearPersonajes.personajes.get(i).getHerramienta() + "\n";
        }

        // Muestro la información de todos los personajes
        JOptionPane.showMessageDialog(null, info);
    }

    public void Batalla() {
        JOptionPane.showMessageDialog(null, "¡Comienza la batalla!");

        // Selección aleatoria del primer enemigo Squad 2, 3 o 4
        Random random = new Random();
        int primerEnemigo = random.nextInt(3) + 2;  // El primer equipo enemigo puede ser Squad 2, 3 o 4
        int inicioPrimerEnemigo = (primerEnemigo - 1) * 4;
        int finPrimerEnemigo = inicioPrimerEnemigo + 4;

        // muestro la primera batalla i
        mostrarEnfrentamiento(primerEnemigo, inicioPrimerEnemigo, finPrimerEnemigo);

        // Batalla 1: Mi equipo vs el primer enemigo
        int ronda = 1;
        boolean miEquipoGana = false;
        while (JugadoresVivos(0, 4) && JugadoresVivos(inicioPrimerEnemigo, finPrimerEnemigo)) {
            // Muestro los detalles después del ronda
            JOptionPane.showMessageDialog(null, "Ronda " + ronda);
            turnoEquipoJugador(inicioPrimerEnemigo, finPrimerEnemigo);
            turnoEquipoEnemigo(inicioPrimerEnemigo, finPrimerEnemigo);

            // Muestro las estadísticas de los squads después del ronda
            mostrarEstadoRonda(0, 4, inicioPrimerEnemigo, finPrimerEnemigo);

            ronda++;
        }

        // Verifico el ganador de la primera batalla
        if (!JugadoresVivos(inicioPrimerEnemigo, finPrimerEnemigo)) {
            JOptionPane.showMessageDialog(null, "¡El primer equipo ha sido derrotado!");
            miEquipoGana = true;
        } else {
            JOptionPane.showMessageDialog(null, "¡Tu equipo ha sido derrotado!");
        }

        // simulo la batalla entre los dos equipos restantes 
        batallaFinal(miEquipoGana, primerEnemigo);
    }

    //  verifico si hay jugadores vivos en un equipo
    private boolean JugadoresVivos(int inicio, int fin) {
        for (int i = inicio; i < fin; i++) {
            if (CrearPersonajes.personajes.get(i).getVida() > 0) {
                return true;
            }
        }
        return false;
    }

    // Simulo la batalla final dependiendo de si tu equipo ganó o no
    private void batallaFinal(boolean miEquipoGana, int primerEnemigo) {
        Random random = new Random();
        int ganadorFinal = 0; // Variable para almacenar el ganador final

        // Determino cual de las dos squads restantes lucharan
        int squad1;
        int squad2;

        if (primerEnemigo == 2) {
            squad1 = 3;
        } else {
            squad1 = 2;
        }

        if (primerEnemigo == 4) {
            squad2 = 3;
        } else {
            squad2 = 4;
        }
        // Simulo la batalla entre los dos equipos de bots
        ganadorFinal = batallaEntreBots(squad1, squad2);

        // Muestro enfrentamiento final con el ganador de los bots
        JOptionPane.showMessageDialog(null, "El enfrentamiento final será entre este equipoy el ganador entre el Squad " + squad1 + " y el Squad " + squad2 + "!");
        

        //  actualizo las estadísticas del squad ganador
        actualizarCaracteristicasSquad(ganadorFinal);

        // Muestro las estadísticas de los squads después de la batalla
        mostrarEstadoRonda(0, 4, (ganadorFinal - 1) * 4, ganadorFinal * 4); 

        // Simulo la batalla entre tu equipo y el equipo ganador de los bots
        int inicioEnemigo = (ganadorFinal - 1) * 4;
        int finEnemigo = inicioEnemigo + 4;

        int ronda = 1;
        while (JugadoresVivos(0, 4) && JugadoresVivos(inicioEnemigo, finEnemigo)) {
            // No muestro los detalles de los ataques, solo indicamos el ronda
            JOptionPane.showMessageDialog(null, "Ronda " + ronda);

            // simulo el turno de los equipos sin mostrar detalles
            turnoEquipoJugador(inicioEnemigo, finEnemigo);
            turnoEquipoEnemigo(inicioEnemigo, finEnemigo);

            // Actualizo las estadísticas sin mostrar los detalles
            mostrarEstadoRonda(0, 4, inicioEnemigo, finEnemigo);

            ronda++;
        }

        if (JugadoresVivos(0, 4)) {
            JOptionPane.showMessageDialog(null, "¡Tu equipo ha ganado la partida!");
        } else {
            JOptionPane.showMessageDialog(null, "¡El equipo enemigo ha ganado la partida!");
        }
    }

    // Simulo una batalla entre dos squads de bots
    private int batallaEntreBots(int squad1, int squad2) {
        Random random = new Random();

        // Obtengo el rango de personajes de cada squad
        int inicio1 = (squad1 - 1) * 4;
        int fin1 = inicio1 + 4;
        int inicio2 = (squad2 - 1) * 4;
        int fin2 = inicio2 + 4;

        // Simulo la batalla entre los dos equipos
        boolean turnoSquad1 = true; // El primer turno es para el primer squad
        while (JugadoresVivos(inicio1, fin1) && JugadoresVivos(inicio2, fin2)) {
            if (turnoSquad1) {
                // El primer squad ataca,no muestro destalles
                for (int i = inicio1; i < fin1; i++) {
                    Personaje atacante = CrearPersonajes.personajes.get(i);
                    if (atacante.getVida() > 0) {
                        // Eligo un enemigo aleatorio
                        int objetivo = random.nextInt(4) + inicio2;
                        Personaje enemigo = CrearPersonajes.personajes.get(objetivo);
                        if (enemigo.getVida() > 0) {
                            // Ataque del atacante
                            enemigo.setVida(enemigo.getVida() - atacante.getDaño());
                        }
                    }
                }
            } else {
                // El segundo squad ataca, no muestro detalles
                for (int i = inicio2; i < fin2; i++) {
                    Personaje atacante = CrearPersonajes.personajes.get(i);
                    if (atacante.getVida() > 0) {
                        // Eligo un enemigo aleatorio
                        int objetivo = random.nextInt(4) + inicio1;
                        Personaje enemigo = CrearPersonajes.personajes.get(objetivo);
                        if (enemigo.getVida() > 0) {
                            // Ataque del atacante
                            enemigo.setVida(enemigo.getVida() - atacante.getDaño());
                        }
                    }
                }
            }
            turnoSquad1 = !turnoSquad1; // Alterno turno
        }

        //  determino el ganador
        if (JugadoresVivos(inicio1, fin1)) {
            return squad1;
        } else {
            return squad2;
        }
    }

    // Función para actualizar las características del squad ganador
    private void actualizarCaracteristicasSquad(int ganadorSquad) {
        int inicio = (ganadorSquad - 1) * 4;
        int fin = inicio + 4;

        // Actualizo las características de los personajes del squad ganador
        for (int i = inicio; i < fin; i++) {
            Personaje personaje = CrearPersonajes.personajes.get(i);
            // Si el personaje sigue vivo, se actualizan sus características 
            
        }
    }

    // Muestro el enfrentamiento
    private void mostrarEnfrentamiento(int squadEnemigo, int inicioEnemigo, int finEnemigo) {
        String enfrentamiento = "Squad 1 (Mi equipo):\n";
        for (int i = 0; i < 4; i++) {
            enfrentamiento += "Jugador " + (i + 1) + " - " + CrearPersonajes.personajes.get(i).getClase() + " (Vida: "+ CrearPersonajes.personajes.get(i).getVida() + ")\n";
        }

        enfrentamiento += "VS\n";
        enfrentamiento += "Squad " + squadEnemigo + " (Enemigo):\n";
        for (int i = inicioEnemigo; i < finEnemigo; i++) {
            enfrentamiento += "Jugador " + (i + 1) + " - "+ CrearPersonajes.personajes.get(i).getClase() + " (Vida: "+ CrearPersonajes.personajes.get(i).getVida() + ")\n";
        }
        JOptionPane.showMessageDialog(null, enfrentamiento);
    }

    // Muestro estado de los squads en cada ronda
    private void mostrarEstadoRonda(int inicio1, int fin1, int inicio2, int fin2) {
        String estado = "Squad 1 (Mi equipo):\n";
        for (int i = inicio1; i < fin1; i++) {
            estado += "Jugador " + (i + 1) + " - "+ CrearPersonajes.personajes.get(i).getClase() + " (Vida: "+ CrearPersonajes.personajes.get(i).getVida() + ")\n";
        }
        estado += "VS\n";
        estado += "Squad 2 (Enemigo):\n";
        for (int i = inicio2; i < fin2; i++) {
            estado += "Jugador " + (i + 1) + " - "+ CrearPersonajes.personajes.get(i).getClase() + " (Vida: "+ CrearPersonajes.personajes.get(i).getVida() + ")\n";
        }

        JOptionPane.showMessageDialog(null, estado);
    }

    // Función para que los jugadores realicen su turno
    private void turnoEquipoJugador(int inicioEnemigo, int finEnemigo) {
        Random random = new Random();
        //  simulo los turnos de los jugadores. Por ejemplo, un jugador puede atacar a un enemigo aleatorio
        for (int i = 0; i < 4; i++) {
            Personaje personaje = CrearPersonajes.personajes.get(i);
            if (personaje.getVida() > 0) {
                int obj = random.nextInt(4) + inicioEnemigo;
                Personaje enemigo = CrearPersonajes.personajes.get(obj);
                if (enemigo.getVida() > 0) {
                    enemigo.setVida(enemigo.getVida() - personaje.getDaño());
                }
            }
        }
    }

    
    private void turnoEquipoEnemigo(int inicioEnemigo, int finEnemigo) {
    	Random random = new Random();
        // simulo los turnos de los enemigos

    	for (int i = inicioEnemigo; i < finEnemigo; i++) {
    		Personaje enemigo = CrearPersonajes.personajes.get(i);
    		if (enemigo.getVida() > 0) {
    			int obj = random.nextInt(4);
    			Personaje objetivoPersonaje = CrearPersonajes.personajes.get(obj);
    			if (objetivoPersonaje.getVida() > 0) {
    				objetivoPersonaje.setVida(objetivoPersonaje.getVida() - enemigo.getDaño());
    			}
    		}
    	}
    }
}