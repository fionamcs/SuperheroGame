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

public class gadgetInterface {//open class

	protected static final String heroInterface = null;
	//creating variables
	private JFrame gadgetDepartment;
	private JPanel gameTopP, gameMiddleP, gameBottomP, gameAllP;
	private JButton watchPurchaseBtn, gunPurchaseBtn, beltPurchaseBtn;
	private JLabel wDescription, gDescription, bDescription, watchImage, gunImage, beltImage;
	
	gadgetInterface(){
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
		watchImage = new JLabel();
		ImageIcon img = new ImageIcon("images/watch.jpg");
		watchImage.setIcon(img);		
		gameTopP.add(watchImage);
			
		//adding the cape image - middle panel image
		gunImage = new JLabel();
		ImageIcon img1 = new ImageIcon("images/watergun.jpg");
		gunImage.setIcon(img1);
		gameMiddleP.add(gunImage);
		
		//adding the belt image - bottom panel image
		beltImage = new JLabel();
		ImageIcon img2 = new ImageIcon("images/belt.jpg");
		beltImage.setIcon(img2);
		gameBottomP.add(beltImage);
			
		
		//actions for the buy helmet button
		watchPurchaseBtn = new JButton("Buy Watch");
		watchPurchaseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//calling method which adds points to action bar
				heroVillain_Interface.addActionPoints();	
				
				
				//set visible of gadget interface to false
				gadgetDepartment.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
				
			}
		});
		
		//actions for the buy cape button
		gunPurchaseBtn = new JButton("Buy Watergun");
		gunPurchaseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//calling method which adds points to action bar
				heroVillain_Interface.addActionPoints();	
			
				
				//set visible of gadget interface to false
				gadgetDepartment.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
				
			}	
		});
		
		//actions for the buy socks button
		beltPurchaseBtn = new JButton("Buy Belt");
		beltPurchaseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//calling method which adds points to action bar
				heroVillain_Interface.addActionPoints();	
				//Villain_Interface.addActionPoints();
				
				//set visible of gadget interface to false
				gadgetDepartment.setVisible(false);
				//start the crime timer
				heroVillain_Interface.crimeTimer.start();
				//start the update progress bar timer
				heroVillain_Interface.updateProgressBarTimer.start();
				
			}
		});
			
		wDescription = new JLabel("Super Sonic Watch: Boosts Action Points by 10");
		wDescription.setForeground(Color.BLACK);
		gDescription = new JLabel("Watergun: Boosts Action Points  by 10");
		gDescription.setForeground(Color.BLACK);
		bDescription = new JLabel("Power Belt: Increase Action Points by 10");
		bDescription.setForeground(Color.BLACK);
		
		gameTopP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameTopP.setLayout(new GridLayout(0,3,10,10));	
		gameMiddleP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameMiddleP.setLayout(new GridLayout(0,3,10,10));
		gameBottomP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		gameBottomP.setLayout(new GridLayout(0,3,10,10));		
		
		gameTopP.add(watchPurchaseBtn);
		gameTopP.add(wDescription);
		gameMiddleP.add(gunPurchaseBtn);
		gameMiddleP.add(gDescription);
		gameBottomP.add(beltPurchaseBtn);
		gameBottomP.add(bDescription);
				
		//game window frame
		gadgetDepartment = new JFrame();
		gadgetDepartment.setTitle("Food Department");
		gadgetDepartment.setSize(1000,3000);
		gadgetDepartment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gadgetDepartment.setVisible(true);
		gadgetDepartment.add(gameAllP);
		
	}//close constructor	

	protected static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}//close class
