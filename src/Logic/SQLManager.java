package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;

import Data.EventRepository;
import tgrkKompo.Event;

public class SQLManager {
	public static Connection con;
	public static Statement stmt;
	public ResultSet rs;
	EventRepository repo;
	
	public SQLManager(EventRepository repo)
	{
		this.repo = repo;
	}

	
	private static void connectToDatabase() throws SQLException {

	    con = DriverManager.getConnection("jdbc:mysql://localhost/KompoDB?useSSL=false","root", "haslo123");
	    stmt = con.createStatement();
	    
	}
	
	public static void addEvent(Event ev)
	{
		try {
			connectToDatabase();
			stmt.executeUpdate("insert into events (name,description,place,eventDate,eventReminder) values ('" + ev.name +"','" + ev.description + "','" + ev.place + "','" + DateFormat.getDateInstance().format(ev.eventDate) + "','" + DateFormat.getDateInstance().format(ev.eventReminder) +"');");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	public static ArrayList<Event> getAllEvents()
	{
		return null;
	}
	
	public static void updateData(ArrayList<Event> ar)
	{
		
	}
}
