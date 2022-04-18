package Order;
import java.util.ArrayList;
import Ingredient.Ingredient;
import Restaurant.Restaurant;



public class Order {
	
	
	Restaurant restaurant;
	
	String base;
	String protein;
	String[] topping;
	
	double tip;
	double taxRate = 0.15;
	
	public Order() {
		restaurant = new Restaurant();
	}
	
	// MANAGES:
	// name of the customer
	// total price (subtotal+tax+tip)
	// total chosen ingredients
	// print Receipt
	
	public void setBase(String baseInput) {
		this.base = baseInput;
	}
	
	public void setProtein(String proteinInput) {
		this.protein = proteinInput;
	}
	
	public void setTopping(String topping1, String topping2, String topping3) {
		this.topping = new String[]{topping1, topping2, topping3};
	}
	
	public void setTipAmount(double tip) {
		this.tip = tip;
	}
	
	public void calculateSubtotal() {
		double basePrice = restaurant.getInventory().get(base).getPrice();
		double proteinPrice = restaurant.getInventory().get(protein).getPrice();
//		double toppingPrice = restaurant.getInventory().get(topping).getPrice();
		
		
		double subtotal = basePrice + proteinPrice + toppingPrice;
		subtotal += subtotal * this.taxRate;
		double finalTotal = subtotal + this.tip;
	}
	public void printReceipt() {
		
	}
	
	
}
