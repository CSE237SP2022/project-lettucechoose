package Protein;

import java.util.HashMap;

import java.util.Map;

@SuppressWarnings("unchecked")
public class Protein {
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
		integerToIngredient.put(3, "tofu");
	}
	
	public Boolean doesExists(Integer selected) {
		return this.integerToIngredient.containsKey(selected);
	}
	
	public Boolean isAvailable(String selectedProtein) {
		int ingredientCount = this.ingredientsInventory.get(selectedProtein);
		
		if (ingredientCount < 1) {
			return false;
		}
		
		this.ingredientsInventory.put(selectedProtein, ingredientCount-1);
		return true;
	}
	
	public String getProteinString(Integer selectedProtein) {
		return this.integerToIngredient.get(selectedProtein);
	}
}
