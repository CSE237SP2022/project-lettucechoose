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
			System.out.println("-----------------------");
			System.out.println("  Next in line please!");
			System.out.println("-----------------------");
		}
	}
	
	private static void takeNewOrder(Restaurant restaurant) {
		Scanner scanner = new Scanner(System.in);
		Order order = new Order();
		Boolean customerContinues = true;
		while (customerContinues) {
			customerContinues = restaurant.askAndSetName(order, scanner);
			if (!customerContinues) break;
			
			customerContinues = restaurant.askAndSetIngredients(order, "base", scanner);
			if (!customerContinues) break;
			
			customerContinues = restaurant.askAndSetIngredients(order, "protein", scanner);
			if (!customerContinues) break;
			
			customerContinues = restaurant.askAndSetIngredients(order, "topping", scanner);
			if (!customerContinues) break;
			
			customerContinues = restaurant.askAndSetIngredients(order, "topping", scanner);
			if (!customerContinues) break;
			
			customerContinues = restaurant.askAndSetIngredients(order, "topping", scanner);
			if (!customerContinues) break;
			
			customerContinues = restaurant.askForTip(order, scanner);
			if (!customerContinues) break;
			
			order.printReceipt();
			
			customerContinues = false;
		}
		
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