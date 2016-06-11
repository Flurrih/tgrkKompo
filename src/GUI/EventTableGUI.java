package GUI;

import java.awt.event.MouseEvent;
import java.text.DateFormat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.EventRepository;
import Logic.XML_SQL_Manager;
import tgrkKompo.Event;

public class EventTableGUI extends JPanel{

	JTable table;
	int clickedRecord = -1;
	
	JScrollPane js;
	static Object[] columnNames = {"Zdarzenie",
	        "Opis",
	        "Miejsce",
	        "Data",
	        "Data2",
	       };

	XML_SQL_Manager ser;
	//EditTable e1;
	DefaultTableModel model ;
	

	
	public EventTableGUI(XML_SQL_Manager ser)
	{
				super();
				//this.e1=edit;
				
				model = new DefaultTableModel(ser.getEventsArray(), columnNames);
				table = new JTable(model);
				js=new JScrollPane(table);
				add(js);
				//e1.eventsTable = this;
				//table.addMouseListener(this);
				this.ser = ser;
				System.out.println(ser.getEventsArray().length);
				
				
				
	}
	
	public void updateData() {
		System.out.println("ypdate");
		js.removeAll();
		model = new DefaultTableModel(ser.getEventsArray(), columnNames);
		table = new JTable(model);
		//table.addMouseListener(this);
		js=new JScrollPane(table);
		add(js);
	}

	public void addNewEvent(Event event) {
		
		model = (DefaultTableModel) table.getModel();
		//model.addRow(new Object[]{event.name,event.description,event.place,DateFormat.getDateInstance().format(event.date).toString()});
		
	}

	/*public void mouseClicked(MouseEvent arg0) {
		if(arg0.getButton()==arg0.BUTTON3)
		{
				clickedRecord = table.rowAtPoint(arg0.getPoint());
				PopUpEdit menu = new PopUpEdit(this);
		        menu.show(arg0.getComponent(), arg0.getX(), arg0.getY()); 
				Object[] obj = {model.getValueAt(clickedRecord, 0), model.getValueAt(clickedRecord, 1) , 
						model.getValueAt(clickedRecord, 2) , model.getValueAt(clickedRecord, 3) };
			
				if(clickedRecord != -1)
					e1.invokeEditTable(obj);
				
		}
	}*/
		
	

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	public Object[] getSelectedEvent()
	{
		System.out.println(model.getValueAt(clickedRecord, 0));
		Object[] obj = {model.getValueAt(clickedRecord, 0), model.getValueAt(clickedRecord, 0) , 
				model.getValueAt(clickedRecord, 0) , model.getValueAt(clickedRecord, 0) };
		return obj;
	}
}
