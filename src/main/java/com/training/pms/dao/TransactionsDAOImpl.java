package com.training.pms.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import com.training.pms.model.Transactions;
import com.training.pms.utility.DBConnection;

public class TransactionsDAOImpl implements TransactionsDAO {
	
	Connection connection = DBConnection.getConnection();

	@Override
	public List<Transactions> getTransactions() {
		List<Transactions> allTransactions = new ArrayList<Transactions>();
		Statement stat;
		
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from transactions");
			res.next();
			
			System.out.println("All Transactions");
			
			while(res.next()) {
				
				Transactions transaction = new Transactions();
				transaction.setId(res.getInt(1));	
				transaction.setTransactionType(res.getString(2));
				transaction.setCustId(res.getInt(3));
				transaction.setAccountNum1(res.getInt(4));
				transaction.setAccountNum2(res.getInt(5));
				transaction.setAmount(res.getInt(6));
//				
				allTransactions.add(transaction);
//	           
	            
	            
	        }
			res.close();
            stat.close();
            stat.close();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return allTransactions;
	}

}
