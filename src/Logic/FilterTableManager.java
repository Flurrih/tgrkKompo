package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GUI.FilterTableGUI;

/**
 * Handler i logika dla FilterTableGUI
 *
 */
public class FilterTableManager extends KeyAdapter implements ItemListener{

	/**
	 * Instancja okna graficznego FilterTableGUI
	 */
	FilterTableGUI gui;
	
	/**
	 * Konstrktor klasy
	 * @param ser - okbiekt serializatora
	 * @param gui - obiekt okna FilterTable
	 */
	public FilterTableManager(XML_SQL_Manager ser, FilterTableGUI gui) {
		this.gui = gui;
	}


	/**
	 * KeyListener handler
	 */
	public void keyReleased(KeyEvent arg0) {
		if(!(arg0.getKeyChar()==27||arg0.getKeyChar()==65535))//this section will execute only when user is editing the JTextField
        {
            gui.updateData(gui.filterString.getText());
            gui.updateUI();
        }
		
	}

	/**
	 * ItemListener handler
	 */
	public void itemStateChanged(ItemEvent arg0) {

			if(gui.choise.getSelectedItem() == "Name")
			{
				gui.selectedChoice = "name";
			}
			if(gui.choise.getSelectedItem() == "Description")
			{
				gui.selectedChoice = "description";
			}
			if(gui.choise.getSelectedItem() == "Place")
			{
				gui.selectedChoice = "place";
			}
			if(gui.choise.getSelectedItem() == "Date")
			{
				gui.selectedChoice = "eventDate";
			}
			if(gui.choise.getSelectedItem() == "Alarm")
			{
				gui.selectedChoice = "eventReminderDate";
			}
		
	}

}
