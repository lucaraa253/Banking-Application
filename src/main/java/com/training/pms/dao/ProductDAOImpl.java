package com.training.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.training.pms.model.Product;
import com.training.pms.utility.DBConnection;

public class ProductDAOImpl implements ProductDAO {

	Connection con = DBConnection.getConnection();
	
	public boolean addProduct(Product product) {
		System.out.println("##Adding products :" + product);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = con.prepareStatement("insert into product values(?,?,?,?)");
			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getProductName());
			statement.setInt(3, product.getQuantityOnHand());
			statement.setInt(4, product.getPrice());

			rows = statement.executeUpdate();
			System.out.println(rows + " inserted successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

	public boolean deleteProduct(int productId) {
		System.out.println("##Deleting product with product id  :" + productId);
		PreparedStatement statement = null;
		int rows=0;
		try {
			statement = con.prepareStatement("delete from product where productid = ?");
			statement.setInt(1, productId);
			rows = statement.executeUpdate();
			System.out.println(rows + " deleted successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rows==0)
			return false;
		else
			return true;
	}

	public boolean updateProduct(Product product) {
		System.out.println("##Updating products :" + product);
		PreparedStatement statement = null;
		int rows=0;
		try {
			statement = con.prepareStatement("update product set productName = ? , quantityonhand = ?, price = ? where productid = ?");
			statement.setInt(4, product.getProductId());
			statement.setString(1, product.getProductName());
			statement.setInt(2, product.getQuantityOnHand());
			statement.setInt(3, product.getPrice());

			rows = statement.executeUpdate();
			System.out.println(rows + " updated successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rows==0)
			return false;
		else
			return true;
	}

	public Product searchByProductId(int productId) {
		System.out.println("Searching products with product id " + productId);
//		Created list for all products
		Product product = new Product();
		
		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select * from product where productid = ?");
			stat.setInt(1, productId);
			
			ResultSet res = stat.executeQuery();
			
			while(res.next()) {
//				Created a new product object to store the single product
				
				product.setProductId(res.getInt(1));	
				product.setProductName(res.getString(2));
				product.setQuantityOnHand(res.getInt(3));
				product.setPrice(res.getInt(4));
//				Adding single product into product list
				
//				System.out.print(res.getInt(1) + "     ");
//	            System.out.print(res.getString(2) + "     ");
//	            System.out.print(res.getInt(3) + "     ");
//	            System.out.println(res.getInt(4) + "     ");
	            
//	            res.close();
//	            stat.close();
//	            stat.close();
	        
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return product;

	}

	public List<Product> searchByProductName(String productName) {
		System.out.println("Searching products with product name " + productName);
//		Created list for all products
		List<Product> products = new ArrayList<Product>();
		
		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select * from product where productName like ? ");
			stat.setString(1, productName);
			
			ResultSet res = stat.executeQuery();
			
			while(res.next()) {
//				Created a new product object to store the single product
				Product product = new Product();
				product.setProductId(res.getInt(1));	
				product.setProductName(res.getString(2));
				product.setQuantityOnHand(res.getInt(3));
				product.setPrice(res.getInt(4));
//				Adding single product into product list
				products.add(product);
//				System.out.print(res.getInt(1) + "     ");
//	            System.out.print(res.getString(2) + "     ");
//	            System.out.print(res.getInt(3) + "     ");
//	            System.out.println(res.getInt(4) + "     ");
	            
//	            res.close();
//	            stat.close();
//	            stat.close();
	        
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return products;

	}

	public List<Product> getProducts() {
		System.out.println("Printing all products ");
		List<Product> allProducts = new ArrayList<Product>();
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from product");
			
			while(res.next()) {
				
				Product product = new Product();
				product.setProductId(res.getInt(1));	
				product.setProductName(res.getString(2));
				product.setQuantityOnHand(res.getInt(3));
				product.setPrice(res.getInt(4));
//				Adding single product into product list
				allProducts.add(product);
//	            System.out.print(res.getInt(1) + "     ");
//	            System.out.print(res.getString(2) + "     ");
//	            System.out.print(res.getInt(3) + "     ");
//	            System.out.println(res.getInt(4) + "     ");
	            
//	            res.close();
//	            stat.close();
//	            stat.close();
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return allProducts;
        
       
        
//        Closing the result search, statement and connection
        
     
	}
	public List<Product> printAllProductsByPrice(int priceLower, int priceHigher) {
		System.out.println("Printing all products between the price " + priceLower + "and" + priceHigher);
		PreparedStatement stat;
		List<Product> products = new ArrayList<Product>();
		try {
			stat = con.prepareStatement("select * from product where price between ? and ?");
			stat.setInt(1, priceLower);
			stat.setInt(2, priceHigher);
			
			ResultSet res = stat.executeQuery();
			while(res.next()) {
				Product product = new Product();
				product.setProductId(res.getInt(1));	
				product.setProductName(res.getString(2));
				product.setQuantityOnHand(res.getInt(3));
				product.setPrice(res.getInt(4));
//				Adding single product into product list
				products.add(product);
//	            System.out.print(res.getInt(1) + "     ");
//	            System.out.print(res.getString(2) + "     ");
//	            System.out.print(res.getInt(3) + "     ");
//	            System.out.println(res.getInt(4) + "     ");
	            
//	            res.close();
//	            stat.close();
//	            stat.close();
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return products;
	}
        
       
        
//        Closing the result search, statement and connection
        
     
	

	public boolean doesProductExist(int productId) {
		boolean productExists = false;
		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select * from product where productid = ?");
			stat.setInt(1, productId);
			
			ResultSet res = stat.executeQuery();
			productExists = res.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productExists;
	}
	

}
