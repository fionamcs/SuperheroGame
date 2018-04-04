package csc1011;

public class hero_Tester {//open class
	
	public static void main(String[] args) {//open main statement
		
		//new hero object
		Hero hero1 =  new Hero ("Superman", Status.Hero, 0, 100);
		
		//output to screen
		System.out.println("Your character name is " + hero1.getName());
		System.out.println("You are a " + hero1.getStatus());
		System.out.println("You currently have " + hero1.actionPoints + " action points.");
		System.out.println("You currently have " + hero1.energy + " energy.");

	}//close main statement

}//close class
