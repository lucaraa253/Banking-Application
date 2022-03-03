package com.training.pms.dao;

import java.util.List;

import com.training.pms.model.Account;
import com.training.pms.model.Transactions;


public interface AccountDAO {
	public List<Account> getAccountsById(String username);
	public List<Account> getAccounts(String username);
	public boolean createAccount(String name, int custId, int amount, boolean approved, String username);
	
	
}
