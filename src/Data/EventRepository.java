package Data;

import java.io.Serializable;
import java.util.ArrayList;

import tgrkKompo.Event;

/**
 * Klasa repozytorium wydarze�, przechowuje ona list� wydarze� oraz implementuje serializator do serializacji XML
 *
 */
public class EventRepository implements Serializable{

	/**
	 * Lista wydarze� aplikacji
	 */
	public ArrayList<Event> eventList = new ArrayList<Event>();
	
	/**
	 * Metoda nadpisuj�ca list� wydarze�, list� pobrana z parametru
	 * @param evs - lista wydarze�
	 */
	public void addEvents(ArrayList<Event> evs)
	{
		eventList = evs;
	}
	/**
	 * Pobranie wydarze� wszystkich obiekt�w z repozytorium
	 * @return lista wydarze�
	 */
	public ArrayList<Event> getEventsArrayList()
	{
		return eventList;
	}
	
}
