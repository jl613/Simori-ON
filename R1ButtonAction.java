import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class R1ButtonAction extends JButton
{

	/**
	* Method for what happens when the R1 button is selected.
	* @param running		if the on button has been pressed.
	* @author Jack L
	* @version 1.0 (20/02/16)
	*/
	
	public R1ButtonAction()
	{	

		final ImageIcon orangebutton = new ImageIcon("./imgs/3737orange.jpg");
		if(SimoriON.running==false)
		{
			//Nothing should happen
		}

		else if(SimoriON.running==true)
		{	
			
			SimoriON.running = false;
			CustomToggle.selectLayer = true;
			new ClearGUI(); //clears the currently selected buttons
				
		}
	}
}
