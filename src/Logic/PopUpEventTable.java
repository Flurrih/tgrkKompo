package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpEventTable extends JPopupMenu implements ActionListener{

	JMenuItem deletetask;
	 JMenuItem edittask;
	private XML_SQL_Manager ser;
	private EventTableManager evtab;
	
	 PopUpEventTable(XML_SQL_Manager ser, EventTableManager evtab)
	 {
		 this.ser = ser;
		 this.evtab = evtab;
		 deletetask=new JMenuItem("Delete task");
	     add(deletetask);
	     deletetask.addActionListener(this);
	     edittask=new JMenuItem("Edit task");
	     add(edittask);
	     edittask.addActionListener(this);
	 }
	 
	 public void init()
	 {
		 deletetask=new JMenuItem("Delete task");
	     add(deletetask);
	     deletetask.addActionListener(this);
	     edittask=new JMenuItem("Edit task");
	     add(edittask);
	     edittask.addActionListener(this);
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
		
		if(arg0.getSource()==edittask)
		{
			System.out.println("test");
			//ser.deleteTask(asd.getSelectedEvent());
			//asd.updateData();
			//asd.revalidate();
			//asd.repaint();
		}
	}

}
