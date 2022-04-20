package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import Order.Order;
import Ingredient.Ingredient;
import Restaurant.Restaurant;


class IngredientsTest {
	
	Ingredient testSalad;
	
	@BeforeEach
	void setup() {
		testSalad = new Ingredient("base", "salad", 3, 3);
	}

	@Test
	void testUpdateQuantity() {
		testSalad.updateQuantity(10);
		assertEquals(13, testSalad.getQuantity());
	}
	
	
 
}
