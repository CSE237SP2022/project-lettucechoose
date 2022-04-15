package test;

import Topping.Topping;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToppingTest {

	Topping topping;
	
	@BeforeEach
	void setUp() throws Exception {
		topping = new Topping();
	}

	// test if each protein exists in Map<String, Integer> ingredientsInventory of protein class when initialized
	
	@Test
	void testEdamameExistsInitially() {		
		Assert.assertEquals(topping.doesExists(1), true);
	}
	
	@Test
	void testGuacamoleExistsInitially() {
		Assert.assertEquals(topping.doesExists(2), true);
	}
	
	@Test
	void testTomatoExistsInitially() {
		Assert.assertEquals(topping.doesExists(3), true);
	}
	
	@Test
	void testOnionExistsInitially() {
		Assert.assertEquals(topping.doesExists(4), true);
	}
	
	@Test
	void testMasagoExistsInitially() {
		Assert.assertEquals(topping.doesExists(5), true);
	}
	
	@Test
	void testNoneExistsInitially() {
		Assert.assertEquals(topping.doesExists(6), true);
	}
	
	// test if each protein is available after protein object is initialized
	
	@Test
	void testEdamameAvailability() {
		topping.decrementQuantity("edamame");
		topping.decrementQuantity("edamame");
		Assert.assertEquals(topping.isAvailable("edamame"), true);
	}
	
	@Test
	void testGuacamoleAvailability() {
		topping.decrementQuantity("guacamole");
		topping.decrementQuantity("guacamole");
		Assert.assertEquals(topping.isAvailable("guacamole"), true);
	}
	
	@Test
	void testTomatoAvailability() {
		topping.decrementQuantity("tomato");
		topping.decrementQuantity("tomato");
		Assert.assertEquals(topping.isAvailable("tomato"), true);
	}
	
	@Test
	void testOnionAvailability() {
		topping.decrementQuantity("onion");
		topping.decrementQuantity("onion");
		Assert.assertEquals(topping.isAvailable("onion"), true);
	}
	
	@Test
	void testMasagoAvailability() {
		topping.decrementQuantity("masago");
		topping.decrementQuantity("masago");
		Assert.assertEquals(topping.isAvailable("masago"), true);
	}
	
	@Test
	void testNoneAvailability() {
		topping.decrementQuantity("none");
		topping.decrementQuantity("none");
		Assert.assertEquals(topping.isAvailable("none"), true);
	}
		
	// test if each protein becomes unavailable after 3 calls of isAvailable
	
	@Test
	void testEdamameUnavailable() {
		topping.decrementQuantity("edamame");
		topping.decrementQuantity("edamame");
		topping.decrementQuantity("edamame");
		Assert.assertEquals(topping.isAvailable("edamame"), false);
	}
	
	@Test
	void testGuacamoleUnavailable() {
		topping.decrementQuantity("guacamole");
		topping.decrementQuantity("guacamole");
		topping.decrementQuantity("guacamole");
		Assert.assertEquals(topping.isAvailable("guacamole"), false);
	}
	
	@Test
	void testTomatoUnavailable() {
		topping.decrementQuantity("tomato");
		topping.decrementQuantity("tomato");
		topping.decrementQuantity("tomato");
		Assert.assertEquals(topping.isAvailable("tomato"), false);
	}
	
	@Test
	void testOnionUnavailable() {
		topping.decrementQuantity("onion");
		topping.decrementQuantity("onion");
		topping.decrementQuantity("onion");
		Assert.assertEquals(topping.isAvailable("onion"), false);
	}
	
	@Test
	void testMasagoUnavailable() {
		topping.decrementQuantity("masago");
		topping.decrementQuantity("masago");
		topping.decrementQuantity("masago");
		Assert.assertEquals(topping.isAvailable("masago"), false);
	}

}
