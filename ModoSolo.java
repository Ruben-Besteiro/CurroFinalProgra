package CurroFinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class ModoSolo {

    // Constructor
    public ModoSolo() {
        cambiarPantalla();
    }

    // Métodos
    public void cambiarPantalla() {

        MenuJuego.Panel.setBackground(Color.BLUE); // COLOR DE FONDO EL MISMO    

        // Botón ATACAR
        JButton boton1 = new JButton("ATACAR");
        boton1.setBackground(Color.WHITE);
        boton1.setForeground(Color.RED);
        boton1.setFont(new Font("Arial", Font.BOLD, 22));    
        boton1.setBounds(100, 100, 200, 50);

        boton1.addActionListener(new ActionListener() { // CUANDO SE PULSE EL BOTON DE SOLO QUE SE VAYA A LA CLASE PERSONAJE Y ATACA
            public void actionPerformed(ActionEvent e) {
                Personaje pers = new Personaje();
                pers.ataque();
            }
        });

        // Botón HABILIDAD
        JButton boton2 = new JButton("HABILIDAD");
        boton2.setBackground(Color.WHITE);
        boton2.setForeground(Color.RED);
        boton2.setFont(new Font("Arial", Font.BOLD, 22));    
        boton2.setBounds(100, 200, 200, 50);

        boton2.addActionListener(new ActionListener() { // CUANDO SE PULSE EL BOTON DE SOLO QUE SE VAYA A LA CLASE PERSONAJE Y ATACA
            public void actionPerformed(ActionEvent e) {
                Personaje pers = new Personaje();
                // FALTA LLAMAR A LO QUE HACE
            }
        });

        // Botón IMPRIMIR PERSONAJES
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

        // Añadir los botones al panel
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
        } else {
            System.out.println("Bot ha elegido habilidad y ha pulsado el boton");
        }
    }
}

