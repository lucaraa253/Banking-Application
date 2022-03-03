package com.training.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.pms.model.Login;
import com.training.pms.utility.DBConnection;

public class LoginDAOImpl implements LoginDAO {

	Connection connection = DBConnection.getConnection();
	@Override
	public boolean register(Login login) {
		System.out.println("##Adding user :" + login);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into customer values(default,?,?)");
			statement.setString(1, login.getUsername());
			statement.setString(2, login.getPassword());

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
			stat = connection.prepareStatement("select * from login where username = ? and password = ? ");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}

}
