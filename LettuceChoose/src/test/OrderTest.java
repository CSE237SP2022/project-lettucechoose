package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import Order.Order;
import Restaurant.Restaurant;

import org.junit.jupiter.api.Test;


class OrderTest {
	
	Order order;
	
	@BeforeEach
	void setup() {
		Restaurant restaurant = new Restaurant();
		order = new Order(restaurant);
		order.setBase("salad");
		order.setProtein("beef");
		order.setTopping("edamame");
		order.setTopping("tomato");
		order.setTopping("mango");
	}

	@Test
	void testcalculateSubTotal() {
		assertEquals(13, order.calculateSubtotal());
	}

	@Test
	void testcalculateTax() {
		order.calculateSubtotal();
		assertEquals(1.95, order.calculateTax());
	}
	
	@Test
	void testcalculateFinalTotal() {
		order.setTipAmount(3.0);
		order.calculateSubtotal();
		order.calculateTax();
		
		assertEquals(17.95, order.calculateTotal());
	}

}
