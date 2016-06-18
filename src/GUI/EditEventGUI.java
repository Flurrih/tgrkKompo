package GUI;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import com.toedter.calendar.JDateChooser;

import Logic.EditEventManager;
import Logic.EventTableManager;

public class EditEventGUI extends JFrame{
	JLabel name1= new JLabel("Name: ");
	JLabel description1=new JLabel("Description: ");
	JLabel place1=new JLabel("Place: ");
	JLabel date1=new JLabel("Date: ");
	TextField name;
	TextField description;
	TextField place;
	JComboBox day;
	JComboBox month;
	JComboBox year;
	JDateChooser chose;
	JButton edittask;
	JApplet app;
	EventTableManager eventTable;
	Object[] selectedEvent;
	public EditEventGUI(Object[] object){
		
		super();
		selectedEvent = object;
	 	//this.eventsTable = eventsTable;
		edittask=new JButton("Edit");
		
		//Date date = new Date("01-"+"January"+"-"+1990);
		setLayout(new GridLayout(0,1,1,1));
		name=new TextField();
		description=new TextField();
		place= new TextField();
		chose=new JDateChooser();
		edittask.addActionListener((ActionListener) new EditEventManager());
		
			   
		add(name1);
		add(name);
		add(description1);
		add(description);
		add(place1);
		add(place);
		add(date1);
		add(chose);
		add(edittask);
		setSize(400,600);
		setVisible(false);
		//chose.setDate(date);
		
		
		if(selectedEvent != null)
		{
			name.setText((String) selectedEvent[0]);
			description.setText((String) selectedEvent[1]);
			place.setText((String) selectedEvent[2]);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				chose.setDate(df.parse((String) selectedEvent[3]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
