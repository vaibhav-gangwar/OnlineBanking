package com.banking.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fd")
public class Fd {
	
	@Id
	@Column(name="Fd_ID")
	private int fdid;
	
	public Fd(int fdid, int customerid, float balance) {
		super();
		this.fdid = fdid;
		this.customerid = customerid;
		Balance = balance;
	}

	public int getFdid() {
		return fdid;
	}

	public void setFdid(int fdid) {
		this.fdid = fdid;
	}

	@Column(name="Cust_ID")
	private int customerid;
	
	@Column(name = "Balance")
	private float Balance;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public float getBalance() {
		return Balance;
	}

	public void setBalance(float balance) {
		Balance = balance;
	}

	public Fd() {
		super();
	}
	

}
