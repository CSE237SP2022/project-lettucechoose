package Restaurant;

import java.util.HashMap;
import Ingredient.Ingredient;

public class Restaurant {
	
	private HashMap<String, Ingredient> inventory;
	
	public Restaurant() {
		inventory = new HashMap<String, Ingredient>();
		setInventory();
	}
	
	

	public void setInventory() { 		// type, name, price, quantity
		Ingredient salad = new Ingredient("Base", "Salad", 3.5, 3);
		Ingredient beef = new Ingredient("Protein", "Beef", 5, 3);
		Ingredient edamame = new Ingredient("Topping", "Edamame", 1, 3);
		
		this.inventory.put("Salad", salad);
		this.inventory.put("Beef", beef);
		this.inventory.put("Edamame", edamame);
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
		if (isValidIngredient(item) && isInStock(item)) {
			Ingredient selectedIngredient = this.getInventory().get(item);
			selectedIngredient.updateQuantity(-1);
		}
	}
	
	
	public HashMap<String, Ingredient> getInventory() {
		return this.inventory;
	}

	
	
}
