import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class ClearGUI extends JButton
{
	/**
	* Clear the GUI.
	* @author Billy & Jack N
	* @version 1.0 (20/02/16)
	*/
	
	public ClearGUI(){
		
		for (int j = 0; j < 16; j++){
			for (int i = 0; i < 16; i++){
				//SimoriON.boolArr[i][j] = false;
				SimoriON.buttonArray[i][j].setSelected(false);
			}
		}	
	}
}
