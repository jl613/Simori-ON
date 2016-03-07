import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class ONButtonAction extends JButton
{
	/**
	* Method for what happens when the ON button is selected.
	* @param running		if the on button has been pressed.
	* @author Billy & Jack N
	* @version 1.0 (20/02/16)
	*/
	
	public ONButtonAction(final boolean running)
	{	
		final ImageIcon orangebutton = new ImageIcon("./imgs/3737orange.jpg");
		if(SimoriON.running==false)
		{
			//for each button in the grid of toggle buttons
			new ClearGUI();
			SimoriON.running=true;
			for (int i = 0; i < 16; i++) {
				LayerThread layer = new LayerThread();
				layer.start();
				layer.layerNo = i + 1;
				SimoriON.layers.add(layer);
			}
		}

		else if(SimoriON.running==true)
		{	
			//turn off all buttons/threads
			new ClearGUI();
			SimoriON.running=false;
		}
	}
}


























