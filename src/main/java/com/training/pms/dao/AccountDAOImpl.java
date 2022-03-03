package com.training.pms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.pms.model.Account;
import com.training.pms.utility.DBConnection;

public class AccountDAOImpl implements AccountDAO{
	int customerId;
	Connection connection = DBConnection.getConnection();
	Account account = new Account();

	public List<Account> getAccountsById(String username) {
		List<Account> allAccounts = new ArrayList<Account>();
		PreparedStatement stat2;
		PreparedStatement stat;
		try {
			stat2 = connection.prepareStatement("select custid from customer where username = ?");
			stat2.setString(1, username);
			
			System.out.println("Account balances for " + username);
			ResultSet res2 = stat2.executeQuery();
			res2.next();
			
			customerId = res2.getInt(1);
			
			stat = connection.prepareStatement("select * from account where custid = ?");
			stat.setInt(1, customerId);
			ResultSet res = stat.executeQuery();
			
			while(res.next()) {
				
				Account account = new Account();
				account.setId(res.getInt(1));	
				account.setName(res.getString(2));
				account.setCustId(res.getInt(3));
				account.setAmount(res.getInt(4));
				account.setApproved(res.getBoolean(5));
//				Adding single product into product list
				allAccounts.add(account);
//	            System.out.print(res.getInt(1) + "     ");
//	            System.out.print(res.getString(2) + "     ");
//	            System.out.print(res.getInt(3) + "     ");
//	            System.out.println(res.getInt(4) + "     ");
	            
	            
	        }
			res.close();
            stat.close();
            stat.close();
            res2.close();
            stat2.close();
            stat2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return allAccounts;
	}
	public List<Account> getAccounts(String username) {
	List<Account> allAccounts = new ArrayList<Account>();
	
	try {
		Statement stat;
		
		stat = connection.createStatement();
		ResultSet res = stat.executeQuery("select * from account");
		res.next();
		
		while(res.next()) {
			
			Account account = new Account();
			account.setId(res.getInt(1));	
			account.setName(res.getString(2));
			account.setCustId(res.getInt(3));
			account.setAmount(res.getInt(4));
			account.setApproved(res.getBoolean(5));
//			Adding single product into product list
			allAccounts.add(account);
//            System.out.print(res.getInt(1) + "     ");
//            System.out.print(res.getString(2) + "     ");
//            System.out.print(res.getInt(3) + "     ");
//            System.out.println(res.getInt(4) + "     ");
            
            
        }
		res.close();
        stat.close();
        stat.close();
        
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    return allAccounts;
	}

	@Override
	public boolean createAccount(String name, int custId, int amount, boolean approved, String username) {
		int rows = 0;
		try {
			int id1;
			
			
			Statement stat;
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select custid from customer where username =" + "'" + username + "'");
			res.next();
			id1 = res.getInt(1);
			
			
			PreparedStatement stat2 = null;
			stat2 = connection.prepareStatement("insert into account values(default,?,?,?,?)");
			stat2.setString(1, name);
			stat2.setInt(2, id1);
			stat2.setInt(3, amount);
			stat2.setBoolean(4, approved);
			
			rows = stat2.executeUpdate();
			System.out.println(rows + " Accounts Created");
			
			stat2.close();
			stat2.close();
			
			
			
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		if (rows == 0)
			return false;
		else
			return true;
		
	}
}
