package tgrkKompo;

import javax.swing.JApplet;
import javax.swing.JTabbedPane;

import Data.EventRepository;
import GUI.*;
import Logic.XML_SQL_Manager;

public class Application extends JApplet{
	
	public JTabbedPane mainPane = new JTabbedPane();
	EventRepository evRepo = new EventRepository();
	public XML_SQL_Manager ser = new XML_SQL_Manager(evRepo);
	
	public void init()
	{
		setSize(500,500);
		mainPane.add("Calendar", new CalendarGUI(this,evRepo));
		mainPane.add("Add Task", new AddEventGUI(ser));
		mainPane.add("Events", new EventTableGUI(ser));
		add(mainPane);
	}
	
	public void selectTab(int i)
	{
		System.out.println("dffsdf");
		mainPane.setSelectedIndex(i);
	}
}
