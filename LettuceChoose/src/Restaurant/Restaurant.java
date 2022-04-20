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
		Ingredient beef = new Ingredient("protein", "beef", 5, 3);
		Ingredient edamame = new Ingredient("topping", "edamame", 1, 3);
		Ingredient onion = new Ingredient("topping", "green", 1.5, 3);
		Ingredient mango = new Ingredient("topping", "mango", 2, 3);
		
		this.inventory.put("salad", salad);
		this.inventory.put("beef", beef);
		this.inventory.put("edamame", edamame);
		this.inventory.put("onion", onion);
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
				System.out.println("Please select a valid item from the options");
			}
		}
	}
	
	public void promptOptions(String category) {
		if (category.equals("base")) {
			System.out.println("Options: salad");
		}else if (category.equals("protein")) {
			System.out.println("Options: beef");
		}else {
			System.out.println("Options: edamame");
		}
	}


	private boolean isInCategory(String inputIngredient, String category) {
		return this.inventory.get(inputIngredient).getCategory().equals(category);
	}

	
	
}
