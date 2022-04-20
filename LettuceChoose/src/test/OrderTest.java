package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import Order.Order;
import org.junit.jupiter.api.Test;


class OrderTest {
	
	Order order;
	
	@BeforeEach
	void setup() {
		order = new Order();
	}


	@Test
	void testQuantity() {
		//order.Order(soba, protein, topping, drink, tip);
		//check if the quantity matches
		//assertEquals(1, soba.quantity);
	}
	
	
	@Test
	void testcalculateSubTotal() {
		order.setBase("salad");
		order.setProtein("beef");
		order.setTopping("edamame");
		order.setTopping("onion");
		order.setTopping("mango");
		
		assertEquals(13, order.calculateSubtotal());
	}
	
	@Test
	void testcalculateFinalTotal() {
		order.setBase("salad");
		order.setProtein("beef");
		order.setTopping("edamame");
		order.setTopping("onion");
		order.setTopping("mango");
		order.setTipAmount(3.0);
		
		order.calculateSubtotal();
		order.calculateTax();
		
		assertEquals(17.95, order.calculateTotal());
	}

}
