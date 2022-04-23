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
		
		System.out.println("Type in any ingredients that you'd like to check the quantity");
		String checkIngredient = scanner.nextLine();
		int ingredientQuantity = restaurant.checkQuantity(checkIngredient);
		if (ingredientQuantity == -1) {
			System.out.println("Invalid ingredient name");
		} else {
			System.out.println(checkIngredient + ": " + ingredientQuantity);
			System.out.println("Would you like to restock " + checkIngredient + "? (y/n)");
			String yn = scanner.nextLine();
			if (yn.equals("y")) {
				System.out.println("How much quantity are you restocking?");
				int restockCount = scanner.nextInt();
				restaurant.incrementQuantity(checkIngredient, restockCount);
			} else if (yn.equals("n")) {
				
			} else {
				System.out.println("Please answer in y or n");
			}
			
			System.out.println("Please type 'continue' if you'd like to check other ingredients");
			String continueOrNot = scanner.nextLine();
			if (continueOrNot.equals("continue")) {
				// continue
			}
		}
		
		
	}
		
	

}