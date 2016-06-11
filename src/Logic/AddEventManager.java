package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import Data.EventRepository;
import GUI.AddEventGUI;
import Logic.XML_SQL_Manager;
import tgrkKompo.Event;

public class AddEventManager implements ActionListener{

	AddEventGUI gui;
	XML_SQL_Manager ser;
	
	public AddEventManager(AddEventGUI gui)
	{
		this.gui = gui;
		ser = gui.ser;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == gui.addButton)	
		{
			System.out.println(gui.getEvent().toString());
			XML_SQL_Manager.addEvent(gui.getEvent());
			gui.cal.refreshCalendar();
		}
	}

}
