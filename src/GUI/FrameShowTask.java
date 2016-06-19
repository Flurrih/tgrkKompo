package GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tgrkKompo.Event;

import Data.EventRepository;
import Logic.XML_SQL_Manager;
/**
 * Klasa odpowiadajaca za interfejs graficzny uzytkownika 
 * Okno wyswietlajace wydarzenia w dniu kliknietym przez uzytkownika prawym klawiszem myszy w kalendarzu
 * */
public class FrameShowTask extends JFrame {
	
	/**Obiekt daty*/
	private Date data;
	/**Obiekt panelu do ktorego dodajemy elementu*/
	private JPanel panel;
	/**Model tabeli*/
	private DefaultTableModel model ;
	/**Tabela wydarzen*/
	private JTable table;
	/**Obiekt umozliwiajacy nam scrollowanie wydarzen*/
	private JScrollPane js;
	/**Tablica nazw kolumn */
	static Object[] columnNames = {"Event",
        "Description",
        "Place",
        "Data",
        "Alarm",
       };
	/**Obiekt repozytorium wydarzen dajacy nam  dostep do listy wydarzen*/
	public EventRepository evt=new EventRepository();
	/**Obiekt zajmujacy sie obslug¹ bazdy danych*/
	public XML_SQL_Manager ser= new XML_SQL_Manager(evt);
	/**ArrayLista wszystkich wydarzen*/
	public ArrayList<Event> tmp=ser.getAllEventsSQL();
	/**Tablica do konwersji z listy do tablicy*/
	public Object []rows=new Object[5];
	
	/**Konstruktor g³ówny odpowiedzialny za wyswietlenie elementów okna
	 * @param date Obiekt aktualnej daty*/
	public FrameShowTask(Date date)
	{
		super("Your Tasks this day");
		//add(panel);
		setSize(400,300);
		model = new DefaultTableModel(columnNames,0);
		table = new JTable(model);
		js=new JScrollPane(table);
		add(js);
		this.data=date;
		for(int i=0;i<tmp.size();i++)
		{
			if(tmp.get(i).eventDate.equals(data))
			{
				rows[0]=tmp.get(i).name;
				rows[1]=tmp.get(i).description;
				rows[2]=tmp.get(i).place;
				rows[3]=tmp.get(i).eventDate.toString();
				rows[4]=tmp.get(i).eventReminderDate.toString();
				
				model.addRow(rows);
			}
		}
		
		
		setVisible(true);
		
		
	}
}
