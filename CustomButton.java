import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*; 

/**
* The CustomButton class extends the JButton class. It represents a button in the GUI.
* 
* @author Billy & Jack N 
 * @version 1.0 (07/02/16)
*
*/
public class CustomButton extends JButton
{
	/**
	* This one-argument constructor creates an instance of a button.
	* @param name		the name of the button.
	* @author Billy & Jack N
	* @version 1.0 (07/02/16)
	*/
	
	public final ImageIcon orangebutton = new ImageIcon("./imgs/3737orange.jpg");
	public final ImageIcon emptybutton = new ImageIcon("./imgs/3737empty.jpg");
	
	public CustomButton(final String name)
	{
		ImageIcon buttonImage = new ImageIcon("./imgs/" + name + ".jpg");
		this.setRolloverIcon(new ImageIcon("./imgs/" + name + "2.jpg"));
		this.setIcon(buttonImage);
		this.setForeground(Color.BLACK);
		this.setBackground(Color.BLACK);
		this.setBorder(new LineBorder(Color.WHITE, 0));
		this.addActionListener(new ActionListener()
		{
			/**
			* Method that determines whether an action has been performed.
			* If an action has been performed then the value of the variable running is changed to true. 
			* @param ae        the event that is triggered when a button is pressed.
			* @author Billy 
			* @version 1.0 (10/02/16)
			*/
			public void actionPerformed(ActionEvent ae)
			{	
				if(name == "ON"){
					new ONButtonAction(SimoriON.running);
				}
				else if(name== "L1"){
					new L1ButtonAction();
				}
				else if(name== "L2"){
					new L2ButtonAction();
				
				}
				else if(name== "L3"){
					new L3ButtonAction();
				}
				else if(name== "L4"){
					new L4ButtonAction();
				}
				else if(name== "R1"){
					new R1ButtonAction();
				}
				else if(name== "R2"){
				
				}
				else if(name== "R3"){
				
				}
				else if(name== "R4"){
				
				}
				else if(name== "OK"){
					new OKButtonAction();
				}
				
			}	
		});
	}
}

