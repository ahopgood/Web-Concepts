package com.alexander.concepts.mvc.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductTest {

	private Product product;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		product = new Product();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetAndGetDescription() {
		String expected = "testfield";
		assertNull(product.getDescription());
		
		product.setDescription(expected);
		assertEquals(expected, product.getDescription());
	}

	@Test
	public void testSetAndGetPrice() {
        double testPrice = 100.00;
        assertEquals(0, 0, 0);    
        
        product.setPrice(testPrice);
        assertEquals(testPrice, product.getPrice(), 0);
	}

}
