package Base;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Base {
	/**
	 *  ingredientsInventory - keeps track of the quantity of each base. 
	 *  integerToIngredient - maps the integer value & string value of base. 
	 */
	
	public Map<String, Integer> ingredientsInventory;
	private Map<Integer, String> integerToIngredient;
	
	
	
	public Base(){
		
		// Ingredients' initial stock is 3
		ingredientsInventory = new HashMap<String,Integer>();
		ingredientsInventory.put("salad", 3);  
		ingredientsInventory.put("soba", 3);
		ingredientsInventory.put("rice", 3);
		
		integerToIngredient = new HashMap<Integer,String>();
		integerToIngredient.put(1, "salad");
		integerToIngredient.put(2, "soba");
		integerToIngredient.put(3, "rice");
	}
	
	/**
	 * 
	 * @param selected - the value that Scanner reads (the user input)
	 * @return - returns true when the value is in the map, returns false otherwise
	 * 
	 * This is to check whether the user input is a valid value for base
	 */
	public Boolean doesExists(Integer selected) {
		return this.integerToIngredient.containsKey(selected);
	}
	
	/**
	 * 
	 * @param selectedBase - the value that user picks for the base
	 * @return - returns true if the selectedBase is in stock. returns false otherwise.
	 */
	public Boolean isAvailable(String selectedBase) {
		int ingredientCount = this.ingredientsInventory.get(selectedBase);
		
		if (ingredientCount < 1) {
			return false;
		}
		
		this.ingredientsInventory.put(selectedBase, ingredientCount-1);
		return true;
	}
	
	/**
	 * 
	 * @param selectedBase - The value the user types in the command line
	 * @return - String value of the base. 
	 * 
	 * Users are prompted to type integer value of the base.
	 * This is to find the string value of the base. 
	 */
	public String getBaseString(Integer selectedBase) {
		return this.integerToIngredient.get(selectedBase);
	}

}
