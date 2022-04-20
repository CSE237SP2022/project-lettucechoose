package Order;

import java.util.ArrayList;
import java.util.List;

import Ingredient.Ingredient;
import Restaurant.Restaurant;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Order {

	Restaurant restaurant;

	String name;
	String base;
	String protein;
	List<String> toppings;

	double basePrice;
	double proteinPrice;
	double toppingPrice;
	
	double tip;
	double taxRate = 0.15;
	double tax;
	double subTotal;
	double finalTotal;

	public Order() {
		restaurant = new Restaurant();
		toppings = new ArrayList<String>();
	}

	
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

	public double calculateSubtotal() {
		double basePrice = restaurant.getInventory().get(base).getPrice();
		double proteinPrice = restaurant.getInventory().get(protein).getPrice();
		double toppingPrice = 0;
		for (String topping : this.toppings) {
			toppingPrice += restaurant.getInventory().get(topping).getPrice();
		}
		this.subTotal = basePrice + proteinPrice + toppingPrice;
		return this.subTotal;
	}

	public double calculateTax() {
		this.tax = Math.round(this.subTotal * taxRate * 100.0) / 100.0;
		return this.tax;
	}
	
	public double calculateTotal() {
		this.finalTotal = this.subTotal + this.tax + this.tip;
		return this.finalTotal;
	}

	public void printReceipt() {

		calculateSubtotal();
		calculateTax();
		calculateTotal();
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime currentTime = LocalDateTime.now();
		String emptySpace = "│                               │";

		System.out.println(".");
		System.out.println(".");

		System.out.println("┌───────────────────────────────┐");

		System.out.println(emptySpace);
		System.out.println("│         LettuceChoose         │");
		System.out.println("│      " + dateTimeFormat.format(currentTime) + "      │");
		System.out.println(emptySpace);
		System.out.println(String.format("│%-8s", "   Order for: ") + String.format("%-17s│", this.name));
		System.out.println(emptySpace);
		System.out.println(String.format("│%-10s", "     Base: ") + String.format("%-20s│", this.base));
		System.out.println(String.format("│%-10s", "     Protein: ") + String.format("%-17s│", this.protein));
		
		for (String topping : this.toppings) {
			System.out.println(String.format("│%-10s", "     Topping: ") + String.format("%-17s│", topping));
		}
		
		// System.out.println(String.format("│%-10s", " Drink: ") +
		// String.format("%-8s", receiptDrink) + String.format("%8s │", "$"+
		// receiptDrinkPrice));
		System.out.println("│  ===========================  │");
		System.out.println(String.format("│%-24s", "   Subtotal") + String.format("%-7s│", "$"+ this.subTotal));
		System.out.println(String.format("│%-24s", "   Tax") + String.format("%-7s│", "$" + this.tax));
		System.out.println(String.format("│%-24s", "   Tip") + String.format("%-7s│", "$" + this.tip));
		System.out.println(String.format("│%-24s", "   Total") + String.format("%-7s│", "$" + this.finalTotal));
		System.out.println(emptySpace);
		System.out.println("│       T h a n k  y o u        │");
		System.out.println("└───────────────────────────────┘");
	}

}
