package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Data.EventRepository;
import Logic.AddEventManager;
import Logic.XML_SQL_Manager;
import tgrkKompo.Event;

public class AddEventGUI extends JPanel {
	
	JLabel name= new JLabel("Name:            ");
	JTextField nameT= new JTextField(35);
	JLabel description= new JLabel("Description: ");
	JTextField descriptionT= new JTextField(35);
	JLabel place= new JLabel("Place:            ");
	JTextField placeT= new JTextField(35);
	
	//data
	JLabel data= new JLabel("Data:              ");
	public JDateChooser chose= new JDateChooser();
	
	//alarm
	JLabel alarm= new JLabel("Alarm:            ");
	JDateChooser choseAlarm= new JDateChooser();
	
	public JButton addButton = new JButton("Add Event");

	public  XML_SQL_Manager ser;
	public CalendarGUI cal;
	public AddEventGUI(XML_SQL_Manager ser,CalendarGUI cal){
	this.ser = ser;
	this.cal=cal;
	addButton.addActionListener((ActionListener) new AddEventManager(this));

	//setBackground(Color.red);
	//super();

	setLayout(new FlowLayout(FlowLayout.LEFT));
	add(name);
	add(nameT);
	add(description);
	add(descriptionT);
	add(place);
	add(placeT);
	add(data);
	chose.setSize(10,10);
	add(chose);

	add(alarm);
	add(choseAlarm);

	add(addButton);
	
	}
	
	@SuppressWarnings("deprecation")
	public Event getEvent()
	{
		Date d1 ;
		d1 = chose.getDate();
		//d1.setHours(Integer.parseInt(hourT.getSelectedItem().toString()));
		//d1.setMinutes(Integer.parseInt(minutesT.getSelectedItem().toString()));

		Date d2;
		d2 = choseAlarm.getDate();
		//d2.setHours(Integer.parseInt(hourAL.getSelectedItem().toString()));
		//d2.setMinutes(Integer.parseInt(minutesAL.getSelectedItem().toString()));
		//DateFormat.getInstance().format(d1)
		return new Event(nameT.getText(), descriptionT.getText(), placeT.getText(), d1, d2);
	}
	
	
	
}
