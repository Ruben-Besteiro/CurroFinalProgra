package CurroFinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPausa {

    private JFrame ventana; // PARA LA VENTANA
    private JPanel panel;   // PARA EL PANEL
    private JButton renaudarBoton; // BOTÓN DE REANUDAR
    private JButton salirBoton;    // BOTÓN DE SALIR
    private JButton pausaBoton;    // BOTÓN DE PAUSA

    // CONSTRUCTOR
    public MenuPausa() {
        pantalla();
        añadir();
    }

    // MÉTODOS
    public void pantalla() { // PARA LA CONFIGURACIÓN DE PANTALLA
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // OBTENER LAS MEDIDAS MÁXIMAS DE LA PANTALLA

        ventana = new JFrame(); // VENTANA
        ventana.setSize(screenSize.width, screenSize.height); // TAMAÑO MÁXIMO
        ventana.getContentPane().setBackground(Color.BLACK); // COLOR DE FONDO DEL MENÚ
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // CERRAR CORRECTAMENTE
        ventana.setVisible(true); // HACER VISIBLE LA VENTANA

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null); // DESACTIVAR EL LAYOUT MANAGER
        ventana.add(panel);    // AÑADIR EL PANEL A LA VENTANA
    }

    public void añadir() { // PARA AÑADIR LOS BOTONES
        crearBotonPausa();
        crearBotonRenaudar();
        crearBotonSalir();
        ventana.revalidate(); // ACTUALIZAR EL CONTENIDO
        ventana.repaint();
    }

    // BOTÓN DE PAUSA
    public void crearBotonPausa() {
        pausaBoton = new JButton("PAUSA");
        pausaBoton.setBackground(Color.BLUE);
        pausaBoton.setForeground(Color.WHITE);
        pausaBoton.setFont(new Font("Arial", Font.BOLD, 22));
        pausaBoton.setBounds(100, 100, 200, 50); // POSICIÓN Y TAMAÑO
        
        // AGREGAR ACCIÓN PARA MOSTRAR LOS OTROS BOTONES
        pausaBoton.addActionListener(e -> mostrarBotones());
        
        panel.add(pausaBoton);
    }

    // BOTÓN DE REANUDAR
    public void crearBotonRenaudar() {
        renaudarBoton = new JButton("RENAUDAR");
        renaudarBoton.setBackground(Color.GREEN);
        renaudarBoton.setForeground(Color.WHITE);
        renaudarBoton.setFont(new Font("Arial", Font.BOLD, 22));
        renaudarBoton.setBounds(100, 200, 200, 50); // POSICIÓN Y TAMAÑO
        renaudarBoton.setVisible(false); // INICIALMENTE OCULTO
        panel.add(renaudarBoton);
    }

    // BOTÓN DE SALIR
    public void crearBotonSalir() {
        salirBoton = new JButton("SALIR");
        salirBoton.setBackground(Color.RED);
        salirBoton.setForeground(Color.WHITE);
        salirBoton.setFont(new Font("Arial", Font.BOLD, 22));
        salirBoton.setBounds(100, 300, 200, 50); // POSICIÓN Y TAMAÑO
        salirBoton.setVisible(false); // INICIALMENTE OCULTO
        panel.add(salirBoton);
    }

    // MÉTODO PARA MOSTRAR LOS BOTONES
    public void mostrarBotones() {
        renaudarBoton.setVisible(true); // MOSTRAR EL BOTÓN DE REANUDAR
        salirBoton.setVisible(true);    // MOSTRAR EL BOTÓN DE SALIR
    }
}

