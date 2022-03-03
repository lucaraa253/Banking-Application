package com.training.pms.model;

import java.util.Objects;

public class Customer {
	int custId;
	String username;
	String password;
	public Customer(int custId, String username, String password) {
		super();
		this.custId = custId;
		this.username = username;
		this.password = password;
	}
	public Customer(String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
	}
	public Customer() {
		
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(custId, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return custId == other.custId && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
