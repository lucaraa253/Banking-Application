package com.training.pms.model;

import java.util.Objects;

public class Account {
	int id;
	String name;
	int custId;
	int amount;
	boolean approved;
	public Account(int id, String name, int custId, int amount, boolean approved) {
		super();
		this.id = id;
		this.name = name;
		this.custId = custId;
		this.amount = amount;
		this.approved = approved;
	}
	
	public Account(String name, int custId, int amount, boolean approved) {
		super();
		this.name = name;
		this.custId = custId;
		this.amount = amount;
		this.approved = approved;
	}
	public Account() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, approved, custId, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return amount == other.amount && approved == other.approved && custId == other.custId && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", custId=" + custId + ", amount=" + amount + ", approved="
				+ approved + "]";
	}

	
	
	
	
	
}
