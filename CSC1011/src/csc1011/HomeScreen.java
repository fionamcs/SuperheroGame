package csc1011;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class HomeScreen implements ActionListener {//open class

	//declare variables
	private JFrame homeWindow;
	private JPanel topPanel, middlePanel, bottomPanel, allPanels;
	private JButton heroButton, villainButton;
	private JLabel welcomeText, messageText, welcomeImage, label;

	//constructor
	public HomeScreen(){
		
		//creating the top, middle and bottom panel
		topPanel = new JPanel();
		topPanel.setBackground(Color.lightGray);
		middlePanel = new JPanel();
		middlePanel.setBackground(Color.gray);
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.darkGray);
		allPanels = new JPanel();
	
		//adding each of the panels
		allPanels.setLayout(new BoxLayout(allPanels, BoxLayout.Y_AXIS));
		allPanels.add(topPanel);
		allPanels.add(middlePanel);
		allPanels.add(bottomPanel);
			
		//Home screen -top panel image
		welcomeImage = new JLabel();
		ImageIcon img = new ImageIcon("images/splashscreen.jpg");
		welcomeImage.setIcon(img);		
		topPanel.add(welcomeImage);
			
		//Home screen - welcome message
		welcomeText = new JLabel("Welcome");
		messageText = new JLabel("How would you like to begin the game:");
		middlePanel.setLayout(new GridLayout (2,0));
		middlePanel.add(welcomeText);
		middlePanel.add(messageText);
			
		//Home screen buttons
		//playing the game as a hero
		heroButton = new JButton("Hero");
		heroButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				//add sound to the hero button
				try{
					String soundName = "sound/sound2.wav";
					AudioInputStream audioIn = AudioSystem.getAudioInputStream((new File(soundName).getAbsoluteFile()));
					//get a sound clip resource
					Clip clip = AudioSystem.getClip();
					//open audio clip and load samples from the audio input stream. clip.open(audio)
					clip.start();
					clip.open(audioIn);
					clip.loop(3);
				}
				catch (UnsupportedAudioFileException f){ f.printStackTrace();
				}
				catch (IOException f){ f.printStackTrace();
				}
				catch(LineUnavailableException f){ f.printStackTrace();
				}
			
				//message displayed after hero button has been selected	

				JOptionPane.showMessageDialog(null, "Hello Hero!");	

				//opens the heroVillain_Interface
				heroVillain_Interface hero_Interface = new heroVillain_Interface();
				//starts game as a hero
				hero_Interface.statusBar.setValue(70);
				//hide the home screen
				homeWindow.setVisible(false);
				}
			});
		
		//playing the game as a villain
		villainButton = new JButton("Villian");
		villainButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
				//add sound to the hero button
				try{
					String soundName = "sound/sound.wav";
					AudioInputStream audioIn = AudioSystem.getAudioInputStream((new File(soundName).getAbsoluteFile()));
					//get a sound clip resource
					Clip clip = AudioSystem.getClip();
					//open audio clip and load samples from the audio input stream. clip.open(audio)
					clip.start();
					clip.open(audioIn);
					clip.loop(3);
				}
				catch (UnsupportedAudioFileException f){ f.printStackTrace();
				}
				catch (IOException f){ f.printStackTrace();
				}
				catch(LineUnavailableException f){ f.printStackTrace();
				}
				
				//message displayed after villain button has been selected
				JOptionPane.showMessageDialog(null, "Hello Villain");
			
				//opens the hero_Interface
				heroVillain_Interface hero_Interface = new heroVillain_Interface();
				//starts game as a villain
				hero_Interface.statusBar.setValue(42);
				//hide home screen
				homeWindow.setVisible(false);
				}
		});
		
	
	
		//Home Screen - adding the buttons to the middle panel and creating a gap in between each one
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		middlePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		middlePanel.add(heroButton);
		middlePanel.add(Box.createRigidArea(new Dimension(0,4)));
		middlePanel.add(villainButton);
	
		//Home Screen frame
		homeWindow = new JFrame();
		homeWindow.setTitle("Trump Card Game");
		homeWindow.setSize(1000,3000);
		homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeWindow.setVisible(true);
		homeWindow.add(allPanels);
	
		//menu bar
		//layout for menu components
		homeWindow.setLayout(new FlowLayout());
		//terminate program when user closes the application
		homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		///label that will display the menu selection
		label = new JLabel();
		//create menu bar
		JMenuBar menuB = new JMenuBar ();
		
		//create the file menu item
		JMenu menuFile = new JMenu ("File");
		JMenuItem menuExit = new JMenuItem ("Exit");
		
		//add file menu items to the file menu
		menuFile.add (menuExit);
		
		//add menu bar to the frame
		menuB.add(menuFile);
		
		//add action listener for the menu items
		menuExit.addActionListener(this);
		
		//add label to the frame
		homeWindow.getContentPane().add(label);
		//add menu to the frame
		homeWindow.setJMenuBar(menuB);
		//display the frame
		homeWindow.setVisible(true);	
		
	}//close constructor
	
	protected static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed (ActionEvent ae) {
		String comStr = ae.getActionCommand();
		if (comStr.equals("Exit")) System.exit(0);
		label.setText(comStr + "Selected");;	
	}//close actionPerformed
	
	//method to ask user to select name
	public static void getName(){
		String name;
		name = JOptionPane.showInputDialog(null, "Please enter a character name?");
		JOptionPane.showMessageDialog(null, "You have chosen to name your character " + name);
	}
	
	public static void main (String args[]){//open main statement
		getName();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new HomeScreen();
			}
		});
	}//close main statement
}//close class
