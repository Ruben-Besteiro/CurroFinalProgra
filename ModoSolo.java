package CurroFinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ModoSolo {

	public ModoSolo() {
		
		MenuJuego.Panel.setBackground(Color.BLUE);	//COLOR DE FONDO EL MISMO	
		
		//LOS BOTONES
		JButton boton1 = new JButton("ATACAR");
		boton1.setBackground(Color.WHITE);
		boton1.setForeground(Color.RED);
		boton1.setFont(new Font("Arial", Font.BOLD, 22));	
		boton1.setBounds(100, 100, 200, 50);
		boton1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Personaje pers = new Personaje();
	        	pers.ataque(0);
	        }
		});

		JButton boton2 = new JButton("HABILIDAD");
		boton2.setBackground(Color.WHITE);
		boton2.setForeground(Color.RED);
		boton2.setFont(new Font("Arial", Font.BOLD, 22));	
		boton2.setBounds(100, 200, 200, 50);
		
		//AÁDO LOS BOTONES A LA NUEVA PANTALLA
		MenuJuego.Panel.add(boton1);
		MenuJuego.Panel.add(boton2);
		
		MenuJuego.Panel.revalidate();	//REORGANIZA EL DISEÑO DEL PANEL EN ESTE CASO
		MenuJuego.Panel.repaint();	//ASEGURA QUE SE VEAN LOS CAMBIOS EN PANTALLA
		
		
	}
	
	
}