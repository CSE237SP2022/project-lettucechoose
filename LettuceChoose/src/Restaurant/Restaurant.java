package Restaurant;

import java.util.HashMap;
import java.util.Scanner;

import Ingredient.Ingredient;
import Order.Order;

public class Restaurant {
	
	private HashMap<String, Ingredient> inventory;
	
	public Restaurant() {
		inventory = new HashMap<String, Ingredient>();
		setInventory();
	}
	
	

	public void setInventory() { 		// type, name, price, quantity
		Ingredient salad = new Ingredient("base", "salad", 3.5, 3);
		Ingredient soba = new Ingredient("base", "soba", 4, 3);
		Ingredient rice = new Ingredient("base", "rice", 3.5, 3);
				
		Ingredient beef = new Ingredient("protein", "beef", 5, 3);
		Ingredient chicken = new Ingredient("protein", "chicken", 4, 3);
		Ingredient tofu = new Ingredient("protein", "tofu", 3.5, 3);
		
		Ingredient edamame = new Ingredient("topping", "edamame", 1, 3);
		Ingredient avocado = new Ingredient("topping", "avocado", 2.5, 3);
		Ingredient tomato = new Ingredient("topping", "tomato", 1.5, 3);
		Ingredient mango = new Ingredient("topping", "mango", 2, 3);
		
		this.inventory.put("salad", salad);
		this.inventory.put("soba", soba);
		this.inventory.put("rice", rice);
		
		this.inventory.put("beef", beef);
		this.inventory.put("chicken", chicken);
		this.inventory.put("tofu", tofu);
		
		this.inventory.put("edamame", edamame);
		this.inventory.put("avocado", avocado);
		this.inventory.put("tomato", tomato);
		this.inventory.put("mango", mango);
	}
	
	
	
	public Boolean isValidIngredient(String item) {
		return this.getInventory().containsKey(item);
	}
	
	
	public Boolean isInStock(String item) {
		Ingredient selectedIngredient = this.getInventory().get(item);
		if (selectedIngredient.getQuantity() > 0) {
			return true;
		}
		return false;
	}
	
	
	public void decrementQuantity(String item) {
		Ingredient selectedIngredient = this.getInventory().get(item);
		selectedIngredient.updateQuantity(-1);
	}
	
	
	public HashMap<String, Ingredient> getInventory() {
		return this.inventory;
	}
	
	public void askAndSetName(Order order, Scanner scanner) {
		System.out.println("Please enter your name!");
		String inputName = scanner.nextLine();
		order.setName(inputName);
	}


	public void askAndSetIngredients(Order order, String category, Scanner scanner) {
		Boolean isChosen = false;
		while(!isChosen) {
			System.out.println("Please select your " + category);
			promptOptions(category);
			String inputIngredient = scanner.nextLine();
			inputIngredient = inputIngredient.toLowerCase();
			if (isValidIngredient(inputIngredient) && isInStock(inputIngredient) && isInCategory(inputIngredient, category)) {
				decrementQuantity(inputIngredient);
				if (category.equals("base")) {
					order.setBase(inputIngredient);
				}else if (category.equals("protein")) {
					order.setProtein(inputIngredient);
				}else if (category.equals("topping")) {
					order.setTopping(inputIngredient);
				}
				isChosen = true;
			}else {
				System.out.println("Please select a valid item from the options.");
			}
		}
	}
	
	public void promptOptions(String category) {
		if (category.equals("base")) {
			System.out.println("Options: salad, soba, rice");
		}else if (category.equals("protein")) {
			System.out.println("Options: beef, chicken, tofu");
		}else {
			System.out.println("Options: edamame, avocado, tomato, mango");

		}
	}

	public void askForTip(Order order, Scanner scanner) {
		System.out.println("Would you like to tip? Please enter in numbers");
		double inputTip = scanner.nextDouble();
		order.setTipAmount(inputTip);
	}

	// visibility changed to public for the testing purposes
	public boolean isInCategory(String inputIngredient, String category) {
		return this.inventory.get(inputIngredient).getCategory().equals(category);
	}

	
	
}
