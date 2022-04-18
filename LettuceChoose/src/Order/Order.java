package Order;
import java.util.ArrayList;
import java.util.List;

import Ingredient.Ingredient;
import Restaurant.Restaurant;



public class Order {
	
	
	Restaurant restaurant;
	
	String name;
	String base;
	String protein;
	List<String> toppings;
	
	double tip;
	double taxRate = 0.15;
	
	public Order() {
		restaurant = new Restaurant();
		toppings = new ArrayList<String>();
	}
	
	// MANAGES:
	// name of the customer
	// total price (subtotal+tax+tip)
	// total chosen ingredients
	// print Receipt
	
	public void setName(String nameInput) {
		this.name = nameInput;
	}
	
	public void setBase(String baseInput) {
		this.base = baseInput;
	}
	
	public void setProtein(String proteinInput) {
		this.protein = proteinInput;
	}
	
	public void setTopping(String toppingInput) {
		this.toppings.add(toppingInput);
	}
	
	public void setTipAmount(double tip) {
		this.tip = tip;
	}
	
	public void calculateSubtotal() {
		double basePrice = restaurant.getInventory().get(base).getPrice();
		double proteinPrice = restaurant.getInventory().get(protein).getPrice();
		double toppingPrice = 0;
		for (String topping:this.toppings) {
			toppingPrice += restaurant.getInventory().get(topping).getPrice();
		}
		
		
		double subtotal = basePrice + proteinPrice + toppingPrice;
		subtotal += subtotal * this.taxRate;
		double finalTotal = subtotal + this.tip;
	}
	public void printReceipt() {
		
	}
	
	
}
