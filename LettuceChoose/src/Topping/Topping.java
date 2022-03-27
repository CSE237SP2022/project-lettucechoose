package Topping;

public class Topping {
	Edamame edamame;
	Guacamole guacamole;
	Tomato tomato;
	Onion onion;
	Masago masago;
	
	Topping(){
		edamame = new Edamame(3);
		guacamole = new Guacamole(3);
		tomato = new Tomato(3);
		onion = new Onion(3);
		masago = new Masago(3);
	}
	
	public class Edamame {
		int quantity;
		
		Edamame(int quantityInput){
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
	
	public class Guacamole {
		int quantity;
		
		Guacamole(int quantityInput){
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
	
	public class Tomato {
		int quantity;
		
		Tomato(int quantityInput){
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
	
	public class Onion {
		int quantity;
		
		Onion(int quantityInput){
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
	
	public class Masago {
		int quantity;
		
		Masago(int quantityInput){
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
