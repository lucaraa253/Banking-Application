package com.training.pms.dao;

import java.util.List;

import com.training.pms.model.Account;
import com.training.pms.model.Customer;
import com.training.pms.model.Employee;
import com.training.pms.model.Product;

public interface EmployeeDAO {
	public boolean register(Employee employee);
	public boolean validate(String username,String password);
	public boolean approveAccount(int id);
	public boolean denyAccount(int id2);
	
	
}
