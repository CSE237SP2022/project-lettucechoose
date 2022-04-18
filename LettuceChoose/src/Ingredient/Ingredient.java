package Ingredient;

public class Ingredient {
	String category;
	String name;
	double price;
	int quantity;

	public Ingredient(String category, String name, double price, int quantity) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getCategory() {
		return this.category;
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
