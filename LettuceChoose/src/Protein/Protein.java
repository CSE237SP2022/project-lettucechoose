package Protein;

public class Protein {
	Beef beef;
	Chicken chicken;
	Salmon salmon;
	Tofu tofu;
	
	public Protein(){
		beef = new Beef(3);
		chicken = new Chicken(3);
		salmon = new Salmon(3);
		tofu = new Tofu(3);
	}
	
	public class Beef {
		int quantity;
		
		Beef(int quantityInput){
			this.quantity = quantityInput;
		}
		
		public Boolean isAvailable() {
			if (this.quantity > 0) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public class Chicken {
		int quantity;
		
		Chicken(int quantityInput){
			this.quantity = quantityInput;
		}
		
		public Boolean isAvailable() {
			if (this.quantity > 0) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public class Salmon {
		int quantity;
		
		Salmon(int quantityInput){
			this.quantity = quantityInput;
		}
		
		public Boolean isAvailable() {
			if (this.quantity > 0) {
				return true;
			}else {
				return false;
			}
		}

	}
	
	public class Tofu {
		int quantity;
		
		Tofu(int quantityInput){
			this.quantity = quantityInput;
		}
		
		public Boolean isAvailable() {
			if (this.quantity > 0) {
				return true;
			}else {
				return false;
			}
		}

	}

}
