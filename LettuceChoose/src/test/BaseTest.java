package test;

import Base.Base;
import Base.Base.Lettuce;
import Base.Base.Soba;
import Base.Base.Rice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class BaseTest {

	
	Base base = new Base();
	
	@Test
	void sobaTest() {
		base.isAvailable(base.soba, "soba");
		base.isAvailable(base.soba, "soba");
		base.isAvailable(base.soba, "soba");
		Assert.assertEquals(base.soba.getCount(), 0);
	}
	
	
	@Test
	void riceTest() {
		base.isAvailable(base.rice, "rice");
		base.isAvailable(base.rice, "rice");
		base.isAvailable(base.rice, "rice");
		Assert.assertEquals(base.rice.getCount(), 0);
	}
	
	@Test
	void lettuceTest() {
		base.isAvailable(base.lettuce, "lettuce");
		base.isAvailable(base.lettuce, "lettuce");
		base.isAvailable(base.lettuce, "lettuce");
		Assert.assertEquals(base.lettuce.getCount(), 0);
	}

}
