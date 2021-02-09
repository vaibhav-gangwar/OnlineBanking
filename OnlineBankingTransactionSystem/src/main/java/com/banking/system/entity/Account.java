package com.banking.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name = "Acc_No")
	private String accountNumber;
	
	@Column(name = "ACC_ID")
	private Long accountId;
	
	
	@OneToOne
	@JoinColumn(name = "Cust_ID")
	Customer customer;
	
	@Column(name = "Balance")
	private float Balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public float getBalance() {
		return Balance;
	}

	public void setBalance(float balance) {
		Balance = balance;
	}

	public Account(String accountNumber, Long accountId, Customer customer, float balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountId = accountId;
		this.customer = customer;
		Balance = balance;
	}

	public Account() {
		super();
		
	}
	
}
	