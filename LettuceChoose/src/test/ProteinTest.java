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
		protein.isAvailable("beef");
		protein.isAvailable("beef");
		Assert.assertEquals(protein.isAvailable("beef"), true);
	}
	
	@Test
	void testChickenAvailabilty() {
		protein.isAvailable("chicken");
		protein.isAvailable("chicken");
		Assert.assertEquals(protein.isAvailable("chicken"), true);
	}
	
	@Test
	void testSalmonAvailabilty() {
		protein.isAvailable("salmon");
		protein.isAvailable("salmon");
		Assert.assertEquals(protein.isAvailable("salmon"), true);
	}
	
	@Test
	void testTofuAvailabilty() {
		protein.isAvailable("tofu");
		protein.isAvailable("tofu");
		Assert.assertEquals(protein.isAvailable("tofu"), true);
	}
		
	// test if each protein becomes unavailable after 3 calls of isAvailable
	
	@Test
	void testBeefUnavailable() {
		protein.isAvailable("beef");
		protein.isAvailable("beef");
		protein.isAvailable("beef");
		Assert.assertEquals(protein.isAvailable("beef"), false);
	}
	
	@Test
	void testChickenUnavailable() {
		protein.isAvailable("chicken");
		protein.isAvailable("chicken");
		protein.isAvailable("chicken");
		Assert.assertEquals(protein.isAvailable("chicken"), false);
	}
	
	@Test
	void testSalmonUnavailable() {
		protein.isAvailable("salmon");
		protein.isAvailable("salmon");
		protein.isAvailable("salmon");
		Assert.assertEquals(protein.isAvailable("salmon"), false);
	}
	
	@Test
	void testTofuUnavailable() {
		protein.isAvailable("tofu");
		protein.isAvailable("tofu");
		protein.isAvailable("tofu");
		Assert.assertEquals(protein.isAvailable("tofu"), false);
	}
	
}
