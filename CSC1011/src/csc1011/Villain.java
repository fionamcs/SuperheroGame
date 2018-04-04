package csc1011;

public class Villain extends Character{//open Villain class which extends Character

	public Villain(String name, Status status, int actionPoints, int energy) {//open constructor
		super(name, status, actionPoints, energy);
		
	}//close constructor

	
	//override methods
	@Override
	public void sleep(){
		System.out.println("The villain is sleeping");
	}
	@Override
	public void commitCrime(){
		System.out.println("The villain has committed a crime!");
	}
	@Override
	public void fightCrime(){
		System.out.println("The villain has successfully fought a crime");
	}
	@Override
	public void Ignore(){
		System.out.println("The villain has ignored the crime");
	}
	
	//hero description
	//public String toString(){
		//String VillainDescription = "Hero: Your character name is:" + villain01.getName() + "/nYou are a: " 
			//	+ villain01.getStatus() + "/nYour energy Bar will start at: " + villain01.getEnergy()
				//+ "/nYour Action Bar will start at: " + villain01.getActionPoints();
			//return VillainDescription;
		//}

}//close class
