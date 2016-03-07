import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class L4ButtonAction extends JButton
{

	/**
	* Method for what happens when the L4 button is selected.
	* @param running		if the on button has been pressed.
	* @author George
	* @version 1.0 (07/03/16)
	*/
	
	public L4ButtonAction()
	{	

		final ImageIcon orangebutton = new ImageIcon("./imgs/3737orange.jpg");
		if(SimoriON.running==false)
		{
			//Nothing should happen
		}

		else if(SimoriON.running==true)
		{	
			
			SimoriON.running = false;
			CustomToggle.loopPointSelect = true;
			new ClearGUI(); //clears the currently selected buttons
			
			//select vertical line

			//print index to text box

			//
			
		}
	}
}
