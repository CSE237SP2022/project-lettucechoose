import java.util.Scanner;
public class main {

	public static void main(String args[]){    


		Scanner cst = new Scanner(System.in);
		System.out.println("Your name please");
		String name = cst.nextLine();
		System.out.println("Hi" + name);

		System.out.println("Any allergies?");
		String allergies = cst.nextLine();
		System.out.println(allergies);

		System.out.println("What is your diet? Pescatarian, Vegan, Keto, None");
		String diet = cst.nextLine();
		System.out.println(diet);

		System.out.println("Base? Salad, Soba, Brown Rice, White Rice");
		String base = cst.nextLine(); 
		System.out.println("Base: " + base);


		System.out.println("toppings? edamame, green onioins, tomato, corn, guac");
		String toppings = cst.nextLine();
		System.out.println("You may choose up to 3. Otherwise, it will be extra charge. Toppings: " + toppings);


		System.out.println("Choose one protein: Beef, Chicken, Salmon, Tuna, Tofu");
		String protein = cst.nextLine(); 
		System.out.println("protein: " + protein);

		System.out.println("Choose drizzle: Roasted Garlic Sauce, Chilli Honey Sauce, Ranch, Ponzu Sauce");
		String drizzle = cst.nextLine(); 
		System.out.println("drizzles: " + drizzle);


		System.out.println("Any drinks? Coke, Sprite, water");
		String drinks = cst.nextLine(); 
		System.out.println("drizzles: " + drinks);


		System.out.println("How many utensils do you need?");
		int utensils = cst.nextInt(); 
		System.out.println("number of utensils: " + utensils);


		System.out.println("Dine-In or To-go?");
		String eatingplace = cst.nextLine(); 
		System.out.println("eating option: " + eatingplace);


		System.out.println("Would you like to tip? 10%, 15%, 20%, and custom");
		double tip = cst.nextInt(); 
		System.out.println("tip: " + tip);



		double price;
		price = 0.0;    
		System.out.println("Your total order price is: " + price);
		System.out.println("Thank you for your oder." + name + " Here is" + protein + base + " with " + toppings + "and " + drizzle);


	}



}
