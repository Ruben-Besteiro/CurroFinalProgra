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
            JOptionPane.showMessageDialog(null, "No es correcto el numero de jugadores en la partida");
            return;
        }

        JOptionPane.showMessageDialog(null, "¡Las Squads ya estan hechas!");

        int contador = 1;
        String info = "";

        for (int i = 0; i < numHumanos; i++) {
            if (i % 4 == 0) {  // Cada 4 personajes mostramos un nuevo squad
                if (i != 0) {
                    info = info + "\n";  // Añado un salto de línea entre los squads
                }
            
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

        // Muestrola información de todos los personajes
        JOptionPane.showMessageDialog(null, info);
    }

    public void Batalla() {
        JOptionPane.showMessageDialog(null, "¡Comienza la batalla!");

        // Selección aleatoria del primer enemigo Squad 2, 3 o 4
        Random random = new Random();
        int primerEnemigo = random.nextInt(3) + 2;  // El primer enemigo puede ser Squad 2, 3 o 4
        int inicioPrimerEnemigo = (primerEnemigo - 1) * 4;
        int finPrimerEnemigo = inicioPrimerEnemigo + 4;

        // Muestro el enfrentamiento inicial
        mostrarEnfrentamiento(primerEnemigo, inicioPrimerEnemigo, finPrimerEnemigo);

        // Batalla 1: Mi equipo vs el primer enemigo
        int round = 1;
        boolean miEquipoGana = false;
        while (JugadoresVivos(0, 4) && JugadoresVivos(inicioPrimerEnemigo, finPrimerEnemigo)) {
            // Muestro los detalles después del round
            JOptionPane.showMessageDialog(null, "Round " + round);
            turnoEquipoJugador(inicioPrimerEnemigo, finPrimerEnemigo);
            turnoEquipoEnemigo(inicioPrimerEnemigo, finPrimerEnemigo);

            // Muestro las estadísticas de las squads después del round
            mostrarEstadoRound(0, 4, inicioPrimerEnemigo, finPrimerEnemigo);

            round++;
        }

        // Verifico el ganador de la primera batalla
        if (!JugadoresVivos(inicioPrimerEnemigo, finPrimerEnemigo)) {
            JOptionPane.showMessageDialog(null, "¡El primer equipo enemigo ha sido derrotado!");
            miEquipoGana = true;
        } else {
            JOptionPane.showMessageDialog(null, "¡Tu equipo ha sido derrotado!");
        }

        // Ahora simulamos la batalla entre los dos squads restantes (si tu equipo gana o pierde)
        batallaFinal(miEquipoGana, primerEnemigo);
    }

    // Método para verificar si hay jugadores vivos en un equipo
    private boolean JugadoresVivos(int start, int end) {
        for (int i = start; i < end; i++) {
            if (CrearPersonajes.personajes.get(i).getVida() > 0) {
                return true;
            }
        }
        return false;
    }

    // Simula la batalla final dependiendo de si tu equipo ganó o no
    private void batallaFinal(boolean miEquipoGana, int primerEnemigo) {
        Random random = new Random();
        int ganadorFinal = 0; // Variable para almacenar el ganador final

        // Determino qué dos squads de bots lucharán entre sí
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

        // Simula la batalla entre los dos squads de bots
        ganadorFinal = batallaEntreBots(squad1, squad2);

        // Mostrar enfrentamiento final con el ganador de los bots
        JOptionPane.showMessageDialog(null, "El enfrentamiento final será entre tu equipo y el ganador entre el Squad " + squad1 + " y el Squad " + squad2 + "!");
        // Aquí no mostramos detalles, solo el mensaje que indica quién ganó

        // Ahora se actualizan las estadísticas de la squad ganadora
        actualizarCaracteristicasSquad(ganadorFinal);

        // Mostrar las estadísticas de las squads después de la batalla
        mostrarEstadoRound(0, 4, (ganadorFinal - 1) * 4, ganadorFinal * 4); // Mostrar la batalla entre los dos equipos

        // Simulo la batalla entre tu equipo y el equipo ganador de los bots
        int Enemigo = (ganadorFinal - 1) * 4;
        int finEnemigo = Enemigo + 4;

        int round = 1;
        while (JugadoresVivos(0, 4) && JugadoresVivos(Enemigo, finEnemigo)) {
            // No mostramos los detalles de los ataques, solo indicamos el round
            JOptionPane.showMessageDialog(null, "Round " + round);

            // Se simula el turno de los equipos sin mostrar detalles
            turnoEquipoJugador(Enemigo, finEnemigo);
            turnoEquipoEnemigo(Enemigo, finEnemigo);

            // Actualizamos las estadísticas sin mostrar los detalles
            mostrarEstadoRound(0, 4, Enemigo, finEnemigo);

            round++;
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

        // Simulo la batalla entre los dos squads
        boolean turnoSquad1 = true; // El primer turno es para el primer squad
        while (JugadoresVivos(inicio1, fin1) && JugadoresVivos(inicio2, fin2)) {
            if (turnoSquad1) {
                // El primer squad ataca, pero no mostramos los detalles
                for (int i = inicio1; i < fin1; i++) {
                    Personaje atacante = CrearPersonajes.personajes.get(i);
                    if (atacante.getVida() > 0) {
                        // Elegir un enemigo aleatorio
                        int objetivo = random.nextInt(4) + inicio2;
                        Personaje enemigo = CrearPersonajes.personajes.get(objetivo);
                        if (enemigo.getVida() > 0) {
                            // Ataque del atacante
                            enemigo.setVida(enemigo.getVida() - atacante.getDaño());
                        }
                    }
                }
            } else {
                // El segundo squad ataca, pero no mostramos los detalles
                for (int i = inicio2; i < fin2; i++) {
                    Personaje atacante = CrearPersonajes.personajes.get(i);
                    if (atacante.getVida() > 0) {
                        // Elegir un enemigo aleatorio
                        int objetivo = random.nextInt(4) + inicio1;
                        Personaje enemigo = CrearPersonajes.personajes.get(objetivo);
                        if (enemigo.getVida() > 0) {
                            // Ataque del atacante
                            enemigo.setVida(enemigo.getVida() - atacante.getDaño());
                        }
                    }
                }
            }
            turnoSquad1 = !turnoSquad1; // Alternar el turno
        }

        // Después de la batalla, se determina al ganador
        if (JugadoresVivos(inicio1, fin1)) {
            return squad1;
        } else {
            return squad2;
        }

    }

    // Función para actualizar las características de la squad ganadora
    private void actualizarCaracteristicasSquad(int ganadorSquad) {
        int ini = (ganadorSquad - 1) * 4;
        int fin = ini + 4;

        // Actualizo las características de los personajes de la squad ganadora
        for (int i = ini; i < fin; i++) {
            Personaje personaje = CrearPersonajes.personajes.get(i);
            // Si el personaje sigue vivo, se actualizan sus características (por ejemplo, aumentando su vida)
            
        }
    }


    // Muestro el enfrentamiento
    private void mostrarEnfrentamiento(int squadEnemigo, int inicioEnemigo, int finEnemigo) {
        String enfrentamiento = "Squad 1 (Mi equipo):\n";
        for (int i = 0; i < 4; i++) {
            enfrentamiento += "Jugador " + (i + 1) + " - "
                    + CrearPersonajes.personajes.get(i).getClase() + " (Vida: "
                    + CrearPersonajes.personajes.get(i).getVida() + ")\n";
        }

        enfrentamiento += "VS\n";
        enfrentamiento += "Squad " + squadEnemigo + " (Enemigo):\n";
        for (int i = inicioEnemigo; i < finEnemigo; i++) {
            enfrentamiento += "Jugador " + (i + 1) + " - "
                    + CrearPersonajes.personajes.get(i).getClase() + " (Vida: "
                    + CrearPersonajes.personajes.get(i).getVida() + ")\n";
        }
        JOptionPane.showMessageDialog(null, enfrentamiento);
    }

    // Muestro el estado de las squads en cada round
    private void mostrarEstadoRound(int inicio1, int fin1, int inicio2, int fin2) {
        String estado = "Squad 1 (Mi equipo):\n";
        for (int i = inicio1; i < fin1; i++) {
            if (CrearPersonajes.personajes.get(i).getVida() > 0) {
                estado += "Jugador " + (i + 1) + " - " 
                        + CrearPersonajes.personajes.get(i).getClase() + " (Vida: "
                        + CrearPersonajes.personajes.get(i).getVida() + ")\n";
            }
        }

        estado += "VS\n";
        estado += "Squad 3 (Enemigo):\n";
        for (int i = inicio2; i < fin2; i++) {
            if (CrearPersonajes.personajes.get(i).getVida() > 0) {
                estado += "Jugador " + (i + 1) + " - " 
                        + CrearPersonajes.personajes.get(i).getClase() + " (Vida: "
                        + CrearPersonajes.personajes.get(i).getVida() + ")\n";
            }
        }
        JOptionPane.showMessageDialog(null, estado);
    }

    // Turno del equipo jugador
    private void turnoEquipoJugador(int inicioEnemigo, int finEnemigo) {
        for (int i = 0; i < 4; i++) { // Tu equipo 
            Personaje jugador = CrearPersonajes.personajes.get(i);

            if (jugador.getVida() <= 0) {
                continue;  // Si el jugador está muerto, no hace nada
            }

            // Elegir acción
            String[] opciones = {"ATACAR", "HABILIDAD"};
            int eleccion = JOptionPane.showOptionDialog(null, "Jugador " + (i + 1) + " ¿Qué quieres hacer?",
                    "Turno del Jugador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (eleccion == 0) { // ATACAR
                atacarEnemigo(jugador, inicioEnemigo, finEnemigo);
            } else { // HABILIDAD
                usarHabilidad(jugador, inicioEnemigo, finEnemigo);
            }
        }
    }

    // Lógica para atacar al enemigo
    private void atacarEnemigo(Personaje atacante, int inicioEnemigo, int finEnemigo) {
        JButton[] botones = new JButton[4];
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int j = inicioEnemigo; j < finEnemigo; j++) {
            Personaje enemigo = CrearPersonajes.personajes.get(j);
            final int Enemigo = j; // Variable temporal final

            if (enemigo.getVida() > 0) {  // Solo muestro botones si el enemigo está vivo
                botones[j - inicioEnemigo] = new JButton("Jugador " + (j + 1) + ": " 
                                                       + enemigo.getClase() + " (Vida: " 
                                                       + enemigo.getVida() + ")");
                botones[j - inicioEnemigo].addActionListener(e -> atacante.ataque(Enemigo, 0));
                panel.add(botones[j - inicioEnemigo]);
            }
        }
        JOptionPane.showMessageDialog(null, panel, "Elige un objetivo", JOptionPane.PLAIN_MESSAGE);
    }

    private void usarHabilidad(Personaje jugador, int inicioEnemigo, int finEnemigo) {
        // Pedir al jugador que ingrese el número de enemigo al que atacar
        String in = JOptionPane.showInputDialog("Introduce el número del jugador enemigo para usar la habilidad: ");//esto se deberia cambiar pero sino, no funciona
        int numJugador = Integer.parseInt(in) - 1;  

        // Verifico que el número de jugador está dentro del rango de enemigos
        if (numJugador < inicioEnemigo || numJugador >= finEnemigo) {
            JOptionPane.showMessageDialog(null, "Error: Solo puedes usar la habilidad contra los jugadores del equipo enemigo.");
        } else {
            // Aquí se llama a la habilidad del jugador seleccionado
            // Asegurándonos de que llamamos al método correcto 
            Personaje enemigo = CrearPersonajes.personajes.get(numJugador);

            // Llamamos al método usarHabilidad
            jugador.habilidad(numJugador);

            JOptionPane.showMessageDialog(null, "Habilidad usada contra el jugador " + (numJugador + 1) + ".");
        }
    }
    
    private void turnoEquipoEnemigo(int inicioEnemigo, int finEnemigo) {
    	Random rand = new Random();
    	for (int j = inicioEnemigo; j < finEnemigo; j++) {
    		Personaje enemigo = CrearPersonajes.personajes.get(j);
    		
    		if (enemigo.getVida() > 0) {
                // Selecciono aleatoriamente un jugador de tu equipo 
                int objetivoJugador = rand.nextInt(4); // Aleatorio entre los primeros 4 jugadores
                Personaje jugadorObjetivo = CrearPersonajes.personajes.get(objetivoJugador);

                // Eligo ataque o habilidad 
                if (rand.nextBoolean()) {  // Si es true, el enemigo atacará
                    enemigo.ataque(objetivoJugador, j);
                    JOptionPane.showMessageDialog(null, "El jugador " + (j + 1) + " (Enemigo) ha atacado a tu jugador " + (objetivoJugador + 1));
                } else {  // Si es false, el enemigo usará una habilidad
                    enemigo.habilidad(j);
                    JOptionPane.showMessageDialog(null, "El jugador " + (j + 1) + " (Enemigo) ha usado una habilidad contra tu jugador " + (objetivoJugador + 1));
                }
            }
    	}
    }
}