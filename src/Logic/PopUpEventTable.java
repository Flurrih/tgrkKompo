package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import GUI.EditEventGUI;
/**
 * Klasa odpowiadajaca za mechaniym okna popup dla tabeli wydarzeñ umozliwiajaca ich edycje badz usuniecie
 * */
public class PopUpEventTable extends JPopupMenu implements ActionListener{

	/**Element menu do usuwania*/
	JMenuItem deletetask;
	/**Element menu do edycji*/
	JMenuItem editTask;
	/**Obiekt wykonujacy operacja na bazie danych*/
	private XML_SQL_Manager ser;
	/**Obiekt managera dla tablicy wydarzen*/
	private EventTableManager evtab;
	
	/**G³ówny konstruktor mechanizmu popup dodajacy elementy do listy
	 * @param ser udostepnia nam dostep do wydarzen
	 * @param evtab handler dla tablicy, operacje dla niej*/
	 PopUpEventTable(XML_SQL_Manager ser, EventTableManager evtab)
	 {
		 this.ser = ser;
		 this.evtab = evtab;
		 deletetask=new JMenuItem("Delete task");
	     add(deletetask);
	     deletetask.addActionListener(this);
	     editTask=new JMenuItem("Edit task");
	     add(editTask);
	     editTask.addActionListener(this);
	 }
	 /**Handler dla okna popup
	  * @param arg0 obiekt wydarzenia*/
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==deletetask)
		{
			System.out.println("test");
			ser.deleteTaskSQL(evtab.gui.getSelectedEvent(evtab.clickedRecord));
			evtab.gui.updateData();
			evtab.gui.revalidate();
			evtab.gui.repaint();
		}
		
		if(arg0.getSource()==editTask)
		{
			EditEventGUI editev = new EditEventGUI(ser,evtab);
			editev.setVisible(true);
		}
	}

}
