import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

/**
* The LayerThread class represents the threads which in turn represents the layers in the program.
* 
* @param args        arguments provided from the command line
* @author Jack L & George
* @version 1.0 (07/02/16)
*/
    	
public class LayerThread implements Runnable   {
    
	/**
	* a no argument constructor that creates an instance of a thread, that represents a layer.
	* @author Jack L & George 
 	* @version 1.0 (08/02/16)
	*/
	public LayerThread() {
		
	}

	/**
	* Method that starts the Tenori-on by creating an instance of a LayerThread
	* @author Jack L & George 
	* @version 1.0 (08/02/16)
	*/
	public void start() {
		new Thread(new LayerThread()).start();
	}


	/**
	* Method that does a majority of the work. It loops through the arrays and plays the relevant sounds.
	* 
	* @author Jack L & George
 	* @version 1.0 (09/02/16)
	* @Override
	*/
	public void run(){
		// TODO Auto-generated method stub
		//Creates new music player
		MusicPlayer sound = new MusicPlayer();
		while (SimoriON.running==true) {
			//Loop through the X-axis of the grid j represents the x co-ordinate
			//the third toggle buttons from the left represent the co-ordinate j = 2
			outerLoop:
			for (int j = 0; j < 16; j++){
				//ArrayList used to store the note value of which toggle buttons are On in this x column
				ArrayList<Integer> chord = new ArrayList<Integer>();
				//Loop through the y-axis of the grid i represents the y co-ordinate
				//the third toggle buttons from the bottom represent the co-ordinate i = 2
				for (int i = 0; i < 16; i++){
				
					//problem with metronome:
					// if a button is selected in rows 1,6,11,16 then it gets unselected every loop but still plays
					//method for unselecting buttons in column 16 is wank
					//need a method to check if button is selected, if it is when metronome goes through it dont unselect
					//auto deselects [0][15],[5][15],[10][15],[15][15]
					//cba to think about it properly but if i think of a solution ill put it here
					//someone neaten/rewrite music player
					
					if (i % 5 == 0 && SimoriON.running == true) {

						SimoriON.buttonArray[i][j].setSelected(true);
					} else if (SimoriON.running==false) {
						break outerLoop;
					}
							
					//if the toggle button is turned on then add it's note value to a chord (ArrayList)
					if (SimoriON.boolArr[i][j] == true && SimoriON.running == true) {
						chord.add(15-i);						
					}
					else if(SimoriON.running==false){
						break outerLoop;
					}
				}

				//Try to play the resulting chord
				try {
					sound.playChord(chord);
				} catch (MidiUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidMidiDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				chord.clear();
				for (int i = 0; i < 4; i++) {
					SimoriON.buttonArray[i * 5][j].setSelected(false);
				}
				for (int i = 0; i < 16; i++) {
					if (SimoriON.boolArr[i][j] == true) {
						SimoriON.buttonArray[i][j].setSelected(true);
					}
				}
			}
		}
	}    		
}
