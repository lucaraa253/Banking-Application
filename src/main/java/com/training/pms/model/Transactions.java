package com.training.pms.model;

import java.util.Objects;

public class Transactions {
	int id;
	String transactionType;
	int custId;
	int accountNum1;
	int accountNum2;
	int amount;
	
	public Transactions() {
		
	}
	
	public Transactions(int id, String transactionType, int custId, int accountNum1, int accountNum2, int amount) {
		super();
		this.id = id;
		this.transactionType = transactionType;
		this.custId = custId;
		this.accountNum1 = accountNum1;
		this.accountNum2 = accountNum2;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getAccountNum1() {
		return accountNum1;
	}
	public void setAccountNum1(int accountNum1) {
		this.accountNum1 = accountNum1;
	}
	public int getAccountNum2() {
		return accountNum2;
	}
	public void setAccountNum2(int accountNum2) {
		this.accountNum2 = accountNum2;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountNum1, accountNum2, amount, custId, id, transactionType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transactions other = (Transactions) obj;
		return accountNum1 == other.accountNum1 && accountNum2 == other.accountNum2 && amount == other.amount
				&& custId == other.custId && id == other.id && Objects.equals(transactionType, other.transactionType);
	}
	@Override
	public String toString() {
		return "Transactions [id=" + id + ", transactionType=" + transactionType + ", custId=" + custId
				+ ", accountNum1=" + accountNum1 + ", accountNum2=" + accountNum2 + ", amount=" + amount + "]";
	}
	
	
}
