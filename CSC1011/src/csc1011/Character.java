package csc1011;

public class Character {//open class
	
	//declare variables
	public String name;
	public Status status;
	public int actionPoints;
	public int energy;
	//add image as icon not buffered image - see zoo tutorial
	
	//constructor
	public Character(String name, Status status, int actionPoints, int energy) {
		//assign each parameter to each variable
		this.name = name;
		this.status = status;
		this.actionPoints = actionPoints;
		this.energy = energy;
	}//close constructor

	//getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getActionPoints() {
		return actionPoints;
	}

	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	
	//methods
	public void sleep(){
		System.out.println("The character is sleeping.");
	}
	public void fightCrime(){
		System.out.println("You have just fought a Crime.");
	}
	public void commitCrime(){
		System.out.println("You have just committed a crime.");
	}
	public void Ignore(){
		System.out.println("You have just ignored an incident.");
	}

}//close class
