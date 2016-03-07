import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class L1ButtonAction extends JButton
{

	/**
	* Method for what happens when the L1 button is selected.
	* @param running		if the on button has been pressed.
	* @author Billy & Jack N
	* @version 1.0 (20/02/16)
	*/
	
	public L1ButtonAction()
	{	

		if(SimoriON.running==false)
		{
			//Nothing should happen
		}

		else if(SimoriON.running==true)
		{	
			
			SimoriON.running = false;
			CustomToggle.instrumentSelect = true;
			System.out.println(SimoriON.running);
			new ClearGUI();
			
			
		}
	}
}
