package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Order.Order;
import Ingredient.Ingredient;
import Restaurant.Restaurant;


class IngredientsTest {

	Restaurant testRestaurant;
	
	@BeforeEach
	void setup() {
		testRestaurant = new Restaurant();
	}
	
	@Test
	void testDecrementQuantity() {
		testRestaurant.decrementQuantity("Salad");
		Ingredient selectedIngredient = testRestaurant.getInventory().get("Salad");
		int quantity = selectedIngredient.getQuantity();
		assertEquals(2, quantity);
	}
	
	

}
