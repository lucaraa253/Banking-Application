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
import com.training.pms.model.Account;
import com.training.pms.model.Customer;
import com.training.pms.model.Employee;
import com.training.pms.model.Product;

public class CustomerApp {
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	
	boolean result;
	
	Customer customer = new Customer();
	CustomerDAO customerDAO = new CustomerDAOImpl();
	Employee emp = new Employee();
	EmployeeDAO empDAO = new EmployeeDAOImpl();
	AccountDAO accDAO = new AccountDAOImpl();
	List<Account> accounts = new ArrayList<Account>();
	Account account = new Account();

	public void startCustomerApp(String username) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		boolean approved;
		int custId;
		int amount;
		
		String password;
		while (true) {
			System.out.println("**************************************************");
			System.out.println("****************CUSTOMER PORTAL*******************");
			System.out.println("**************************************************");
			System.out.println("********|    1. Apply for an account     |********");
			System.out.println("********|    2. View Account Balances    |********");
			System.out.println("********|    3. Withdraw Cash            |********");
			System.out.println("********|    4. Deposit Cash             |********");
			System.out.println("********|    5. Transfer Cash            |********");
			System.out.println("********|    6. Log Out                  |********");
			System.out.println("********|    7. Exit                     |********");
			System.out.println("**************************************************");
			System.out.println("**************************************************");

			choice = scanner.nextInt();
			
			switch(choice) {
			case 1: 
				
				System.out.println("Are you applying for a checking or savings account : ");
				String name = scanner.next();
				
				approved = false;
				amount = 0;
				custId = 0;
				
				account = new Account(name, custId, amount, approved);
				result = accDAO.createAccount(name, custId, amount, approved, username);
				if (result)
					System.out.println("Congratulations, your account : " + name + " saved successfully");
				else
					System.out.println("Sorry your account cannot be saved");
				break;
			case 2: 
				
				accounts = accDAO.getAccountsById(username);
				if (accounts.size() == 0) {
					System.out.println("No accounts");
					continue;
				}
				
				printAllAccounts(accounts);
				
				
					break;
			case 3: 
				System.out.println("Please enter the account you would like to withdraw money from");
				int repoAccount = scanner.nextInt();
				
				System.out.println("Please enter the amount you would like to withdraw from your account");
				int repoAmmount = scanner.nextInt();
				
				customerDAO.withdraw(username, repoAccount, repoAmmount);
				
				
					break;
			case 4:
				System.out.println("Please enter the account you would like to deposit money into");
				int depoAccount = scanner.nextInt();
				
				System.out.println("Please enter the amount you would like to deposit");
				int depoAmmount = scanner.nextInt();
				
				customerDAO.deposit(username, depoAccount, depoAmmount);
				
				
				
				break;
			case 5:
				
				
				System.out.println("Enter the account number to debit the amount :");
				int sender = scanner.nextInt();

				System.out.println("Enter the account number to credit the amount :");
				int receiver = scanner.nextInt();
				
				System.out.println("Enter the amout to be  transferred :");
				int total = scanner.nextInt();
				
				customerDAO.transfer(sender, receiver, total, username);
				
				
				break;
			case 6:
				BankingPortalApp productApp2 = new BankingPortalApp();
				productApp2.startProductApp();
				break;
			case 7:
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



	
}