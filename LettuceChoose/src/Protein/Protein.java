package Protein;

import java.util.HashMap;
import java.util.Map;

import Base.Base.BaseChoice;

@SuppressWarnings("unchecked")
public class Protein {
	public Beef beef;
	public Chicken chicken;
	public Salmon salmon;
	public Tofu tofu;
	
	
	public enum ProteinChoice{
		Beef(1),
		Chicken(2),
		Salmon(3),
		Tofu(4);

		private int value;
	    private static Map map = new HashMap<>();

	    private ProteinChoice(int value) {
	        this.value = value;
	    }

	    static {
	        for (ProteinChoice pc : ProteinChoice.values()) {
	            map.put(pc.value, pc);
	        }
	    }

	    public static ProteinChoice valueOf(int pc) {
	        return (ProteinChoice) map.get(pc);
	    }

	    public int getValue() {
	        return value;
	    }
	}
	
	public Protein(){
		beef = new Beef(3);
		chicken = new Chicken(3);
		salmon = new Salmon(3);
		tofu = new Tofu(3);
	}
	
	
	public Boolean isAvailable(Object whichProtein, String proteinChosen) {
		if (whichProtein == this.beef) {
			if (this.beef.quantity > 0){
				this.beef.quantity -= 1;
				proteinChosen = "beef";
				return true;
			}else {
				return false;
			}
		}else if (whichProtein == this.chicken) {
			if (this.chicken.quantity > 0){
				this.chicken.quantity -= 1;
				proteinChosen = "chicken";
				return true;
			}else {
				return false;
			}
		}else if (whichProtein == this.salmon) {
			if (this.salmon.quantity > 0) {
				this.salmon.quantity -= 1;
				proteinChosen = "salmon";
				return true;
			}else {
				return false;
			}
		}else if (whichProtein == this.tofu) {
			if (this.tofu.quantity > 0) {
				this.tofu.quantity -= 1;
				proteinChosen = "tofu";
				return true;
			}else {
				return false;
			}
		}else {
			System.out.println("not found in isAvailable()");
			return false;
		}
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
