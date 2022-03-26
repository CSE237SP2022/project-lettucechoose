
public class Order {

	String user;
	int diet;
	int base;
	int protein;
	int[] toppings;
	double tip;
	
	public Order(String user) {
		this.user = user;
	}
	
	public void chooseDiet(int num) {
		// create ENUM for diets
		this.diet = num;
		
	}
	
	public void chooseBase(int num) {
		this.base = num;
		
	}
	
	public void chooseProtein(int num) {
		this.protein = num;
		
	}
	
	public void chooseToppings(int[] nums) {
		this.toppings = nums;
		
	}
	
	public void chooseTipAmount(double tip) {
		this.tip = tip;
	}
	
	
}
