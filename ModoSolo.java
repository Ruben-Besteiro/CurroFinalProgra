package CurroFinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ModoSolo {
	
	private JTextArea pantallaTextos;	//PANTALLA DE TEXTOS
	private ArrayList<JButton> botones;	//ARRAYLIST DE LOS BOTONES
	private SONIDOVICTORIA victoria;
	
    //CONSTRUCTOR
    public ModoSolo() {
    	botones = new ArrayList<>();
        cambiarPantalla();
        //MenuPausa();
    }

    //METODOS
    public void cambiarPantalla() {
        MenuJuego.Panel.setLayout(null); // USAMOS LAYOUT MANUAL
        MenuJuego.Panel.setBackground(Color.BLUE); //COLOR DE FONDO

        //DIMENSIONES DEL PANEL
        int panelAncho = MenuJuego.Panel.getWidth();
        int panelAlto = MenuJuego.Panel.getHeight();

        // PANTALLA DE TEXTO EN EL CENTRO
        pantallaTextos = new JTextArea();
        pantallaTextos.setEditable(false);
        pantallaTextos.setFont(new Font("Arial", Font.PLAIN, 16));
        pantallaTextos.setLineWrap(true);
        pantallaTextos.setWrapStyleWord(true);
        pantallaTextos.setBackground(Color.BLACK); //FONDO NEGRO
        pantallaTextos.setForeground(Color.WHITE); //TEXTO BLANCO


        JScrollPane scroll = new JScrollPane(pantallaTextos);
        //CALCULOS NECESARIOS PARA PONERLO EN EL CENTRO DE LA PANTALLA
        int pantallaAncho = 400; 
        int pantallaAlto = 200; 
        scroll.setBounds((panelAncho - pantallaAncho) / 2, (panelAlto - pantallaAlto) / 3, pantallaAncho, pantallaAlto); //CENTRADO

        //BOTON ATACAR A LA IZQUIERDA
        JButton boton1 = new JButton("ATACAR");
        boton1.setBackground(Color.WHITE);
        boton1.setForeground(Color.RED);
        boton1.setFont(new Font("Arial", Font.BOLD, 22));
        boton1.setBounds(50, scroll.getY() + scroll.getHeight() + 20, 200, 50); //DEBAJO Y A LA IZQUIERDA
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] opciones = generarOpcionesAtaque();
                if (opciones.length > 0) {
                    int eleccion = Integer.parseInt(JOptionPane.showInputDialog(
                        null, 
                        "A quién deseas atacar?", 
                        "Introduce tu objetivo"
                    ));
                    if (eleccion >= 0) {
                        int indiceObjetivo = eleccion;
                        try {
                            if (indiceObjetivo < CrearPersonajes.personajes.size() && CrearPersonajes.personajes.get(indiceObjetivo) != null) {
                                CrearPersonajes.personajes.get(0).ataque(indiceObjetivo);
                                eliminarJugador();
                                eleccionBots();
                            } /*else {
                                JOptionPane.showMessageDialog(null, "El objetivo seleccionado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                            }*/
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar atacar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay objetivos disponibles para atacar.", "Sin objetivos", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // BOTÓN HABILIDAD A LA DERECHA
        JButton boton2 = new JButton("HABILIDAD");
        boton2.setBackground(Color.WHITE);
        boton2.setForeground(Color.RED);
        boton2.setFont(new Font("Arial", Font.BOLD, 22));
        boton2.setBounds(panelAncho - 250, boton1.getY(), 200, 50); //POSICION BOTON
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CrearPersonajes.personajes.get(0).habilidad();	//LLAMO A LA FUCNION DE HABILIDAD DE RUBI
                    eliminarJugador();
                    eleccionBots();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Se produjo un error al usar la habilidad: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        //BOTON IMPRIMIR PERSONAJES DEBAJO DE LA PANTALLA DE TEXTO
        JButton botonImprimir = new JButton("IMPRIMIR PERSONAJES");
        botonImprimir.setBackground(Color.WHITE);
        botonImprimir.setForeground(Color.RED);
        botonImprimir.setFont(new Font("Arial", Font.BOLD, 22));
        botonImprimir.setBounds((panelAncho - 300) / 2, boton1.getY() + boton1.getHeight() + 20, 300, 50); //CENTRADO BAJO LOS OTROS BOTONES
        botonImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimirPersonajes();
            }
        });
        
        //BOTONES PANTALLA
        MenuJuego.Panel.add(botonImprimir);
        MenuJuego.Panel.add(scroll);
        MenuJuego.Panel.add(boton1);
        MenuJuego.Panel.add(boton2);
        
        //BOTONES LISTA
        botones.add(boton1);
        botones.add(boton2);
        botones.add(botonImprimir);
        
        MenuJuego.Panel.revalidate();
        MenuJuego.Panel.repaint();
    }

    //IMPRIME LOS PEROSNAJES POR LA CONSOLA
    public void imprimirPersonajes() {
        System.out.println("Lista de Personajes:");
        //RECORRO LA LISTA DE LOS PERSONAJES DE LA PARTIDA
        for (int i = 0; i < CrearPersonajes.personajes.size(); i++) {
            if (CrearPersonajes.personajes.get(i) != null) { 	//PERSONAJES DISTINTOS DE NULL
                try {
                	agregarTextoPantalla("Personaje " + i + ": " + CrearPersonajes.personajes.get(i).ToString(i));	//PANTAKLLA TEXTOS
                } catch (Exception e) {
                    System.err.println("Error al intentar obtener la información del personaje " + i + ": " + e.getMessage());	//LO HE AÑADIDO POR QUE ME DABA ERRORES
                }
            } else {	//SI ES NULL ES POR QUE ESTA MUERTO
                System.out.println("Personaje " + i + ": ELIMINADO");
            }
        }
        //IMPRIME LOS JUGADORES QUE QUEDAN VIVOS
        agregarTextoPantalla(vivos());
    }


    //METODO RANDOM PARA QUE LOS BOTS ATAQUEN O USEN SU HABILIDAD
    public void eleccionBots() {
        Random random = new Random();
        for (int i = 1; i < CrearPersonajes.personajes.size(); i++) { //EMPIEZA EN 1 PARA SALTARME A MI
            try {
                if (CrearPersonajes.personajes.get(i) != null && CrearPersonajes.personajes.get(i).getVida() > 0) {
                    int decision = random.nextInt(2); // 0 PARA ATACAR, 1 PARA USAR HABILIDAD

                    if (decision == 0) { //EL BOT DECIDE ATACAR
                        //GENERAR UNA LISTA DE POSIBLES OBJETIVOS
                        ArrayList<Integer> objetivos = new ArrayList<>();
                        for (int j = 0; j < CrearPersonajes.personajes.size(); j++) {
                            if (j != i && CrearPersonajes.personajes.get(j) != null && CrearPersonajes.personajes.get(j).getVida() > 0) {
                                objetivos.add(j); //AÑADO LOS OBJETIVOS VIVOS
                            }
                        }
                        //ATAQUA A UN OBJETIVO RANDOM
                        if (!objetivos.isEmpty()) {
                            int indiceObjetivo = objetivos.get(random.nextInt(objetivos.size()));
                            agregarTextoPantalla("BOT " + i + " HA ELEGIDO ATACAR A JUGADOR " + indiceObjetivo);
                            CrearPersonajes.personajes.get(i).ataque(indiceObjetivo); //ATACA
                        } else {
                            agregarTextoPantalla("BOT " + i + " NO TIENE OBJETIVOS DISPONIBLES.");
                        }
                    } else { //EL BOT DECIDE USAR HABILIDAD
                        agregarTextoPantalla("BOT " + i + " HA USADO SU HABILIDAD.");
                        CrearPersonajes.personajes.get(i).habilidad(); //USA HABILIDAD
                    }
                }
            } catch (Exception ex) {
                System.err.println("Error durante el turno del bot: " + ex.getMessage());
            }
        }
        eliminarJugador();
        ganador(); //REVISA POR SI SOLO QUEDA UNO CON VIDA Y TERMINA EL JUEGO
    }


    //METODO PARA ELIMINAR A UN JUGADOR DEL ARRAY PONIENDO NULL EN SU POSICION
    public void eliminarJugador() {
        for (int i = 0; i < CrearPersonajes.personajes.size(); i++) {
            if (CrearPersonajes.personajes.get(i) != null && CrearPersonajes.personajes.get(i).getVida() <= 0) {
                agregarTextoPantalla("El jugador " + i + " ha sido eliminado.");
                CrearPersonajes.personajes.set(i, null); //MARCAR COMO NULL
                MuertePersonajePrincipal();
            }
        }
    }

    
    //METODO PARA ELEGUIR AL JUGADOR AL CUAL ATACAR SIEMPRE QUE TENGA MAS DE 0 DE VIDA
    public String[] generarOpcionesAtaque() {
        ArrayList<String> opciones = new ArrayList<>();	//ARRAY LIST DE LAS OPCIONES QUE TIENE EL JUADOR HUMANO
        for (int i = 1; i < CrearPersonajes.personajes.size(); i++) { //INT I=1 PARA QUE SE SALTE A MI JUGADOR QUE ES EL 0
        	if (CrearPersonajes.personajes.get(i) != null && CrearPersonajes.personajes.get(i).getVida() > 0) {
                opciones.add("Atacar a " + i);
            }
        }
        return opciones.toArray(new String[0]);
    }
    
    //METODO PARA VICTORIA
    public void ganador() {
        int indiceGanador = -1;	
        int vivos=0;
        
        //RECORRO 
        for (int i = 0; i < CrearPersonajes.personajes.size(); i++) {
            if (CrearPersonajes.personajes.get(i) != null && CrearPersonajes.personajes.get(i).getVida() > 0) {
                indiceGanador = i;
                vivos++;
            }
        }
        //CUANDO SOLO QUEDA UNO
        if (vivos == 1) {
            if (indiceGanador == 0) { //SI GANO YO 
                agregarTextoPantalla("¡FELICIDADES! ¡ERES EL GANADOR!");	//MENSAJE DE LA PANTALLA DE TEXTOS
                borrarBotonesPorMuerte(); //DESACTIVO BOTONES
                victoria = new SONIDOVICTORIA(); //INICIALIZO EL SONIDO
                victoria.sonido(); //sUENA EL SONIDO UNA SOLA VEZ
            } else {
                agregarTextoPantalla("El bot " + indiceGanador + " ha ganado la partida.");	//GANA UN BOT
                borrarBotonesPorMuerte(); //QUITO BOTONES
                //System.exit(0);;
            }
        }

     }
    
    //METODO POR SI MUERO
    public void MuertePersonajePrincipal() {
    	if (CrearPersonajes.personajes.get(0) == null || CrearPersonajes.personajes.get(0).getVida() <= 0) {	//SI MI PERSONAJE QUE ES EL 1 EN LA LISTA MUERE PUES
    		agregarTextoPantalla("TE HAN MATADO GG");
    		borrarBotonesPorMuerte();
    		//System.exit(0);	//ME SACA DEL JUEGO	lo tengo comentado por si acaso lo meto
    	}
    }
   
    //METODO PARA CONTAR CUANDOS JUGADORES QUEDAN VIVOS
    public String vivos() {
    	int vivos=0;
    	
    	//RECORRO EL ARRAY DE PERSONAJES Y SI HAY ALGUNO CON MAS DE 0 DE VIDA ME SUMA Y ASI CUENTO LOS VIVOS
    	for (int i=0; i < CrearPersonajes.personajes.size(); i++) {
    		if (CrearPersonajes.personajes.get(i) != null && CrearPersonajes.personajes.get(i).getVida() > 0) {
    			vivos++;
    		}
    	}
		return "Quedan " + vivos + " vivos en partida";	
    }
    
    //METODO PARA AGREGAR TEXTO A LA PANTALLA
    public void agregarTextoPantalla(String texto) {
    	 pantallaTextos.append(texto + "\n"); //TEXTO CON EL SALTO DE LINEA
    	 pantallaTextos.setCaretPosition(pantallaTextos.getDocument().getLength()); //DESPLAZA AUTOMATICAMENTE HACIA ABAJO
    }
    
    //METODO PARA HACER QUE DESAPAREZCAN LOS BOTONES CUANDO MUERA
    public void borrarBotonesPorMuerte() {
    	for (int i=0; i < botones.size(); i++) {
    		botones.get(i).setEnabled(false);
    	}
    }
    
 }
