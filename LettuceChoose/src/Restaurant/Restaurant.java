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
	
	private void putBaseToInventory() {
		Ingredient salad = new Ingredient("base", "salad", 3.5, 3);
		Ingredient soba = new Ingredient("base", "soba", 4, 3);
		Ingredient rice = new Ingredient("base", "rice", 3.5, 3);
		this.inventory.put("salad", salad);
		this.inventory.put("soba", soba);
		this.inventory.put("rice", rice);
	}
	
	/*
	 * checks if the input string is a valid type of Ingredient
	 * @param user-input string of ingredient
	 * @return false if input is invalid
	 */
	
	public Boolean isValidIngredient(String item) {
		return this.getInventory().containsKey(item);
	}
	
	/*
	 * checks if the item is in stock by calling checkQuantity()
	 * @param user-input string of ingredient
	 * @return boolean value of quantity being greater than 0
	 */
	
	public Boolean isInStock(String item) {
		Ingredient selectedIngredient = this.getInventory().get(item);
		return (selectedIngredient.getQuantity() > 0);
	}
	
	/*
	 * checks if the item is available by checking its quantity
	 * @param user-input string of ingredient
	 * @return int value of quantity
	 */
	
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
		if (checkUserQuits(inputName, order) == false) return false;  
		order.setName(inputName);
		return true;
	}
	
	public Boolean askAndSetIngredients(Order order, String category, Scanner scanner) {
		Boolean isChosen = false;
		while(!isChosen) {
			System.out.print("Please select your " + category + ".");
			promptOptions(category, order);
			System.out.print("> ");
			String inputIngredient = scanner.nextLine();
			if (checkUserQuits(inputIngredient, order) == false) return false;  
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
	
	public void promptOptions(String category, Order order) {
		if (category.equals("base")) {
			System.out.println(" Options: salad, soba, rice");
		}else if (category.equals("protein")) {
			System.out.println(" Options: beef, chicken, tofu");
		}else {
			int index = order.getToppings().size() + 1;
			System.out.println(" You'll choose 3 toppings. Options: edamame, avocado, tomato, mango (" + index + "/3)");
		}
	}

	public Boolean askForTip(Order order, Scanner scanner) {
		Boolean isChosen = false;
		while (!isChosen) {
			System.out.println("Would you like to tip? Please enter in numbers. If not, please enter '0'");
			System.out.print("> ");
			String inputTipString = scanner.nextLine();
			if (checkUserQuits(inputTipString, order) == false) return false;  
			try {
				double inputTip = Double.parseDouble(inputTipString);
				order.setTipAmount(inputTip);
				isChosen = true;
				return true;
			} catch (NumberFormatException e) {
			    System.out.println("Please type in a numeric value for a tip.");
			}
		}
		return true;
		
		
	}

	// visibility changed to public for the testing purposes
	public Boolean isInCategory(String inputIngredient, String category) {
		return this.inventory.get(inputIngredient).getCategory().equals(category);
	}

  
	public Boolean checkUserQuits(String inputPrompt, Order order) {
		if (inputPrompt.equals("q")) {
			resetOrder(order);
			return false;
		}
		return true;
	}
	
	/*
	 * resets the current order on request
	 * @param the current order
	 * 
	 */
	
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
	public Boolean checkIfVendor() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please press ENTER to start! If you are vendor, please type [vendor].");
		String vendorPasscode = scanner.nextLine();
		return (vendorPasscode.equals("vendor"));
	}
	
	public void vendorFunctionalities() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("====Vendor Page====");

		Boolean vendorContinue = true;
		while(vendorContinue) {
			String ingredient = this.vendorCheckIngredientQuantity(scanner);
			if (!ingredient.equals("Invalid")) {
				this.vendorRestockQuantity(ingredient, scanner);
			} 		
			vendorContinue = this.vendorAskQuit(scanner);
		}
	}

	public String vendorCheckIngredientQuantity(Scanner scanner) {
		System.out.println("Type in any ingredients to check the quantity.");
		System.out.print("> ");
		String checkIngredient = scanner.nextLine();
		checkIngredient = checkIngredient.toLowerCase();
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
		String restockResponse = scanner.nextLine();
		if (restockResponse.equals("y")) {
			System.out.println("How much quantity are you restocking?");
			System.out.print("> ");
			int restockCount = scanner.nextInt();
			scanner.nextLine();
			this.incrementQuantity(ingredient, restockCount);
			System.out.println("You have successfully restocked " + ingredient + ".");
		} else if (restockResponse.equals("n")) {
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
