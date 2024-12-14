package CurroFinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ModoSolo {
	
    //CONSTRUCTOR
    public ModoSolo() {
        cambiarPantalla();
        //MenuPausa();
        
    }

    //METODOS
    public void cambiarPantalla() {

        MenuJuego.Panel.setBackground(Color.BLUE); // COLOR DE FONDO EL MISMO    

        //BOTON ATACAR
        JButton boton1 = new JButton("ATACAR");
        boton1.setBackground(Color.WHITE);
        boton1.setForeground(Color.RED);
        boton1.setFont(new Font("Arial", Font.BOLD, 22));    
        boton1.setBounds(100, 100, 200, 50);

        boton1.addActionListener(new ActionListener() { // CUANDO SE PULSE EL BOTON DE SOLO QUE SE VAYA A LA CLASE PERSONAJE Y ATACA
            public void actionPerformed(ActionEvent e) {
            	generarOpcionesAtaque();
            }
        });

        //BOTON HABILIDAD
        JButton boton2 = new JButton("HABILIDAD");
        boton2.setBackground(Color.WHITE);
        boton2.setForeground(Color.RED);
        boton2.setFont(new Font("Arial", Font.BOLD, 22));    
        boton2.setBounds(100, 200, 200, 50);

        boton2.addActionListener(new ActionListener() { // CUANDO SE PULSE EL BOTON DE SOLO QUE SE VAYA A LA CLASE PERSONAJE Y ATACA
            public void actionPerformed(ActionEvent e) {
            	CrearPersonajes.personajes.get(0).habilidad();	//EL 0 ES POR EL NUMERO DEL PERSONAJE ES DECIR EL NUESTRO POR QUE ES EN SOLITARIO
            }
        });

        //BOTON PARA IMPRIMIR TODOS LOS JUGADORES
        JButton botonImprimir = new JButton("IMPRIMIR PERSONAJES");
        botonImprimir.setBackground(Color.WHITE);
        botonImprimir.setForeground(Color.RED);
        botonImprimir.setFont(new Font("Arial", Font.BOLD, 22));
        botonImprimir.setBounds(100, 300, 300, 50);

        botonImprimir.addActionListener(new ActionListener() { // AL PRESIONAR EL BOTÓN, IMPRIME PERSONAJES
            public void actionPerformed(ActionEvent e) {
                imprimirPersonajes();
            }
        });

        //AÑADO BOTONES Y TODO
        MenuJuego.Panel.add(boton1);
        MenuJuego.Panel.add(boton2);
        MenuJuego.Panel.add(botonImprimir);

        MenuJuego.Panel.revalidate(); // REORGANIZA EL DISEÑO DEL PANEL EN ESTE CASO
        MenuJuego.Panel.repaint(); // ASEGURA QUE SE VEAN LOS CAMBIOS EN PANTALLA
    }

    //IMPRIME LOS PEROSNAJES POR LA CONSOLA
    public void imprimirPersonajes() {
        System.out.println("Lista de Personajes:");
        for (int i = 0; i < CrearPersonajes.personajes.size(); i++) {
            System.out.println("Personaje " + i + ": " + CrearPersonajes.personajes.get(i).ToString(i));
        }
    }

    //METODO RANDOM PARA QUE LOS BOTS ATAQUEN O USEN SU HABILIDAD
    public void eleccionBots() {
        Random random = new Random();
        int eleccion;
        eleccion = random.nextInt(2); // GENERA UN NUMERO RANDOM ENTRE EL 0 Y 1 PARA QUE DE FORMA RANDOM APRIETEN LOS BOTS EL BOTON DE ATACAR O HABILIDAD :)

        if (eleccion == 0) {
            System.out.println("Bot ha elegido atacar y ha pulsado el boton");
            CrearPersonajes.personajes.get(1).ataque(2);	//ESCOGES A QUIEN ATACAS
        } else {
            System.out.println("Bot ha elegido habilidad y ha pulsado el boton");
            CrearPersonajes.personajes.get(1).habilidad();	//ESCOGES DESPUES TE SALE UN PANEL PARA QUE ELIJAS
        }
    }
    
    //METODO PARA CHEQUEAR QUÉ JUGADORES ESTÁN MUERTOS Y ELIMINARLOS
    public void eliminarJugador() {
    	CrearPersonajes.personajes.removeIf(personaje -> personaje.getVida() <= 0);
        System.out.println("Se han eliminado los jugadores con vida menor o igual a 0.");
     }
    
    
    //METODO PARA ELEGUIR AL JUGADOR AL CUAL ATACAR SIEMPRE QUE TENGA MAS DE 0 DE VIDA
    private String[] generarOpcionesAtaque() {
        ArrayList<String> opciones = new ArrayList<>();	//ARRAY LIST DE LAS OPCIONES QUE TIENE EL JUADOR HUMANO
        for (int i = 1; i < CrearPersonajes.personajes.size(); i++) { //INT I=1 PARA QUE SE SALTE A MI JUGADOR QUE ES EL 0
        	if (CrearPersonajes.personajes.get(i).getVida() > 0) {
                opciones.add("Atacar a " + i);
            }
        }
        eliminarJugador();
        return opciones.toArray(new String[0]);
    }
}
