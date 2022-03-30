import java.util.Scanner;
import Base.Base;
import Protein.Protein;
import Topping.Topping;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class main {

	public static void main(String args[]){    
		Base baseObject = new Base();
		Protein proteinObject = new Protein();
		Topping toppingObject = new Topping();
		
		while(true) {
			
			Order orderObject = new Order(baseObject, proteinObject, toppingObject);

			Scanner cst = new Scanner(System.in);
			System.out.println("Hi! Welcome to the LettuceChoose!🥗✔️ ");
			System.out.println("Your name please?");
			
			String name = cst.nextLine();
			orderObject.user = name;
			System.out.println("Hi, " + orderObject.user + ". Do you have any allergies?");

			String allergies = cst.nextLine();

			System.out.println("What is your diet? Pescatarian, Vegan, Keto, None");
			String diet = cst.nextLine();

			boolean isBaseChosen = false;
			while(!isBaseChosen) {
				System.out.println("Choose your base: 1) Salad, 2) Soba, 3) Rice. Please type in numbers.");
				String base = cst.nextLine(); 
				int baseInt = Integer.parseInt(base); 
				Boolean successOrNot = orderObject.chooseBase(baseInt);
				if (successOrNot) {
					orderObject.baseChosen = "" + Base.BaseChoice.valueOf(baseInt);
					System.out.println("Base: " + orderObject.baseChosen);
					isBaseChosen = true;
				}else {
					System.out.println("We are out of " + Base.BaseChoice.valueOf(baseInt) +". Please choose other base");
				}
			}

			System.out.println("Choose one protein: 1) Beef, 2) Chicken, 3) Salmon, 4) Tofu. Please type in numbers.");
			String protein = cst.nextLine(); 
			int proteinInt = Integer.parseInt(protein);
			orderObject.proteinChosen = "" + Protein.ProteinChoice.valueOf(proteinInt);
			System.out.println("Protein: " + orderObject.proteinChosen);

			
			System.out.println("Choose 3 toppings: 1) edamame, 2) guacamole, 3) tomato, 4) onions, 5) masago");
			System.out.println("Type in your first topping! (in numbers)");
			String topping1 = cst.nextLine();
			System.out.println("Type in your second topping! (in numbers)");
			String topping2 = cst.nextLine();
			System.out.println("Type in your third topping! (in numbers)");
			String topping3 = cst.nextLine();
			
			int topping1Int = Integer.parseInt(topping1);
			int topping2Int = Integer.parseInt(topping2);
			int topping3Int = Integer.parseInt(topping3);
			
			String topping1Str = ""+Topping.ToppingChoice.valueOf(topping1Int);
			String topping2Str = ""+Topping.ToppingChoice.valueOf(topping2Int);
			String topping3Str = ""+Topping.ToppingChoice.valueOf(topping3Int);
			
			String[] toppingsArr = {topping1Str, topping2Str, topping3Str};
			orderObject.toppingChosen = toppingsArr;
			
			System.out.println("Toppings: " + orderObject.toppingChosen[0] + ", " + orderObject.toppingChosen[1] + ", " + orderObject.toppingChosen[2]);

//			System.out.println("Choose drizzle: Roasted Garlic Sauce, Chilli Honey Sauce, Ranch, Ponzu Sauce");
//			String drizzle = cst.nextLine(); 
//			System.out.println("drizzles: " + drizzle);

//			System.out.println("Any drinks? Coke, Sprite, Water");
//			String drinks = cst.nextLine(); 
//			System.out.println("drinks: " + drinks);

			
			System.out.println("Would you like to tip? If so, how much? You can put 0");
			double tip = cst.nextDouble(); 
			System.out.println("tip: $" + tip);
			cst.nextLine();

//			System.out.println("Your total order price is: " + price);
//			System.out.println("Thank you for your order, " + name + "! Here is " + protein + " " + base + " with " + toppings + " and " + drizzle);

			System.out.println("Processing your order, " + name + "!");
			
			
			// salad bowl + drinks + tip + tax
			int saladBowlPrice = 10;
			double total = saladBowlPrice + tip + saladBowlPrice * 0.15;
			printReceipt(orderObject.baseChosen, orderObject.proteinChosen, orderObject.toppingChosen, tip, total, name);
			
			System.out.println("-------------------"+"\n"+"Next in line!"+"\n"+"-------------------");
			
		}

	}
	
	
	public static void printReceipt(String rBase, String rProtein, String[] rToppings, double rTip, double rTotal, String rName) {
		
//		─ │ ┌ ┐ ┘ └ ├ ┬ ┤ ┴ ┼   <- use these!!
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(".");
		System.out.println(".");
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│                               │");
		System.out.println("│         LettuceChoose         │");
		System.out.println("│      " + dtf.format(now) + "      │");  
		System.out.println("│                               │");
		System.out.println("│  Order for: " + rName + "      ");
		System.out.println("│                               │");
		System.out.println("│   Salad                 $10   │");
		System.out.println("│     Base:  " + rBase + "       ");  
		System.out.println("│     Protein: " + rProtein + " ");  
		System.out.println("│     Toppings: " + rToppings[0] + " ");   // should add $$ for additional toppings
		System.out.println("│               " + rToppings[1] +"  ");
		System.out.println("│               " + rToppings[2] + " ");
//		System.out.println("│               Tomato    $2    │");
//		System.out.println("│     Drizzle: Ranch            │");
//		System.out.println("│   Drink: Diet Coke      $5    │");
		System.out.println("│  ===========================  │");
		System.out.println("│   Subtotal              $10   │");
		System.out.println("│   Tax                   $1.5  │");
		System.out.println("│   Tip                   $" + rTip + "  ");
		System.out.println("│   Total                 $" + rTotal + " ");
		System.out.println("│                               │");
		System.out.println("│       T h a n k  y o u        │");
		System.out.println("└───────────────────────────────┘");

	}

}
