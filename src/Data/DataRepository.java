package Data;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;

public class DataRepository {
    private Date date = new Date();
    private int actualday=date.getDate()-1;
    private int actualyear=1900+date.getYear();
    private int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private String weekdays[] = {"Sun", "Mon", "Wto", "Sro", "Czw", "Fri", "Sat"}; 
    private String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String actualmonth=months[date.getMonth()];
    
    public Date getDate()
    {
    	return date;
    }
    public int getActualDay()
    {
    	return actualday;
    }    
    public String getActualMonth()
    {
    	return actualmonth;
    }
    public int getActualYear()
    {
    	return actualyear;
    }
    public int[] getDay()
    {
    	return days;
    }
    public String getWeekDay(int i)
    {
    	return weekdays[i];
    }
    public String getMonth(int i)
    {
    	return months[i];
    }
    public String[] getWeekDays()
    {
    	return weekdays;
    }
    public String[] getMonths()
    {
    	return months;
    }
    
    
    public int getMonthLen(int i)
    {
    	return days[i];
    }

}
