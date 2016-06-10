package tgrkKompo;

import java.text.DateFormat;
import java.util.Date;

public class Event {

	public String name;
	public String description;
	public String place;
	public Date eventDate;
	public Date eventReminder;
	
	public Event(String name,String desc,String place,Date eventDate, Date eventReminder)
	{
		this.name = name;
		this.description = desc;
		this.place = place;
		this.eventDate = eventDate;
		this.eventReminder = eventReminder;
	}
	
	public String toString()
	{
		return name + " " + description + " " + place + " " + DateFormat.getDateInstance().format(eventDate) + " " + DateFormat.getDateInstance().format(eventReminder);
	}

}
