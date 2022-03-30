package Topping;

import java.util.HashMap;
import java.util.Map;

import Protein.Protein.ProteinChoice;

public class Topping {
	Edamame edamame;
	Guacamole guacamole;
	Tomato tomato;
	Onion onion;
	Masago masago;
	
	
	public enum ToppingChoice{
		Edamame(1),
		Guacamole(2),
		Tomato(3),
		Onion(4),
		Masago(5);

		private int value;
	    private static Map map = new HashMap<>();

	    private ToppingChoice(int value) {
	        this.value = value;
	    }

	    static {
	        for (ToppingChoice tc : ToppingChoice.values()) {
	            map.put(tc.value, tc);
	        }
	    }

	    public static ToppingChoice valueOf(int tc) {
	        return (ToppingChoice) map.get(tc);
	    }

	    public int getValue() {
	        return value;
	    }
	}
	
	public Topping(){
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
