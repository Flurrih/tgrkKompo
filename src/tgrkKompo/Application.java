package tgrkKompo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import Data.EventRepository;
import GUI.*;
import Logic.CalendarManager;
import Logic.XML_SQL_Manager;

public class Application extends JApplet implements KeyListener{
	
	public JTabbedPane mainPane = new JTabbedPane();
	EventRepository evRepo = new EventRepository();
	public XML_SQL_Manager ser = new XML_SQL_Manager(evRepo);
	public CalendarGUI cale=new CalendarGUI(this,evRepo);
	public EventTableGUI evtab;
	public AddEventGUI addev;
	public FilterTableGUI filter;
	public Boolean alertsChecked = false;
	public MainMenu main= new MainMenu(this);
	
	public void init(){
		addev = new AddEventGUI(ser,cale);
		evtab =  new EventTableGUI(ser);
		filter = new FilterTableGUI(ser);
		setSize(500,500);
		mainPane.add("Main menu", main);
		mainPane.add("Calendar", cale);
		mainPane.add("Add Task", addev);
		mainPane.add("Events", evtab);
		mainPane.add("Filter", filter);
		mainPane.add("About", new AboutGUI());
		mainPane.addKeyListener(this);
		mainPane.addMouseListener(new CalendarManager(cale));
		//mainPane.add("Week 9", new Week9());
		add(mainPane);
	}
	
	public void selectTab(int i)
	{
		mainPane.setSelectedIndex(i);
	}

	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() ==KeyEvent.VK_1)
		{
			mainPane.setSelectedIndex(0);
		}
		if(arg0.getKeyCode() ==KeyEvent.VK_2)
		{
			mainPane.setSelectedIndex(1);
		}
		if(arg0.getKeyCode() ==KeyEvent.VK_3)
		{
			mainPane.setSelectedIndex(2);
		}
		if(arg0.getKeyCode() ==KeyEvent.VK_4)
		{
			mainPane.setSelectedIndex(3);
		}
		if(arg0.getKeyCode() ==KeyEvent.VK_5)
		{
			mainPane.setSelectedIndex(4);
		}
		if(arg0.getKeyCode() ==KeyEvent.VK_6)
		{
			mainPane.setSelectedIndex(5);
		}
	
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}


	
	
		
}
