import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class selectRowCol extends JButton
{
	/**
	* Select every button in the row and column of the selected button
	* @author Billy & Jack N
	* @version 1.0 (20/02/16)
	*/
	public final ImageIcon orangebutton = new ImageIcon("./imgs/3737orange.jpg");


	public selectRowCol( final int iCoord, final int jCoord){

		//System.out.println(SimoriON.buttonArray);
		new ClearGUI();
		for (int j = 0; j < 16; j++){
			for (int i = 0; i < 16; i++){
				SimoriON.buttonArray[i][jCoord].setPressedIcon(orangebutton);
				SimoriON.buttonArray[i][jCoord].setSelectedIcon(orangebutton);
				SimoriON.buttonArray[i][jCoord].setSelected(true);
				
			}
			SimoriON.buttonArray[iCoord][j].setPressedIcon(orangebutton);
			SimoriON.buttonArray[iCoord][j].setSelectedIcon(orangebutton);
			SimoriON.buttonArray[iCoord][j].setSelected(true);	
		}
				
	}
}
