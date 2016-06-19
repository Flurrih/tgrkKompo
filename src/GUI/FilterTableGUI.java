package GUI;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Data.DataRepository;
import Logic.EventTableManager;
import Logic.FilterTableManager;
import Logic.XML_SQL_Manager;


/**
 * Klasa odpowiadajaca za interfejs graficzny uzytkownika 
 * Okno Filtrowania wydarzen
 * */
public class FilterTableGUI extends JPanel{
	
	/**Obiekt tablicy wydarzen*/
	public JTable filterTable;
	/**Obiekt udostepniajacy nam scrollowanie*/
	JScrollPane js;
	/**Lista wyboru elementu po ktorym sortujemy*/
	public JComboBox choise= new JComboBox();
	/**Etykieta Sort By: Wskazujaca na wybrany element sortowania*/
	JLabel filter= new JLabel("Sort By: ");
	/**Obiekt klasy odpowiedzialnej ze polaczenia z baza danych i operacje na niej*/
	XML_SQL_Manager ser;
	/**Model tabeli*/
	DefaultTableModel model ;
	/**Manager tabeli filtrowania zawierajaca handlery*/
	FilterTableManager filtermanager;
	/**Pole tekstowe na wpisywane dane do filtrowania*/
	public JTextField filterString= new JTextField(35);
	/**Obiekt tekstu*/
	public String selectedChoice;
	/**Konstruktow g³ówny dodajacy dane do tabeli w zaleznosci od wybranych opcji i wpisanego textu
	 * @param ser obiekt udostepniajacy nam liste wydarzen
	 *  */
	public FilterTableGUI(XML_SQL_Manager ser)
	{
		
				super();
				selectedChoice = "Name";
				filterString.addKeyListener((KeyListener) new FilterTableManager(ser, this));
				add(filter);
				choise.addItem("Name");
				choise.addItem("Description");
				choise.addItem("Place");
				choise.addItem("Date");
				choise.addItem("Alarm");
				choise.addItemListener((ItemListener) new FilterTableManager(ser, this));
				filtermanager = new FilterTableManager(ser, this);
				model = null;
				filterTable = new JTable(model);
				js=new JScrollPane(filterTable);
				add(choise);
				add(filterString);
				add(js);
				//e1.eventsTable = this;
				this.ser = ser;
	}
	/**Metoda odswiezajaca nasza tabele
	 * @param name wyszukiwanie po nazwie*/
	public void updateData(String name) {
		//js.removeAll();
		//filterTable.removeAll();
		model = new DefaultTableModel(ser.findEventsBy(selectedChoice,name), new DataRepository().getColumnsTable());
		filterTable.setModel(model);
		//js = new JScrollPane(filterTable);
		//add(js);
	}
	
}
