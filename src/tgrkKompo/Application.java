package tgrkKompo;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import Data.EventRepository;
import GUI.*;
import Logic.XML_SQL_Manager;

public class Application extends JApplet{
	
	public JTabbedPane mainPane = new JTabbedPane();
	EventRepository evRepo = new EventRepository();
	public XML_SQL_Manager ser = new XML_SQL_Manager(evRepo);
	public CalendarGUI cale=new CalendarGUI(this,evRepo);
	public EventTableGUI evtab;
	public AddEventGUI addev;
	public FilterTableGUI filter;
	public Boolean alertsChecked = false;
	
	
	public void init(){
		addev = new AddEventGUI(ser,cale);
		evtab =  new EventTableGUI(ser);
		filter = new FilterTableGUI(ser);
		setSize(500,500);
		
		mainPane.add("Calendar", cale);
		mainPane.add("Add Task", addev);
		mainPane.add("Events", evtab);
		mainPane.add("Filter", filter);
		mainPane.add("About", new AboutGUI());
		//mainPane.add("Week 9", new Week9());
		add(mainPane);
	}
	
	public void selectTab(int i)
	{
		//System.out.println("dffsdf");
		mainPane.setSelectedIndex(i);
	}
		
}
