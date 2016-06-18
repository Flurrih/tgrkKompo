package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import GUI.EventTableGUI;
import tgrkKompo.Event;

public class EventTableManager implements MouseListener, ActionListener{

	XML_SQL_Manager ser;
	public EventTableGUI gui;

	public int clickedRecord = -1;
	
	public EventTableManager(XML_SQL_Manager ser, EventTableGUI gui) {
		this.ser = ser;
		this.gui = gui;
	}

	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getButton()==arg0.BUTTON3)
		{
			clickedRecord = gui.table.rowAtPoint(arg0.getPoint());
			 PopUpEventTable menu = new PopUpEventTable(ser, this);
		     menu.show(arg0.getComponent(), arg0.getX(), arg0.getY());
		}
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == gui.oldButton)
		{
			deleteOldEvents();
		}
		
	}

	
}
