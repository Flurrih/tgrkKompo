package tgrkKompo;

import java.text.DateFormat;
import java.util.Date;

public class Event {

	public String name;
	public String description;
	public String place;
	public Date eventDate;
	public Date eventReminderDate;
	private boolean canAlarm;
	
	public Event(String name,String desc,String place,Date eventDate, Date eventReminderDate)
	{
		canAlarm = true;
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
	public String toStringAlarm()
	{
		return "\nName: " +name + " \nDescription: " + description + " \nPlace: " + place + " \nDate: " +
				eventDate.toString();
	}

	public void disableAlarm()
	{
		canAlarm = false;
	}
	public boolean canAlarm()
	{
		return canAlarm;
	}
}
