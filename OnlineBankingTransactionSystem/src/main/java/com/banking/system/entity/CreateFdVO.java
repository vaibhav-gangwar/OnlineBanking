package com.banking.system.entity;

public class CreateFdVO {
	
	String fromEmailId;	
	float accountbalance;	
	float depositbalance;
	
	
	public CreateFdVO(String fromEmailId, float accountbalance, float depositbalance) {
		super();
		this.fromEmailId = fromEmailId;
		this.accountbalance = accountbalance;
		this.depositbalance = depositbalance;
	}
	
	
	public CreateFdVO() {
		super();
		
	}


	public String getFromEmailId() {
		return fromEmailId;
	}
	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}
	public float getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(float accountbalance) {
		this.accountbalance = accountbalance;
	}
	public float getDepositbalance() {
		return depositbalance;
	}
	public void setDepositbalance(float depositbalance) {
		this.depositbalance = depositbalance;
	}

	

}
