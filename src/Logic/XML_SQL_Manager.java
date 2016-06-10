package Logic;

import Data.EventRepository;
import tgrkKompo.Event;

public class XML_SQL_Manager {
	static int choice = 1;
	
	static EventRepository repo;
	
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
			SQLManager.addEvent(event);
		}
		else if(choice == 2) // XML
		{
			XmlManager.addEvent(event);
		}
		update();
	}
	
	public static void update()
	{
		if(choice == 1)// SQL default
		{ 
			XmlManager.updateData(repo.getEvents());
		}
		else if(choice == 2) // XML
		{
			SQLManager.updateData(repo.getEvents());
		}
	}
}
