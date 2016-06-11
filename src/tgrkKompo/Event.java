package tgrkKompo;

import java.text.DateFormat;
import java.util.Date;

public class Event {

	public String name;
	public String description;
	public String place;
	public Date eventDate;
	public Date eventReminderDate;
	
	public Event(String name,String desc,String place,Date eventDate, Date eventReminderDate)
	{
		this.name = name;
		this.description = desc;
		this.place = place;
		this.eventDate = eventDate;
		this.eventReminderDate = eventReminderDate;
	}

	public String toString()
	{
		return name + " " + description + " " + place + " " +
				eventDate.toString() + " " + 
				eventReminderDate.toString();
	}

}
