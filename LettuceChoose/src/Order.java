import Base.Base;
import Protein.Protein;
import Topping.Topping;


public class Order {

	String user;
	int diet;
	Base base;
	Protein protein;
	Topping[] toppings;
	double tip;
	
	public Order(String user) {
		this.user = user;
	}
	
	public void chooseDiet(int num) {
		// create ENUM for diets
		this.diet = num;
		
	}
	
	public void chooseBase(Base b) {
		this.base = b;
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
	
	
}
