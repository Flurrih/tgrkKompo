package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.EventRepository;
import Logic.EventTableManager;
import Logic.XML_SQL_Manager;

import tgrkKompo.Application;
import tgrkKompo.Event;


/**Klasa odpowiadajaca za interfejs graficzny uzytkownika
 * Panel g³ówny programu, menu g³ówne
 *  */
public class MainMenu extends JPanel implements ActionListener {

	/**Obiekt przycisku do exportu outlooka**/
	JButton outlook = new JButton("outlook");
	/**Obiekt przycisku przekierywujacy do Kalendarza*/
	JButton cal= new JButton("Calendar");
	/**Obiekt przycisku przekierywujacy do Dodawanie Wydarzenia*/
	JButton adevnt= new JButton("Add Event");
	/**Obiekt przycisku przekierywujacy do Tabeli*/
	JButton table= new JButton("Table");
	/**Obiekt przycisku przekierywujacy do Filtrowania*/
	JButton filter= new JButton("Search Event");
	/**Obiekt przycisku przekierywujacy do panelu About*/
	JButton about= new JButton("About");
	/**Obiekt przycisku pozwalajacy za³adowac plik XML z danymi*/
	JButton loadXML= new JButton("loadXML");
	/**Obiekt przycisku pozwalajacy zapisac plik XML z danymi*/
	JButton saveXML= new JButton("saveXML");
	/**Obiekt g³ówenj klasy programu skupiacej wszystkie komponenty*/
	Application app;
	/**Etykieta nazwy programu*/
	JLabel best=new JLabel("       TGRK Best Organiser");
	
	/**Model tabeli dla alarmów*/
	DefaultTableModel model ;
	/**Obiekt tabeli alarmów*/
	JTable tablee;
	/**Scroll dla alarmow*/
	JScrollPane js;
	/**Tablica nazw kolumn dla alarmów*/
	static Object[] columnNames = {"Event",
        "Description",
        "Place",
        "Data",
       };
	/**Obiekt repozytorium wydarzen*/
	EventRepository evt=new EventRepository();
	/**Obiekt wykonujacy operacje na bazie danych*/
	XML_SQL_Manager ser= new XML_SQL_Manager(evt);
	/**ArrayLista zawierajaca wszystkie wydarzenia*/
	ArrayList<Event> tmp=ser.getAllEventsSQL();
	/**Tablica dla konwersji alarmow do tabeli*/
	Object []rows=new Object[4];
	/**Tablica dla konwersji wydarzen do tabeli*/
	Object []rows1=new Object[3];
	/**Model tabeli wydarzen*/
	DefaultTableModel model1 ;
	/**Tabela dla wydarzen*/
	JTable tablee1;
	/**Scroll dla wydarzen*/
	JScrollPane js1;
	/**Tablica nazw kolumn dla wydarzen*/
	static Object[] columnNames1 = {"Event",
        "Description",
        "Place",
       };
	/**Konstruktor g³ówny wyswietlajacy wszystkie elementy
	 * @param app obiekt g³ównej klasy aplikacji*/
public MainMenu(Application app){
	//super();
	this.app=app;
	//setLayout(new FlowLayout());
	removeAll();
	updateUI();
	best.setFont(new Font("Arial", Font.PLAIN, 36));
	best.setMaximumSize(new Dimension(500,200));
	best.setMinimumSize(new Dimension(500,200));
	best.setPreferredSize(new Dimension(500,100));
	add(best);
	add(cal);
	cal.addActionListener(this);
	add(adevnt);
	adevnt.addActionListener(this);
	add(table);
	table.addActionListener(this);
	add(filter);
	filter.addActionListener(this);
	add(about);
	about.addActionListener(this);
	//add(cfg);
	//cfg.addActionListener(this);
	loadXML.addActionListener(this);
	add(loadXML);
	saveXML.addActionListener(this);
	add(saveXML);
	outlook.addActionListener(this);
	add(outlook);
	
	JLabel talarm=new JLabel("                Today's Alarms");
	talarm.setFont(new Font("Arial", Font.PLAIN, 24));
	talarm.setPreferredSize(new Dimension(400,30));
	add(talarm);
	model = new DefaultTableModel(columnNames,0);
	tablee = new JTable(model);
	js=new JScrollPane(tablee);
	js.setPreferredSize(new Dimension(400,80));
	add(js);
	Date dataa=new Date();
	for(int i=0;i<tmp.size();i++)
	{
		
		
		if(tmp.get(i).eventReminderDate.getDate()==dataa.getDate() && tmp.get(i).eventReminderDate.getMonth()==dataa.getMonth() && tmp.get(i).eventReminderDate.getYear()==dataa.getYear())
		{
		//System.out.println("DZIALA");
		rows[0]=tmp.get(i).name;
		rows[1]=tmp.get(i).description;
		rows[2]=tmp.get(i).place;
		rows[3]=tmp.get(i).eventDate.toString();
			
		model.addRow(rows);
		}
	}
	
	
	
	JLabel tevents=new JLabel("                Today's Events");
	tevents.setFont(new Font("Arial", Font.PLAIN, 24));
	tevents.setPreferredSize(new Dimension(400,30));
	add(tevents);
	model1 = new DefaultTableModel(columnNames1,0);
	tablee1 = new JTable(model1);
	js1=new JScrollPane(tablee1);
	js1.setPreferredSize(new Dimension(400,80));
	add(js1);
	for(int i=0;i<tmp.size();i++)
	{
		
		
		if(tmp.get(i).eventDate.getDate()==dataa.getDate() && tmp.get(i).eventDate.getMonth()==dataa.getMonth() && tmp.get(i).eventDate.getYear()==dataa.getYear())
		{
		rows1[0]=tmp.get(i).name;
		rows1[1]=tmp.get(i).description;
		rows1[2]=tmp.get(i).place;
	
			
		model1.addRow(rows1);
		}
	}
	
	
	
	
	
}

/**Handler dla przyciskow*/
public void actionPerformed(ActionEvent arg0) {
	if(arg0.getSource()==cal)
	{
		app.selectTab(1);
	}
	
	if(arg0.getSource()==adevnt)
	{
		app.selectTab(2);
	}
	if(arg0.getSource()==table)
	{
		app.selectTab(3);
	}
	
	if(arg0.getSource()==filter)
	{
		app.selectTab(4);
	}
	
	if(arg0.getSource()==about)
	{
		app.selectTab(5);
	}

	if(arg0.getSource() == loadXML)
	{
		app.ser.updateFromXML();
		app.evtab.updateData();
		app.evtab.updateUI();
	}
	if(arg0.getSource() == saveXML)
	{
		app.ser.serializeXML();
	}
	if(arg0.getSource() == outlook)
	{
		ser.toOutlook();
	}
}
	
}
