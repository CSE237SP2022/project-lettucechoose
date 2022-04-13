package Order;
import java.util.ArrayList;

import Base.Base;
import Protein.Protein;
import Topping.Topping;


public class Order {

	public String customerName;
	int diet;
	
	public String baseChosen;
	public String proteinChosen;
	public ArrayList<String> toppingChosen;
	public String drinkChosen;
	
	public double totalPrice;
	public int drinkPrice;
	public double tip;
	
	@SuppressWarnings("unchecked")
	public Order() {
		this.toppingChosen = new ArrayList();
	}

	
	public void assignDiet(int num) {
		// create ENUM for diets
		this.diet = num;
	}
	
	public void assignBase(String baseChosen) {
		this.baseChosen = baseChosen;
	}
	
	public void assignProtein(String proteinChosen) {
		this.proteinChosen = proteinChosen;
	}
	
	public void assignTopping(String toppingChosen) {
		this.toppingChosen.add(toppingChosen);
	}
	
	public void assignDrink(String drinkChosen) {
		this.drinkChosen = drinkChosen;
	}
	public void chooseTipAmount(double tip) {
		this.tip = tip;
	}
	
	public String summarizeOrder() {
		String toppingsString = "";
		
		for (int i = 0; i < toppingChosen.size(); i++) {
			toppingsString+=toppingChosen.get(i);
			toppingsString+=", ";
		}
		
		String res = "Your base is:" + baseChosen + "\n" +"Your protein is: " + proteinChosen + "\n" + "Your toppings are: " + toppingsString + "\n" + "\n";
		
		double totalPriceWithTip = this.totalPrice + this.tip;
		
		res += "Total Price: " + totalPriceWithTip;
		
		return res;
	}
	
	
	
	
}