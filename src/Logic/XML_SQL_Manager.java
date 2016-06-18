package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
import tgrkKompo.Event;

public class XML_SQL_Manager {
	static int choice = 1;
	
	static EventRepository repo;
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	
	public void setChoice(int i)
	{
		choice = i;
	}
	
	public XML_SQL_Manager(EventRepository repo)
	{
		this.repo = repo;
		connectToDatabase();
	}
	
	public static void addEvent(Event event)
	{
		if(choice == 1)// SQL default
		{ 
			addEventSQL(event);
		}
		else if(choice == 2) // XML
		{
			//XmlManager.addEvent(event);
		}
		update();
	}
	
	public static void update()
	{
		if(choice == 1)// SQL default
		{ 
			//XmlManager.updateData(repo.getEvents());
		}
		else if(choice == 2) // XML
		{
			//SQLManager.updateData(repo.getEvents());
		}
	}
	
	private static void connectToDatabase()
	{
	    try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/KompoDB?useSSL=false","root", "haslo123");
			stmt = con.createStatement();
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void addEventSQL(Event ev)
	{
		//connectToDatabase();
		try {
			//connectToDatabase();
			
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
		serializeXML();

	}
	
	public static ArrayList<Event> getAllEventsSQL()
	{	
		//connectToDatabase();
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
	
	public static void updateRepoSQL()
	{
		repo.addEvents(getAllEventsSQL());
	}
	
	public static void deleteTaskSQL(Object[] obj)
	{

		try {
			stmt.executeUpdate("DELETE FROM events WHERE name = '" + obj[0] + "'");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		updateRepoSQL();
		serializeXML();
	}
	public static void deleteTaskSQL(Event obj)
	{

		try {
			stmt.executeUpdate("DELETE FROM events WHERE name = '" + obj.name + "'");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		updateRepoSQL();
		serializeXML();
	}
	
	public static Object[][] findEventsByName(String name)
	{
		//connectToDatabase();
		ArrayList<Event> events = new ArrayList<Event>();
		
		try {//LIKE CONCAT('%', keyword, '%')
		    rs = stmt.executeQuery("SELECT * FROM events where name like '%" + name + "%';");
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

	public Object[][] findEventsBy(String selectedChoice, String name) {
		//connectToDatabase();
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
	
	public static ArrayList<Event> getTodaysAlarmsEventsSQL(String date)
	{	
		//connectToDatabase();
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
	
	public static void serializeXML()
	{
      	try 
        {
            XStream xstream = new XStream();
            PrintWriter writer = new PrintWriter(new File("xmltest.xml"));
            writer.print(xstream.toXML((ArrayList<Event>)repo.eventList));
           writer.close();
        }
      	catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
	}
	
	public static ArrayList<Event> deserializeXML()
	{
		ArrayList<Event> events = new ArrayList<Event>();
		try
        { 	
        	XStream xStream = new XStream();
        	events = (ArrayList<Event>) xStream.fromXML(new FileInputStream("xmltest.xml"));
        }
   
        catch (FileNotFoundException ex)
        {
        	ex.printStackTrace();
        }  

		return events;
	}
	
	
}
