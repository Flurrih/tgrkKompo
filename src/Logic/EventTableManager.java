package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import GUI.EventTableGUI;
import tgrkKompo.Event;

/**
 * Handler i logika dla EventTableGUI
 *
 */
public class EventTableManager extends MouseAdapter implements ActionListener{

	/**
	 * Obiekt serializatora 
	 */
	XML_SQL_Manager ser;
	/**
	 * Instancja okna graficznego EventTableGUI
	 */
	public EventTableGUI gui;

	/**
	 * Indeks wybranego wydarzenia (-1 - nie wybrano ¿adnego)
	 */
	public int clickedRecord = -1;
	
	/**
	 * Konstruktor klasy
	 * @param ser - obiekt serializatora
	 * @param gui - obiekt okna EventTable
	 */
	public EventTableManager(XML_SQL_Manager ser, EventTableGUI gui) {
		this.ser = ser;
		this.gui = gui;
	}

	/**
	 * MouseAdapter handler
	 */
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getButton()==arg0.BUTTON3)
		{
			clickedRecord = gui.table.rowAtPoint(arg0.getPoint());
			 PopUpEventTable menu = new PopUpEventTable(ser, this);
		     menu.show(arg0.getComponent(), arg0.getX(), arg0.getY());
		}
		
	}

	/**
	 * Metoda do usuwania wydarzeñ z dat¹ starsz¹ ni¿ aktualny dzieñ
	 */
	public void deleteOldEvents()
	{
		ArrayList<Event> events = ser.getAllEventsSQL();
		Date date = new Date();
		date.setDate(date.getDate()-1);
		for(int i = 0; i < events.size(); i++)
		{
			if(events.get(i).eventDate.before(date))
			{
				ser.deleteTaskSQL(events.get(i));
				gui.updateData();
				gui.updateUI();
			}
		}
	}

	/**
	 * ActionListener handler
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == gui.oldButton)
		{
			deleteOldEvents();
		}
		
	}

	
}
