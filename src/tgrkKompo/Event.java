package tgrkKompo;

import java.text.DateFormat;
import java.util.Date;

/**
 * Klasa kt�ra przechowuje stan pojedynczego obiektu wydarzenia
 *
 */
public class Event {

	/**
	 * nazwa wydarzenia
	 */
	public String name;
	/**
	 * opis wydarzenia
	 */
	public String description;
	/**
	 * lokalizacja wydarzenia
	 */
	public String place;
	/**
	 * data wydarzenia
	 */
	public Date eventDate;
	/**
	 * data alarmu wydarzenia
	 */
	public Date eventReminderDate;
	/**
	 * flaga blokuj�ca alarm
	 */
	private boolean canAlarm;
	
	/**
	 * Konstruktor klasy
	 * @param name - nazwa nowego wydarzenia
	 * @param desc - opis nowego wydarzenia
	 * @param place - lokalizacja nowego wydarzenia
	 * @param eventDate - data nowego wydarzenia
	 * @param eventReminderDate - data alarmu nowego wydarzenia
	 */
	public Event(String name,String desc,String place,Date eventDate, Date eventReminderDate)
	{
		canAlarm = true;
		this.name = name;
		this.description = desc;
		this.place = place;
		this.eventDate = eventDate;
		this.eventReminderDate = eventReminderDate;
	}



	/**
	 * Metoda zwracaj�ca pola obiektu w stringu
	 * @return pola obiektu w pojedynczym stringu
	 */
	public String toString()
	{
		return name + " " + description + " " + place + " " +
				eventDate.toString() + " " + 
				eventReminderDate.toString();
	}
	
	/**
	 * Metoda zwracaj�ca string alarmu sk�adaj�cego si� z p�l obiektu
	 * @return string alarmu
	 */
	public String toStringAlarm()
	{
		return "\nName: " +name + " \nDescription: " + description + " \nPlace: " + place + " \nDate: " +
				eventDate.toString();
	}

	/**
	 * Metoda wy��czaj�ca alarm
	 */
	public void disableAlarm()
	{
		canAlarm = false;
	}
	/**
	 * Metoda sprawdzaj�ca czy obiekt Event mo�e wy�wietla� alarm
	 * @return warto�� logiczna alarmu (0 - wy��czony, 1- w��czony)
	 */
	public boolean canAlarm()
	{
		return canAlarm;
	}
}
