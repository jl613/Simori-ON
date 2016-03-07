import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class L2ButtonAction extends JButton
{

	/**
	* Method for what happens when the L2 button is selected.
	* @author Jack L && Billy
	* @version 1.0 (20/02/16)
	*/
	
	public L2ButtonAction()
	{	

		
		if(SimoriON.running==false)
		{
			//Nothing should happen
		}

		else if(SimoriON.running==true)
		{	
			//pause the layer
			SimoriON.running = false;
			//set the toggle boolean 'velocitySelect' as true to begin
			CustomToggle.velocitySelect = true;
			new ClearGUI(); //clears the currently selected buttons
			
			
		}
	}
}
