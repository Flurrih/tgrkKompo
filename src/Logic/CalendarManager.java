package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.util.Date;

import tgrkKompo.Application;

import GUI.CalendarGUI;


public class CalendarManager implements ItemListener,ActionListener{

	CalendarGUI cal;

	
	public CalendarManager(CalendarGUI cal)
	{
		this.cal=cal;
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED)
        {
        	cal.panel2.removeAll();
        	cal.panel2.updateUI();
        	cal.drawCalendar((String)cal.month.getSelectedItem(), (Integer)cal.year.getSelectedItem());
        }
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cal.goBack)
		{
			cal.panel2.removeAll();
			cal.panel2.updateUI();
        	cal.drawCalendar(cal.data.getActualMonth(), cal.data.getActualYear());
			cal.month.setSelectedItem(cal.data.getActualMonth());
			cal.year.setSelectedItem(cal.data.getActualYear());
		}
		
		for(int i=0;i<cal.buttons.size();i++)
		{
			if(e.getSource()==cal.buttons.get(i))
			{
				System.out.println("Dziala");
				Date tmp= new Date(cal.year.getSelectedIndex()+80,cal.month.getSelectedIndex(),i+1);
				cal.app.selectTab(1); 
				
			}
			
		}
		
	}

}
