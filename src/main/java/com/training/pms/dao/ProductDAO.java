package com.training.pms.dao;

import java.util.List;

import com.training.pms.model.Product;

public interface ProductDAO {
//	Saving the product object
	public boolean addProduct(Product product);
	
	public boolean deleteProduct(int productId);
	
	public boolean updateProduct(Product product);
	
	public Product searchByProductId(int productId);
	
	public List<Product> searchByProductName(String productName);
	
	public List<Product> getProducts();
	
	public List<Product> printAllProductsByPrice(int priceLower, int priceHigher);
	
	public boolean doesProductExist(int productId);
}
