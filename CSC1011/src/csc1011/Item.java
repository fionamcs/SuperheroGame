package csc1011;

public class Item {//open class
	
	//declare variables
		public String name;
		public String itemDescription;
		public double cost;
		
		//constructor
		public Item(String name, String itemDescription, double cost) {
			this.name = name;
			this.itemDescription = itemDescription;
			this.cost = cost;
		}//close constructor

		//getters and setters
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getItemDescription() {
			return itemDescription;
		}

		public void setItemDescription(String itemDescription) {
			this.itemDescription = itemDescription;
		}

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}
}//close class
