package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

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
	
	public AddEventGUI(){
		
		
		

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
	
	}
	
}
