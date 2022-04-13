package Drink;

import java.util.HashMap;
import java.util.Map;


public class Drink {
	public Map<String, Integer> drinksInventory;
	public Map<String, Integer> drinkPrice;
	private Map<Integer, String> integerToDrinks;
	
	public Drink(){
		drinksInventory = new HashMap<String,Integer>();
		drinksInventory.put("coke", 3);
		drinksInventory.put("sprite", 3);
		drinksInventory.put("iced tea", 3);
		drinksInventory.put("none", Integer.MAX_VALUE);
		
		integerToDrinks = new HashMap<Integer,String>();
		integerToDrinks.put(1, "coke");
		integerToDrinks.put(2, "sprite");
		integerToDrinks.put(3, "iced tea");
		integerToDrinks.put(4, "none");
		
		drinkPrice = new HashMap<String, Integer>();
		drinkPrice.put("coke", 2);
		drinkPrice.put("sprite", 3);
		drinkPrice.put("iced tea", 2);
		drinkPrice.put("none", 0);
	}
	
	public Boolean doesExists(Integer selected) {
		return this.integerToDrinks.containsKey(selected);
	}
	
	public Boolean isAvailable(String selectedDrink) {
		int drinkCount = this.drinksInventory.get(selectedDrink);
		
		if (drinkCount < 1) {
			return false;
		}
		
		this.drinksInventory.put(selectedDrink, drinkCount-1);
		return true;
	}
	
	public String getDrinkString(Integer selectedDrink) {
		return this.integerToDrinks.get(selectedDrink);
	}
	
	public int getDrinkPrice(Integer selectedDrink) {
		String drinkString = this.integerToDrinks.get(selectedDrink);
		return this.drinkPrice.get(drinkString);
	}
}
