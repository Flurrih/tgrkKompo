package Data;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;

/**
 * Obiekt repozytorium sta³ych wartoœci np. nag³owki tabel i kalendarza
 *
 */
public class DataRepository {
	/**
	 * Obiekt aktualnej daty
	 */
    private Date date = new Date();
    /**
     * aktualny dzieñ
     */
    private int actualday=date.getDate()-1;
    /**
     * daktualny rok
     */
    private int actualyear=1900+date.getYear();
    /**
     * liczba dni ka¿dego miesi¹ca
     */
    private int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    /**
     * Nazwy dni tygodnia
     */
    private String weekdays[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; 
    /**
     * Nazwy miesiêcy
     */
    private String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    /**
     * aktualny miesi¹c
     */
    private String actualmonth=months[date.getMonth()];
    
    /**
     * Kolumny tabeli EventTable
     */
	private Object[] columnNames = {"Event",
	        "Description",
	        "Place",
	        "Event Date",
	        "Alarm Date",
	       };

	/**
	 * Metoda odpowiedzalna za pobranie nazwy kolumn dla tabeli EventTable
	 * @return tablica nag³ówków tabeli
	 */
    public Object[] getColumnsTable()
    {
    	return columnNames;
    }
    /**
     * Pobranie daty
     * @return data aktualnego dnia
     */
    public Date getDate()
    {
    	return date;
    }
    /**
     * Pobranie aktualnego dnia
     * @return aktualny dzien]ñ
     */
    public int getActualDay()
    {
    	return actualday;
    }    
    /**
     * Pobranie aktualnego miesi¹ca
     * @return aktualny miesi¹c
     */
    public String getActualMonth()
    {
    	return actualmonth;
    }
    /**
     * Pobranie aktualnego roku
     * @return aktualny rok
     */
    public int getActualYear()
    {
    	return actualyear;
    }
    /**
     * Pobranie aktualnego dnia
     * @return aktualny dzien
     */
    public int[] getDay()
    {
    	return days;
    }
    /**
     * Pobranie stringa dla danego dnia tygodnia
     * @param i - indeks dnia tygodnia
     * @return nazwa dnia
     */
    public String getWeekDay(int i)
    {
    	return weekdays[i];
    }
    /**
     * Pobranie stringa dla danego miesi¹ca
     * @param i - indeks miesi¹ca
     * @return nazwa miesi¹ca
     */
    public String getMonth(int i)
    {
    	return months[i];
    }
    /**
     * Pobranie tablicy z nazwami tygodnia
     * @return tablica nazw tygodnia
     */
    public String[] getWeekDays()
    {
    	return weekdays;
    }
    /**
     * Pobranie tablicy z nazwami miesi¹ca
     * @return tablica nazw miesi¹ca
     */
    public String[] getMonths()
    {
    	return months;
    }
    
    /**
     * Pobranie liczby dni danego miesi¹ca
     * @param i - indeks miesi¹ca
     * @return liczba dni miesi¹ca
     */
    public int getMonthLen(int i)
    {
    	return days[i];
    }

}
