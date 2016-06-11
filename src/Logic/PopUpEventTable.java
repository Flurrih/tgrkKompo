package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpEventTable extends JPopupMenu implements ActionListener{

	JMenuItem deletetask;
	 JMenuItem edittask;
	private XML_SQL_Manager ser;
	
	 PopUpEventTable(XML_SQL_Manager ser, EventTableManager evtab)
	 {
		 this.ser = ser;
		 deletetask=new JMenuItem("Delete task");
	     add(deletetask);
	     edittask=new JMenuItem("Edit task");
	     add(edittask);
	 }
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==deletetask)
		{
			//ser.deleteTask(asd.getSelectedEvent());
			//asd.updateData();
			//asd.revalidate();
			//asd.repaint();
		}
	}

}
