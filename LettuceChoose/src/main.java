import java.util.Scanner;
import Restaurant.Restaurant;
import Order.Order;    

public class main {

	public static void main(String args[]){   
		Restaurant restaurant = new Restaurant();
		
		while(true) {
			System.out.println("Hi, Welcome to LettuceChoose!");
			
			if (restaurant.checkIfVendor()) {
				restaurant.vendorFunctionalities();
			} else {
				takeNewOrder(restaurant);
			}
			System.out.println("-----------------------");
			System.out.println("  Next in line please!");
			System.out.println("-----------------------");
		}
	}
	
	private static void takeNewOrder(Restaurant restaurant) {
		Scanner scanner = new Scanner(System.in);
		Order order = new Order();
		Boolean customerContinues = true;

		customerContinues = restaurant.askAndSetName(order, scanner);
		if (!customerContinues) return;
		customerContinues = restaurant.askAndSetIngredients(order, "base", scanner);
		if (!customerContinues) return;
		customerContinues = restaurant.askAndSetIngredients(order, "protein", scanner);
		if (!customerContinues) return;
		customerContinues = restaurant.askAndSetIngredients(order, "topping", scanner);
		if (!customerContinues) return;
		customerContinues = restaurant.askAndSetIngredients(order, "topping", scanner);
		if (!customerContinues) return;
		customerContinues = restaurant.askAndSetIngredients(order, "topping", scanner);
		if (!customerContinues) return;
		customerContinues = restaurant.askForTip(order, scanner);
		if (!customerContinues) return;
		
		order.printReceipt();
			

	}
}