import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

/**
* The CustomToggle class extends JToggleButton. It represents a toggle button in the GUI.
*
* @author Billy & Jack N
* @version 1.0 (10/02/16)
*
*/
public class CustomToggle extends JToggleButton
{
	public static boolean instrumentSelect = false; //used to check whether the user wants to select a new instrument
	public static boolean velocitySelect = false; //used to check whether the user wants to select a new velocity
	public static boolean loopSpeedSelect = false; //used to check whether the user wants to select a new speed
	public static boolean loopPointSelect = false; // used to check whether the user wants to select a new loop point
	public static boolean selectLayer = false; // used to check whether the user wants to select a different layer

	/**
	* This two-argument constructor creates instances with custom size and colour.
	*
	* @param i 	x cooridinate of the button's postion in the grid.
	* @param j 	y cooridinate of the button's postion in the grid.
	* @author Billy & Jack N
	* @version 1.0 (09/02/16)
	*/
	
	public final ImageIcon orangebutton = new ImageIcon("./imgs/3737orange.jpg");
	public final ImageIcon emptybutton = new ImageIcon("./imgs/3737empty.jpg");
	
	public CustomToggle(final int i, final int j)
	{
		this.setPreferredSize(new Dimension(37, 37));
		this.setForeground(Color.WHITE);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.WHITE, 0));
		this.setIcon(emptybutton);	 
		this.setPressedIcon(emptybutton);
		this.setSelectedIcon(orangebutton);   	
	   	this.setBorderPainted(false);
		
		this.addActionListener(new ActionListener()	
	        {
			public void actionPerformed(ActionEvent ae)
			{
				JToggleButton toggledbtn = (JToggleButton) ae.getSource();
				if(SimoriON.running==true)				
				{
					SimoriON.boolArr[i][j] = false;
					if (toggledbtn.isSelected()) 
					{
						SimoriON.boolArr[i][j] = true;
					}

				//if the layer isn't currently running then perform checks on whether the users has pressed any L or R buttons
				} else if (SimoriON.running==false) {
					//is user choosing instrument
					if (instrumentSelect == true) {
						new selectRowCol(i , j);
						OKButtonAction.instrument = j + 1 + (i * 16);
					//is user choosing velocity
					} else if (velocitySelect == true) {
						new selectRowCol(i, j);
						OKButtonAction.velocity = j + 1 + (i * 16);
					//is user choosing loop speed
					} else if (loopSpeedSelect == true) {
						new selectRowCol(i, j);
						OKButtonAction.loopSpeed = j + 1 + (i * 16);
					//if none of the variables are being edited then immediately deselect the toggle button
					} else if (loopPointSelect == true) {
						new selectCol(j);
					} else if (selectLayer == true) {
						new selectRow(i);
					} else {
						toggledbtn.setSelected(false);
					}

				}	    				
			}
		});
	}
}
