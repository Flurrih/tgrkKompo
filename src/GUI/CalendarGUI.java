package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Data.DataRepository;
import Logic.*;
import tgrkKompo.Application;

public class CalendarGUI extends JPanel  {

	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();

    JComboBox month = new JComboBox();
    JComboBox year = new JComboBox();
   
    DataRepository data = new DataRepository();

    //static Application app;
    
    public CalendarGUI(Application app)
    {
        for(int i=0;i< data.getMonths().length;i++)
        {
            month.addItem(data.getMonth(i));
        }
        month.addItemListener(new CalendarManager());
        for(int i=1980;i<=2099;i++)
        {
        	
            year.addItem(new Integer(i));
       
        }
        year.addItemListener(new CalendarManager());
        
        
        panel.add(month);
        panel.add(year);
        

    }
    
}