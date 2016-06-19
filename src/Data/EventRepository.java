package Data;

import java.io.Serializable;
import java.util.ArrayList;

import tgrkKompo.Event;

/**
 * Klasa repozytorium wydarzeñ, przechowuje ona listê wydarzeñ oraz implementuje serializator do serializacji XML
 *
 */
public class EventRepository implements Serializable{

	/**
	 * Lista wydarzeñ aplikacji
	 */
	public ArrayList<Event> eventList = new ArrayList<Event>();
	
	/**
	 * Metoda nadpisuj¹ca listê wydarzeñ, list¹ pobrana z parametru
	 * @param evs - lista wydarzeñ
	 */
	public void addEvents(ArrayList<Event> evs)
	{
		eventList = evs;
	}
	/**
	 * Pobranie wydarzeñ wszystkich obiektów z repozytorium
	 * @return lista wydarzeñ
	 */
	public ArrayList<Event> getEventsArrayList()
	{
		return eventList;
	}
	
}
