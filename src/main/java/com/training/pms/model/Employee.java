package com.training.pms.model;

import java.util.Objects;

public class Employee {
	int employeeId;
	String username;
	String password;
	
	
	
	public Employee(int employeeId, String username, String password) {
		super();
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
	}
	
	public Employee(String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
	}
	public Employee() {
		
	}
	public int getEmployeeId() {
		
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
		return Objects.hash(employeeId, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeId == other.employeeId && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
