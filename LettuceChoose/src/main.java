import java.util.ArrayList;
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
			takeNewOrder(baseObject, proteinObject, toppingObject);
		}
	}


	private static void takeNewOrder(Base baseObject, Protein proteinObject, Topping toppingObject) {
		Order orderObject = new Order();
		Scanner commandLineScanner = new Scanner(System.in);
		
		askNameAndAddName(orderObject, commandLineScanner);
		askBaseAndAddBase(orderObject, baseObject, commandLineScanner);
		askProteinAndAddProtein(orderObject, proteinObject, commandLineScanner);
		askToppingsAndAddToppings(orderObject, toppingObject, commandLineScanner);
		askTipAndAddTip(orderObject, commandLineScanner);
		System.out.println("Processing your order, " + orderObject.customerName + "!");
		calculatePriceAndPrintRecipt(orderObject);
		System.out.println("-------------------"+"\n"+ "🙋🙋‍♀️ Next in line!"+"\n"+"-------------------");
	}


	private static void calculatePriceAndPrintRecipt(Order orderObject) {
		// salad bowl + drinks + tip + tax
		int saladBowlPrice = 10;
		double totalPrice = saladBowlPrice + orderObject.tip + saladBowlPrice * 0.15;
		printReceipt(orderObject.baseChosen, orderObject.proteinChosen, orderObject.toppingChosen, orderObject.tip, totalPrice, orderObject.customerName);
	}


	private static double askTipAndAddTip(Order orderObject, Scanner cst) {
		System.out.println("Would you like to tip? If so, how much? You can put 0");
		double userInput = cst.nextDouble(); 
		orderObject.tip = userInput;
		System.out.println("tip: $" + orderObject.tip);
		cst.nextLine();
		return userInput;
	}


	private static void askToppingsAndAddToppings(Order orderObject, Topping toppingObject, Scanner cst) {


		Boolean isTopping1Chosen = false, isTopping2Chosen = false, isTopping3Chosen = false;
		String topping1Str = "", topping2Str = "", topping3Str = "";
		
		System.out.println("Choose 3 toppings: 1) Edamame, 2) Guacamole, 3) Tomato, 4) Onions, 5) Masago");
		
		while(!isTopping1Chosen) {
			System.out.println("Type in your first topping! (in numbers)");
			String topping1Input = cst.nextLine();
			Integer topping1Integer = tryStringToInt(topping1Input);
			if (topping1Integer == null) {
				System.out.println("Please enter a valid number");
				continue;
			}
			if (!toppingObject.doesExists(topping1Integer)) {
				System.out.println("Please select an available option");
				continue;
			}
			
			String topping1ChosenString = toppingObject.getToppingString(topping1Integer);
			Boolean isTopping1Left = toppingObject.isAvailable(topping1ChosenString);
			if (isTopping1Left) {
				orderObject.assignTopping(topping1ChosenString);
				System.out.println("Topping 1: " + topping1ChosenString);
				isTopping1Chosen = true;
			}else {
				System.out.println("We are out of " + topping1ChosenString +". Please choose other topping");
			}
		}
		while(!isTopping2Chosen) {
			System.out.println("Type in your second topping! (in numbers)");
			String topping2Input = cst.nextLine();
			Integer topping2Integer = tryStringToInt(topping2Input);
			if (topping2Integer == null) {
				System.out.println("Please enter a valid number");
				continue;
			}
			if (!toppingObject.doesExists(topping2Integer)) {
				System.out.println("Please select an available option");
				continue;
			}
			
			String topping2ChosenString = toppingObject.getToppingString(topping2Integer);
			Boolean isTopping2Left = toppingObject.isAvailable(topping2ChosenString);
			if (isTopping2Left) {
				orderObject.assignTopping(topping2ChosenString);
				System.out.println("Topping 2: " + topping2ChosenString);
				isTopping2Chosen = true;
			}else {
				System.out.println("We are out of " + topping2ChosenString +". Please choose other topping");
			}
		}
		while(!isTopping3Chosen) {
			System.out.println("Type in your third topping! (in numbers)");
			String topping3Input = cst.nextLine();
			Integer topping3Integer = tryStringToInt(topping3Input);
			if (topping3Integer == null) {
				System.out.println("Please enter a valid number");
				continue;
			}
			if (!toppingObject.doesExists(topping3Integer)) {
				System.out.println("Please select an available option");
				continue;
			}
			
			String topping3ChosenString = toppingObject.getToppingString(topping3Integer);
			Boolean isTopping3Left = toppingObject.isAvailable(topping3ChosenString);
			if (isTopping3Left) {
				orderObject.assignTopping(topping3ChosenString);
				System.out.println("Topping 3: " + topping3ChosenString);
				isTopping3Chosen = true;
			}else {
				System.out.println("We are out of " + topping3ChosenString +". Please choose other topping");
			}
		}
		
		System.out.println("Toppings: " + orderObject.toppingChosen.get(0) + ", " + orderObject.toppingChosen.get(1) + ", " + orderObject.toppingChosen.get(2));
	}




	private static void askProteinAndAddProtein(Order orderObject, Protein proteinObject, Scanner cst) {
		boolean isProteinChosen = false;
		while(!isProteinChosen) {
			System.out.println("Choose one protein: 1) Beef, 2) Chicken, 3) Salmon, 4) Tofu. Please type in numbers.");
			String userInput = cst.nextLine(); 
			Integer proteinInt = tryStringToInt(userInput); 
			if (proteinInt == null) {
				System.out.println("Please enter a valid number");
				continue;
			}
			
			if (!proteinObject.doesExists(proteinInt)) {
				System.out.println("Please select an available option");
				continue;
			}
			
			String proteinChosenString = proteinObject.getProteinString(proteinInt);
			Boolean isProteinLeft = proteinObject.isAvailable(proteinChosenString);
			if (isProteinLeft) {
				orderObject.assignProtein(proteinChosenString);
				System.out.println("Protein: " + orderObject.proteinChosen);
				isProteinChosen = true;
			}else {
				System.out.println("We are out of " + proteinChosenString +". Please choose other base");
			}
			
		}

	}


	private static void askBaseAndAddBase(Order orderObject, Base baseObject, Scanner cst) {
		boolean isBaseChosen = false;
		while(!isBaseChosen) {
			System.out.println("Choose your base: 1) Salad, 2) Soba, 3) Rice. Please type in numbers.");
			String userInput = cst.nextLine(); 
			Integer baseInt = tryStringToInt(userInput); 
			if (baseInt == null) {
				System.out.println("Please enter a valid number");
				continue;
			}
			
			if (!baseObject.doesExists(baseInt)) {
				System.out.println("Please select an available option");
				continue;
			}
			
			String baseChosenString = baseObject.getBaseString(baseInt);
			Boolean baseLeft = baseObject.isAvailable(baseChosenString);
			if (baseLeft) {
				orderObject.assignBase(baseChosenString);
				System.out.println("Base: " + orderObject.baseChosen);
				isBaseChosen = true;
			}else {
				System.out.println("We are out of " + baseChosenString +". Please choose other base");
			}
		}
	}


	private static void askNameAndAddName(Order orderObject, Scanner cst) {
		System.out.println("Hi! Welcome to the LettuceChoose!🥗✔️ ");
		System.out.println("Your name please?");
		
		String userInput = cst.nextLine();
		orderObject.customerName = userInput;
		
		System.out.println("Hi, " + orderObject.customerName + "! Let's build your own salad bowl :)");
	}
	
	
	public static void printReceipt(String rBase, String rProtein, ArrayList<String> rToppings, double rTip, double rTotal, String rName) {
		
//		─ │ ┌ ┐ ┘ └ ├ ┬ ┤ ┴ ┼   <- use these!!
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime currentTime = LocalDateTime.now();  
		System.out.println(".");
		System.out.println(".");
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│                               │");
		System.out.println("│         LettuceChoose         │");
		System.out.println("│      " + dateTimeFormat.format(currentTime) + "      │");  
		System.out.println("│                               │");
		System.out.println("│  Order for: " + rName + "      ");
		System.out.println("│                               │");
		System.out.println("│   Salad                 $10   │");
		System.out.println("│     Base:  " + rBase + "       ");  
		System.out.println("│     Protein: " + rProtein + " ");  
		System.out.println("│     Toppings: " + rToppings.get(0) + " ");   
		System.out.println("│               " + rToppings.get(1) +"  ");
		System.out.println("│               " + rToppings.get(2) + " ");
//		System.out.println("│     Drizzle: Ranch            │");  WILL BE IMPLEMENTED SOON
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
	
	public static Integer tryStringToInt(String text) {
		  try {
		    return Integer.parseInt(text);
		  } catch (NumberFormatException e) {
		    return null;
		  }
		}

}
