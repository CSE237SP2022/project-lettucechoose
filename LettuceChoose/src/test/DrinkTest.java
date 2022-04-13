package test;

import Drink.Drink;

import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DrinkTest {

	Drink drink;
	
	
	@BeforeEach
	void setup() {
		drink = new Drink();
	}
	
	
	// test if each drink exists in Map<String, Integer> drinksInventory of drink class when initialized 
	
	@Test
	void testCokeExistsInitially() {		
		Assert.assertEquals(drink.doesExists(1), true);
	}
	
	@Test
	void testSpriteExistsInitially() {
		Assert.assertEquals(drink.doesExists(2), true);
	}
	
	@Test
	void testIcedTeaExistsInitially() {
		Assert.assertEquals(drink.doesExists(3), true);
	}
	
	@Test
	void testNoneExistsInitially() {
		Assert.assertEquals(drink.doesExists(4), true);
	}
	
	//	test if each drink is available after drink object is initialized
	
	
	@Test
	void testCokeAvailability() {
		drink.isAvailable("coke");
		drink.isAvailable("coke");
		Assert.assertEquals(drink.isAvailable("coke"), true);
	}
	
	@Test
	void testSpriteAvailability() {
		drink.isAvailable("sprite");
		drink.isAvailable("sprite");
		Assert.assertEquals(drink.isAvailable("sprite"), true);
	}
	
	@Test
	void testIcedTeaAvailability() {
		drink.isAvailable("iced tea");
		drink.isAvailable("iced tea");
		Assert.assertEquals(drink.isAvailable("iced tea"), true);
	}
		
	// test if each drink becomes unavailable after 3 calls of isAvailable
	
	@Test
	void testCokeUnavailable() {
		drink.isAvailable("coke");
		drink.isAvailable("coke");
		drink.isAvailable("coke");
		Assert.assertEquals(drink.isAvailable("coke"), false);
	}
	
	@Test
	void testSpriteUnavailable() {
		drink.isAvailable("sprite");
		drink.isAvailable("sprite");
		drink.isAvailable("sprite");		
		Assert.assertEquals(drink.isAvailable("sprite"), false);
	}
	
	@Test
	void testIcedTeaUnavailable() {
		drink.isAvailable("iced tea");
		drink.isAvailable("iced tea");
		drink.isAvailable("iced tea");		
		Assert.assertEquals(drink.isAvailable("iced tea"), false);
	}
	
	// test if Map<String, Integer> drinkPrice contains correct values for given drink
	
	@Test
	void testCokePrice() {
		Assert.assertEquals(drink.getDrinkPrice(1), 2);
	}
	
	@Test
	void testSpritePrice() {
		Assert.assertEquals(drink.getDrinkPrice(2), 3);
	}
	
	@Test
	void testIcedTeaPrice() {
		Assert.assertEquals(drink.getDrinkPrice(3), 4);
	}
	
	@Test
	void testNoneTeaPrice() {
		Assert.assertEquals(drink.getDrinkPrice(4), 0);
	}

}
