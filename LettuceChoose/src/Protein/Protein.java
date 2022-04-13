package Protein;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Protein {
	
	/**
	 *  ingredientsInventory - keeps track of the quantity of each protein. 
	 *  integerToIngredient - maps the integer value & string value of protein.
	 */
	public Map<String, Integer> ingredientsInventory;
	private Map<Integer, String> integerToIngredient;
	
	public Protein(){
		ingredientsInventory = new HashMap<String,Integer>();
		ingredientsInventory.put("beef", 3);
		ingredientsInventory.put("chicken", 3);
		ingredientsInventory.put("salmon", 3);
		ingredientsInventory.put("tofu", 3);
		
		integerToIngredient = new HashMap<Integer,String>();
		integerToIngredient.put(1, "beef");
		integerToIngredient.put(2, "chicken");
		integerToIngredient.put(3, "salmon");
		integerToIngredient.put(4, "tofu");
	}
	
	
	
	/**
	 * 
	 * @param selected - the value that Scanner reads (the user input)
	 * @return - returns true when the value is in the map, returns false otherwise
	 * 
	 * This is to check whether the user input is a valid value for protein
	 */
	public Boolean doesExists(Integer selected) {
		return this.integerToIngredient.containsKey(selected);
	}
	
	
	
	
	/**
	 * 
	 * @param selectedProtein - the value that user picks for the protein
	 * @return - returns true if the selectedProtein is in stock. returns false otherwise.
	 */
	public Boolean isAvailable(String selectedProtein) {
		int ingredientCount = this.ingredientsInventory.get(selectedProtein);
		
		if (ingredientCount < 1) {
			return false;
		}
		
		this.ingredientsInventory.put(selectedProtein, ingredientCount-1);
		return true;
	}
	
	
	
	
	
	/**
	 * 
	 * @param selectedProtein - The value the user types in the command line
	 * @return - String value of the protein. 
	 * 
	 * Users are prompted to type integer value of the protein.
	 * This is to find the string value of the protein. 
	 */
	public String getProteinString(Integer selectedProtein) {
		return this.integerToIngredient.get(selectedProtein);
	}
}
