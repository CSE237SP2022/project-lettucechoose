import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class main {

	public static void main(String args[]){    
		

		Scanner cst = new Scanner(System.in);
		System.out.println("Hi! Welcome to the LettuceChoose!🥗✔️ ");
		System.out.println("Your name please?");
		
		String name = cst.nextLine();
		System.out.println("Hi, " + name + ". Do you have any allergies?");

		String allergies = cst.nextLine();
		System.out.println(allergies);

		System.out.println("What is your diet? Pescatarian, Vegan, Keto, None");
		String diet = cst.nextLine();
		System.out.println(diet);

		System.out.println("Choose your base: Salad, Soba, Rice");
		String base = cst.nextLine(); 
		System.out.println("Base: " + base);

		System.out.println("Choose one protein: Beef, Chicken, Salmon, Tofu");
		String protein = cst.nextLine(); 
		System.out.println("protein: " + protein);

		
		System.out.println("Choose your toppings: edamame, guacamole, tomato, onions, masago");
		System.out.println("You can choose up to 3 toppings. Otherwise, there will be extra charge.");
		String toppings = cst.nextLine();
		System.out.println("Toppings: " + toppings);


		System.out.println("Choose drizzle: Roasted Garlic Sauce, Chilli Honey Sauce, Ranch, Ponzu Sauce");
		String drizzle = cst.nextLine(); 
		System.out.println("drizzles: " + drizzle);
 

		System.out.println("Any drinks? Coke, Sprite, water");
		String drinks = cst.nextLine(); 
		System.out.println("drinks: " + drinks);


		System.out.println("How many utensils do you need?");
		int utensils = cst.nextInt(); 
		System.out.println("number of utensils: " + utensils);

		
		cst.nextLine();
		System.out.println("Dine-In or To-go?");
		String eatingplace = cst.nextLine(); 
		System.out.println("eating option: " + eatingplace);
 
		
		System.out.println("Would you like to tip? 10%, 15%, 20%, and custom");
		double tip = cst.nextInt(); 
		System.out.println("tip: " + tip + "%");
		cst.nextLine();
	

		double price;
		price = 0.0;    
		
		System.out.println("Your total order price is: " + price);
		System.out.println("Thank you for your order, " + name + "! Here is " + protein + " " + base + " with " + toppings + " and " + drizzle);
	
		printReceipt();
	}
	
	public static void printReceipt() {
		
//		─ │ ┌ ┐ ┘ └ ├ ┬ ┤ ┴ ┼   <- use these!!
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│                               │");
		
		System.out.println("│        LettuceChoose          │");
		
		System.out.println("│      " + dtf.format(now) + "      │");  
		System.out.println("│                               │");
		System.out.println("│   Salad                 $10   │");
		System.out.println("│     Base: Salad               │");  
		System.out.println("│     Protein: Beef             │");  
		System.out.println("│     Toppings: Edamame         │");   // should add $$ for additional toppings
		System.out.println("│               Masago          │");
		System.out.println("│               Onions          │");
		System.out.println("│               Tomato    $2    │");
		System.out.println("│    Drizzle: Ranch             │");
		System.out.println("│             Masago            │");
		System.out.println("│   Drink: Diet Coke      $5    │");
		System.out.println("│  ===========================  │");
		System.out.println("│   Subtotal              $17   │");
		System.out.println("│   Tax                   $3    │");
		System.out.println("│   Tip                   $3    │");
		System.out.println("│   Total                 $23   │");
		System.out.println("│                               │");
		System.out.println("│       T h a n k  y o u        │");
		System.out.println("└───────────────────────────────┘");




	}

}
