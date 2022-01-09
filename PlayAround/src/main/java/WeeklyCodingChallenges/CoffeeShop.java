package WeeklyCodingChallenges;

import java.util.ArrayList;

public class CoffeeShop {

	public String name;
	public ArrayList<MenuItem> orders = new ArrayList<MenuItem>();
	public ArrayList<MenuItem> items = new ArrayList<MenuItem>();
	private static boolean food = false;
	private static boolean drink = true;
	
	
	public void setName (String n) {
		this.name = n;
	}
	
	public void addMenuItem(MenuItem m) {
		
		this.items.add(m);
	}
	
	public void addOrder(MenuItem anItem) {
		
		if (this.items.contains(anItem)) {
			orders.add(anItem);
			System.out.println("A "+anItem+" has been ordered.");
		} else {
			System.out.println("A "+anItem+" is not available!");
		}
	}
	
	public void fulfillOrder() {
		
		if (this.orders.size()>0) {
			System.out.println("The order for "+this.orders.get(0)+" has bene fulfilled.");
			this.orders.remove(0);
		} else {
			System.out.println("All orders have been fulfilled!");
		}
	}
	
	public ArrayList<MenuItem> listOrders () {
		
		
		ArrayList<MenuItem> lo = new ArrayList<MenuItem>();
		
		for(MenuItem anOrder: this.orders) {
			lo.add(anOrder);
		}
		
		return lo;
	}
	
	public double dueAmount () {
		double due=0;
		for(MenuItem anOrder: this.orders) {
			due += anOrder.price;
		}
		return due;
			
	}
	
	public ArrayList<MenuItem> cheapestItem() {
		
		ArrayList<MenuItem> cheap = new ArrayList<MenuItem>();
		
		//If there are no items on the menu, return an "item" saying so
		if (this.items.size()==0) {
			MenuItem nothing = new MenuItem("NO ITEMS ON MENU",false,0.00);
			cheap.add(nothing);
			return cheap;
		}
		
		//Find the cheapest price on the menu
		double lowPrice = this.items.get(0).price;
		for ( MenuItem anItem : this.items)
			if (anItem.price < lowPrice)
				lowPrice = anItem.price;
		
		//Now, find all the items that are this price.
		for (MenuItem anItem : this.items)
			if (anItem.price == lowPrice)
				cheap.add(anItem);
		
		return cheap;
			
	}
	
	public ArrayList<MenuItem> foodOnly () {
		
		ArrayList<MenuItem> listing = new ArrayList<MenuItem>();
		
		for(MenuItem anItem: this.items)
			if (anItem.type == this.food)
				listing.add(anItem);
		return listing;
	}
	
	public ArrayList<MenuItem> drinkOnly () {
		
		ArrayList<MenuItem> listing = new ArrayList<MenuItem>();
		
		for(MenuItem anItem: this.items)
			if (anItem.type == this.drink)
				listing.add(anItem);
		return listing;
	}
	
		
	public static void main (String[] args) {
		
		//The "main" method
		CoffeeShop cs = new CoffeeShop();
		
		//Find the cheapest item on the menu
		System.out.println("The cheapest item on the menu costs $"+cs.cheapestItem().get(0).price+ 
				", and is "+cs.cheapestItem());
		
		//Add some menu items
		MenuItem m1 = new MenuItem("Dark Roast",drink,4.25);
		MenuItem m2 = new MenuItem("Frappachino",drink,3.47);
		MenuItem m3 = new MenuItem("Cake",food,5.31);
		MenuItem m4 = new MenuItem("Banana Bread",food,3.15);
		MenuItem m6 = new MenuItem("Pumpkin Bread",food,3.15);
		MenuItem m7 = new MenuItem("Lemon Loaf",food,3.15);
		MenuItem m5 = new MenuItem("Pizza",food,15.00);
		
		cs.addMenuItem(m1);
		cs.addMenuItem(m2);
		cs.addMenuItem(m3);
		cs.addMenuItem(m4);
		cs.addMenuItem(m6);
		cs.addMenuItem(m7);
		
		//order some items
		cs.addOrder(m1);
		cs.addOrder(m2);
		cs.addOrder(m5);
		cs.addOrder(m1);
		cs.addOrder(m3);
		
		//List orders before fulfilling
		System.out.println("There are currently "+cs.listOrders().size()+" in the shop for "+cs.listOrders());
		
		//Total due for all orders
		System.out.println("The total due for all orders is $"+cs.dueAmount());
		
		//Fulfill orders.
		cs.fulfillOrder();
		cs.fulfillOrder();
		cs.fulfillOrder();
		cs.fulfillOrder();
		cs.fulfillOrder();
		cs.fulfillOrder();
		
		//List orders after fulfilling
		System.out.println("There are currently "+cs.listOrders().size()+" in the shop for "+cs.listOrders());
		
		//Find the cheapest item on the menu
		System.out.println("The cheapest item on the menu costs $"+cs.cheapestItem().get(0).price+ 
				", and is "+cs.cheapestItem());
		
		//List all food items on the menu
		System.out.println("All of the food items are :"+cs.foodOnly());
		
		//List all drink items on the menu
		System.out.println("All of the drink items are :"+cs.drinkOnly());
		
	}

}