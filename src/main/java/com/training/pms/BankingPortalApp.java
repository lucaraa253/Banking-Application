package com.training.pms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.training.pms.dao.CustomerDAO;
import com.training.pms.dao.CustomerDAOImpl;
import com.training.pms.dao.EmployeeDAO;
import com.training.pms.dao.EmployeeDAOImpl;
import com.training.pms.dao.ProductDAO;
import com.training.pms.dao.ProductDAOImpl;
import com.training.pms.model.Account;
import com.training.pms.model.Customer;
import com.training.pms.model.Employee;
import com.training.pms.model.Product;

public class BankingPortalApp {
	
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	// Animal a = new Cat();
	ProductDAO productDAO = new ProductDAOImpl();
	Product product = new Product();
	boolean result;
	List<Account> accounts = new ArrayList<Account>();
	Customer customer = new Customer();
	CustomerDAO customerDAO = new CustomerDAOImpl();
	Employee emp = new Employee();
	EmployeeDAO empDAO = new EmployeeDAOImpl();
	Account account = new Account();
	

	public void startProductApp() throws IOException {

		// declaring local variables for input
		

		String username;
		String password;
		while (true) {
			System.out.println("*********************************************");
			System.out.println("******************LOG IN PORTAL**************");
			System.out.println("*********************************************");
			System.out.println("********|    1. Employee Sign up    |********");
			System.out.println("********|    2. Employee Login      |********");
			System.out.println("********|    3. Customer Sign up    |********");
			System.out.println("********|    4. Customer Login      |********");
			System.out.println("********|    5. Exit                |********");
			System.out.println("*********************************************");
			System.out.println("*********************************************");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("*********************************************");
			System.out.println("**********Please enter your choice***********");
			System.out.println("*********************************************");
			System.out.println();
			System.out.println();
			System.out.println();
			
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1: 
				System.out.println("Please select a username : ");
				username = scanner.next();
				System.out.println("Please select a password : ");
				password = scanner.next();
				emp = new Employee(username, password);
				result = empDAO.register(emp);
				
					break;
			case 2: 
				System.out.println("Please enter your username : ");
				username = scanner.next();
				System.out.println("Please enter your password : ");
				password = scanner.next();
				
				result = empDAO.validate(username, password);
				emp = new Employee(username, password);
				if (result) {
					System.out.println("Congratulations : " + username+ " you are now logged in");
					EmployeeApp empApp = new EmployeeApp();
					empApp.startEmployeeApp(username);
				}
					
				else
					System.out.println("Oops! Something went wrong. Please enter a valid username and password");
				
				break;
				
			case 3:
				System.out.println("Please select a username : ");
				username = scanner.next();
				System.out.println("Please select a password : ");
				password = scanner.next();
				customer = new Customer(username, password);
				result = customerDAO.register(customer);
				
				
				break;
				
				
			case 4:
				System.out.println("Please enter your username : ");
				username = scanner.next();
				System.out.println("Please enter your password : ");
				password = scanner.next();
				
				result = customerDAO.validate(username, password);
				customer = new Customer(username, password);
				if (result) {
					System.out.println("Congratulations : " + username+ " you are now logged in");
					CustomerApp custApp = new CustomerApp();
					custApp.startCustomerApp(username);
				}
					
				else
					System.out.println("Oops! Something went wrong. Please enter a valid username and password");
				
				break;
				
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice ");
			}
		}
		
}
}