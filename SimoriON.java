import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * The SimoriON class inherits from JFrame. It creates the GUI and implements threads that play the sound. 
 * @author Billy & Jack N
 * @version 1.0 (05/02/16)
 *
 */
public class SimoriON extends JFrame{
	
	public static boolean[][] boolArr = new boolean[16][16]; //used to store the live or off values for each button 
	public static boolean running = false;
	public static CustomToggle[][] buttonArray = new CustomToggle[16][16];
	private static int gridSize = 16;
	public static LayerThread layer1 = new LayerThread();
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
	
     	/**
     	* a no argument constructor that creates instances of the GUI elements. 
     	* @author Billy & Jack N
 		* @version 1.0 (05/02/16)
     	*
    	*/
    	public SimoriON()
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
			buttonArray[i][j]=matrixBut;
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
	* @param args        arguments provided from the command line.
	* @author Billy & Jack N 
	* @version 1.0 (07/02/16)
	*
	*/
	public static void main(String[] args)
    	{
    		JFrame frame = new SimoriON();
			frame.addWindowListener(new WindowAdapter() {
    			public void windowClosing(WindowEvent e) {
        		 	System.exit(1);
    			}
			});  
    	}
}
