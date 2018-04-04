package csc1011;

public class Food extends Item{//open class

	//constructor
	public Food(String name, String itemDescription, double cost) {//open constructor
		super(name, itemDescription, cost);
	}//close constructor
	
	//creating food objects
	Food food1 = new Food("Fruit","Boosts status by 10", 4);
	Food food2 = new Food("Coffee","Boosts status by 10", 4);
	Food food3 = new Food("Energy Drink","Boosts status by 10", 5);

}//close class
