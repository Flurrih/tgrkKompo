package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.AddEventGUI;
import tgrkKompo.Event;

public class AddEventManager implements ActionListener{

	AddEventGUI gui;
	
	public AddEventManager(AddEventGUI gui)
	{
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == gui.addButton)	
		{
			System.out.println(gui.getEvent().toString());
		}
	}

}
