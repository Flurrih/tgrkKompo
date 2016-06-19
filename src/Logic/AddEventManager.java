package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import javax.swing.JOptionPane;

import Data.EventRepository;
import GUI.AddEventGUI;
import Logic.XML_SQL_Manager;
import tgrkKompo.Event;

/**
 * Handler i logika dla klasy AddEventGUI
 *
 */
public class AddEventManager implements ActionListener{

	/**
	 * Instancja okna AddEventGUI
	 */
	AddEventGUI gui;
	/**
	 * Instancja serializatora
	 */
	XML_SQL_Manager ser;
	
	/**
	 * Konstruktor klasy
	 * @param gui - obiekt okna AddEvent
	 */
	public AddEventManager(AddEventGUI gui)
	{
		this.gui = gui;
		ser = gui.ser;
	}
	/**
	 * ActionListener handler
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == gui.addButton)	
		{
			System.out.println(gui.getEvent().toString());
			XML_SQL_Manager.addEventSQL(gui.getEvent());
			gui.cal.refreshCalendar();
			gui.cal.app.evtab.updateData();
			gui.cal.app.evtab.updateUI();
		}
	}

}
