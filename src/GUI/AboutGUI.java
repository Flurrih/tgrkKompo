package GUI;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Klasa odpowiadajaca za interfejs graficzny uzytkownika 
 * Panel About w programie
 */
public class AboutGUI extends JPanel {
	
	/**
	 * Glowny konstruktor bezparametrywowy dodajacy do Panelu etykiety i informacje z nazwiskami tworców
	 */
	public AboutGUI()
	{
		add(new JLabel("Organiser"));
		setLayout(new GridLayout(20,5));
		JTextField rafal= new JTextField(20);
		JTextField tomek= new JTextField(20);
		add(rafal);
		add(tomek);
		rafal.setText("Rafa³ Koper");
		tomek.setText("Tomasz Gabryelewicz");
		rafal.setEditable(false);
		tomek.setEditable(false);
		
		
	}

}
