package com.training.pms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.training.pms.dao.AccountDAO;
import com.training.pms.dao.AccountDAOImpl;
import com.training.pms.dao.CustomerDAO;
import com.training.pms.dao.CustomerDAOImpl;
import com.training.pms.dao.EmployeeDAO;
import com.training.pms.dao.EmployeeDAOImpl;
import com.training.pms.dao.ProductDAO;
import com.training.pms.dao.ProductDAOImpl;
import com.training.pms.dao.TransactionsDAO;
import com.training.pms.dao.TransactionsDAOImpl;
import com.training.pms.model.Account;
import com.training.pms.model.Customer;
import com.training.pms.model.Employee;
import com.training.pms.model.Product;
import com.training.pms.model.Transactions;

public class EmployeeApp {
	
	int choice = 0;
	boolean result;
	
	Customer customer = new Customer();
	CustomerDAO customerDAO = new CustomerDAOImpl();
	Employee emp = new Employee();
	EmployeeDAO empDAO = new EmployeeDAOImpl();
	TransactionsDAO transDAO = new TransactionsDAOImpl();
	AccountDAO accDAO = new AccountDAOImpl();
	List<Account> accounts = new ArrayList<Account>();
	List<Transactions> transactions = new ArrayList<Transactions>();
	
	public void startEmployeeApp(String username) throws IOException {


		
		Scanner scanner = new Scanner(System.in);
		
		
		while (true) {
			System.out.println("************************************************");
			System.out.println("****************EMPLOYEE PORTAL*****************");
			System.out.println("************************************************");
			System.out.println("********|    1. View All Accounts      |********");
			System.out.println("********|    2. Print All Transactions |********");
			System.out.println("********|    3. Approve An Account     |********");
			System.out.println("********|    4. Deny An Account        |********");
			System.out.println("********|    5. Log out                |********");
			System.out.println("********|    6. Exit                   |********");
			System.out.println("************************************************");
			System.out.println("************************************************");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1: 
				
				accounts = accDAO.getAccounts(username);
				if (accounts.size() == 0) {
					System.out.println("No accounts");
					continue;
				}
				
				printAllAccounts(accounts);
				
				
					break;
			case 2: 
				transactions = transDAO.getTransactions();
				if (transactions.size() == 0) {
					System.out.println("No accounts");
					continue;
				}
				
				printAllTransactions(transactions);
				break;
				
			case 3:
				System.out.println("Please enter the account ID you would like to approve");
				int id = scanner.nextInt();
				
				
				
				result = empDAO.approveAccount(id);
				if(result) {
					System.out.println("The account was approved");
				}else {
					System.out.println("Something went wrong");
				}
				
				
					break;
				
			case 4:
				System.out.println("Please enter the account ID you would like to approve");
				int id2 = scanner.nextInt();
				
				
				
				result = empDAO.denyAccount(id2);
				if(result) {
					System.out.println("The account was approved");
				}else {
					System.out.println("Something went wrong");
				}
				
				
				
				break;
				
			case 5:
				BankingPortalApp productApp2 = new BankingPortalApp();
				productApp2.startProductApp();
				break;
				
				
			case 6:
				System.out.println("Thank you for using Bank of Revature");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice ");
			}
			
				}
			}

	


	public void printAllAccounts(List<Account> accounts) {
		Iterator<Account> iterator = accounts.iterator();
		while (iterator.hasNext()) {
			Account temp = iterator.next();
			System.out.print("Account ID : " + temp.getId() + "  ||  ");
			System.out.print("Bank account type : " + temp.getName() + "  ||  ");
			System.out.print("Balance : " + temp.getAmount() + "  ||  ");
			System.out.println("Approved : " + temp.isApproved());
			System.out.println();
		}
	}
	
	public void printAllTransactions(List<Transactions> transactions) {
		Iterator<Transactions> iterator2 = transactions.iterator();
		while (iterator2.hasNext()) {
			Transactions temp2 = iterator2.next();
			System.out.print("Transaction ID : " + temp2.getId() + "  ||  ");
			System.out.print("Transaction type : " + temp2.getTransactionType() + "  ||  ");
			System.out.print("Customer ID : " + temp2.getCustId() + "  ||  ");
			System.out.println("Main Account performing transaction : " + temp2.getAccountNum1());
			System.out.println("Second account receiving a transaction : " + temp2.getAccountNum2());
			System.out.println("Amount transacted : " + temp2.getAmount());
			System.out.println();
			System.out.println("Next Transaction");
			System.out.println();
		}
	}
	
}
