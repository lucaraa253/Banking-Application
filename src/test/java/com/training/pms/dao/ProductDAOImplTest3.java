package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.training.pms.model.Product;


@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class ProductDAOImplTest3 {
	ProductDAO productDAO;
	int productId;
	Product product;
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		productDAO = new ProductDAOImpl();
		productId = 9999;
		product = new Product();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(value = 1)
	void testAddProduct() {
		product = new Product(productId, "Dummy", 10, 100);
		assertTrue(productDAO.addProduct(product));
	}

	@Test
	@Order(value = 2)
	void testSearchByProductId() {
		Product foundProduct = productDAO.searchByProductId(productId);
		product = new Product(productId, "Dummy", 10, 100);
		assertEquals(foundProduct, product);
	}
	@Test
	@Order(value = 3)
	void testUpdateProduct() {
		Product prod = new Product(productId, "NewDummy", 199, 90);
		assertTrue(productDAO.updateProduct(prod));
	}

	@Test
	@Order(value = 4)
	void testGetProducts() {
		List<Product> products = productDAO.getProducts();
		assertNotEquals(0, products.size());
	}
	
	
	@Test
	@Order(value = 5)
	void testDeleteProduct() {
		assertTrue(productDAO.deleteProduct(productId));
	}



	@Test
	void testSearchByProductName() {
		//fail("Not yet implemented");
	}



	@Test
	void testSearchProductByPrice() {
		//fail("Not yet implemented");
	}

	@Test
	void testIsProductExists() {
		//fail("Not yet implemented");
	}

}

