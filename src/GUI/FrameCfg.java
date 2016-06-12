package GUI;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class FrameCfg extends JFrame {
	Object[] columnNames = {"Zdarzenie",
	        "Opis",
	        "Miejsce",
	        "Data",
	       };

	Object[][] data= {
		    {"Spotkanie", "O prace",
		        "Lodz", "25 maja"},
		       {"Spotkanie", "O prace",
			        "Lodz", "25 maja"},
		   };

	String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };


		JButton nr2;
		JFrame asd;
		JTabbedPane zakladki;
		JComponent zakladka,zakladka1;
		ImageIcon icon ;
		JSplitPane split;
		JTable table;
		JLayeredPane layeredPane;
		JComboBox petList;
		JMenu men;
		JMenuBar menuBar;
		JMenuItem menuItem;
		JSlider slider;
		JProgressBar progres;
		JFileChooser fc;
		
		public FrameCfg()
		{
			setSize(300,300);
			nr2=new JButton("Welcome");
			add(nr2);
			//nr2.addActionListener(this);
			asd = new JFrame("Manu");
			//icon = new ImageIcon();
			layeredPane=new JLayeredPane();
			layeredPane.setPreferredSize(new Dimension(10, 100));
			layeredPane.setBorder(BorderFactory.createTitledBorder(
			                                    "LayaredPane"));
			//JLabel label = createColoredLabel();
			//layeredPane.add(label, new Integer(i));
			zakladki= new JTabbedPane();
			petList = new JComboBox(petStrings);
			
			slider = new JSlider(JSlider.HORIZONTAL,0,100,10);
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(1);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			
			//progres=new JProgressBar(0,10);
			
			fc = new JFileChooser();
			
			table= new JTable(data,columnNames);
			split=new JSplitPane();
			zakladki.add("Kalendarz",split);
			zakladki.add("Zdarzenia",table);
			zakladki.add("Przypomnienia",layeredPane);
			zakladki.add("ComboBox",petList);
			zakladki.add("Czasomierz Ustaw Czas ",slider);
			zakladki.add("Wybierz plik ",fc);
			//zakladki.add("Progress ",progres);
			menuBar = new JMenuBar();
			men = new JMenu("A Menu");
			menuBar.add(men);
			menuItem = new JMenuItem("A text-only menu item");
			men.add(menuItem);
			
			nr2.setToolTipText("Click this");
			
			add(menuBar);
			add(zakladki);
			//add(split);
			
		}



		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==nr2)
			{
				asd.setVisible(true);
			}
		}
}
