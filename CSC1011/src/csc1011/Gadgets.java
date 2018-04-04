package csc1011;

public class Gadgets extends Item{//open class
	
	//constructor
	public Gadgets(String name, String itemDescription, double cost) {//open constructor
		super(name, itemDescription, cost);	
	}//close constructor
	
	//creating new objects
	Gadgets gadget1 = new Gadgets("SuperSonic Watch","Boosts action points by 10", 4);
	Gadgets gadget2 = new Gadgets("Watergun","Boosts action points by 10", 4);
	Gadgets gadget3 = new Gadgets("Power Belt","Increases action points by 10", 8);
	

}//close class
