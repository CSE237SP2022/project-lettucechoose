package Base;

public class Base {
	Lettuce lettuce;
	Rice rice;
	Soba soba;
	
	Base(){
		lettuce = new Lettuce(3);
		rice = new Rice(3);
		soba = new Soba(3);
	}
	
	
	
	public class Lettuce {
		int quantity;
		
		Lettuce(int quantityInput){
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
	
	public class Rice {
		int quantity;
		
		Rice(int quantityInput){
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
	
	public class Soba {
		int quantity;
		
		Soba(int quantityInput){
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
