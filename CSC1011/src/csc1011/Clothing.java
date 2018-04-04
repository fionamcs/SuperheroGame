package csc1011;

public class Clothing extends Item{//open class

	//constructor
	public Clothing(String name, String itemDescription, double cost) {//open constructor
		super(name, itemDescription, cost);
	}//close constructor

	//creating a new object
	Clothing clothing1 = new Clothing ("Bulletproof Helmet", "Adds 10 to the status bar", 5);
	Clothing clothing2 = new Clothing ("Rudy Red Cape","Add 10 to the hero villain action bar", 5);
	Clothing clothing3 = new Clothing ("Speedy Socks", "Add 10 to the hero villain action bar", 3);
	
}//close class
