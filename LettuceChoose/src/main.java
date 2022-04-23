import java.util.Scanner;
import Restaurant.Restaurant;
import Order.Order;    

public class main {

	public static void main(String args[]){   
		Restaurant restaurant = new Restaurant();
		
		while(true) {
			System.out.println("Hi, Welcome to LettuceChoose!");
			
			if (checkIfVendor()) {
				vendorFunctionalities(restaurant);
			} else {
				takeNewOrder(restaurant);
			}
			
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
	
	private static Boolean checkIfVendor() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please press ENTER to start!");
		String vendorPasscode = scanner.nextLine();
		return (vendorPasscode.equals("vendor1234"));
	}
	
	
	private static void vendorFunctionalities(Restaurant restaurant) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("====Vendor Page====");
		

		Boolean vendorContinue = true;
		while(vendorContinue) {
			String ingredient = restaurant.vendorCheckIngredientQuantity(scanner);
			if (!ingredient.equals("Invalid")) {
				restaurant.vendorRestockQuantity(ingredient, scanner);
			} 		
			vendorContinue = restaurant.vendorAskQuit(scanner);
		}
		
		
	}
		
	

}