package com.training.pms.dao;

import com.training.pms.model.Customer;
import com.training.pms.model.Login;

public interface CustomerDAO {
	public boolean register(Customer customer);
	public boolean validate(String username,String password);
	public void transfer(int sender, int receiver, int total,String username);
	public void withdraw(String username, int repoAccount, int repoAmmount);
	public void deposit(String username, int depoAccount, int depoAmmount);
	
}
