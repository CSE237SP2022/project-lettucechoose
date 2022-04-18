package Ingredient;

public class Ingredient {
	String type;
	String name;
	double price;
	int quantity;

	public Ingredient(String type, String name, double price, int quantity) {
		this.type = type;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void updateQuantity(int amount) {
		this.quantity += amount;
	}
	
}
