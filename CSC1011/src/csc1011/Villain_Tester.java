package csc1011;

public class Villain_Tester {//open class

	public static void main(String[] args) {//open main statemement
		
		//create new villain object
		Villain villain1 = new Villain ("Joker", Status.Villain, 0, 100);
		
		//output to the screen
		System.out.println("Your character name is " + villain1.getName());
		System.out.println("You are a " + villain1.getStatus());
		System.out.println("You currently have " + villain1.actionPoints + " action points.");
		System.out.println("You currently have " + villain1.energy + " energy.");


		

	}//close main statement

}//close class
