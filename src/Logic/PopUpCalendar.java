package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import GUI.FrameShowTask;

public class PopUpCalendar extends JPopupMenu implements ActionListener {

	
	 JMenuItem addtask;
	 JMenuItem showtasks;
	 Date tmp;
	 PopUpCalendar(Date tmp)
	 {
		 	this.tmp=tmp;
			showtasks=new JMenuItem("Show Tasks");
	       	add(showtasks);
	       	showtasks.addActionListener(this);
	 }
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==showtasks)
		{
			FrameShowTask frm= new FrameShowTask(tmp);
		}
		
	}

}
