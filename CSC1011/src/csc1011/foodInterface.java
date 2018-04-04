package csc1011;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class foodInterface {//open class

	protected static final String heroInterface = null;
	//creating variables
	private JFrame foodDepartment;
	private JPanel gameTopP, gameMiddleP, gameBottomP, gameAllP;
	private JButton fruitPurchaseBtn, coffeePurchaseBtn, eDrinkPurchaseBtn;
	private JLabel fruitImage, coffeeImage, eDrinkImage;
	private JLabel fDescription, cDescription, eDescription;
	
	foodInterface(){
		//layout of panels
		gameTopP = new JPanel();
		gameTopP.setBackground(Color.LIGHT_GRAY);
		gameMiddleP = new JPanel();
		gameMiddleP.setBackground(Color.GRAY);
		gameBottomP = new JPanel();	
		gameBottomP.setBackground(Color.DARK_GRAY);
		gameAllP = new JPanel();
					
		gameAllP.setLayout(new BoxLayout(gameAllP, BoxLayout.Y_AXIS));
		gameAllP.add(gameTopP);
		gameAllP.add(gameMiddleP);
		gameAllP.add(gameBottomP);
					
		//adding the hat image -top panel image
		fruitImage = new JLabel();
		ImageIcon img = new ImageIcon("images/fruit.jpg");
		fruitImage.setIcon(img);		
		gameTopP.add(fruitImage);
			
		//adding the cape image - middle panel image
		coffeeImage = new JLabel();
		ImageIcon img1 = new ImageIcon("images/coffee.jpg");
		coffeeImage.setIcon(img1);
		gameMiddleP.add(coffeeImage);
		
		//adding the belt image - bottom panel image
		eDrinkImage = new JLabel();
		ImageIcon img2 = new ImageIcon("images/eDrink.jpg");
		eDrinkImage.setIcon(img2);
		gameBottomP.add(eDrinkImage);
			
			
		//actions for the buy helmet button
		fruitPurchaseBtn = new JButton("Buy Fruit");
		fruitPurchaseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//calling method which adds points to status bar
				heroVillain_Interface.addStatusBar();
				
				//set visable of food interface to false
				foodDepartment.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
				
				
			}
		});
		
		//actions for the buy cape button
		coffeePurchaseBtn = new JButton("Buy Coffee");
		coffeePurchaseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//calling method which adds points to status bar
				heroVillain_Interface.addStatusBar();
				
				//set visible of food interface to false
				foodDepartment.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
				
			}	
		});
		
		//actions for the buy socks button
		eDrinkPurchaseBtn = new JButton("Buy Energy Drink");
		eDrinkPurchaseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//calling method which adds points to status bar
				heroVillain_Interface.addStatusBar();
				
				//set visible of food interface to false
				foodDepartment.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
				
			}
		});
		
		//fruit description
		fDescription = new JLabel("Fruit: Boosts status by 10");
		fDescription.setForeground(Color.BLACK);
		
		cDescription = new JLabel("Coffee: Boosts status by 10");
		cDescription.setForeground(Color.BLACK);
		
		eDescription = new JLabel("Energy Drink: Boosts status by 10");
		eDescription.setForeground(Color.BLACK);
		
		gameTopP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameTopP.setLayout(new GridLayout(0,3,10,10));	
		gameMiddleP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameMiddleP.setLayout(new GridLayout(0,3,10,10));
		gameBottomP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameBottomP.setLayout(new GridLayout(0,3,10,10));		
		gameTopP.add(fruitPurchaseBtn);
		gameTopP.add(fDescription);
		gameMiddleP.add(coffeePurchaseBtn);
		gameMiddleP.add(cDescription);
		gameBottomP.add(eDrinkPurchaseBtn);
		gameBottomP.add(eDescription);
				
		//game window frame
		foodDepartment = new JFrame();
		foodDepartment.setTitle("Food Department");
		foodDepartment.setSize(1000,3000);
		foodDepartment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		foodDepartment.setVisible(true);
		foodDepartment.add(gameAllP);
		
	}//close constructor	
}//close class
