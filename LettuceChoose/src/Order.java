import Base.Base;
import Protein.Protein;
import Topping.Topping;



public class Order {

	String user;
	int diet;
	
	Base base;
	Protein protein;
	Topping[] toppings;
	
	String baseChosen;
	String proteinChosen;
	String[] toppingChosen;
	
	double totalPrice;
	double tip;
	
	public Order(String user, int diet, Base base, Protein protein, Topping[] toppings) {
		this.user = user;
		this.diet = diet;
		
		this.base = base;
		this.protein = protein;
		this.toppings = toppings;
		
		this.totalPrice = 0.0;
		this.tip = 0.0;
	}
	
	public void chooseDiet(int num) {
		// create ENUM for diets
		this.diet = num;
		
	}
	
	public boolean chooseBase(int b) {
		Object baseObject = this.base.baseMap.get(b);
		
		return this.base.isAvailable(baseObject, baseChosen);
	}
	
	public void chooseProtein(Protein p) {
		this.protein = p;
		
	}
	
	public void chooseToppings(Topping[] t) {
		this.toppings = t;
		
	}
	
	public void chooseTipAmount(double tip) {
		this.tip = tip;
	}
	
	public String summarizeOrder() {
		String toppingsString = "";
		
		for (int i = 0; i < toppingChosen.length; i++) {
			toppingsString+=toppingChosen[i];
			toppingsString+=", ";
		}
		
		String res = "Your base is:" + baseChosen + "\n" +"Your protein is: " + proteinChosen + "\n" + "Your toppings are: " + toppingsString + "\n" + "\n";
		
		double totalPriceWithTip = this.totalPrice + this.tip;
		
		res += "Total Price: " + totalPriceWithTip;
		
		return res;
	}
	
}
