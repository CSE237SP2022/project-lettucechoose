package test;

import Protein.Protein;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProteinTest {

	Protein protein;
	
	@BeforeEach
	void setup() {
		 protein = new Protein();
	}
	
	// test if each protein exists in Map<String, Integer> ingredientsInventory of protein class when initialized
	
	@Test
	void testSobaExistsInitially() {		
		Assert.assertEquals(protein.doesExists(1), true);
	}
	
	@Test
	void testRiceExistsInitially() {
		Assert.assertEquals(protein.doesExists(2), true);
	}
	
	@Test
	void testSaladExistsInitially() {
		Assert.assertEquals(protein.doesExists(3), true);
	}
	
	// test if each protein is available after protein object is initialized
	
	@Test
	void testBeefAvailability() {
		protein.decrementQuantity("beef");
		protein.decrementQuantity("beef");
		Assert.assertEquals(protein.isAvailable("beef"), true);
	}
	
	@Test
	void testChickenAvailabilty() {
		protein.decrementQuantity("chicken");
		protein.decrementQuantity("chicken");
		Assert.assertEquals(protein.isAvailable("chicken"), true);
	}
	
	@Test
	void testSalmonAvailabilty() {
		protein.decrementQuantity("salmon");
		protein.decrementQuantity("salmon");
		Assert.assertEquals(protein.isAvailable("salmon"), true);
	}
	
	@Test
	void testTofuAvailabilty() {
		protein.decrementQuantity("tofu");
		protein.decrementQuantity("tofu");
		Assert.assertEquals(protein.isAvailable("tofu"), true);
	}
		
	// test if each protein becomes unavailable after 3 calls of isAvailable
	
	@Test
	void testBeefUnavailable() {
		protein.decrementQuantity("beef");
		protein.decrementQuantity("beef");
		protein.decrementQuantity("beef");
		Assert.assertEquals(protein.isAvailable("beef"), false);
	}
	
	@Test
	void testChickenUnavailable() {
		protein.decrementQuantity("chicken");
		protein.decrementQuantity("chicken");
		protein.decrementQuantity("chicken");
		Assert.assertEquals(protein.isAvailable("chicken"), false);
	}
	
	@Test
	void testSalmonUnavailable() {
		protein.decrementQuantity("salmon");
		protein.decrementQuantity("salmon");
		protein.decrementQuantity("salmon");
		Assert.assertEquals(protein.isAvailable("salmon"), false);
	}
	
	@Test
	void testTofuUnavailable() {
		protein.decrementQuantity("tofu");
		protein.decrementQuantity("tofu");
		protein.decrementQuantity("tofu");
		Assert.assertEquals(protein.isAvailable("tofu"), false);
	}
	
}
