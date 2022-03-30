import Base.Base;
import Protein.Protein;
import Topping.Topping;



public class Order {

	String customerName;
	int diet;
	
	Base base;
	Protein protein;
	Topping topping;
	
	String baseChosen;
	String proteinChosen;
	String[] toppingChosen;
	
	double totalPrice;
	double tip;
	
	public Order(Base base, Protein protein, Topping topping) {
		
		this.base = base;
		this.protein = protein;
		this.topping = topping;
		
		this.totalPrice = 0.0;
		this.tip = 0.0;
	}
	
	public void chooseDiet(int num) {
		// create ENUM for diets
		this.diet = num;
		
	}
	
	public boolean chooseBase(int b) {
		Object baseObject = this.base.baseMap.get(b);
		
		return this.base.isAvailable(baseObject, this.baseChosen);
	}
	
	public void chooseProtein(Protein p) {
		this.protein = p;
		
	}
	
	public void chooseToppings(Topping t) {
		this.topping = t;
		
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
