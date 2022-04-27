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

	public Order(Restaurant restaurant) {
		this.restaurant = restaurant;
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
	
	public String getBase() {
		return this.base;
	}
	
	public String getProtein() {
		return this.protein;
	}
	
	public List<String> getToppings() {
		return this.toppings;
	}
	
	public void calculateIngredientPrice() {
		basePrice = restaurant.getInventory().get(base).getPrice();
		proteinPrice = restaurant.getInventory().get(protein).getPrice();
		toppingPrice = 0;
		for (String topping : this.toppings) {
			toppingPrice += restaurant.getInventory().get(topping).getPrice();
		}
	}
	
	public double getEachToppingPrice(String topping) {
		return restaurant.getInventory().get(topping).getPrice();
	}

	public void printReceipt() {
		calculateSubtotal();
		calculateTax();
		calculateTotal();
		
		printReceiptTopTemplate();
		printReceiptDateAndCustomer();
		printReceiptSaladIngredients();
		printReceiptPrice();
		printReceiptBottomTemplate();
	}
	
	public double calculateSubtotal() {
		calculateIngredientPrice();
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

	private void printReceiptTopTemplate() {
		System.out.println(".");
		System.out.println(".");
		System.out.println("┌───────────────────────────────┐");
		System.out.println(printReceiptEmptySpace());
	}

	private void printReceiptDateAndCustomer() {
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("│         LettuceChoose         │");
		System.out.println("│      " + dateTimeFormat.format(currentTime) + "      │");
		System.out.println(printReceiptEmptySpace());
		System.out.println(String.format("│%-8s", "   Order for: ") + String.format("%-17s│", this.name));
		System.out.println(printReceiptEmptySpace());
	}
	
	private void printReceiptSaladIngredients() {
		calculateIngredientPrice();
		System.out.println(String.format("│%-22s", "   Base: " + this.base) + String.format("%-9s│", "$" + this.basePrice ));
		System.out.println(String.format("│%-22s", "   Protein: " + this.protein) + String.format("%-9s│", "$" + this.proteinPrice));
		for (String topping : this.toppings) {
			System.out.println(String.format("│%-22s", "   Topping: " + topping) + String.format("%-9s│", "$" + getEachToppingPrice(topping)));
		}
		System.out.println("│  ===========================  │");
	}
	
	private void printReceiptPrice() {
		System.out.println(String.format("│%-22s", "   Subtotal") + String.format("%-9s│", "$"+ this.subTotal));
		System.out.println(String.format("│%-22s", "   Tax") + String.format("%-9s│", "$" + this.tax));
		System.out.println(String.format("│%-22s", "   Tip") + String.format("%-9s│", "$" + this.tip));
		System.out.println(String.format("│%-22s", "   Total") + String.format("%-9s│", "$" + this.finalTotal));
	}
	
	private void printReceiptBottomTemplate() {
		System.out.println(printReceiptEmptySpace());
		System.out.println("│       T h a n k  y o u        │");
		System.out.println("└───────────────────────────────┘");
	}
	
	private String printReceiptEmptySpace() {
		String emptySpace = "│                               │";
		return emptySpace;
	}
}
