package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Logic.AddEventManager;
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
	JDateChooser chose= new JDateChooser();
	JLabel hour= new JLabel("       Hour: ");
	JComboBox hourT=new JComboBox();
	JLabel minutes= new JLabel("        Minutes: ");
	JComboBox minutesT=new JComboBox();
	
	
	JLabel empty=new JLabel("                ");
	
	//alarm
	JLabel alarm= new JLabel("Alarm:            ");
	JDateChooser choseAlarm= new JDateChooser();
	JLabel hourA=new JLabel("       Hour: ");
	JComboBox hourAL=new JComboBox();
	JLabel minutesA= new JLabel("        Minutes: ");
	JComboBox minutesAL=new JComboBox();
	
	public JButton addButton = new JButton("Add Event");

	

	public AddEventGUI(){
		
	addButton.addActionListener((ActionListener) new AddEventManager(this));

	//setBackground(Color.red);
	//super();
	hourT.addItem("---");
	hourAL.addItem("---");
	for(int i=0;i<24;i++)
	{
		
		if(i==23) 
			{
			hourT.addItem("00");
			hourAL.addItem("00");
			}
		else {
			hourT.addItem(i+1);
			hourAL.addItem(i+1);
		}
	}
	minutesT.addItem("---");
	minutesAL.addItem("---");
	for(int i=0;i<60;i++)
	{
		
		if(i<10){minutesT.addItem("0"+i);
		minutesAL.addItem("0"+i);
		}
		else {minutesT.addItem(i);
		minutesAL.addItem(i);
		}
	}
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
	add(hour);
	add(hourT);
	add(minutes);
	add(minutesT);
	add(empty);
	add(alarm);
	add(choseAlarm);
	add(hourA);
	add(hourAL);
	add(minutesA);
	add(minutesAL);
	add(addButton);
	
	}
	
	public Event getEvent()
	{
		Date d1 = new Date();
		Date d2 = new Date();
		
		d1 = chose.getDate();
		d1.setHours((int) hourT.getSelectedItem());
		//d1.setMinutes((int) minutesT.getSelectedItem());
		return new Event(nameT.getText(), descriptionT.getText(), placeT.getText(), chose.getDate(), choseAlarm.getDate());
	}
	
}
