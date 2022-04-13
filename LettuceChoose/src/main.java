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
		System.out.println("Choose 3 toppings: 1) Edamame, 2) Guacamole, 3) Tomato, 4) Onions, 5) Masago, 6) None");
		int currentTopping = 1;
		while(currentTopping != 4) {
			System.out.println("Type in your topping"+currentTopping+"! (in numbers)");
			String toppingInput = cst.nextLine();
			Integer toppingInteger = tryStringToInt(toppingInput);
			if (toppingInteger == null) {
				System.out.println("Please enter a valid number");
				continue;
			}
			if (!toppingObject.doesExists(toppingInteger)) {
				System.out.println("Please select an available option");
				continue;
			}
			
			String toppingChosenString = toppingObject.getToppingString(toppingInteger);
			Boolean isToppingLeft = toppingObject.isAvailable(toppingChosenString);
			if (isToppingLeft) {
				orderObject.assignTopping(toppingChosenString);
				System.out.println("Topping"+currentTopping+": " + toppingChosenString);
				currentTopping+=1;
			}else {
				System.out.println("We are out of " + toppingChosenString +". Please choose other topping");
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
	
	
	public static void printReceipt(String receiptBase, String receiptProtein, ArrayList<String> receiptToppings, double receiptTip, double receiptTotal, String receiptName) {
		
		int saladPrice = 10;
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime currentTime = LocalDateTime.now();  
		String emptySpace = "│                               │";
		String receiptTextSalad = String.format("|%-10s", "     Salad: ");
		String receiptTextSaladPrice = String.format("%16s   |", "$"+saladPrice);
		
		String receiptTextBase = String.format("|%-10s", "     Base: ");
		String receiptTextBaseChoice = String.format("%-20s|", receiptBase);
		
		String receiptTextProtein = String.format("|%-10s", "     Protein: ");
		String receiptTextProteinChoice = String.format("%-17s|", receiptProtein);
		
		System.out.println(".");
		System.out.println(".");
		
		System.out.println("┌───────────────────────────────┐"); 

		System.out.println(emptySpace);
		System.out.println("│         LettuceChoose         │");
		System.out.println("│      " + dateTimeFormat.format(currentTime) + "      │");  
		System.out.println(emptySpace);
		System.out.println("│  Order for: " + receiptName + "      ");
		System.out.println(emptySpace);
		
		System.out.println(receiptTextSalad + receiptTextSaladPrice);
		System.out.println(receiptTextBase + receiptTextBaseChoice);
		System.out.println(receiptTextProtein + receiptTextProteinChoice);
		
		System.out.println("│     Toppings: " + receiptToppings.get(0) + " ");   
		System.out.println("│               " + receiptToppings.get(1) +"  ");
		System.out.println("│               " + receiptToppings.get(2) + " ");
//		System.out.println("│     Drizzle: Ranch            │");  WILL BE IMPLEMENTED SOON
//		System.out.println("│   Drink: Diet Coke      $5    │");
		System.out.println("│  ===========================  │");
		System.out.println("│   Subtotal              $10   │");
		System.out.println("│   Tax                   $1.5  │");
		System.out.println("│   Tip                   $" + receiptTip + "  ");
		System.out.println("│   Total                 $" + receiptTotal + " ");
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
