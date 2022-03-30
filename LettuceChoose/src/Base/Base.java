package Base;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Base {
	Lettuce lettuce;
	Rice rice;
	Soba soba;
	public Map<Integer, Object> baseMap;
	
	public enum BaseChoice{
		Salad(1),
		Soba(2),
		Rice(3);

		private int value;
	    private static Map map = new HashMap<>();

	    private BaseChoice(int value) {
	        this.value = value;
	    }

	    static {
	        for (BaseChoice bc : BaseChoice.values()) {
	            map.put(bc.value, bc);
	        }
	    }

	    public static BaseChoice valueOf(int bc) {
	        return (BaseChoice) map.get(bc);
	    }

	    public int getValue() {
	        return value;
	    }
	}
	
	public Base(){
		this.lettuce = new Lettuce(3);
		this.rice = new Rice(3);
		this.soba = new Soba(3);
		
		baseMap = new HashMap<Integer, Object>();
		baseMap.put(1, this.lettuce);
		baseMap.put(2, this.rice);
		baseMap.put(3, this.soba);
		
	}
	
	public Boolean isAvailable(Object whichBase, String baseChosen) {
		if (whichBase == this.lettuce) {
			if (this.lettuce.quantity > 0){
				this.lettuce.quantity -= 1;
				baseChosen = "lettuce";
				return true;
			}else {
				return false;
			}
		}else if (whichBase == this.rice) {
			if (this.rice.quantity > 0){
				this.rice.quantity -= 1;
				baseChosen = "rice";
				return true;
			}else {
				return false;
			}
		}else if (whichBase == this.soba) {
			if (this.soba.quantity > 0) {
				this.soba.quantity -= 1;
				baseChosen = "soba";
				return true;
			}else {
				return false;
			}
		}else {
			System.out.println("not found in isAvailable()");
			return false;
		}
	}
	
	public class Lettuce {
		int quantity;
		
		Lettuce(int quantityInput){
			this.quantity = quantityInput;
		}
	}
	
	public class Rice {
		int quantity;
		
		Rice(int quantityInput){
			this.quantity = quantityInput;
		}
	}
	
	public class Soba {
		int quantity;
		
		Soba(int quantityInput){
			this.quantity = quantityInput;
		}

	}

}
