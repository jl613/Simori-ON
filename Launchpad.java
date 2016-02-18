import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * The Launchpad class inherits from JFrame. It creates the GUI and implements threads that play the sound. 
 * @author Billy  && Jack N
 * @version 1.0 (05/02/16)
 *
 */
public class Launchpad extends JFrame{
	
	boolean[][] boolArr = new boolean[16][16]; //used to store the live or off values for each button
	private static int gridSize = 16;
	private CustomButton l1;
	private CustomButton l2;
	private CustomButton l3;
	private CustomButton l4;
	private CustomButton r1;
	private CustomButton r2;
	private CustomButton r3;
	private CustomButton r4;
	private CustomButton ok;
	private CustomButton on;
	private CustomToggle matrixBut;
	protected JTextField textField;
	private boolean running = false;

	LayerThread layer1 = new LayerThread(); //represents a single layer track
		

	/**
     * a no argument constructor that creates instances of the GUI elements. 
     * @author Billy && Jack N
 	 * @version 1.0 (05/02/16)
     *
     */
    	public Launchpad()
    	{
        	super("Simori-ON");
       		//create a main panel and give a flow layout  
		//flow layout enables panels to be placed left to right
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		//create panels for left/right buttons
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
	
		//create panels for top/bottom line of buttons
		//will contain the ok and on buttons, as well as text field
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
	
		//create a panel for center buttons
		//center panel will contain top/bottom panels 
		JPanel centerPanel = new JPanel();

		//make panels have box layout
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));   
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		//create buttons
		l1 = new CustomButton("L1");

		l2 = new CustomButton("L2");
		l3 = new CustomButton("L3");
		l4 = new CustomButton("L4");

		r1 = new CustomButton("R1");
		r2 = new CustomButton("R2");
		r3 = new CustomButton("R3");
		r4 = new CustomButton("R4");

		ok = new CustomButton("OK");
		on = new CustomButton("ON");

		//add buttons to left panel
		//create spacing between buttons
		leftPanel.add(l1);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 75)));
		leftPanel.add(l2);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 75)));
		leftPanel.add(l3);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 75)));
		leftPanel.add(l4);
	
		//add buttons to right panel
		//create spacing between buttons
		rightPanel.add(r1);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 75)));
		rightPanel.add(r2);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 75)));
		rightPanel.add(r3);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 75)));
		rightPanel.add(r4);
		
		//add on button to top panel
		//create spacing to separate from grid
		topPanel.add(on);
		topPanel.add(Box.createRigidArea(new Dimension(0, 25)));

		//add ok button and text field to bottom panel
		//create spacing to separate from grid
		centerPanel.add(Box.createRigidArea(new Dimension(0, 25)));
		textField = new JTextField(20);
		bottomPanel.add(textField);
		bottomPanel.add(ok);


		//makes a grid of 16x16 buttons
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(gridSize, gridSize));
		gridPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		for (int i = 0; i < gridSize; i++)
		{
		    for (int j = 0; j < gridSize; j++)
		    {
			//create each button and give each one an action
			matrixBut = new CustomToggle(i, j);
			gridPanel.add(matrixBut);
		    }
		}
		
		//make panel backgrounds all white
		leftPanel.setBackground(Color.WHITE);
		centerPanel.setBackground(Color.WHITE);
		rightPanel.setBackground(Color.WHITE);		
		topPanel.setBackground(Color.WHITE);
		bottomPanel.setBackground(Color.WHITE);
		gridPanel.setBackground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);

		//add ON button to top panel
		centerPanel.add(topPanel);
		centerPanel.add(gridPanel);
		centerPanel.add(bottomPanel);

		//populate the content panel
		contentPane.add(leftPanel);
		contentPane.add(centerPanel);
		contentPane.add(rightPanel);
		setContentPane(contentPane);

		//display
		pack();
		setLocationByPlatform(true);
		setVisible(true);
   	}   
   	/**
     * main method that creates a new window.
     * 
     * @param args        arguments provided from the command line
     * @author Billy && Jack N 
 	 * @version 1.0 (07/02/16)
     *
     */
    	public static void main(String[] args)
    	{
    		JFrame frame = new Launchpad();
		frame.addWindowListener(new WindowAdapter() {
    			public void windowClosing(WindowEvent e) {
        		 	System.exit(1);
    			}
		});
            
    	}
		
		/**
     	* The LayerThread class represents the threads which in turn represents the layers in the program.
     	* 
     	* @param args        arguments provided from the command line
     	* @author Jack L && George && Ollie
 	 	* @version 1.0 (07/02/16)
     	*/
    	
    	public class LayerThread implements Runnable   {
    		
    		/**
     		* a no argument constructor that creates an instance of a thread, that represents a layer.
     		* @author Jack L && George 
 	 		* @version 1.0 (08/02/16)
     		*/
    		public LayerThread() {
    			
    		}
    		/**
     		* Method that starts the Tenori-on by creating an instance of a LayerThread
     		* @author Jack L && George 
 			* @version 1.0 (08/02/16)
     		*/
    		public void start() {
    			new Thread(new LayerThread()).start();
    		}



    		/**
     		* Method that does a majority of the work. It loops through the arrays and plays the relevant sounds.
    		* 
    		* @author Jack L && George && Ollie
 	 		* @version 1.0 (09/02/16)
    		* @Override
    		*/
    		public void run(){
    			// TODO Auto-generated method stub
    			//Creates new music player
    			MusicPlayer sound = new MusicPlayer();
    			
    			while (!Thread.currentThread().isInterrupted()) {
    				//Loop through the X-axis of the grid j represents the x co-ordinate
    				//the third toggle buttons from the left represent the co-ordinate j = 2
    				for (int j = 0; j < 16; j++){
    					//ArrayList used to store the note value of which toggle buttons are On in this x column
    					ArrayList<Integer> chord = new ArrayList<Integer>();
    					//Loop through the y-axis of the grid i represents the y co-ordinate
        				//the third toggle buttons from the bottom represent the co-ordinate i = 2
    					for (int i = 0; i < 16; i++){
    						//if the toggle button is turned on then add it's note value to a chord (ArrayList)
    						if (boolArr[i][j] == true) {
    							chord.add(15-i);						
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
    				}
    			}
    		}
    		
    }
    	
    /**
     * The CustomButton class extends the JButton class. It represents a button in the GUI.
     * 
     * @author Billy && Jack N && Ollie
 	 * @version 1.0 (07/02/16)
     *
     */
	public class CustomButton extends JButton
	{
		/**
		* This one-argument constructor creates an instance of a button 
		* @param name		the name of the button
		* @author Billy && Jack N
		* @version 1.0 (07/02/16)
		*/
		public CustomButton(final String name)
		{
			ImageIcon buttonImage = new ImageIcon("./" + name + ".jpg");
			this.setRolloverIcon(new ImageIcon("./" + name + "2.jpg"));
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
     			* @author Ollie
				* @version 1.0 (10/02/16)
     			* 
     			*/
				public void actionPerformed(ActionEvent ae)
				{	
					if(name == "ON" && running==false)
					{
						//CLEAR EVERY TOGGLE BUTTON (MAKE METHOD?)
						layer1.start();
						running=true;
					}
					else if(name == "ON" && running==true)
					{	
						//STOP THE MOTHERFUCKING THREAD				
						running=false;	
						//CLEAR EVERY TOGGLE BUTTON (MAKE METHOD?)

					}
				}	
			});
		}
	}

	/**
     * The CustomToggle class extends JToggleButton. It represents a toggle button in the GUI.
     * 
     * @author Billy && Jack N
 	 * @version 1.0 (10/02/16)
     *
     */
	public class CustomToggle extends JToggleButton
	{
		/**
		* This two-argument constructor creates instances with custom size and colour.
		*
		*@param i 	x cooridinate of the button's postion in the grid
		*@param j 	y cooridinate of the button's postion in the grid
		* @author Billy && Jack N
		* @version 1.0 (09/02/16)
		*/
		public CustomToggle(final int i, final int j)
		{
			ImageIcon orangebutton = new ImageIcon("./3737orange.jpg");
		        ImageIcon emptybutton = new ImageIcon("./3737empty.jpg");
			this.setRolloverIcon(new ImageIcon("./3737orange.jpg"));

			this.setPreferredSize(new Dimension(37, 37));
			this.setForeground(Color.WHITE);
			this.setBackground(Color.WHITE);
			this.setBorder(new LineBorder(Color.WHITE, 0));
			this.setIcon(emptybutton);
		    	this.setPressedIcon(orangebutton);
		    	this.setSelectedIcon(orangebutton);
		   	this.setBorderPainted(false);

			this.addActionListener(new ActionListener()	
		        {
				public void actionPerformed(ActionEvent ae)
				{
					boolArr[i][j] = false;
					JToggleButton toggledbtn = (JToggleButton) ae.getSource(); 
					if (toggledbtn.isSelected()) {
						boolArr[i][j] = true;
	   				
	    				}
				}
			});
		}
	}
	
	/**
     * The MusicPlayer class represents the ability to produce music. 
     * It provides functionality for playing more than one note at a time.
     * 
     * @author Jack L && George
 	 * @version 1.0 (09/02/16)
     *
     */
	public class MusicPlayer {
		
			/**
			* a no argument constructor that is going to be developed further into the project.
			*/
		  public void playInstruments( ) {
		     
		  }
		  	  	
			 /**
	  		 * Method that plays a chord when a toggle button is clicked on 
	  		 * 
			 * @param chord 							The array that holds the values of the notes to be played in this iteration.
	  		 * @throws MidiUnavailableException 		thrown when the program cannot connect to a midi
	  		 * @throws InvalidMidiDataException 		thrown when the data in the midi is invalid
	  		 * @throws InterruptedException 			thrown when the midi is interrupted
	  		 * @author Jack L && George 
 	 		 * @version 1.0 (09/02/16)
	  		 *
	  		 */
	  		public void playChord(ArrayList<Integer> chord) throws MidiUnavailableException,
	  		InvalidMidiDataException, InterruptedException{
	  			//Create a new array of Messages
	  			//each message is one note to send to a receiver
	  			ShortMessage[] messages = new ShortMessage[chord.size()];
	  			//create a new synthesizer to generate the type of sound using the ShortMessages
	  			Synthesizer synth = MidiSystem.getSynthesizer();
	  			//Opens the connection to the synth
	  			synth.open();
	  			//Create a new receiver which the messages are sent to
	  			Receiver rcvr = synth.getReceiver();
	  		      
	  			//Loops through each note in the Chord ArrayList to initialise the array and set the instrument
	  			for (int i = 0; i < chord.size(); i++){
	  				messages[i] = new ShortMessage();
	  				//set the desired instrument to be played
	  				messages[i].setMessage(ShortMessage.PROGRAM_CHANGE, 1, 102, 0);
	  				//send this instrument data to the receiver
	  				rcvr.send(messages[i], -1);
	  				
	  				
	  				
	  			}
	  			//Loops through and begins playing each note in the chord ArrayList
	  			for (int i = 0; i < chord.size(); i++){
	  				//Create a message with the note to be played
	  				messages[i].setMessage(ShortMessage.NOTE_ON, 1, 60 + chord.get(i), 80);
	  				//send this message to the receiver
	  				rcvr.send(messages[i], -1);
	  			}
	  			//allows the note some time to play
	  			Thread.sleep(750);

				//Loops through and begins playing each note in the chord ArrayList
				for (int i = 0; i < chord.size(); i++){
	  				//Create a message with the note to be played
	  				messages[i].setMessage(ShortMessage.NOTE_OFF, 1, 60 + chord.get(i), 80);
	  				//send this message to the receiver
	  				rcvr.send(messages[i], -1);
	  			}
	  			
	  			//close receiver and synth
	  			rcvr.close();
	  			synth.close();
	  		}
		  
	}
	
}
