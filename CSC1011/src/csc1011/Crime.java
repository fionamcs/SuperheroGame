package csc1011;

public class Crime {//open class
	
	//declare variables
	private String crime;

	//constructor
	Crime(String crime) {
		this.crime = crime;
	}//close constructor
	
	//getters and setters
	public String getCrime() {
		return crime;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}

}//close class
