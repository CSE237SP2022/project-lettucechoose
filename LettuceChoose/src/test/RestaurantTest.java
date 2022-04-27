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
	void testInStockWithExistingItem() {
		assertEquals(testRestaurant.isInStock("salad"), true);
		for(int i = 0; i <= 2; i++) {
			testRestaurant.decrementQuantity("salad");
		}
		assertEquals(testRestaurant.isInStock("salad"), false);
	}
	
	@Test
	void testCheckQuantity() {
		assertEquals(testRestaurant.checkQuantity("salad"), 3);
		assertEquals(testRestaurant.checkQuantity("chicken"), 3);
		assertEquals(testRestaurant.checkQuantity("mango"), 3);
		assertEquals(testRestaurant.checkQuantity("saladdddd"), -1);
		assertEquals(testRestaurant.checkQuantity("CHicken"), -1);
		assertEquals(testRestaurant.checkQuantity("manGO"), -1);
	}
	
	@Test
	void testCheckQuantityWithDecrement() {
		testRestaurant.decrementQuantity("salad");
		assertEquals(testRestaurant.checkQuantity("salad"), 2);
	}
	
	@Test
	void testResetOrder() {
		testRestaurant.decrementQuantity("salad");
	}
	
	@Test
	void testCategoryWithNonExistingItem() {
		Boolean testCategory = testRestaurant.isInCategory("chicken", "base");
		assertEquals(false, testCategory);
	}
	
	@Test
	void testCategoryWithExistingItem() {
		Boolean testCategory = testRestaurant.isInCategory("salad", "base");
		assertEquals(true, testCategory);
	}
	
	@Test
	void testCategoryWithNonExistingCategory() {
		Boolean testCategory = testRestaurant.isInCategory("salad", "baseee");
		assertEquals(false, testCategory);
	}

}
