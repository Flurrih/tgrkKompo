package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.DataRepository;
import Data.EventRepository;
import Logic.EventTableManager;
import Logic.XML_SQL_Manager;
import tgrkKompo.Event;

public class EventTableGUI extends JPanel{

	public JTable table;
	
	JScrollPane js;
	JComboBox choise=new JComboBox();
	XML_SQL_Manager ser;
	//EditTable e1;
	DefaultTableModel model ;
	
	EventTableManager evtab;
	Object[][] tmp;
	public EventTableGUI(XML_SQL_Manager ser)
	{
		
				super();
				//add(new JLabel("Sort By: "));
				//choise.addItem("Name ");
				//choise.addItem("Description ");
				//choise.addItem("Place");
				//choise.addItem("Data");
				//choise.addItem("Alarm");
				///add(choise);
				///choise.addActionListener(this);
				tmp=ser.getEventsArray();
				
				evtab = new EventTableManager(ser, this);
				model = new DefaultTableModel(tmp, new DataRepository().getColumnsTable());
				table = new JTable(model);
				js=new JScrollPane(table);
				add(js);
				//e1.eventsTable = this;
				table.addMouseListener((MouseListener) evtab);
				this.ser = ser;
				System.out.println(ser.getEventsArray().length);
				
				
	}
	
	public void updateData() {
		//js.removeAll();
		model = new DefaultTableModel(ser.getEventsArray(), new DataRepository().getColumnsTable());
		table.setModel(model);
		table.addMouseListener((MouseListener) new EventTableManager(ser, this));
		//js=new JScrollPane(table);
		//add(js);
		
	}

	/*public void addNewEvent(Event event) {
		
		model = (DefaultTableModel) table.getModel();
		//model.addRow(new Object[]{event.name,event.description,event.place,DateFormat.getDateInstance().format(event.date).toString()});
		
	}*/

		
	
	

	public Object[] getSelectedEvent(int clickedRecord)
	{
		System.out.println(model.getValueAt(clickedRecord, 0));
		Object[] obj = {model.getValueAt(clickedRecord, 0), model.getValueAt(clickedRecord, 0) , 
				model.getValueAt(clickedRecord, 0) , model.getValueAt(clickedRecord, 0) };
		return obj;
	}

	
	
}
