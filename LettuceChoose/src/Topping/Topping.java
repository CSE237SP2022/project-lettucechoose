package Topping;

import java.util.HashMap;

import java.util.Map;

@SuppressWarnings("unchecked")
public class Topping {
	public Map<String, Integer> ingredientsInventory;
	private Map<Integer, String> integerToIngredient;
	
	public Topping(){
		ingredientsInventory = new HashMap<String,Integer>();
		ingredientsInventory.put("edamame", 3);
		ingredientsInventory.put("guacamole", 3);
		ingredientsInventory.put("tomato", 3);
		ingredientsInventory.put("onion", 3);
		ingredientsInventory.put("masago", 3);
		
		integerToIngredient = new HashMap<Integer,String>();
		integerToIngredient.put(1, "edamame");
		integerToIngredient.put(2, "guacamole");
		integerToIngredient.put(3, "tomato");
		integerToIngredient.put(4, "onion");
		integerToIngredient.put(5, "masago");
	}
	
	public Boolean doesExists(Integer selected) {
		return this.integerToIngredient.containsKey(selected);
	}
	
	public Boolean isAvailable(String selectedTopping) {
		int ingredientCount = this.ingredientsInventory.get(selectedTopping);
		
		if (ingredientCount < 1) {
			return false;
		}
		
		this.ingredientsInventory.put(selectedTopping, ingredientCount-1);
		return true;
	}
	
	public String getToppingString(Integer selectedTopping) {
		return this.integerToIngredient.get(selectedTopping);
	}

}
