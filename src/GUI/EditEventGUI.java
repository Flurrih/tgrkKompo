package GUI;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import com.toedter.calendar.JDateChooser;

import Logic.EditEventManager;
import Logic.EventTableManager;
import Logic.XML_SQL_Manager;
/**
 * Klasa odpowiadajaca za interfejs graficzny uzytkownika 
 * Okno Edycji wydarzenia
 * */
public class EditEventGUI extends JFrame{
	/** Etykieta Name wskazujaca na nazwe */
	private JLabel name1= new JLabel("Name: ");
	/** Etykieta Description wskazujaca na opis */
	private JLabel description1=new JLabel("Description: ");
	/** Etykieta Place wskazujaca na miejsce */
	private JLabel place1=new JLabel("Place: ");
	/** Etykieta EventDate wskazujaca na date wydarzenia*/
	private JLabel date1=new JLabel("Event Date: ");
	/** Etykieta EventAlarm wskazujaca na date alarmu*/
	private JLabel dateA=new JLabel("Alarm Date: ");
	/**Pole tekstowe nazwy wydarzenia*/
	public TextField name;
	/**Pole tekstowe opisu wydarzenia*/
	public TextField description;
	/**Pole tekstowe miejsca wydarzenia*/
	public TextField place;
	
	/**Obiekt kalendarza do wyboru daty wydarzenia*/
	public JDateChooser chose;
	
	/**Obiekt kalendarza do wyboru daty alarmu dla wydarzenia*/
	public JDateChooser choseA;
	
	/**Obiekt przycisku realizujacy edycje*/
	public JButton edittask;
	/**Obiekt realizujacy edycje tablicy wydarzen*/
	public EventTableManager eventTable;
	/**Tablica przechowujaca obiekty eventow*/
	public Object[] selectedEvent;
	/**Obiekt klasy odpowiedzialnej ze polaczenia z baza danych i operacje na niej*/
	public XML_SQL_Manager ser;
	
	/**Konstruktor g³ówny edycji wydarzenia zmieniajacy wydarzenia w tabeli
	 * @param ser dostêp do danych bazy
	 * @param eventTable wprowadzanie zmian w tabeli*/
	public EditEventGUI(XML_SQL_Manager ser,EventTableManager eventTable){
		
		super();
		this.eventTable = eventTable;
		this.ser = ser;
		selectedEvent = eventTable.gui.getSelectedEvent(eventTable.clickedRecord);
	 	//this.eventsTable = eventsTable;
		edittask=new JButton("Edit");
		
		//Date date = new Date("01-"+"January"+"-"+1990);
		setLayout(new GridLayout(0,1,1,1));
		name=new TextField();
		description=new TextField();
		place= new TextField();
		chose=new JDateChooser();
		choseA = new JDateChooser();
		edittask.addActionListener((ActionListener) new EditEventManager(this));
		
			   
		add(name1);
		add(name);
		add(description1);
		add(description);
		add(place1);
		add(place);
		add(date1);
		add(chose);
		add(dateA);
		add(choseA);
		add(edittask);
		setSize(400,600);
		setVisible(false);
		//chose.setDate(date);
		
		
		if(selectedEvent != null)
		{
			name.setText((String) selectedEvent[0]);
			description.setText((String) selectedEvent[1]);
			place.setText((String) selectedEvent[2]);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				chose.setDate(df.parse((String) selectedEvent[3]));
				choseA.setDate(df.parse((String) selectedEvent[4]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
