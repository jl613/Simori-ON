import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class L3ButtonAction extends JButton
{

	/**
	* Method for what happens when the L3 button is selected.
	* @param running		if the on button has been pressed.
	* @author Jack L && George
	* @version 1.0 (20/02/16)
	*/
	public L3ButtonAction()
	{	

		if(SimoriON.running==false)
		{
			//Nothing should happen
		}

		else if(SimoriON.running==true)
		{	
			
			SimoriON.running = false;
			CustomToggle.loopSpeedSelect = true;
			new ClearGUI(); //clears the currently selected buttons
			
			
		}
	}
}
