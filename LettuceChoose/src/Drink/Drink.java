package Drink;

import java.util.HashMap;
import java.util.Map;


public class Drink {
	
	/**
	 *  drinksInventory - keeps track of the quantity of each drink. 
	 *  integerToDrinks - maps the integer value & string value of drink. 
	 *  drinkPrice - maps the drink and its price
	 */
	public Map<String, Integer> drinksInventory;
	private Map<Integer, String> integerToDrinks;
	public Map<String, Integer> drinkPrice;
	
	public Drink(){
		// Drinks' initial stock is 3
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
		drinkPrice.put("iced tea", 4);
		drinkPrice.put("none", 0);
	}
	
	
	
	/**
	 * 
	 * @param selected - the value that Scanner reads (the user input)
	 * @return - returns true when the value is in the map, returns false otherwise
	 * 
	 * This is to check whether the user input is a valid value for drink
	 */
	public Boolean doesExists(Integer selected) {
		return this.integerToDrinks.containsKey(selected);
	}
	
	
	
	
	/**
	 * 
	 * @param selectedDrink - the value that user picks for the drink
	 * @return - returns true if the selectedDrink is in stock. returns false otherwise.
	 */
	public Boolean isAvailable(String selectedDrink) {
		int drinkCount = this.drinksInventory.get(selectedDrink);
		
		if (drinkCount < 1) {
			return false;
		}
		
		this.drinksInventory.put(selectedDrink, drinkCount-1);
		return true;
	}
	
	
	
	
	/**
	 * 
	 * @param selectedDrink - The value the user types in the command line
	 * @return - String value of the drink. 
	 * 
	 * Users are prompted to type integer value of the drink.
	 * This is to find the string value of the drink. 
	 */
	public String getDrinkString(Integer selectedDrink) {
		return this.integerToDrinks.get(selectedDrink);
	}
	
	
	
	
	/**
	 * 
	 * @param selectedDrink - user's choice of drink
	 * @return - the price of the selectedDrink
	 */
	public int getDrinkPrice(Integer selectedDrink) {
		String drinkString = this.integerToDrinks.get(selectedDrink);
		return this.drinkPrice.get(drinkString);
	}
}
