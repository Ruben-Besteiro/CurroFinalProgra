package CurroFinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuJuego {			// Todo esto es hecho por Jaime

	private JFrame ventana;	//PARA LA VENTANA
	public static JPanel Panel;	//PARA EL PANEL
	private JButton ModoJuego; // BOTÓN PARA EL MODO DE JUEGO
	
	//CONSTRUCTOR
	public MenuJuego() {
		Ventana();
		añadir();
	}

	//METODOS
	//PANTALLA
	public void Ventana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//PARA OBTENER LAS MEDIDAS MAXIMAS DE LA PANTALLA
        
		ventana = new JFrame();	//VENTANA
		ventana.setSize(screenSize.width, screenSize.height);	//CON TAMAÑO MAXIMO EN ANCHURA Y ALTURA
		ventana.getContentPane().setBackground(Color.BLACK);	//COLOR DE FONDO DEL MENU
		ventana.setVisible(true);	//HAGO VISIBLE LA VENTANA
		
		System.out.println("Ancho de pantalla: " + screenSize.width);
	    System.out.println("Alto de pantalla: " + screenSize.height);
	}
	
	//AÑADIR BOTONES Y DEMAS
	public void añadir() {
		Panel = new JPanel();
		Panel.setBackground(Color.BLACK);
		Panel.setLayout(null);	//DESACTIVO ESTO PARA PODER USAR POSICIONES PERSONALIZADAS
		
		botones();	//AÑADO LOS BOTONES AL PANEL
		
		ventana.add(Panel);		//AÑADO EL PANEL A LA VENTANA "MENU"
	}
	
	//BOTONES DE INICIO Y TODO
	public void botones() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //TAMAÑO DE LA PANTALLA
		
		JButton exitb = new JButton("EXIT");	//BOTON CON SU TEXTO EN EL
		exitb.setBackground(Color.WHITE);	//cOLOR FONDO BOTON
		exitb.setForeground(Color.RED); //COLOR TEXTO
		exitb.setFont(new Font("Arial", Font.BOLD, 22));	
		exitb.setBounds(50, 50, 150, 50); //POSICION DEL BOTON DE SALIR
		
		// AÑADIR UN EVENTO DE ACCIÓN PARA EL BOTÓN
	    exitb.addActionListener(e -> System.exit(0)); // CERRAR LA APLICACIÓN
		
		//CALCULO LA POSICION DEL BOTON PARA QUE SE COLOQUE A LA IZQUIERDA ABAJO
        int buttonX = screenSize.width - 150 - 120; //PARA CALCULAR LA POSI
        int buttonY = screenSize.height - 50 - 120; 
        
        //BOTON DE INSTRUCCIONES
        JButton instrucciones = new JButton("?");
        instrucciones.setBackground(Color.WHITE);
		instrucciones.setForeground(Color.RED);
		instrucciones.setFont(new Font("Arial", Font.BOLD, 22));	
		
        //CALCULO LA POSICION DEL BOTON DE INSTRUCCIONES PARA QUE SE COLOQUE EN LA ESQUINA SUPERIOR DERECHA
        int instruccionesX = screenSize.width - 50 - 150; //MARGEN DE 150 PIXELES (DERECHA)
        int instruccionesY = 75; //MARGEN DE 75 PIXELES A LA PARTE SUPERIOR

        instrucciones.setBounds(instruccionesX, instruccionesY, 150, 60); // Ajustar tamaño y posición del botón
        
        //BOTON PARA EL MODO DE JUEGO
        ModoJuego = new JButton("MODO DE JUEGO"); //INICIALIZO, POR QUE LO HE DECLARADO COMO ATRIBUTO PARA HACER METODOS CON EL
        ModoJuego.setBackground(Color.WHITE);
        ModoJuego.setForeground(Color.RED);
        ModoJuego.setFont(new Font("Arial", Font.BOLD, 22));	
        
        //POSICION DEL BOTON  DE MODO DE JUEGO EN PANTALLA
        int buttonWidth = 250;
        int buttonHeight = 100;
        int buttonXX = (screenSize.width - buttonWidth) / 2; //CENTRO CON EL EJE X
        int buttonYY = (screenSize.height - buttonHeight) / 2; //CENTRO CON EL EJE Y

        ModoJuego.setBounds(buttonXX, buttonYY, buttonWidth, buttonHeight);
		
		Panel.add(exitb);
		Panel.add(ModoJuego);
		Panel.add(instrucciones);
	
		//PARA QUE FUNCIONE UN BOTON DE MODO DE JUEGO
		ModoJuego.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mostrarBotones();
			}
		});
		
		//PARA QUE FUNCIONE EL BOTON DE INSTRUCCIONES
		instrucciones.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            //MENSAJE AL DARLE AL BOTON DE ?
	            javax.swing.JOptionPane.showMessageDialog(ventana, 
	                "Cómo jugar:\n" +
	                "1. Selecciona un modo de juego (SOLO, DUO o SQUAD).\n" +
	                "2. Sigue las reglas del modo seleccionado.\n" +
	                "3. ¡Disfruta del juego!\n\n" +
	                "Diviértete y buena suerte.", 
	                "Instrucciones", 
	                javax.swing.JOptionPane.INFORMATION_MESSAGE);
	        }
	    });
		
		
	}
	
	public void mostrarBotones() {	//ESTE METODO ES PARA QUE CUANDO SE PULSE EL BOTON DE MODO DE JUEGO APAREZCAN ESTOS TRES BOTONES QUE SON LOS MODOS DE JUEGO QUE HAY 
	    //PARA CUADRAR LOS BOTONES
	    int centralX = ModoJuego.getX();
	    int centralY = ModoJuego.getY();
	    int centralWidth = ModoJuego.getWidth();
	    int centralHeight = ModoJuego.getHeight();

	    //BOTONES DE SOLO, DUO Y SQUAD EN EL PUNTO CORRECTIO
	    JButton soloB = new JButton("SOLO");
	    soloB.setBounds(centralX, centralY + centralHeight + 10, centralWidth, 50);
	    soloB.setBackground(Color.GRAY);
	    soloB.setForeground(Color.BLUE);
	  
	    //AQUI TENDRIA QUE IR LA PARTE DE RUBI DEL MENU Q ESTA ABAJO
	    
	    JButton duoB = new JButton("DUO");
	    duoB.setBounds(centralX, centralY + centralHeight + 70, centralWidth, 50);
	    duoB.setBackground(Color.GRAY);
	    duoB.setForeground(Color.BLUE);

	    JButton squadB = new JButton("SQUAD");
	    squadB.setBounds(centralX, centralY + centralHeight + 130, centralWidth, 50);
	    squadB.setBackground(Color.GRAY);
	    squadB.setForeground(Color.BLUE);

	    //AÑADO LOS BOTONES DE SOLO, DUO Y SQUAD
	    Panel.add(soloB);
	    Panel.add(duoB);
	    Panel.add(squadB);
	    
	    //LES DOY FUNCION DE CAMBIAR LA PANTALLA
		soloB.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	JOptionPane.showMessageDialog(null, "Has elegido el modo solo, por lo que habrá 1 jugador humano y 15 bots");
	        	CrearPersonajes.CreacionDePersonajes(1);
	        	cambiarPantalla();
	        }
		});
		
		duoB.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	JOptionPane.showMessageDialog(null, "Has elegido el modo dúo, por lo que habrá 2 jugadores humanos y 14 bots");
	        	CrearPersonajes.CreacionDePersonajes(2);
	        	cambiarPantalla();
	        }
		});
		
		squadB.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	JOptionPane.showMessageDialog(null, "Has elegido el modo squad, por lo que habrá 4 jugadores humanos y 12 bots");
	        	CrearPersonajes.CreacionDePersonajes(2);
	        	cambiarPantalla();
	        }
		});

	    //ACTUALIZO EL PANEL PARA QUE SE MUESTREN LOS BOTONES DE SOLO, DUO Y SQUAD
	    Panel.revalidate();
	    Panel.repaint();
	}
	
	//METODO PARA CAMBIAR DE PANTALLA
		public void cambiarPantalla() {
			Panel.removeAll();	
			new ModoSolo();//LIMPIAMOS LA PANTALLA
			
		}
	
}


/*soloB.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		CrearPersonajes.CreacionDePersonajes();             // Aquí pasa a ejecutarse lo de Rubi
	}
});
*/