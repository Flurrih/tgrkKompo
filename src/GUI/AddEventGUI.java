package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Data.EventRepository;
import Logic.AddEventManager;
import Logic.XML_SQL_Manager;
import tgrkKompo.Event;


/**
 * Klasa odpowiadajaca za interfejs graficzny uzytkownika 
 * Panel Add Event w programie
 */
public class AddEventGUI extends JPanel {
	
	/** Etykieta Name wskazujaca na nazwe */
	JLabel name= new JLabel("Name:            ");
	
	/** Pole tekstowe. Miejsce na wpisanie nazwy*/
	JTextField nameT= new JTextField(35);
	
	/** Etykieta Description wskazujaca na opis*/
	JLabel description= new JLabel("Description: ");
	
	/** Pole tekstowe. Miejsce na wpisanie opisu*/
	JTextField descriptionT= new JTextField(35);
	
	/** Etykieta Place wskazujaca na miejsce*/
	JLabel place= new JLabel("Place:            ");
	
	/** Pole tekstowe. Miejsce na wpisanie miejsca wydarzenia*/
	JTextField placeT= new JTextField(35);
	
	/** Etykieta Data wskazujaca na date*/
	JLabel data= new JLabel("Data:              ");
	
	/** Obiekt odpowiedzialny za wybór daty wydarzenia w panelu */
	public JDateChooser chose= new JDateChooser();
	
	/** Etykieta alarm wskazujaca na alarm*/
	JLabel alarm= new JLabel("Alarm:            ");
	
	/** Obiekt odpowiedzialny za wybór daty alarmu w panelu */
	JDateChooser choseAlarm= new JDateChooser();
	
	/** Obiekt przycisku po którym dodajemy event*/
	public JButton addButton = new JButton("Add Event");

	/** Obiekt klasy zajmujacej siê serializacja i równie¿ operacjami na repozytorium bazy */
	public  XML_SQL_Manager ser;
	/** Obiekt customowego kalendarza */
	public CalendarGUI cal;
	/**Konstruktor g³ówny zajmujacy siê dodaniem do panelu przycisków,pól i etykiet
	* @param ser Klasa odpowiedzialna za polaczenia z baza
	* @param cal Klasa kalendarza, potrzebna do odswiezania
	*/
	public AddEventGUI(XML_SQL_Manager ser,CalendarGUI cal){
	this.ser = ser;
	this.cal=cal;
	addButton.addActionListener((ActionListener) new AddEventManager(this));

	//setBackground(Color.red);
	//super();

	setLayout(new FlowLayout(FlowLayout.LEFT));
	add(name);
	add(nameT);
	add(description);
	add(descriptionT);
	add(place);
	add(placeT);
	add(data);
	chose.setSize(10,10);
	add(chose);

	add(alarm);
	add(choseAlarm);

	add(addButton);
	
	}
	
	
	/**Metoda zwaracaj¹ca event dzieki któremu dodajemy go do bazy danych */
	@SuppressWarnings("deprecation")
	public Event getEvent()
	{
		Date d1 ;
		d1 = chose.getDate();
		//d1.setHours(Integer.parseInt(hourT.getSelectedItem().toString()));
		//d1.setMinutes(Integer.parseInt(minutesT.getSelectedItem().toString()));

		Date d2;
		d2 = choseAlarm.getDate();
		//d2.setHours(Integer.parseInt(hourAL.getSelectedItem().toString()));
		//d2.setMinutes(Integer.parseInt(minutesAL.getSelectedItem().toString()));
		//DateFormat.getInstance().format(d1)
		return new Event(nameT.getText(), descriptionT.getText(), placeT.getText(), d1, d2);
	}
	
	
	
}
