package test;

import Base.Base;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseTest {
	
	private Base base;
	
	@BeforeEach
	void setup() {
		base = new Base();
		
	}
	
	// test if each base exists in Map<String, Integer> ingredientsInventory of base class when initialized
	
	@Test
	void testSobaExistsInitially() {		
		Assert.assertEquals(base.doesExists(1), true);
	}
	
	@Test
	void testRiceExistsInitially() {
		Assert.assertEquals(base.doesExists(2), true);
	}
	
	@Test
	void testSaladExistsInitially() {
		Assert.assertEquals(base.doesExists(3), true);
	}

	// test if each base is available after base object is initialized
	
	@Test
	void testSobaAvailability() {
		base.decrementQuantity("soba");
		base.decrementQuantity("soba");
		Assert.assertEquals(base.isAvailable("soba"), true);
	}
	
	
	@Test
	void testRiceAvailability() {
		base.decrementQuantity("rice");
		base.decrementQuantity("rice");
		Assert.assertEquals(base.isAvailable("rice"), true);
	}
	
	@Test
	void testSaladAvailability() {
		base.decrementQuantity("salad");
		base.decrementQuantity("salad");
		Assert.assertEquals(base.isAvailable("salad"), true);
	}
	
	// test if each base becomes unavailable after 3 calls of isAvailable
	
	@Test
	void testSobaUnAvailable() {
		base.decrementQuantity("soba");
		base.decrementQuantity("soba");
		base.decrementQuantity("soba");
		Assert.assertEquals(base.isAvailable("soba"), false);
	}
	
	@Test
	void testRiceUnAvailable() {
		base.decrementQuantity("rice");
		base.decrementQuantity("rice");
		base.decrementQuantity("rice");
		Assert.assertEquals(base.isAvailable("rice"), false);
	}
	
	@Test
	void testSaladUnAvailable() {
		base.decrementQuantity("salad");
		base.decrementQuantity("salad");
		base.decrementQuantity("salad");
		Assert.assertEquals(base.isAvailable("salad"), false);
	}
	
	// test if each base exists in Map<String, Integer> ingredientsInventory of base class regardless of their count or availability
	
	@Test
	void testSobaExists() {
		base.isAvailable("soba");
		base.isAvailable("soba");
		base.isAvailable("soba");
		Assert.assertEquals(base.doesExists(1), true);
	}
	
	@Test
	void testRiceExists() {
		base.isAvailable("rice");
		base.isAvailable("rice");
		base.isAvailable("rice");
		Assert.assertEquals(base.doesExists(2), true);
	}
	
	@Test
	void testSaladExists() {
		base.isAvailable("salad");
		base.isAvailable("salad");
		base.isAvailable("salad");
		Assert.assertEquals(base.doesExists(3), true);
	}
	
	
}