package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductDAOImplTest2 {
	
	ProductDAO productDao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		productDao = new ProductDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDoesProductExist() {
		int productId=2;
		boolean actual = productDao.doesProductExist(productId);
		assertFalse(actual);
	}
	@Test
	void testDoesProductExist2() {
		int productId=3;
		boolean actual = productDao.doesProductExist(productId);
		assertTrue(actual);
	}

}
