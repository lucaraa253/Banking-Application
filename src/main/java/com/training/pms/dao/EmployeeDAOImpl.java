package com.training.pms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.training.pms.model.Account;
import com.training.pms.model.Customer;
import com.training.pms.model.Employee;
import com.training.pms.model.Product;
import com.training.pms.utility.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	

	Connection connection = DBConnection.getConnection();
	@Override
	public boolean register(Employee employee) {
		System.out.println("##Adding employee :" + employee);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into bankemployee values(default,?,?)");
			statement.setString(1, employee.getUsername());
			statement.setString(2, employee.getPassword());

			rows = statement.executeUpdate();
			System.out.println(rows + " user registered successfully");

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
			stat = connection.prepareStatement("select * from bankemployee where username = ? and pword = ?");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userValid;
	}

	@Override
	public boolean approveAccount(int id) {
		
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("update account set approved = true where id = ?");
			statement.setInt(1, id);

			rows = statement.executeUpdate();
			System.out.println(rows + " Accounts approved");

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
	public boolean denyAccount(int id2) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("update account set approved = false where id = ?");
			statement.setInt(1, id2);

			rows = statement.executeUpdate();
			System.out.println(rows + " Accounts denied");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

	
	
	
	
	
		
		
	}
	


