import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

/**
* The MusicPlayer class represents the ability to produce music. 
* It provides functionality for playing more than one note at a time.
* 
* @author Jack L & Ollie
* @version 1.0 (09/02/16)
*
*/
public class MusicPlayer {
	public static int instrument = 102; //default instrument piano
	public static int velocity = 80; //default note press set to 80
	public static int loopSpeed = 90; //default beats per minute set at 90
	/**
	* a no argument constructor that is going to be developed further into the project.
	*/
	public MusicPlayer() {

	}
	public void playInstruments( ) {    
	}
	  	
	/**
	* Method that plays a chord when a toggle button is clicked on 
	* 
	* @param chord 				The array that holds the values of the notes to be played in this iteration.
	* @throws MidiUnavailableException 		thrown when the program cannot connect to a midi
	* @throws InvalidMidiDataException 		thrown when the data in the midi is invalid
	* @throws InterruptedException 		thrown when the midi is interrupted
	* @author Jack L & George & Ollie
	* @version 2.0 (23/02/16)
	*
	*/
	public void playChord(ArrayList<Integer> chord) throws MidiUnavailableException,
	InvalidMidiDataException, InterruptedException{
		//Create a new array of Messages
		//each message is one note to send to a receiver
		ShortMessage[] messages = new ShortMessage[chord.size()];
		//create a new synthesizer to generate the type of sound using the ShortMessages
		Synthesizer synthethizer = MidiSystem.getSynthesizer();
		//Opens the connection to the synth
		synthethizer.open();
		//Create a new receiver which the messages are sent to
		Receiver reciever = synthethizer.getReceiver();
	    	velocityCheck();
	    	instrumentCheck();
		//Loops through each note in the Chord ArrayList to initialise the array and set the instrument
		for (int i = 0; i < chord.size(); i++){
			messages[i] = new ShortMessage();
			//set the desired instrument to be played
			messages[i].setMessage(ShortMessage.PROGRAM_CHANGE, 1, instrument, 0);
			//send this instrument data to the receiver
			reciever.send(messages[i], -1);	
		}
		//Loops through and begins playing each note in the chord ArrayList
		for (int i = 0; i < chord.size(); i++){
			//Create a message with the note to be played
			messages[i].setMessage(ShortMessage.NOTE_ON, 1, 60 + chord.get(i), velocity);
			//send this message to the receiver
			reciever.send(messages[i], -1);
		}

		//allows the note some time to play
		Thread.sleep(Math.round(60000/loopSpeed)); //handles the BPM

		//Loops through and begins playing each note in the chord ArrayList
		for (int i = 0; i < chord.size(); i++){
			//Create a message with the note to be player
			messages[i].setMessage(ShortMessage.NOTE_OFF, 1, 60 + chord.get(i), velocity);
			//send this message to the receiver
			reciever.send(messages[i], -1);
		}
		
		//close receiver and synthethizer
		reciever.close();
		synthethizer.close();
	}
	/*
	* Instrument has range 0 - 127
	*/
	public void instrumentCheck() {
		if (instrument > 127) {
			instrument = 127;
		}
	}
	/*
	* velocity has range 0 - 127
	*/
	public void velocityCheck() {
		if (velocity > 127) {
			velocity = 127;
		}
	}
	/*
	* Loop speed has range 0 - 160
	*/
	public void loopSpeedCheck() {
		if (loopSpeed > 160) {
			loopSpeed = 160;
		}
	}
}

