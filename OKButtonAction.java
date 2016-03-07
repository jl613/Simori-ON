import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

public class OKButtonAction extends JButton {
	/**
	* Method for what happens when the L2 button is selected.
	* @author Jack L
	* @version 1.0 (20/02/16)
	*/
	

	//used to set the value of instrument in music player
	public static int instrument;
	//used to set the value of veloctiy in music player
	public static int velocity;
	//used to set the loops speed in music player
	public static int loopSpeed;
	public OKButtonAction() {

		//if the user is currently selecting an instrument
		if (CustomToggle.instrumentSelect == true) {
			//change the instrument of musicplayer to the chosen one
			MusicPlayer.instrument = instrument;
			//clear the toggle buttons
			new ClearGUI();
			//restart the layer
			SimoriON.running=true;
			SimoriON.layer1.start();
			CustomToggle.instrumentSelect = false;
			
		//if the used is currently selecting velocity	
		} else if (CustomToggle.velocitySelect == true) {
			//change the velocity of the music player to the users chosen veloctiy
			//velocity is the force at which a note is pressed
			MusicPlayer.velocity = velocity;
			//clear the toggle buttons
			new ClearGUI();
			//restart the layer
			SimoriON.running=true;
			SimoriON.layer1.start();
			CustomToggle.velocitySelect = false;

		//if the used is currently selecting loop speed
		} else if (CustomToggle.loopSpeedSelect == true) {
			//change the loop speed of the music player to the users chosen speed
			MusicPlayer.loopSpeed = loopSpeed;
			//clear the toggle buttons
			new ClearGUI();
			//retart the layer
			SimoriON.running=true;
			SimoriON.layer1.start();
			CustomToggle.loopSpeedSelect = false;
		}  else if (CustomToggle.loopPointSelect == true) {
			new ClearGUI();
			SimoriON.running=true;
			SimoriON.layer1.start();
			CustomToggle.loopPointSelect = false;
		} else if (CustomToggle.selectLayer == true) {
			new ClearGUI();
			SimoriON.running=true;
			SimoriON.layer1.start();
			CustomToggle.selectLayer = false;
		}
	}


	
}