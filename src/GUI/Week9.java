package GUI;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JApplet;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class Week9 extends Applet {
	
	
		
		Choice choice1,choice2;
		Font appFont;
		CheckboxGroup checkboxgroup1;
		static Checkbox checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6;
		
		
		public void paint(Graphics g)
		{
			removeAll();
			String tab[]=new String[3];
			tab[0]="Times New Roman";
			tab[1]="Arial";
			tab[2]="Tahoma";
		
			
			if(osiemnascie==true)
			{	
				if(italic==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.ITALIC, 18);
				}
				if(bold==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.BOLD, 18);
				}
				
				if(bold==false & italic==false)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.PLAIN, 18);
				}
				
				if(bold==true & italic==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.ITALIC | Font.BOLD, 18);
				}
				g.setFont(appFont);
				g.drawString("TEKST probny Java", 30, 100);
			}
			if(dwacztery==true)
			{	
				if(italic==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.ITALIC, 24);
				}
				if(bold==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.BOLD, 24);
				}
				
				if(bold==false & italic==false)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.PLAIN,24);
				}
				
				if(bold==true & italic==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.ITALIC | Font.BOLD, 24); // & and
				}
				
				g.setFont(appFont);
				g.drawString("TEKST probny Java", 30, 100);
			}
			if(trzydwa==true)
			{	
				if(italic==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.ITALIC, 32);
				}
				if(bold==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.BOLD,32);
				}
				
				if(bold==false & italic==false)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.PLAIN, 32);
				}
				
				if(bold==true & italic==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.ITALIC | Font.BOLD, 32);
				}
				g.setFont(appFont);
				g.drawString("TEKST probny Java", 30, 100);
			}
			if(trzyszesc==true)
			{	
				if(italic==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.ITALIC,36);
				}
				if(bold==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.BOLD, 36);
				}
				
				if(bold==false & italic==false)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.PLAIN,36);
				}
				
				if(bold==true & italic==true)
				{
			appFont = new Font(choice1.getSelectedItem(), Font.ITALIC | Font.BOLD, 36);
				}
				
			
				
				
			}
			
				if(kolor==0)g.setColor(Color.green);
				if(kolor==1)g.setColor(Color.red);
				//g.setColor(Color.red);
				g.setFont(appFont);
				g.drawString("TEKST probny Java", 30, 100);
		}
		
		public Week9(){	
		removeAll();
		
		checkboxgroup1 = new CheckboxGroup();
		
		checkbox1 = new Checkbox("18pt", false, checkboxgroup1);
	    add(checkbox1);
	    //checkbox1.addItemListener(this);

	     checkbox2 = new Checkbox("24pt", false, checkboxgroup1);
	    add(checkbox2);
	    //checkbox2.addItemListener((ItemListener) this);

	     checkbox3 = new Checkbox("32pt", false, checkboxgroup1);
	    add(checkbox3);
	    //checkbox3.addItemListener((ItemListener)this);

	     checkbox4 = new Checkbox("36pt", false, checkboxgroup1);
	    add(checkbox4);
	    //checkbox4.addItemListener((ItemListener)this);
	   

	     checkbox5 = new Checkbox("Italic");
	    add(checkbox5);
	    //checkbox5.addItemListener((ItemListener)this);
	    
	     checkbox6 = new Checkbox("Bold");
	    add(checkbox6);
	    //checkbox6.addItemListener((ItemListener)this);
	    
	    
	    choice1 = new Choice();
	    choice1.add("Times New Roman");
	    choice1.add("Arial");
	    choice1.add("Tahoma");
	    add(choice1);
	    
	    
	    choice2 = new Choice();
	    choice2.add("Zielony");
	    choice2.add("Czerwony");
	    add(choice2);
	    
		}
		

		boolean osiemnascie=false,dwacztery=false,trzydwa=false,trzyszesc=false,italic=false,bold=false;
		int czcionka=1;
		int kolor=0;
		
		 public void itemStateChanged(ItemEvent e) 
		 {
			 if(e.getItemSelectable()==checkbox1)
			 {
				 osiemnascie=!osiemnascie;
				 dwacztery=false;
				 trzydwa=false;
				 trzyszesc=false;
			 }
			 
			 if(e.getItemSelectable()==checkbox2)
			 {
				 dwacztery=!dwacztery;
				 osiemnascie=false;
				 trzydwa=false;
				 trzyszesc=false;
			 }
			
			 if(e.getItemSelectable()==checkbox3)
			 {
				 trzydwa=!trzydwa;
				 dwacztery=false;
				 osiemnascie=false;
				 trzyszesc=false;
			 }
			 if(e.getItemSelectable()==checkbox4)
			 {
				 trzyszesc=!trzyszesc;
				 dwacztery=false;
				 osiemnascie=false;
				 trzydwa=false;
			 }
			 
			 if(e.getItemSelectable()==checkbox5)
			 {
				 italic=!italic;
			 }
			 
			 if(e.getItemSelectable()==checkbox6)
			 {
				 bold=!bold;
			 }
			 
			 if(choice2.getSelectedItem()=="Zielony")
				{
						 kolor=0;
				}	 	 
				 
				if(choice2.getSelectedItem()=="Czerwony")
				{
						 kolor=1;
				}	 
			 

			 repaint();
		 }
		 
		
		 
		 
		 
		


}
