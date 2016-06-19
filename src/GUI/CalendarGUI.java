package GUI;
import tgrkKompo.Event;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Data.DataRepository;
import Data.EventRepository;
import Logic.*;
import tgrkKompo.Application;

/**
 * Klasa odpowiadajaca za interfejs graficzny uzytkownika 
 * Panel Kalendarza w programie
 * */

public class CalendarGUI extends JPanel  {

	/**Obiekt repozytorium danych na których operujemy */
	public DataRepository data = new DataRepository();
	/**Obiekt Eventow w ktorym mamy dostep do listy eventow */
	public static EventRepository evRepo;
	
	/**Panel dla miesiecy dni i przycisku Go Back*/
	private JPanel panel = new JPanel();
	/**Panel dla przyciskow*/
	public JPanel panel2 = new JPanel();
	/**Lista wyboru miesiaca kalendarza*/
	public JComboBox month = new JComboBox();
    /**Lista wyboru roku kalendarza*/
	public JComboBox year = new JComboBox();
    /**Przycisk Go Back dzieki ktoremu wracamy do aktualenj daty*/
	public JButton goBack= new JButton("Go Back");
    /**Lista przechowujaca wszystkie przyciski w kalendarzu*/
	public ArrayList<JButton> buttons= new ArrayList<JButton>();
    /**Obiekt daty*/
    public Date date; 
    /**Obiekt aplikacji g³ównej klasy skupiajacej wszystkie razem*/
    public static Application app;
    
    /**
     * Konstruktor g³ówny dodajacy wszystkie elementy kalendarza
     * @param app Klasa g³ówna programu
     * @param evRepo dostep do listy wydarzen
     * */
    public CalendarGUI(Application app, EventRepository evRepo)
    {
    	
    	this.evRepo = evRepo;
    	this.app = app;
        for(int i=0;i< data.getMonths().length;i++)
        {
            month.addItem(data.getMonth(i));
        }
        month.addItemListener(new CalendarManager(this));
        for(int i=1980;i<=2099;i++)
        {
        	
            year.addItem(new Integer(i));
       
        }
        year.addItemListener(new CalendarManager(this));
        
        goBack.addActionListener((ActionListener) new CalendarManager(this));
        panel.add(month);
        panel.add(year);
        panel.add(goBack);

        panel2.setLayout(new GridLayout(0,7,10,10));
        Date date = new Date();
        drawCalendar(data.getMonth((date.getMonth())), new Integer((1900+date.getYear())));
        year.setSelectedItem(new Integer((1900+date.getYear())));
        month.setSelectedItem(data.getMonth(date.getMonth()));
        
        add(panel);
        add(panel2);
        setVisible(true);
        //addMouseListener(this);
        setSize(500,600);
    }
    
    /**Metoda g³ówna tworzaca nowy obietk kalendarza*/
        public static void main(String args[])
        {
                	CalendarGUI frame = new CalendarGUI(app,evRepo);
        }
        
        /**Metoda rysujaca kalendarz
         * @param inputMonth wybrany z listy miesiac
         * @param inputYearr wybrany z listy rok
         */
        public void drawCalendar(String inputMonth, Integer inputYearr)
        {
        	
        	 panel2.removeAll();
             panel2.updateUI();
             buttons.clear();
             int inputYear=inputYearr.intValue();
             for(int i=0;i< 7;i++)
             {
                 JLabel label = new JLabel(data.getWeekDay(i));
                 panel2.add(label);
             }
             
             date = new Date("01-"+inputMonth+"-"+inputYear);
             int noOfDaysInMonth = data.getMonthLen(date.getMonth());
             if(date.getYear()%4==0 && date.getMonth()==1)
             {
                 noOfDaysInMonth = 29;
             }
             
             XML_SQL_Manager cnct= new XML_SQL_Manager(evRepo);
            ArrayList<Event> tmp2=cnct.getAllEventsSQL();
           
             for(int i=0;i<=noOfDaysInMonth+1;i++)
             {
          	   
          	   buttons.add(new JButton(String.valueOf(i+1)));
          	   buttons.get(i).addActionListener(new CalendarManager(this));
          	   buttons.get(i).addMouseListener(new CalendarManager(this));
          	   Date tmp= new Date(year.getSelectedIndex()+80,month.getSelectedIndex(),i+1);
          	   
          	   	for(int j=0;j<tmp2.size();j++)
          	   	{
          	   		//System.out.println("lista");
          	   		//System.out.println(tmp2.get(j).date.getDate());
          	   		//System.out.println("tmp");
          	   		//System.out.println(tmp.getDate());
          	   		if(tmp2.get(j).eventDate.compareTo(tmp)==0)
          	   			{
          	   			//System.out.println("ZMIANA KOLORU !!!");
          	   			buttons.get(i).setBackground(Color.blue);}
          	   	}
          	  
             }
          	 for(int i=1, day=1;day<=noOfDaysInMonth;i++)
             {
                 for(int j=0;j<7;j++)
                 { 
                 	
                 	
                     if(day==1)
                     {
                         if(j==date.getDay())
                         {
                            
                             panel2.add(buttons.get(day-1));
                             day++;
                         }
                         else
                         {
                             JLabel label = new JLabel("");
                             panel2.add(label);
                         }
                     }
                     else
                     {
                     	
       
                    	 panel2.add(buttons.get(day-1));
                         day++;
                     }
                     if(day>noOfDaysInMonth)
                     {
                         break;
                     }
                 }
             }
          	 
          	// System.out.println("Wybrany" + year.getSelectedIndex());
            // System.out.println("Aktualny" + data.getActualYear());
             if(month.getSelectedItem()== data.getActualMonth() && year.getSelectedIndex()==(data.getActualYear()-1980))buttons.get(data.getActualDay()).setBackground(Color.RED);
             
             panel2.validate();
          	 

        }
        /**Metoda sluzaca do szybkiego odswiezenia kalendarza*/
        public void refreshCalendar()
        {
        	drawCalendar(data.getMonth((date.getMonth())), new Integer((1900+date.getYear())));
        }
        
    }
    
