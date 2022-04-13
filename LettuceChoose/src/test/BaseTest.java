package test;

import Base.Base;
//import Base.Base.Lettuce;
//import Base.Base.Soba;
//import Base.Base.Rice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class BaseTest {
	
	// test if each base exists in Map<String, Integer> ingredientsInventory of base class when initialized
	
	@Test
	void testSobaExistsInitially() {
		Base base = new Base(); // set up
		Assert.assertEquals(base.doesExists(1), true);
	}
	
	@Test
	void testRiceExistsInitially() {
		Base base = new Base(); // set up
		Assert.assertEquals(base.doesExists(2), true);
	}
	
	@Test
	void testSaladExistsInitially() {
		Base base = new Base(); // set up
		Assert.assertEquals(base.doesExists(3), true);
	}

	// test if each base is available after base is initialized
	
	@Test
	void testSobaAvailability() {
		Base base = new Base(); // set up
		base.isAvailable("soba");
		Assert.assertEquals(base.isAvailable("soba"), true);
	}
	
	
	@Test
	void testRiceAvailability() {
		Base base = new Base(); // set up
		base.isAvailable("rice");
		Assert.assertEquals(base.isAvailable("rice"), true);
	}
	
	@Test
	void testSaladAvailability() {
		Base base = new Base(); // set up
		base.isAvailable("salad");
		Assert.assertEquals(base.isAvailable("salad"), true);
	}
	
	// test if each base becomes unavailable after 3 calls of isAvailable
	
	@Test
	void testSobaUnAvailable() {
		Base base = new Base(); // set up
		base.isAvailable("soba");
		base.isAvailable("soba");
		base.isAvailable("soba");
		Assert.assertEquals(base.isAvailable("soba"), false);
	}
	
	@Test
	void testRiceUnAvailable() {
		Base base = new Base(); // set up
		base.isAvailable("rice");
		base.isAvailable("rice");
		base.isAvailable("rice");
		Assert.assertEquals(base.isAvailable("rice"), false);
	}
	
	@Test
	void testSaladUnAvailable() {
		Base base = new Base(); // set up
		base.isAvailable("salad");
		base.isAvailable("salad");
		base.isAvailable("salad");
		Assert.assertEquals(base.isAvailable("salad"), false);
	}
	
	// test if each base exists in Map<String, Integer> ingredientsInventory of base class regardless of their count or availability
	
	@Test
	void testSobaExists() {
		Base base = new Base(); // set up
		base.isAvailable("soba");
		base.isAvailable("soba");
		base.isAvailable("soba");
		Assert.assertEquals(base.doesExists(1), true);
	}
	
	@Test
	void testRiceExists() {
		Base base = new Base(); // set up
		base.isAvailable("rice");
		base.isAvailable("rice");
		base.isAvailable("rice");
		Assert.assertEquals(base.doesExists(2), true);
	}
	
	@Test
	void testSaladExists() {
		Base base = new Base(); // set up
		base.isAvailable("salad");
		base.isAvailable("salad");
		base.isAvailable("salad");
		Assert.assertEquals(base.doesExists(3), true);
	}
	
	
	
	
	

}