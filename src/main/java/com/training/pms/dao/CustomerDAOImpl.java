package com.training.pms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.training.pms.model.Customer;

import com.training.pms.utility.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {

	Connection connection = DBConnection.getConnection();
	int debitorBalance,creditorBalance,amount1, amount2,custId1,custId2=0;
	@Override
	public boolean register(Customer customer) {
		System.out.println("##Adding user :" + customer);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into customer values(default,?,?)");
			statement.setString(1, customer.getUsername());
			statement.setString(2, customer.getPassword());

			rows = statement.executeUpdate();
			System.out.println(rows + " user registered successfully");
			
			statement.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean validate(String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from customer where username = ? and pword = ? ");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();
			res.close();
			stat.close();
//		    stat.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
       
		
		return userValid;
	}
	@Override
	public void transfer(int sender, int receiver, int total, String username) {
		
		try {
			String accountName1,accountName2;
			Statement stat2;
			Statement stat3;
			Statement stat4;
			Statement stat5;
			CallableStatement stat = connection.prepareCall("call transferAmountAndGetbalance(?,?,?,?,?)");
			
			stat2 = connection.createStatement();
			ResultSet res = stat2.executeQuery("select amount,name from account where id =" + sender);
			res.next();
			amount1 = res.getInt(1);
			accountName1 = res.getString(2);
			
			stat3 = connection.createStatement();
			ResultSet res2 = stat3.executeQuery("select custid,name from account where id =" + sender);
			res2.next();
			custId1 = res2.getInt(1);
			accountName2 = res2.getString(2);
			
			stat4 = connection.createStatement();
			ResultSet res3 = stat4.executeQuery("select custid from customer where username =" + "'"+username+"'");
			res3.next();
			custId2 = res3.getInt(1);
			
			
			
			
			stat.setInt(1, sender);
			stat.setInt(2, receiver);
			stat.setInt(3, total);
		
			stat.registerOutParameter(4, Types.INTEGER);
			stat.setInt(4, debitorBalance);

			stat.registerOutParameter(5, Types.INTEGER);
			stat.setInt(5, creditorBalance);
			
		
			if(amount1 > total && custId1 == custId2) {
				stat.execute();
				stat5 = connection.createStatement();
				stat5.executeUpdate("insert into transactions values(default,"+  "'transfer', " + custId1 + ","+ sender +","+ receiver +","+ total + ")");
				debitorBalance = stat.getInt(4);
				creditorBalance = stat.getInt(5);
				
				System.out.println("Transfer done/completed and the balance is : ");
				System.out.println("Debitor balance :"+debitorBalance);
				System.out.println("Creditor balance :"+creditorBalance);
				
				
			}else {
				System.out.println("Insufficient funds to complete the transfer");
			}
			if(custId1 != custId2) {
				System.out.println("You cannot transfer money from an account that is not yours");
			}
			
			
			
			
			res.close();
			 stat.close();
		     stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	@Override
	public void withdraw(String username, int repoAccount, int repoAmmount) {
		try {
			int id1, id2,amount = 0;
			boolean approved= false;
			Statement stat;
			Statement stat4;
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select custid,approved,amount from account where id =" + repoAccount);
			res.next();
			id1 = res.getInt(1);
			
			approved = res.getBoolean(2);
			amount=res.getInt(3);
			Statement stat2;
			stat2 = connection.createStatement();
			ResultSet res2 = stat2.executeQuery("select custid from customer where username =" + "'"+username+"'");
			res2.next();
			id2 = res2.getInt(1);
			
			res.close();
			res2.close();
			 stat.close();
		     stat.close();
		     stat2.close();
		     stat2.close();
			
			if(id1 == id2 && approved && amount>repoAmmount) {
				Statement stat3;
				stat3 = connection.createStatement();
				
				stat3.executeUpdate("update account set amount = amount - " + repoAmmount + " where id = " + repoAccount);
				System.out.println("$" + repoAmmount +" was just withdrawn from account No : " + repoAccount);
				
				stat4 = connection.createStatement();
				stat4.executeUpdate("insert into transactions values(default,"+  "'withdraw', " + id1 + ","+ repoAccount +", null ,"+ repoAmmount + ")");
				
				
				
			}else if(!approved){
				System.out.println("Your account will need to be approved before you make a withdraw");
			}else if(!(amount > repoAmmount)){
				System.out.println("You cannot withdraw from your account if it will result in a negative balance");
			}else {
				System.out.println("You cannot withdraw from an account that is not yours");
			}
			
			
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}

	@Override
	public void deposit(String username, int depoAccount, int depoAmmount) {
		try {
			int id1, id2 = 0;
			boolean approved = false;
			
			Statement stat;
			Statement stat4;
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select custid,approved from account where id =" + depoAccount);
			res.next();
			id1 = res.getInt(1);
			approved = res.getBoolean(2);
			
			Statement stat2;
			stat2 = connection.createStatement();
			ResultSet res2 = stat2.executeQuery("select custid from customer where username =" + "'"+username+"'");
			res2.next();
			id2 = res2.getInt(1);
			
			if(id1 == id2 && approved ==true) {
				Statement stat3;
				stat3 = connection.createStatement();
				
				stat3.executeUpdate("update account set amount = amount + " + depoAmmount + " where id = " + depoAccount);
				System.out.println("$" + depoAmmount +" was just tranfered into account No : " + depoAccount);
				
				stat4 = connection.createStatement();
				stat4.executeUpdate("insert into transactions values(default,"+  "'deposit', " + id1 + ","+ depoAccount +", null ,"+ depoAmmount + ")");
				
			}else if(id1 != id2){
				System.out.println("You cannot debit an account that is not yours");
			}else {
				System.out.println("Your account will need to be approved before you make a deposit");
			}
			
			
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}

	
}