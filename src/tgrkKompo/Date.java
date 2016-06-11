package tgrkKompo;

public class Date {

	int year,month,day,hour,minute;

	public Date(String year, String month, String day, String hour, String minute)
	{
		this.year = Integer.parseInt(year);
		this.month = Integer.parseInt(month);
		this.day = Integer.parseInt(day);
		this.hour = Integer.parseInt(hour);
		this.minute = Integer.parseInt(minute);
	}
	
	public void setDate(String year, String month, String day, String hour, String minute)
	{
		this.year = Integer.parseInt(year);
		this.month = Integer.parseInt(month);
		this.day = Integer.parseInt(day);
		this.hour = Integer.parseInt(hour);
		this.minute = Integer.parseInt(minute);
	}
	
}
