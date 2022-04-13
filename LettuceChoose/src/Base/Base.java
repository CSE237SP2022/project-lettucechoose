package Base;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Base {
	public Map<String, Integer> ingredientsInventory;
	private Map<Integer, String> integerToIngredient;
	
	public Base(){
		ingredientsInventory = new HashMap<String,Integer>();
		ingredientsInventory.put("salad", 3);
		ingredientsInventory.put("soba", 3);
		ingredientsInventory.put("rice", 3);
		
		integerToIngredient = new HashMap<Integer,String>();
		integerToIngredient.put(1, "salad");
		integerToIngredient.put(2, "soba");
		integerToIngredient.put(3, "rice");
	}
	
	public Boolean doesExists(Integer selected) {
		return this.integerToIngredient.containsKey(selected);
	}
	
	public Boolean isAvailable(String selectedBase) {
		int ingredientCount = this.ingredientsInventory.get(selectedBase);
		
		if (ingredientCount < 1) {
			return false;
		}
		
		this.ingredientsInventory.put(selectedBase, ingredientCount-1);
		return true;
	}
	
	public String getBaseString(Integer selectedBase) {
		return this.integerToIngredient.get(selectedBase);
	}

}
