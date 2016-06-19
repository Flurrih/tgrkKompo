package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import GUI.EditEventGUI;

public class EditEventManager implements ActionListener{

	EditEventGUI gui;
	public EditEventManager(EditEventGUI editEventGUI) {
		this.gui = editEventGUI;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==gui.edittask)
		{
			gui.selectedEvent[0] = gui.name.getText();
			gui.selectedEvent[1] = gui.description.getText();
			gui.selectedEvent[2] = gui.place.getText();
			gui.selectedEvent[3] = DateFormat.getDateInstance().format(gui.chose.getDate()).toString();
			gui.selectedEvent[4] = DateFormat.getDateInstance().format(gui.choseA.getDate()).toString();
			
				//uaktualnienie tego rekordu
			System.out.println(gui.selectedEvent[0] + " " + gui.selectedEvent[1]);
			gui.ser.editEvent(gui.selectedEvent);
			gui.eventTable.gui.updateData();
			gui.dispose();
		}
		
	}

}
