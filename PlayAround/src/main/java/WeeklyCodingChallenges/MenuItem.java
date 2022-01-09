package WeeklyCodingChallenges;


public class MenuItem {
	
	public String name;
	public boolean type; //0=Food or 1=drink
	public double price;
	
	public MenuItem(String n, boolean t, double p) {
		
		this.name = n;
		this.type = t;
		this.price = p;
		
	}

	@Override
	public String toString() {
		return name;
	}
	
}