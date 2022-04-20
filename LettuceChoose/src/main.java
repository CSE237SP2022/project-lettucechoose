import java.util.Scanner;
import Restaurant.Restaurant;
import Order.Order;    

public class main {

	public static void main(String args[]){   
		Restaurant restaurant = new Restaurant();
		
		while(true) {
			System.out.println("Hi, Welcome to LettuceChoose!");
			// check if the person is a vendor 
			// 		if the person is the vendor, s/he will be prompted to other questions
			
			// take new order for customers
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
		restaurant.askForTip(order, scanner);
		order.printReceipt();
	}
		
	

}