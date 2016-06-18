package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import GUI.EditEventGUI;

public class PopUpEventTable extends JPopupMenu implements ActionListener{

	JMenuItem deletetask;
	 JMenuItem editTask;
	private XML_SQL_Manager ser;
	private EventTableManager evtab;
	
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
			EditEventGUI editev = new EditEventGUI(evtab.gui.getSelectedEvent(evtab.clickedRecord));
			editev.setVisible(true);
		}
	}

}
