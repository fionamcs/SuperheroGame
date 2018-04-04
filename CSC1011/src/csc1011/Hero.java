package csc1011;

public class Hero extends Character{//open class which extends character

	public Hero(String name, Status status, int actionPoints, int energy) {//open constructor
		super(name, status, actionPoints, energy);
	}//close constructor
	
	//override methods
	@Override
	public void sleep(){
		System.out.println("The hero is sleeping");
	}
	@Override
	public void fightCrime(){
		System.out.println("The hero has successfully fought a crime!");
	}
	@Override
	public void commitCrime(){
		System.out.println("The hero has committed a crime!");
	}
	@Override
	public void Ignore(){
		System.out.println("The hero has ingnored the crime");
	}
	
	//hero description
	//public String toString(){
		//String heroDescription = "Hero: Your character name is:" + hero1.getName() + "/nYou are a: " 
			//	+ hero1.getStatus() + "/nYour energy Bar will start at: " + hero1.getEnergy()
			//	+ "/nYour Action Bar will start at: " + hero1.getActionPoints();
	//	return heroDescription;
	//}
	
	//get hero method
	//public Hero getHero1() {
		//return hero1;
	//}
	//public void setHero1(Hero hero1) {
		//this.hero1 = hero1;
	//}
}//close class
