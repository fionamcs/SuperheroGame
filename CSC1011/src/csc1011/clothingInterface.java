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


public class clothingInterface {//open class

	protected static final String heroInterface = null;
	//creating variables
	private JFrame clothingDepartment;
	private JPanel gameTopP, gameMiddleP, gameBottomP, gameAllP;
	private JButton hatPurchaseBtn, capePurchaseBtn, socksPurchaseBtn;
	private JLabel hDescription, cDescription, sDescription, hatImage, capeImage, sockImage;
	
	//constructor
	clothingInterface(){
		
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
		hatImage = new JLabel();
		ImageIcon img = new ImageIcon("Images/hat.jpg");
		hatImage.setIcon(img);		
		gameTopP.add(hatImage);
			
		//adding the cape image - middle panel image
		capeImage = new JLabel();
		ImageIcon img1 = new ImageIcon("Images/cape.jpg");
		capeImage.setIcon(img1);
		gameMiddleP.add(capeImage);
			
		//adding the belt image - bottom panel image
		sockImage = new JLabel();
		ImageIcon img2 = new ImageIcon("Images/socks.jpg");
		sockImage.setIcon(img2);
		gameBottomP.add(sockImage);
			
		
		//actions for the buy helmet button
		hatPurchaseBtn = new JButton("Buy Helmet");
		hatPurchaseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				//calling method which adds points to action bar
				heroVillain_Interface.addActionPoints();
				
				//hide clothing interface
				clothingDepartment.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
			}
		});
		
		//actions for the buy cape button
		capePurchaseBtn = new JButton("Buy Cape");
		capePurchaseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//calling method which adds points to action bar
				heroVillain_Interface.addActionPoints();
				
				//hide clothing interface
				clothingDepartment.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
			}	
		});
		
	//actions for the buy socks button
		socksPurchaseBtn = new JButton("Buy Socks");
		socksPurchaseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//calling method which adds points to action bar
				heroVillain_Interface.addActionPoints();
				
				//hide clothing interface
				clothingDepartment.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
				
			}
		});
		
		hDescription = new JLabel("Bulletproof Helmet: Adds 10 to the status bar");
		hDescription.setForeground(Color.BLACK);
		cDescription = new JLabel("Rudy Red Cape: Add 10 to the Hero Villain Action bar");
		cDescription.setForeground(Color.BLACK);
		sDescription = new JLabel("Speedy Socks: Add 10 to the Hero Villain Action bar");
		sDescription.setForeground(Color.BLACK);
		
		
		
		gameTopP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameTopP.setLayout(new GridLayout(0,3,10,10));	
		gameMiddleP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameMiddleP.setLayout(new GridLayout(0,3,10,10));
		gameBottomP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameBottomP.setLayout(new GridLayout(0,3,10,10));		
		
		gameTopP.add(hatPurchaseBtn);
		gameTopP.add(hDescription);
		gameMiddleP.add(capePurchaseBtn);
		gameMiddleP.add(cDescription);
		gameBottomP.add(socksPurchaseBtn);
		gameBottomP.add(sDescription);
					
		//game window frame
		clothingDepartment = new JFrame();
		clothingDepartment.setTitle("Clothing Department");
		clothingDepartment.setSize(1000,3000);
		clothingDepartment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clothingDepartment.setVisible(true);
		clothingDepartment.add(gameAllP);
		
	}//close constructor	

	protected static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


}//close class
