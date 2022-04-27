package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Order.Order;
import Ingredient.Ingredient;
import Restaurant.Restaurant;;

class RestaurantTest {

	Restaurant testRestaurant;
	Order testOrder;
	
	@BeforeEach
	void setup() {
		testRestaurant = new Restaurant();
		testOrder = new Order(testRestaurant);
	}
	
	@Test
	void testDecrementQuantity() {
		int initialQuantity = testRestaurant.checkQuantity("salad");
		testRestaurant.setOrder(testOrder, "base", "salad");
		Ingredient selectedIngredient = testRestaurant.getInventory().get("salad");
		int quantity = selectedIngredient.getQuantity();
		assertEquals(initialQuantity-1, quantity);
	}
	
	
	@Test
	void testIncrementQuantity() {
		int initialQuantity = testRestaurant.checkQuantity("salad");
		testRestaurant.incrementQuantity("salad", 3);
		Ingredient selectedIngredient = testRestaurant.getInventory().get("salad");
		int quantity = selectedIngredient.getQuantity();
		assertEquals(initialQuantity+3, quantity);
	}
	
	@Test
	void testInStockWithExistingItem() {
		assertEquals(true, testRestaurant.isInStock("edamame"));
		for(int i = 0; i <= 2; i++) {
			testRestaurant.setOrder(testOrder, "topping", "edamame");
		}
		assertEquals(false, testRestaurant.isInStock("edamame"));
	}
	

	
	// checkQuantity() returns -1 if the input is an invalid ingredient
	@Test
	void testCheckQuantity() {
		assertEquals(3, testRestaurant.checkQuantity("salad"));
		assertEquals(3, testRestaurant.checkQuantity("chicken"));
		assertEquals(3, testRestaurant.checkQuantity("mango"));
		assertEquals(-1, testRestaurant.checkQuantity("saladdddd"));
		assertEquals(-1, testRestaurant.checkQuantity("CHicken"));
		assertEquals(-1, testRestaurant.checkQuantity("manGO"));
	}
	
	@Test
	void testCheckQuantityWithDecrement() {
		int initialQuantity = testRestaurant.checkQuantity("salad");
		testRestaurant.decrementQuantity("salad");
		assertEquals(initialQuantity-1, testRestaurant.checkQuantity("salad"));
	}
	
	// If user cancels the order in the middle of the order, 
	// the quantity of the base shouldn't be decremented
	@Test
	void testCancelOrder() {
		
		int initialQuantity = testRestaurant.checkQuantity("salad");
		testRestaurant.setOrder(testOrder, "base", "salad");
		testRestaurant.resetOrder(testOrder);
		assertEquals(initialQuantity, testRestaurant.checkQuantity("salad"));
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
