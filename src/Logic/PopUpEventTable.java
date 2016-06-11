package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpEventTable extends JPopupMenu implements ActionListener{

	JMenuItem deletetask;
	 JMenuItem edittask;
	
	 PopUpEventTable()
	 {
		 
		 deletetask=new JMenuItem("Delete task");
	     add(deletetask);
	     edittask=new JMenuItem("Edit task");
	     add(edittask);
	 }
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
