package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tgrkKompo.Application;

public class MainMenu extends JPanel implements ActionListener {

	JButton cal= new JButton("Calendar");
	JButton adevnt= new JButton("Add Event");
	JButton table= new JButton("Table");
	JButton filter= new JButton("Search Event");
	JButton about= new JButton("About");
	JButton cfg= new JButton("Config");
	JButton loadXML= new JButton("loadXML");
	JButton saveXML= new JButton("saveXML");
	Application app;
	JLabel best=new JLabel("       TGRK Best Organiser");
public MainMenu(Application app){
	super();
	this.app=app;
	//setLayout(new FlowLayout());
	removeAll();
	updateUI();
	best.setFont(new Font("Arial", Font.PLAIN, 36));
	best.setMaximumSize(new Dimension(500,200));
	best.setMinimumSize(new Dimension(500,200));
	best.setPreferredSize(new Dimension(500,200));
	add(best);
	add(cal);
	cal.addActionListener(this);
	add(adevnt);
	adevnt.addActionListener(this);
	add(table);
	table.addActionListener(this);
	add(filter);
	filter.addActionListener(this);
	add(about);
	about.addActionListener(this);
	add(cfg);
	cfg.addActionListener(this);
	loadXML.addActionListener(this);
	add(loadXML);
	saveXML.addActionListener(this);
	add(saveXML);
}
public void actionPerformed(ActionEvent arg0) {
	if(arg0.getSource()==cal)
	{
		app.selectTab(1);
	}
	
	if(arg0.getSource()==adevnt)
	{
		app.selectTab(2);
	}
	if(arg0.getSource()==table)
	{
		app.selectTab(3);
	}
	
	if(arg0.getSource()==filter)
	{
		app.selectTab(4);
	}
	
	if(arg0.getSource()==about)
	{
		app.selectTab(5);
	}
	if(arg0.getSource()==cfg)
	{
		//System.out.println("Dziala");
		FrameCfg asd = new FrameCfg();
		asd.setVisible(true);
	}
	if(arg0.getSource() == loadXML)
	{
		app.ser.updateFromXML();
		app.evtab.updateData();
		app.evtab.updateUI();
	}
	if(arg0.getSource() == saveXML)
	{
		app.ser.serializeXML();
	}
}
	
}
