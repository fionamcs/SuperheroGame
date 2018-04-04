package csc1011;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.*;

public class heroVillain_Interface{
	
		//creating variables
		private JFrame heroInterface;
		private static JPanel gameTopP;
		private static JPanel gameMiddleP;
		private static JPanel gameBottomP;
		private JPanel gameAllP;
		private static JButton sleepBtn, shopBtn;
		private static JLabel energyBarLabel, actionBarLabel, statusBarLabel;
		private static JLabel heroImage;
		private static JLabel villainImage;
		private static JLabel superheroImage;
		private static JLabel supervillainImage;
		private static JLabel humanImage;
		private JProgressBar energyBar;
		static JProgressBar statusBar;
		private static JProgressBar heroVillainActionBar;
		private ArrayList <Crime> crimeList = new ArrayList<Crime>();
		public static Timer updateProgressBarTimer, crimeTimer;
		
		//constructor
		public heroVillain_Interface(){
			
			//adding crime list
			crimeList.add(new Crime("Theft"));
			crimeList.add(new Crime("Murder"));
			crimeList.add(new Crime("Speeding"));
			crimeList.add(new Crime("Drink Driving"));
			crimeList.add(new Crime("Violence"));
			crimeList.add(new Crime("Assault"));	
			
			//layout of panels
			gameTopP = new JPanel();
			gameTopP.setBackground(Color.lightGray);
			gameMiddleP = new JPanel();
			gameMiddleP.setBackground(Color.gray);
			gameBottomP = new JPanel();	
			gameBottomP.setBackground(Color.darkGray);
			gameAllP = new JPanel();
			
			gameAllP.setLayout(new BoxLayout(gameAllP, BoxLayout.X_AXIS));
			gameAllP.add(gameTopP);
			gameAllP.add(gameMiddleP);
			gameAllP.add(gameBottomP);
		
			//progress bars - middle panel
			//energy Bar (creating the bar, labeling the bar and setting the value to 100)
			energyBar = new JProgressBar(0,100);
			energyBarLabel = new JLabel("Energy Level");
			energyBar.setStringPainted(true);
			energyBar.setValue(100);
			energyBarLabel.setForeground(Color.white);
			gameMiddleP.add(energyBarLabel);
			gameMiddleP.add(energyBar);
			energyBarLabel.setBounds(10,10,50,30);
			energyBar.setBounds(60,10,200,30);
			
			//creating a timer, this updates the energy bar
			//the energy bar decreases constantly using this timer
			updateProgressBarTimer = new Timer(1000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					updateProgressBar(energyBar);
				}
			});
			//start the update bar timer
			updateProgressBarTimer.start();
			
			
				
			//Status bar (creating the bar, labeling the bar and setting the bar to 0)
			setStatusBar(new JProgressBar(0,100));
			statusBarLabel = new JLabel("Status Bar");
			getStatusBar().setStringPainted(true);
			//statusBar.setValue(70);
			statusBarLabel.setForeground(Color.white);
			gameMiddleP.add(statusBarLabel);
			gameMiddleP.add(getStatusBar());
			statusBarLabel.setBounds(10,10,50,30);
			getStatusBar().setBounds(60,10,200,30);
			
					
			//Hero Villain Action Bar (creating the progress bar, labeling the bar and setting the bar to 20)
			heroVillainActionBar = new JProgressBar(0,100);
			actionBarLabel = new JLabel("Hero/ Villian Action Bar");
			heroVillainActionBar.setStringPainted(true);
			heroVillainActionBar.setValue(0);
			actionBarLabel.setForeground(Color.white);
			gameMiddleP.add(actionBarLabel);
			gameMiddleP.add(heroVillainActionBar);
			actionBarLabel.setBounds(10,10,50,30);
			heroVillainActionBar.setBounds(60,10,200,30);
				
			//creating sleep button
			sleepBtn = new JButton("Sleep");
		
			//action listener for sleep button
			sleepBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {	
					//output message "You are sleeping" in a new dialogue box
					JOptionPane.showMessageDialog(null,"You are sleeping." + "\nYou have gained 5 units of energy.");
					//adds 5 to the energy bar after the sleep button has been pressed
					energyBar.setValue(energyBar.getValue()+5);
					energyBar.setString(energyBar.getValue() + "%");
				}
			
			});
			
			//creating shop button
			shopBtn = new JButton("View Shop");
			
			//action listener for shop button
			shopBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//output message "Welcome to the Shop!" in a new dialogue box
					JOptionPane.showMessageDialog(null, "Welcome to the Shop!");
					//opens the shop main menu
					shopHomeScreen sHomescreen = new shopHomeScreen();
					crimeTimer.stop();
					updateProgressBarTimer.stop();

				}
			});
			
			//creating a timer, this enables crimes to appear automatically
			//the energy bar decreases constantly using this timer
			crimeTimer = new Timer(5500, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Random random = new Random();
					int num = random.nextInt(5);
					Crime crime = crimeList.get(num);

					int response;
					
					//output the random crime from the list
					//fix so that crime is output
					response =JOptionPane.showOptionDialog(null, crime.getCrime(), "Crime Committed", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, new String[]{"Fight Crime", "Commit Crime", "Ignore Crime"}, null);
					//adding buttons to the JOptionPane
					
					switch (response){
					//fight crime button
					case JOptionPane.OK_OPTION:
						//deducts 4 from energy
						energyBar.setValue(energyBar.getValue() -4);
						energyBar.setString(energyBar.getValue() + "%");
						//adds 1 to action points
						heroVillainActionBar.setValue(heroVillainActionBar.getValue() +1);
						heroVillainActionBar.setString(heroVillainActionBar.getValue() + "%");
						//adds 8 from status
						getStatusBar().setValue(getStatusBar().getValue() +8);
						//displays message
						JOptionPane.showMessageDialog(null, "You have fought a crime!" + "\nEnergy Lost: 4" + "\nActionPoints gained: 1" + "\nStatus gained: 8");
						break;
					
					//commit crime button
					case JOptionPane.NO_OPTION:
						//deducts 4 from energy
						energyBar.setValue(energyBar.getValue() -4);
						energyBar.setString(energyBar.getValue() + "%");
						//adds 1 to action points
						heroVillainActionBar.setValue(heroVillainActionBar.getValue() +1);
						heroVillainActionBar.setString(heroVillainActionBar.getValue() + "%");
						//deducts 8 from status
						getStatusBar().setValue(getStatusBar().getValue() -8);
						//displays message
						JOptionPane.showMessageDialog(null, "You have committed a crime!" + "\nEnergy Lost: 4" + "\nActionPoints gained: 1" + "\nStatus Lost: 8");		
						break;
					
					//ignore crime button 
					case JOptionPane.CANCEL_OPTION:
						//deducts 2 from energy
						energyBar.setValue(energyBar.getValue() -2);
						energyBar.setString(energyBar.getValue() + "%");					
						//deducts 1 from status
						getStatusBar().setValue(getStatusBar().getValue() -1);
						//displays message
						JOptionPane.showMessageDialog(null,"You have ignored a crime!" + "\nEnergy Lost: 2" + "\nActionPoints gained: 0" + "\nStatus lost: 1");					
						
					}//close switch(response)
				}
			});
			
			crimeTimer.start();
		
			gameBottomP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			gameBottomP.setLayout(new GridLayout(0,2,10,10));
			gameBottomP.add(sleepBtn);
			gameBottomP.add(shopBtn);
				
			//game window frame
			heroInterface = new JFrame();
			heroInterface.setTitle("Trump Card Game");
			heroInterface.setSize(2000,400);
			heroInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			heroInterface.setVisible(true);
			heroInterface.add(gameAllP);
			
			checkStatus();
		}

		//update energy progress bar
		public static void updateProgressBar(JProgressBar energyBar){
			energyBar.setValue(energyBar.getValue()-1);
			energyBar.setString(energyBar.getValue() + "%");
			checkStatus();
			//if statement
			//if the value in the energy reaches 0
			if (energyBar.getString().equals ("0%"))
			{
				//when the energy bar reaches 0, a dialog box will appear displaying a message
				JOptionPane.showMessageDialog(null, "Game Over! You have no energy left, you are not cut out to be a superhero or super villain... You must be a human!");
				//when the user dismisses this message by clicking ok, the game will automatically exit
				System.exit(0);
			}
		}//close action listener

		//update status progress bar
		public static void updateProgressBar1(JProgressBar statusBar){
			statusBar.getValue();
			}//close action listener
		
		
		//update actionPoints progress bar
		public static void updateProgressBar2(JProgressBar heroVillainActionBar){
			heroVillainActionBar.getValue();
			heroVillainActionBar.setString(heroVillainActionBar.getValue() + "%");
			if (heroVillainActionBar.getValue()>100)
			{
				heroVillainActionBar.setValue(100);
			}
			if(heroVillainActionBar.getValue()<=0)
			{
				heroVillainActionBar.setValue(0);
			}
			
			// if statement
			// if the heroVillianActionBar (action points) reaches 100 the game is complete
			if(heroVillainActionBar.getValue() == 100)
			{
				//when 100 action points is reached this message is opened in a new dialog box
				JOptionPane.showMessageDialog(null, "Congratulations! You have completed the game");
				//the game will automatically exit, after the congratulations message has been dismissed
				// the message is dismissed by pressing ok on the dialog box
				System.exit(0);
			}
			}//close action listener

		public static JProgressBar getStatusBar() {
			return statusBar;
		}

		public static void setStatusBar(JProgressBar statusBar) {
			heroVillain_Interface.statusBar = statusBar;
		}
		//check status method
		public static void checkStatus(){
			gameTopP.removeAll();
			//if status >=90 and <=100          superhero
			if (statusBar.getValue() >=90 && statusBar.getValue() <=100) {	
				//set string to superhero
				statusBar.setString("Superhero");
				
				//displays superhero image
				superheroImage = new JLabel();
				ImageIcon img = new ImageIcon("images/superhero.jpg");
				superheroImage.setIcon(img);
				gameTopP.add(superheroImage);

					
				//changes the background colour to white
				gameTopP.setBackground(Color.WHITE);
				gameMiddleP.setBackground(Color.WHITE);
				gameBottomP.setBackground(Color.WHITE);
						
				}	
			//if status <=89 and >=75          Hero
			if (statusBar.getValue() <=89 && statusBar.getValue() >=65) {
				//set string to Hero
				statusBar.setString("Hero");
					
				//displays Hero image
				heroImage = new JLabel();
				ImageIcon img = new ImageIcon("images/hero.jpg");
				heroImage.setIcon(img);				
				gameTopP.add(heroImage);

					
				//change the background colour to light gray
				gameTopP.setBackground(Color.LIGHT_GRAY);
				gameMiddleP.setBackground(Color.LIGHT_GRAY);
				gameBottomP.setBackground(Color.LIGHT_GRAY);

				}
				
			//if status <=74 and >=51       Human
			if (statusBar.getValue() <=64 && statusBar.getValue() >=51) {

				//set string to human
				statusBar.setString("Human");
						
				//displays Human image
				humanImage = new JLabel();
				ImageIcon img = new ImageIcon("images/human.jpg");
				humanImage.setIcon(img);
				gameTopP.add(humanImage);

				//change colour of background to yellow
				gameTopP.setBackground(Color.YELLOW);
				gameMiddleP.setBackground(Color.YELLOW);
				gameBottomP.setBackground(Color.YELLOW);
						
				}
					
			//if status <=50 && >= 36   Villain
			if (statusBar.getValue() <=50 && statusBar.getValue() >=36) {
				//set string to villain
				statusBar.setString("Villain");
						
				//displays villain image
				villainImage = new JLabel();
				ImageIcon img = new ImageIcon("images/villain.jpg");
				villainImage.setIcon(img);						
				gameTopP.add(villainImage);

				//change colour of background to gray
				gameTopP.setBackground(Color.GRAY);
				gameMiddleP.setBackground(Color.GRAY);						
				gameBottomP.setBackground(Color.GRAY);
							
				}
					
			//if status <=35 && >=25      Supervillain
			if (statusBar.getValue() <=35 && statusBar.getValue() >= 10) {
				//set string to supervillain
				statusBar.setString("Supervillain");
						
				//displays supervillain image
				supervillainImage = new JLabel();
				ImageIcon img = new ImageIcon("images/supervillain.jpg");
				supervillainImage.setIcon(img);
				gameTopP.add(supervillainImage);

						
				//change colour of background to black	
				gameTopP.setBackground(Color.BLACK);
				gameMiddleP.setBackground(Color.BLACK);							
				gameBottomP.setBackground(Color.BLACK);
								
				}
			//if status <=24 && >=1         Human
			if (statusBar.getValue() <=9 && statusBar.getValue() >=1) {
				//set string to human
				statusBar.setString("Human");
						
				//displays human image
				humanImage = new JLabel();
				ImageIcon img = new ImageIcon("images/human.jpg");
				humanImage.setIcon(img);
						
						
				//change colour of background to yellow	
				gameTopP.setBackground(Color.YELLOW);
				gameMiddleP.setBackground(Color.YELLOW);							
				gameBottomP.setBackground(Color.YELLOW);
								
				}//close condition	
			
			gameTopP.repaint();
			gameTopP.validate();
			
			
			
		}//close constructor
		//method to add 20 to energy
		public void addEnergy(){
			energyBar.setValue(energyBar.getValue() +20);
		}
		//method to add action points
		public static void addActionPoints(){
			heroVillainActionBar.setValue(heroVillainActionBar.getValue() +10);
		}
		//method to add to status bar
		public static void addStatusBar(){
			statusBar.setValue(statusBar.getValue() + 10);
		}

}//close class
