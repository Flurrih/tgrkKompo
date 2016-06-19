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

/**
 * G³ówna klasa aplikacji, w której tworzymy interfejs panelu
 *
 */
public class Application extends JApplet implements KeyListener{
	
	/**
	 * Obiekt g³ownego palenu aplikacji
	 */
	public JTabbedPane mainPane = new JTabbedPane();
	/**
	 * Obiekt g³ównego repozytorium aplikacji
	 */
	EventRepository evRepo = new EventRepository();
	/**
	 * Obiekt g³ównego serializatora aplikacji
	 */
	public XML_SQL_Manager ser = new XML_SQL_Manager(evRepo);
	/**
	 * Obiekt okna kalendarza
	 */
	public CalendarGUI cale=new CalendarGUI(this,evRepo);
	/**
	 * Obiekt okna z tablic¹ wydarzeñ
	 */
	public EventTableGUI evtab;
	/**
	 * Obiekt okna dodawania wydarzenia
	 */
	public AddEventGUI addev;
	/**
	 * Obiekt okna filtracji wydarzeñ
	 */
	public FilterTableGUI filter;
	/**
	 * Flaga okreœlaj¹ca czy aplikacja wykona³a sprawdzenia alarmu
	 */
	public Boolean alertsChecked = false;
	/**
	 * Obiekt okna menu g³ownego
	 */
	public MainMenu main= new MainMenu(this);
	
	/**
	 * Metoda inicjalizacji panelu graficznego
	 */
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
		add(mainPane);
	}
	
	/**
	 * Metoda zmieniaj¹ca zak³adke panelu aplikacji
	 * @param i - indeks zak³¹dki
	 */
	public void selectTab(int i)
	{
		mainPane.setSelectedIndex(i);
	}

	/**
	 * KeyListener aplikacji
	 */
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
