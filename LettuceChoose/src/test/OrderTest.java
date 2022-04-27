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
	void testCalculateSubTotal() {
		double subtotal = order.calculateSubtotal();
		assertEquals(13, subtotal);
	}

	@Test
	void testCalculateTax() {
		order.calculateSubtotal();
		Double tax = order.calculateTax();
		assertEquals(1.95, tax);
	}
	
	@Test
	void testCalculateFinalTotal() {
		order.setTipAmount(3.0);
		order.calculateSubtotal();
		order.calculateTax();
		
		assertEquals(17.95, order.calculateTotal());
	}
	
	@Test
	void testCalculateFinalTotalWithNoTip() {
		order.setTipAmount(0);
		order.calculateSubtotal();
		order.calculateTax();
		
		assertEquals(14.95, order.calculateTotal());
	}
	
	@Test
	void testCalculateFinalTotalWithNegativeTip() {
		order.setTipAmount(-1);
		order.calculateSubtotal();
		order.calculateTax();
		
		assertEquals(15.95, order.calculateTotal());
	}

}
