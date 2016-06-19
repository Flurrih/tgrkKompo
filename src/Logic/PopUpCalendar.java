package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import GUI.FrameShowTask;
/**
 * Klasa odpowiadajaca za mechanizm okna popup dla przyciskow kalendarza 
 * */
public class PopUpCalendar extends JPopupMenu implements ActionListener {

	/**Element menu pokazujacy wydarzenia */
	 JMenuItem showtasks;
	 /**Obiekt daty*/
	 Date tmp;
	 /**G³ówny konstruktor okna popup
	  * @param tmp obiekt daty 
	  * */
	 public PopUpCalendar(Date tmp)
	 {
		 	this.tmp=tmp;
			showtasks=new JMenuItem("Show Tasks");
	       	add(showtasks);
	       	showtasks.addActionListener(this);
	 }
	 
	 /**Implementacja handlera 
	  * @param arg0 obiekt wydarzenia*/
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==showtasks)
		{
			FrameShowTask frm= new FrameShowTask(tmp);
		}
		
	}

}
