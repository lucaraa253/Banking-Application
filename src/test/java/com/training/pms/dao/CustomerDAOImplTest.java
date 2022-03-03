package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerDAOImplTest {
	
	CustomerDAO custDAO = new CustomerDAOImpl();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testValidate() {
		Boolean actual = custDAO.validate("Harold", "Nancy");
		Boolean expected = true;
		assertTrue(expected, actual);
	}

	private void assertTrue(Boolean expected, Boolean actual) {
		// TODO Auto-generated method stub
		
	}

}
