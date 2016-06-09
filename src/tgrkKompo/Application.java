package tgrkKompo;

import javax.swing.JApplet;
import javax.swing.JTabbedPane;

import GUI.*;

public class Application extends JApplet{
	public JTabbedPane mainPane = new JTabbedPane();
	
	public void init()
	{
		setSize(500,500);
		mainPane.add("Calendar", new CalendarGUI(this));
		add(mainPane);
	}
	
	void selectTab(int i)
	{
		mainPane.setSelectedIndex(i);
	}
}
