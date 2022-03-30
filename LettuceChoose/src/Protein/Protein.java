package Protein;

import java.util.HashMap;
import java.util.Map;

import Base.Base.BaseChoice;

public class Protein {
	Beef beef;
	Chicken chicken;
	Salmon salmon;
	Tofu tofu;
	
	
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
