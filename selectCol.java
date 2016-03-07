import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class selectCol extends JButton
{
	/**
	* Select every button in the row and column of the selected button
	* @author Billy & Jack N
	* @version 1.0 (20/02/16)
	*/
	public final ImageIcon orangebutton = new ImageIcon("./imgs/3737orange.jpg");


	public selectCol(final int jCoord){

		new ClearGUI();
		for (int i = 0; i < 16; i++) {

			SimoriON.buttonArray[i][jCoord].setPressedIcon(orangebutton);
			SimoriON.buttonArray[i][jCoord].setSelectedIcon(orangebutton);
			SimoriON.buttonArray[i][jCoord].setSelected(true);	
				
			}

		}
				
	}

