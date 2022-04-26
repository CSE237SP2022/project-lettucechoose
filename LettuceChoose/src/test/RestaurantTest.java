package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ingredient.Ingredient;
import Restaurant.Restaurant;;

class RestaurantTest {

	Restaurant testRestaurant;
	
	@BeforeEach
	void setup() {
		testRestaurant = new Restaurant();
	}
	
	@Test
	void testDecrementQuantity() {
		testRestaurant.decrementQuantity("salad");
		Ingredient selectedIngredient = testRestaurant.getInventory().get("salad");
		int quantity = selectedIngredient.getQuantity();
		assertEquals(2, quantity);
	}
	
	@Test
	void testIncrementQuantity() {
		testRestaurant.incrementQuantity("salad", 3);
		Ingredient selectedIngredient = testRestaurant.getInventory().get("salad");
		int quantity = selectedIngredient.getQuantity();
		assertEquals(6, quantity);
	}
	
	@Test
	void testCategory() {
		Boolean testCategory = testRestaurant.isInCategory("chicken", "base");
		assertEquals(false, testCategory);
	}
	
	

}
