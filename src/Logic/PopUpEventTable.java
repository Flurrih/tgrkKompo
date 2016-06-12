package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpEventTable extends JPopupMenu implements ActionListener{

	JMenuItem deletetask;
	 JMenuItem oldtasks;
	private XML_SQL_Manager ser;
	private EventTableManager evtab;
	
	 PopUpEventTable(XML_SQL_Manager ser, EventTableManager evtab)
	 {
		 this.ser = ser;
		 this.evtab = evtab;
		 deletetask=new JMenuItem("Delete task");
	     add(deletetask);
	     deletetask.addActionListener(this);
	     oldtasks=new JMenuItem("Remove old tasks");
	     add(oldtasks);
	     oldtasks.addActionListener(this);
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
		
		if(arg0.getSource()==oldtasks)
		{
			System.out.println("test");
			evtab.deleteOldEvents();
		}
	}

}
