package Data;

import java.util.ArrayList;

import tgrkKompo.Event;

public class EventRepository {

	public ArrayList<Event> eventList = new ArrayList<Event>();
	
	public void addEvents(ArrayList<Event> evs)
	{
		eventList = evs;
	}
	
	public ArrayList<Event> getEventsArrayList()
	{
		return eventList;
	}
	
}
