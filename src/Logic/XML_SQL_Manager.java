package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.thoughtworks.xstream.XStream;

import java.sql.Timestamp;

import Data.EventRepository;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Clazz;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;
import tgrkKompo.Event;

/**
 * Klasa odpowiedzialna za wszelkie operacje zwi¹zane z SQL, XML 
 *
 */
public class XML_SQL_Manager {

	/**
	 * statyczne obiekt repozytorium
	 */
	static EventRepository repo;
	/**
	 * statyczny obiekt do ³¹czenia z baz¹ danych
	 */
	public static Connection con;
	/**
	 * statyczny obiekt odpowiedzialny za zapytania do bazy danych
	 */
	public static Statement stmt;
	/**
	 * stayczny obiekt do przechowywania wyniku zapytania SQL
	 */
	public static ResultSet rs;
	

    /**
     * Konstruktor klasy
     * @param repo - instancja repozytorium która przechowywuje wszystkie wydarzenia aplikacji
     */
	public XML_SQL_Manager(EventRepository repo)
	{
		this.repo = repo;
		connectToDatabase();
	}
	
	/**
	 * statyczna metoda do ³¹czenia z baz¹ danych
	 */
	private static void connectToDatabase()
	{
	    try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/KompoDB?useSSL=false","root", "haslo123");
			stmt = con.createStatement();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * statyczna metoda odpowiedzialna za dodawanie pojedynczego wydarzenia
	 * @param ev
	 */
	public static void addEventSQL(Event ev)
	{
		try {			
			stmt.executeUpdate("insert into events (name,description,place,eventDate,eventReminderDate)values ('" 
					+ ev.name +"','" 
					+ ev.description + "','" 
					+ ev.place + "','" 
					+ DateFormat.getDateInstance().format(ev.eventDate) + "','" 
					+ DateFormat.getDateInstance().format(ev.eventReminderDate) 
					+"');");
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		updateRepoSQL();
	}
	/**
	 * Metoda zwracaj¹ca liste wydarzeñ z bazy danych SQL
	 * @return zwraca liste typu Event
	 */
	public static ArrayList<Event> getAllEventsSQL()
	{	
		ArrayList<Event> events = new ArrayList<Event>();
		
		try {
		    rs = stmt.executeQuery("SELECT * FROM events");
		    while (rs.next()) {
		        String n = rs.getString("name");
		        String d = rs.getString("description");
		        String p = rs.getString("place");
		        Date evdat = (Date)rs.getDate("eventDate");
		        Date evrem = (Date)rs.getDate("eventReminderDate");
		        
		        Event event = new Event(n,d,p,evdat,evrem);
		        events.add(event);
		    }
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return events;
	}
	/**
	 * Metoda do edytowania wydarzenia z SQL
	 * @param obj - wydarzenie do edycji
	 */
	public static void editEvent(Object[] obj)
	{

		try {
			stmt.executeUpdate("update events set description = '" + obj[1] + "', place = '" + obj[2] + "', eventDate = '" + obj[3] + "', eventReminderDate = '" + obj[4]
					+ "' where name = '" + obj[0] + "';");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		updateRepoSQL();
	}
	
	/**
	 * Metoda zwracaj¹ca tablice obiektów, ArrayList<Event> jest konwenterowany na Object[][]
	 * @return tablice wydarzeñ
	 */
	public Object[][] getEventsArray()
	{
		updateRepoSQL();
		Object[][] ret = new Object[repo.eventList.size()][5];

		for(int i = 0; i < repo.eventList.size(); i++)
		{
		
			ret[i][0] = repo.eventList.get(i).name;
			ret[i][1] = repo.eventList.get(i).description;
			ret[i][2] = repo.eventList.get(i).place;
			ret[i][3] = repo.eventList.get(i).eventDate.toString();
			ret[i][4] = repo.eventList.get(i).eventReminderDate.toString();
		}
		return ret;
	}
	/**
	 * Metoda przepisuj¹ca wydarzenia z bazy danych do repozytirium
	 */
	public static void updateRepoSQL()
	{
		repo.addEvents(getAllEventsSQL());
	}
	/**
	 * Metoda usuwaj¹ca rekord z bazy danych
	 * @param obj - obiekt do usuniêcia
	 */
	public static void deleteTaskSQL(Object[] obj)
	{

		try {
			stmt.executeUpdate("DELETE FROM events WHERE name = '" + obj[0] + "'");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		updateRepoSQL();
	}
	/**
	 * Metoda usuwaj¹ca rekord z bazy danych
	 * @param obj - obiekt typu Event do usuniêcia
	 */
	public static void deleteTaskSQL(Event obj)
	{
		try {
			stmt.executeUpdate("DELETE FROM events WHERE name = '" + obj.name + "'");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		updateRepoSQL();
	}
	/**
	 * Metoda usuwaj¹ca wszystkie rekordy z bazy danych
	 */
	public static void truncateDB()
	{
		try {
			stmt.executeUpdate("truncate table events");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Metoda do filtrowania wydarzeñ
	 * @param selectedChoice - parametr okreœlaj¹cy po czym filtrujemy np. name, place
	 * @param name - string który jest wyszukiwany w wyrazie
	 * @return przefiltrowana tablica obiektów
	 */
	public Object[][] findEventsBy(String selectedChoice, String name) {
		ArrayList<Event> events = new ArrayList<Event>();
		
		try {
		    rs = stmt.executeQuery("SELECT * FROM events where " + selectedChoice + " like '%" + name + "%';");
		    while (rs.next()) {
		        String n = rs.getString("name");
		        String d = rs.getString("description");
		        String p = rs.getString("place");
		        Date evdat = (Date)rs.getDate("eventDate");
		        Date evrem = (Date)rs.getDate("eventReminderDate");
		        
		        Event event = new Event(n,d,p,evdat,evrem);
		        events.add(event);
		    }
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		Object[][] ret = new Object[events.size()][5];

		
		for(int i = 0; i < events.size(); i++)
		{
		
			ret[i][0] = events.get(i).name;
			ret[i][1] = events.get(i).description;
			ret[i][2] = events.get(i).place;
			ret[i][3] = events.get(i).eventDate.toString();
			ret[i][4] = events.get(i).eventReminderDate.toString();
		}


		return ret;
	}
	/**
	 * MEtoda zwracaj¹ca liste typu Event których data alarmu równa jest z aktualna dat¹
	 * @param date
	 * @return
	 */
	public static ArrayList<Event> getTodaysAlarmsEventsSQL(String date)
	{	
		ArrayList<Event> events = new ArrayList<Event>();
		
		try {
		    rs = stmt.executeQuery("SELECT * FROM events where eventReminderDate = '" + date + "'" );
		    while (rs.next()) {
		        String n = rs.getString("name");
		        String d = rs.getString("description");
		        String p = rs.getString("place");
		        Date evdat = (Date)rs.getDate("eventDate");
		        Date evrem = (Date)rs.getDate("eventReminderDate");
		        
		        Event event = new Event(n,d,p,evdat,evrem);
		        events.add(event);
		    }
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return events;
	}
	/**
	 * Metoda do serializaji listy wydarzeñ do formatu XML. (Export)
	 */
	public static void serializeXML()
	{
      	try 
        {
            XStream xstream = new XStream();
            PrintWriter writer = new PrintWriter(new File("eventsXML.xml"));
            writer.print(xstream.toXML((ArrayList<Event>)repo.eventList));
           writer.close();
        }
      	catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
	}
	
	/**
	 * Metoda do deserializacji wydarzeñ z pliku XML do listy typu Event
	 * @return lista z deserializowanymi wydarzeniami
	 */
	public static ArrayList<Event> deserializeXML()
	{
		ArrayList<Event> events = new ArrayList<Event>();
		try
        { 	
        	XStream xStream = new XStream();
        	events = (ArrayList<Event>) xStream.fromXML(new FileInputStream("eventsXML.xml"));
        }
   
        catch (FileNotFoundException ex)
        {
        	ex.printStackTrace();
        }  

		return events;
	}
	/**
	 * Metoda wypelniaj¹ca liste z repozytorium, wydarzeniami z pliku XML. (Import)
	 */
	public static void updateFromXML()
	{
		ArrayList<Event> events = deserializeXML();
		truncateDB();
		for(int i = 0; i < events.size(); i++ )
		{
			System.out.println(events.get(i).toString());
			addEventSQL(events.get(i));
		}
		updateRepoSQL();
	}
	
	/**
	 * Metoda eksportujaca wydarzenia do formatu Outlook
	 */
	public void toOutlook()
	{
			ArrayList<Event> events = getAllEventsSQL();
			Calendar calendar = new Calendar();
			FileOutputStream fin = null;
	        try {
	             fin = new FileOutputStream(new File( "eventsOutlook.ics"));
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	 
	 
	        DateTime dt = new DateTime(events.get(0).eventDate);
	       
	        for(int i = 0; i < events.size(); i++)
	        {
		        VEvent vEvent = new VEvent(dt, events.get(i).description);
		        vEvent.getProperties().add(Clazz.PUBLIC);
		        vEvent.getProperties().add(new Description(events.get(i).description));
		        vEvent.getAlarms().add(new VAlarm(new DateTime(events.get(i).eventReminderDate)));
		        calendar.getComponents().add(vEvent);		        	
	        }
       
	        calendar.getProperties().add(new ProdId("-//Outlook//EN"));
	        calendar.getProperties().add(Version.VERSION_2_0);
	        calendar.getProperties().add(Method.PUBLISH);
	       
	       
	        CalendarOutputter calendarOutputter = new CalendarOutputter();
	        calendarOutputter.setValidating(false);
	       
	        try {
	            calendarOutputter.output(calendar, fin);
	        } catch (IOException | ValidationException e) {
	            e.printStackTrace();
	        }
	       
	       
	    }
	 
	}