package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		connectToDatabase();
		try {
			//connectToDatabase();
			
			stmt.executeUpdate("insert into events (name,description,place,eventDate,eventReminderDate)values ('" 
					+ ev.name +"','" 
					+ ev.description + "','" 
					+ ev.place + "','" 
					+ ev.eventDate + "','" 
					+ ev.eventReminderDate 
					+"');");
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		updateRepoSQL();
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Event> getAllEventsSQL()
	{	
		connectToDatabase();
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
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return events;
	}
	

	
	public Object[][] getEventsArray()
	{
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
}
