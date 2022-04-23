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
		putBaseToInventory();
		putProteinToInventory();
		putToppingToInventory();
	}

	private void putToppingToInventory() {
		Ingredient edamame = new Ingredient("topping", "edamame", 1, 3);
		Ingredient avocado = new Ingredient("topping", "avocado", 2.5, 3);
		Ingredient tomato = new Ingredient("topping", "tomato", 1.5, 3);
		Ingredient mango = new Ingredient("topping", "mango", 2, 3);
		this.inventory.put("edamame", edamame);
		this.inventory.put("avocado", avocado);
		this.inventory.put("tomato", tomato);
		this.inventory.put("mango", mango);
	}



	private void putProteinToInventory() {
		Ingredient beef = new Ingredient("protein", "beef", 5, 3);
		Ingredient chicken = new Ingredient("protein", "chicken", 4, 3);
		Ingredient tofu = new Ingredient("protein", "tofu", 3.5, 3);
		this.inventory.put("beef", beef);
		this.inventory.put("chicken", chicken);
		this.inventory.put("tofu", tofu);
	}
	
	public void putBaseToInventory() {
		Ingredient salad = new Ingredient("base", "salad", 3.5, 3);
		Ingredient soba = new Ingredient("base", "soba", 4, 3);
		Ingredient rice = new Ingredient("base", "rice", 3.5, 3);
		this.inventory.put("salad", salad);
		this.inventory.put("soba", soba);
		this.inventory.put("rice", rice);
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
	
	public int checkQuantity(String item) {
		if (isValidIngredient(item)) {
			Ingredient selectedIngredient = this.getInventory().get(item);
			return selectedIngredient.getQuantity();
		} else {
			return -1;
		}
	}
	
	
	public void decrementQuantity(String item) {
		Ingredient selectedIngredient = this.getInventory().get(item);
		selectedIngredient.updateQuantity(-1);
	}
	
	public void incrementQuantity(String item, int amount) {
		Ingredient selectedIngredient = this.getInventory().get(item);
		selectedIngredient.updateQuantity(amount);
	}
	
	
	public HashMap<String, Ingredient> getInventory() {
		return this.inventory;
	}
	
	
	
	public Boolean askAndSetName(Order order, Scanner scanner) {
		System.out.println("Please enter your name!");
		System.out.print("> ");
		String inputName = scanner.nextLine();
		if (inputName.equals("q")) {
			return false;
		}
		order.setName(inputName);
		return true;
	}

	
	public Boolean askAndSetIngredients(Order order, String category, Scanner scanner) {
		Boolean isChosen = false;
		while(!isChosen) {
			System.out.print("Please select your " + category + ".");
			promptOptions(category);
			System.out.print("> ");
			String inputIngredient = scanner.nextLine();
			if (inputIngredient.equals("q")) {
				resetOrder(order);
				return false;
			}
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
			}else if (isValidIngredient(inputIngredient) && !isInStock(inputIngredient) && isInCategory(inputIngredient, category)) {
				System.out.println("Sorry, " + inputIngredient + " is sold out. Please select from other options.");
			}else {
				System.out.println("Please select a valid item from the options.");
			}
		}
		return true;
	}
	
	public void promptOptions(String category) {
		if (category.equals("base")) {
			System.out.println(" Options: salad, soba, rice");
		}else if (category.equals("protein")) {
			System.out.println(" Options: beef, chicken, tofu");
		}else {
			System.out.println(" Options: edamame, avocado, tomato, mango");
		}
	}

	public Boolean askForTip(Order order, Scanner scanner) {
		System.out.println("Would you like to tip? Please enter in numbers");
		System.out.print("> ");
		String inputTipString = scanner.nextLine();
		if (inputTipString.equals("q")) {
			resetOrder(order);
			return false;
		}
		double inputTip = Double.parseDouble(inputTipString);
		order.setTipAmount(inputTip);
		return true;
	}
	
	

	// visibility changed to public for the testing purposes
	public boolean isInCategory(String inputIngredient, String category) {
		return this.inventory.get(inputIngredient).getCategory().equals(category);
	}

	
	
	public void resetOrder(Order order) {
		System.out.println("Canceling your order..");
		System.out.println(".");
		System.out.println(".");
		if (order.getBase() != null) {
			incrementQuantity(order.getBase(), 1);
		} 
		if (order.getProtein() != null) {
			incrementQuantity(order.getProtein(), 1);
		}
		for (String topping:order.getToppings()) {
			incrementQuantity(topping, 1);
		}
	}
	
	
	//vendor functionalities

	public String vendorCheckIngredientQuantity(Scanner scanner) {
		System.out.println("Type in any ingredients to check the quantity.");
		System.out.print("> ");
		String checkIngredient = scanner.nextLine();
		
		int ingredientQuantity = this.checkQuantity(checkIngredient);
		if (ingredientQuantity == -1) {
			System.out.println("Invalid ingredient name");
			return "Invalid";
		} 
		System.out.println(checkIngredient + ": " + ingredientQuantity);
		return checkIngredient;
	}
	
	
	public void vendorRestockQuantity(String ingredient, Scanner scanner) {
		System.out.println("Would you like to restock " + ingredient + "? (y/n)");
		System.out.print("> ");
		String yn = scanner.nextLine();
		if (yn.equals("y")) {
			System.out.println("How much quantity are you restocking?");
			int restockCount = scanner.nextInt();
			scanner.nextLine();
			this.incrementQuantity(ingredient, restockCount);
			System.out.println("You have successfully restocked " + ingredient + ".");
		} else if (yn.equals("n")) {
			System.out.println("You have successfully not restocked " + ingredient + ".");
		} else {
			System.out.println("Please answer in 'y' or 'n'.");
			vendorRestockQuantity(ingredient, scanner);
		}
	}
	
	public Boolean vendorAskQuit(Scanner scanner) {
		System.out.println("Please type 'q' to quit or any other keys to check other ingredients.");
		System.out.print("> ");
		String continueOrNot = scanner.nextLine();
		if (!continueOrNot.equals("q")) {
			return true;
		} return false;
	}

	
	
	
	
}
