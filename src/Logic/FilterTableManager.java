package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GUI.FilterTableGUI;

public class FilterTableManager implements KeyListener{

	FilterTableGUI gui;
	public FilterTableManager(XML_SQL_Manager ser, FilterTableGUI gui) {
		this.gui = gui;
	}



	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(!(arg0.getKeyChar()==27||arg0.getKeyChar()==65535))//this section will execute only when user is editing the JTextField
        {
            gui.updateData(gui.filterString.getText());
            gui.updateUI();
        }
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
