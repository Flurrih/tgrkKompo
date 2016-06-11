package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpCalendar extends JPopupMenu implements ActionListener {

	
	 JMenuItem addtask;
	 JMenuItem showtasks;
	 PopUpCalendar()
	 {
			showtasks=new JMenuItem("Show Tasks");
	       	add(showtasks);
	 }
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
