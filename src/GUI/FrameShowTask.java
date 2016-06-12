package GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tgrkKompo.Event;

import Data.EventRepository;
import Logic.XML_SQL_Manager;

public class FrameShowTask extends JFrame {

	Date data;
	JPanel panel;
	DefaultTableModel model ;
	JTable table;
	JScrollPane js;
	static Object[] columnNames = {"Event",
        "Description",
        "Place",
        "Data",
        "Alarm",
       };
	EventRepository evt=new EventRepository();
	XML_SQL_Manager ser= new XML_SQL_Manager(evt);
	ArrayList<Event> tmp=ser.getAllEventsSQL();
	
	Object []rows=new Object[5];
	
	
	public FrameShowTask(Date date)
	{
		super("Your Tasks this day");
		//add(panel);
		setSize(400,300);
		model = new DefaultTableModel(columnNames,0);
		table = new JTable(model);
		js=new JScrollPane(table);
		add(js);
		this.data=date;
		for(int i=0;i<tmp.size();i++)
		{
			if(tmp.get(i).eventDate.equals(data))
			{
				rows[0]=tmp.get(i).name;
				rows[1]=tmp.get(i).description;
				rows[2]=tmp.get(i).place;
				rows[3]=tmp.get(i).eventDate.toString();
				rows[4]=tmp.get(i).eventReminderDate.toString();
				
				model.addRow(rows);
			}
		}
		
		
		setVisible(true);
		
		
	}
}
