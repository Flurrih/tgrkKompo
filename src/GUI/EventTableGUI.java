package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.DataRepository;
import Data.EventRepository;
import Logic.EventTableManager;
import Logic.XML_SQL_Manager;
import tgrkKompo.Event;


/**
 * Klasa odpowiadajaca za interfejs graficzny uzytkownika 
 * Panel wyswietlajacy tabele wydarzen
 * */
public class EventTableGUI extends JPanel{
	/**Obiekt tabeli do ktorej dodajemy eventy*/
	public JTable table;
	/**Obiekt udostepniajacy nam scrollowanie*/
	JScrollPane js;
	/**Obiekt klasy odpowiedzialnej ze polaczenia z baza danych i operacje na niej*/
	XML_SQL_Manager ser;
	/**Model tabeli*/
	DefaultTableModel model ;
	/**Obiekt przycisku usuwajacy stare wydarzenia*/
	public JButton oldButton;
	/**Manager tabeli*/
	EventTableManager evtab;
	/**Tablica kwadratowa przechowujaca dane do wyswietlanie*/
	Object[][] tmp;
	
	/**Konstruktor g³ówny odpowiedzialny za dodawanie tabeli i danych do tabeli
	 * @param ser obiekt udostepniajacy nam liste wydarzen*/
	public EventTableGUI(XML_SQL_Manager ser)
	{
		
				super();
				oldButton = new JButton("oldButton");
				//add(new JLabel("Sort By: "));
				//choise.addItem("Name ");
				//choise.addItem("Description ");
				//choise.addItem("Place");
				//choise.addItem("Data");
				//choise.addItem("Alarm");
				///add(choise);
				///choise.addActionListener(this);
				tmp=ser.getEventsArray();
				
				evtab = new EventTableManager(ser, this);
				model = new DefaultTableModel(tmp, new DataRepository().getColumnsTable());
				table = new JTable(model);
				js=new JScrollPane(table);
				add(js);
				oldButton.addActionListener((ActionListener) evtab);
				add(oldButton);

				//e1.eventsTable = this;
				table.addMouseListener((MouseListener) evtab);
				this.ser = ser;
				System.out.println(ser.getEventsArray().length);
				
				
	}
	/**Metoda do odswiezania tabeli*/
	public void updateData() {
		//js.removeAll();
		model = new DefaultTableModel(ser.getEventsArray(), new DataRepository().getColumnsTable());
		table.setModel(model);
		table.addMouseListener((MouseListener) new EventTableManager(ser, this));
		//js=new JScrollPane(table);
		//add(js);
		
	}

	/*public void addNewEvent(Event event) {
		
		model = (DefaultTableModel) table.getModel();
		//model.addRow(new Object[]{event.name,event.description,event.place,DateFormat.getDateInstance().format(event.date).toString()});
		
	}*/

		
	
	
	/**Metoda zwracajaca element wybrany prawym klawiszem myszy*/
	public Object[] getSelectedEvent(int clickedRecord)
	{
		System.out.println(model.getValueAt(clickedRecord, 0));
		Object[] obj = {model.getValueAt(clickedRecord, 0), model.getValueAt(clickedRecord, 1) , 
				model.getValueAt(clickedRecord, 2) , model.getValueAt(clickedRecord, 3), model.getValueAt(clickedRecord, 4) };
		return obj;
	}

	
	
}
