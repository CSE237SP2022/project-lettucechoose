import java.util.ArrayList;
import java.util.Scanner;
import Base.Base;
import Protein.Protein;
import Topping.Topping;
import Drink.Drink;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class main {

	public static void main(String args[]){    
		Base baseObject = new Base();
		Protein proteinObject = new Protein();
		Topping toppingObject = new Topping();
		Drink drinkObject = new Drink();
		while(true) {
			takeNewOrder(baseObject, proteinObject, toppingObject, drinkObject);
		}
	}

	
	

	private static void takeNewOrder(Base baseObject, Protein proteinObject, Topping toppingObject, Drink drinkObject) {
		Order orderObject = new Order();
		Scanner commandLineScanner = new Scanner(System.in);
		
		askNameAndAddName(orderObject, commandLineScanner);
		askBaseAndAddBase(orderObject, baseObject, commandLineScanner);
		askProteinAndAddProtein(orderObject, proteinObject, commandLineScanner);
		askToppingsAndAddToppings(orderObject, toppingObject, commandLineScanner);
		askDrinkAndAddDrink(orderObject, drinkObject, commandLineScanner);
		
		askTipAndAddTip(orderObject, commandLineScanner);
		System.out.println("Processing your order, " + orderObject.customerName + "!");
		calculatePriceAndPrintRecipt(orderObject);
		System.out.println("-------------------"+"\n"+ "🙋🙋‍♀️ Next in line!"+"\n"+"-------------------");
	}


	private static void calculatePriceAndPrintRecipt(Order orderObject) {
		// salad bowl + drinks + tip + tax
		int saladBowlPrice = 10;
		int subTotal = saladBowlPrice + orderObject.drinkPrice;
		Double taxRate = 0.15;
		double totalPrice = subTotal + orderObject.tip + subTotal * taxRate;
		printReceipt(orderObject.baseChosen, orderObject.proteinChosen, orderObject.toppingChosen, orderObject.drinkChosen, orderObject.drinkPrice, orderObject.tip, totalPrice, orderObject.customerName);
	}


	private static double askTipAndAddTip(Order orderObject, Scanner cst) {
		System.out.println("Would you like to tip? If so, how much? You can put 0");
		double userInput = cst.nextDouble(); 
		orderObject.tip = userInput;
		System.out.println("tip: $" + orderObject.tip);
		cst.nextLine();
		return userInput;
	}

	private static void askDrinkAndAddDrink(Order orderObject, Drink drinkObject, Scanner cst) {
		
		boolean isDrinkChosen = false;
		while(!isDrinkChosen) {
			System.out.println("Choose a drink: 1) Coke $2,  2) Sprite $3,  3) Iced Tea  $2,  4) None");
			String userInput = cst.nextLine(); 
			Integer drinkInt = tryStringToInt(userInput); 
			if (drinkInt == null) {
				System.out.println("Please enter a valid number");
				continue;
			}
			
			if (!drinkObject.doesExists(drinkInt)) {
				System.out.println("Please select an available option");
				continue;
			}
			
			String drinkChosenString = drinkObject.getDrinkString(drinkInt);
			Boolean isDrinkLeft = drinkObject.isAvailable(drinkChosenString);
			if (isDrinkLeft) {
				orderObject.assignDrink(drinkChosenString);
				System.out.println("Drink: " + orderObject.drinkChosen);
				orderObject.drinkPrice = drinkObject.getDrinkPrice(drinkInt);
				isDrinkChosen = true;
			}else {
				System.out.println("We are out of " + drinkChosenString +". Please choose other base");
			}
			
		}
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
	
	
	public static void printReceipt(String receiptBase, String receiptProtein, ArrayList<String> receiptToppings, String receiptDrink, int receiptDrinkPrice, double receiptTip, double receiptTotal, String receiptName) {
		
		int saladPrice = 10;
		double taxAmount = (10+receiptDrinkPrice)* 0.15;
		double roundOffTax = Math.round(taxAmount * 100.0) / 100.0;
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime currentTime = LocalDateTime.now();  
		String emptySpace = "│                               │";

		
		// String formatting customer name
		String nameText = String.format("│%-8s", "   Order for: ");
		String nameValueText = String.format("%-17s│", receiptName);
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
