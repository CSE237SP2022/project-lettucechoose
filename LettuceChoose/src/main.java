import java.util.ArrayList;
import java.util.Scanner;
import Ingredient.Ingredient;
import Restaurant.Restaurant;
import Order.Order;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class main {

	public static void main(String args[]){   
		Restaurant restaurant = new Restaurant();
		
		while(true) {
			takeNewOrder(restaurant);
		}
	}
	
	private static void takeNewOrder(Restaurant restaurant) {
		Scanner scanner = new Scanner(System.in);
		Order order = new Order();
		restaurant.askAndSetName(order, scanner);
		restaurant.askAndSetIngredients(order, "base", scanner);
		restaurant.askAndSetIngredients(order, "protein", scanner);
		restaurant.askAndSetIngredients(order, "topping", scanner);
		restaurant.askAndSetIngredients(order, "topping", scanner);
		restaurant.askAndSetIngredients(order, "topping", scanner);
	}
		
	

}