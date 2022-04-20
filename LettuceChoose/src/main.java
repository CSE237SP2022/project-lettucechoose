import java.util.Scanner;
import Restaurant.Restaurant;
import Order.Order;    

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
		System.out.println("Hi, Welcome to LettuceChoose!");
		restaurant.askAndSetName(order, scanner);
		restaurant.askAndSetIngredients(order, "base", scanner);
		restaurant.askAndSetIngredients(order, "protein", scanner);
		restaurant.askAndSetIngredients(order, "topping", scanner);
		restaurant.askAndSetIngredients(order, "topping", scanner);
		restaurant.askAndSetIngredients(order, "topping", scanner);
		
		order.printReceipt();
	}
		
	

}