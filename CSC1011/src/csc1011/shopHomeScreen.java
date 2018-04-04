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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class shopHomeScreen {//open class
	

	protected static final String heroInterface = null;
	//creating variables
	private JFrame shopMenuInterface;
	private JPanel gameTopP, gameMiddleP, gameBottomP, gameAllP;
	private JButton foodBtn, clothingBtn, gadgetsBtn, exitBtn;
	private JLabel shopImage;
	
	//constructor
	shopHomeScreen(){
		//layout of panels
		gameTopP = new JPanel();
		gameTopP.setBackground(Color.LIGHT_GRAY);
		gameMiddleP = new JPanel();
		gameMiddleP.setBackground(Color.GRAY);
		gameBottomP = new JPanel();	
		gameBottomP.setBackground(Color.DARK_GRAY);
		gameAllP = new JPanel();
				
		gameAllP.setLayout(new BoxLayout(gameAllP, BoxLayout.X_AXIS));
		gameAllP.add(gameTopP);
		gameAllP.add(gameMiddleP);
		gameAllP.add(gameBottomP);
				
		//adding the hero image -top panel image
		shopImage = new JLabel();
		ImageIcon img = new ImageIcon("Images/shop.jpg");
		shopImage.setIcon(img);		
		gameTopP.add(shopImage);
		
		//actions for the food button
		//opens the food interface where player can buy food
		foodBtn = new JButton("Food Department");
		foodBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					
				//message displayed after food button has been selected
				JOptionPane.showMessageDialog(null, "Welcome to the Food Department!");
					
				//opens the foodDepartment screen
				foodInterface food = new foodInterface();
				shopMenuInterface.setVisible(false);
				}
			});	
		
		//actions for the clothing button
		//opens the clothing interface where player can buy clothing
		clothingBtn = new JButton("Clothing Department");
		clothingBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				//message displayed after clothing button has been selected
				JOptionPane.showMessageDialog(null, "Welcome to the Clothing Department");
				
				//opens the clothingDepartment screen
				clothingInterface clothing = new clothingInterface();
				shopMenuInterface.setVisible(false);
			}
		});
		
		//actions for the gadgets button
		//opens the gadgets interface where player can buy gadgets
		gadgetsBtn = new JButton("Gadget Department");
		gadgetsBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				//message displayed after gadget button has been selected
				JOptionPane.showMessageDialog(null, "Welcome to the Gaget Department");
				
				//open the gadgetsDepartment screen
				gadgetInterface gadget = new gadgetInterface();
				shopMenuInterface.setVisible(false);
			}
		});
			
		//create exit shop button
		exitBtn = new JButton("Exit shop");
		//add action listener to the exit shop button
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//set visible of shop interface to false
				shopMenuInterface.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
				
			}
		});
		
		gameBottomP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameBottomP.setLayout(new GridLayout(0,2,10,10));
		gameBottomP.add(foodBtn);
		gameBottomP.add(clothingBtn);
		gameBottomP.add(gadgetsBtn);
		gameBottomP.add(exitBtn);
				
		//game window frame
		shopMenuInterface = new JFrame();
		shopMenuInterface.setTitle("Trump Card Game");
		shopMenuInterface.setSize(1000,3000);
		shopMenuInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shopMenuInterface.setVisible(true);
		shopMenuInterface.add(gameAllP);
		}//close constructor	

	
	protected static void setVisable(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {//open main statement
	

	}//close main statement


}//class

