package Logic;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import tgrkKompo.Application;
import tgrkKompo.Event;
import GUI.CalendarGUI;

/**
 * Handler oraz logika okna CalendarGUI
 *
 */
public class CalendarManager extends MouseAdapter implements ItemListener,ActionListener{

	/**
	 * Instancja okna graficznego kalendarza
	 */
	CalendarGUI cal;
	/**
	 * Lista alarmów aplikacji
	 */
	ArrayList<Event> alerts;
	
	/**
	 * Konstruktor kalendarza
	 * @param cal - obiekt okna kalendarza
	 */
	public CalendarManager(CalendarGUI cal)
	{
		this.cal=cal;
		alerts = cal.app.ser.getTodaysAlarmsEventsSQL(DateFormat.getDateInstance().format(new Date()));
	}
	/**
	 * ItemListener handler
	 */
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED)
        {
        	cal.panel2.removeAll();
        	cal.panel2.updateUI();
        	cal.drawCalendar((String)cal.month.getSelectedItem(), (Integer)cal.year.getSelectedItem());
        }
		
	}
	/**
	 * ActionListener handler
	 */
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
				cal.app.addev.chose.setDate(tmp);
				cal.app.selectTab(2); 
				
			}
			
		}
     	 

	}
	
	/**
	 * MouseAdapter
	 */
	public void mouseClicked(MouseEvent arg0) {
		for(int i=0;i<cal.buttons.size();i++)
		{
			if(arg0.getSource()==cal.buttons.get(i) && cal.buttons.get(i).getBackground()==Color.blue)
			{
				if(arg0.getButton()==arg0.BUTTON3)
				{
					 Date tmp= new Date(cal.year.getSelectedIndex()+80,cal.month.getSelectedIndex(),i+1);
					 PopUpCalendar menu = new PopUpCalendar(tmp);
				     menu.show(arg0.getComponent(), arg0.getX(), arg0.getY());
				}
			}
		}
		
	}

	/**
	 * TO DEL??????????????????????????????????????????????????????????????????????????????
	 */
	public void mouseEntered(MouseEvent arg0) {
		//JOptionPane.showMessageDialog(null, "My");
		if(cal.app.alertsChecked == false)
			checkAlarm();
		//cal.refreshCalendar();
	}
	/**
	 * TO DEL??????????????????????????????????????????????????????????????????????????????
	 */
	public void mouseExited(MouseEvent arg0) {
		//JOptionPane.showMessageDialog(null, "My");
		
		if(cal.app.alertsChecked == false)
			checkAlarm();
		//cal.refreshCalendar();
		
	}

	/**
	 * Metoda wyœwietlaj¹ca alarmy
	 */
	public void checkAlarm()
	{
		System.out.println(alerts.size());
		cal.app.alertsChecked = true;
		if(alerts.size() > 0)
		{
			for(int i = 0; i < alerts.size(); i++)
			{
				if(alerts.get(i).canAlarm() == true)
				{
					JOptionPane.showMessageDialog(null, "Today's alarm: " + alerts.get(i).toStringAlarm());
					alerts.get(i).disableAlarm();
				}
			}
		}
	}

}
