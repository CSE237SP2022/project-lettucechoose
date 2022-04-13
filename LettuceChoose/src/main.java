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
	
	
	public static void printReceipt(String receiptBase, String receiptProtein, ArrayList<String> receiptToppings, double receiptTip, double receiptTotal, String receiptName) {
		
		int saladPrice = 10;

		double taxAmount = (10+receiptDrinkPrice)* 0.15;
		double roundOffTax = Math.round(taxAmount * 100.0) / 100.0;
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime currentTime = LocalDateTime.now();  
		String emptySpace = "│                               │";
<<<<<<< Updated upstream
		String receiptTextSalad = String.format("|%-10s", "     Salad: ");
		String receiptTextSaladPrice = String.format("%16s   |", "$"+saladPrice);
=======
>>>>>>> Stashed changes
		
		// String formatting customer name
		String nameText = String.format("│%-8s", "   Order for: ");
		String nameValueText = String.format("%-17s│", receiptName);
//		System.out.println("│  Order for: " + receiptName + "      ");
		// String formatting the salad line and the price
		String saladText = String.format("│%-12s", "   Salad: ");
		String saladPriceText = String.format("%15s    │", "$"+saladPrice);
		
		// String formatting the base 
		String baseText = String.format("│%-10s", "     Base: ");
		String baseChoiceText = String.format("%-20s│", receiptBase);
		
		// String formatting the protein 
		String proteinText = String.format("│%-10s", "     Protein: ");
		String proteinChoiceText = String.format("%-17s│", receiptProtein);
		
		// String formatting the toppings
		String toppingText = String.format("│%-10s", "     Toppings: ");
		String toppingChoiceText1 = String.format("%-16s│", receiptToppings.get(0));
		String toppingTextSpace = String.format("│%-15s", "");
		String toppingChoiceText2 = String.format("%-16s│", receiptToppings.get(1));
		String toppingChoiceText3 = String.format("%-16s│", receiptToppings.get(2));
		
		// String formatting the drink
		String drinkText = String.format("│%-10s", "   Drink: ");
		String drinkChoiceText = String.format("%-8s", receiptDrink);
		String drinkPriceText = String.format("%8s     │", "$"+ receiptDrinkPrice);
		
		// String formatting subtotal, tip, tax, total
		String subtotalText = String.format("│%-24s", "   Subtotal");
		String subtotalPriceText = String.format("%-7s│", "$"+ (10+receiptDrinkPrice));
		String taxText = String.format("│%-24s", "   Tax");
		String taxPriceText = String.format("%-7s│", "$"+ roundOffTax);
		String tipText = String.format("│%-24s", "   Tip");
		String tipPriceText = String.format("%-7s│", "$"+ receiptTip);
		String totalText = String.format("│%-24s", "   Total");
		String totalPriceText = String.format("%-7s│", "$"+ receiptTotal);
		
		
		System.out.println(".");
		System.out.println(".");
		
		System.out.println("┌───────────────────────────────┐"); 

		System.out.println(emptySpace);
		System.out.println("│         LettuceChoose         │");
		System.out.println("│      " + dateTimeFormat.format(currentTime) + "      │");  
		System.out.println(emptySpace);
		System.out.println(nameText+nameValueText);
		System.out.println(emptySpace);
<<<<<<< Updated upstream
		
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
=======
		System.out.println(saladText + saladPriceText);
		System.out.println(baseText + baseChoiceText);
		System.out.println(proteinText + proteinChoiceText); 
		System.out.println(toppingText+toppingChoiceText1);
		System.out.println(toppingTextSpace+toppingChoiceText2);
		System.out.println(toppingTextSpace+toppingChoiceText3);
		System.out.println(drinkText+drinkChoiceText+drinkPriceText);
		System.out.println("│  ===========================  │");
		System.out.println(subtotalText+subtotalPriceText);
		System.out.println(taxText+taxPriceText);
		System.out.println(tipText+tipPriceText);
		System.out.println(totalText+totalPriceText);
		System.out.println(emptySpace);
>>>>>>> Stashed changes
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
