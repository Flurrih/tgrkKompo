package GUI;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Data.DataRepository;
import Logic.EventTableManager;
import Logic.FilterTableManager;
import Logic.XML_SQL_Manager;

public class FilterTableGUI extends JPanel{

	public JTable filterTable;
	JScrollPane js;
	JComboBox choise= new JComboBox();
	JLabel filter= new JLabel("Sort By: ");
	XML_SQL_Manager ser;
	//EditTable e1;
	DefaultTableModel model ;
	
	FilterTableManager filtermanager;
	public JTextField filterString= new JTextField(35);
	
	public FilterTableGUI(XML_SQL_Manager ser)
	{
		
				super();
				
				//filterString.addKeyListener((KeyListener) new FilterTableManager(ser, this));
				add(filter);
				choise.addItem("Name");
				choise.addItem("Description");
				choise.addItem("Place");
				choise.addItem("Date");
				choise.addItem("Alarm");
				filtermanager = new FilterTableManager(ser, this);
				model = null;
				filterTable = new JTable(model);
				js=new JScrollPane(filterTable);
				//add(filterString);
				add(choise);
				add(js);
				//e1.eventsTable = this;
				this.ser = ser;
	}
	
	public void updateData(String name) {
		//js.removeAll();
		//filterTable.removeAll();
		model = new DefaultTableModel(ser.findEventsByName(name), new DataRepository().getColumnsTable());
		filterTable.setModel(model);
		//js = new JScrollPane(filterTable);
		//add(js);
	}
	
}
