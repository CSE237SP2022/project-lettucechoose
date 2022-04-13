package Topping;

import java.util.HashMap;

import java.util.Map;

@SuppressWarnings("unchecked")
public class Topping {
	
	/**
	 *  ingredientsInventory - keeps track of the quantity of each topping. 
	 *  integerToIngredient - maps the integer value & string value of topping. 
	 */
	public Map<String, Integer> ingredientsInventory;
	private Map<Integer, String> integerToIngredient;
	
	public Topping(){
		ingredientsInventory = new HashMap<String,Integer>();
		ingredientsInventory.put("edamame", 3);
		ingredientsInventory.put("guacamole", 3);
		ingredientsInventory.put("tomato", 3);
		ingredientsInventory.put("onion", 3);
		ingredientsInventory.put("masago", 3);
		ingredientsInventory.put("none", Integer.MAX_VALUE);
		
		integerToIngredient = new HashMap<Integer,String>();
		integerToIngredient.put(1, "edamame");
		integerToIngredient.put(2, "guacamole");
		integerToIngredient.put(3, "tomato");
		integerToIngredient.put(4, "onion");
		integerToIngredient.put(5, "masago");
		integerToIngredient.put(6, "none");
	}
	
	/**
	 * @param selected - the value that Scanner reads (the user input)
	 * @return - returns true when the value is in the map, returns false otherwise
	 * 
	 * This is to check whether the user input is a valid value for topping
	 */
	public Boolean doesExists(Integer selected) {
		return this.integerToIngredient.containsKey(selected);
	}
	
	
	/**
	 * 
	 * @param selectedTopping - the value that user picks for the topping
	 * @return - returns true if the selectedTopping is in stock. returns false otherwise.
	 */
	public Boolean isAvailable(String selectedTopping) {
		int ingredientCount = this.ingredientsInventory.get(selectedTopping);
		
		if (ingredientCount < 1) {
			return false;
		}
		
		this.ingredientsInventory.put(selectedTopping, ingredientCount-1);
		return true;
	}
	
	/**
	 * 
	 * @param selectedTopping - The value the user types in the command line
	 * @return - String value of the topping. 
	 * 
	 * Users are prompted to type integer value of the topping.
	 * This is to find the string value of the topping. 
	 */
	public String getToppingString(Integer selectedTopping) {
		return this.integerToIngredient.get(selectedTopping);
	}

}
