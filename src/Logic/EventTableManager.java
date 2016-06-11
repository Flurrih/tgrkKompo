package Logic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.EventTableGUI;

public class EventTableManager implements MouseListener {

	XML_SQL_Manager ser;
	private EventTableGUI gui;
	
	public EventTableManager(XML_SQL_Manager ser, EventTableGUI gui) {
		this.ser = ser;
		this.gui = gui;
	}

	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getButton()==arg0.BUTTON3)
		{
			//System.out.println("dziala :D");
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
	
	

}
