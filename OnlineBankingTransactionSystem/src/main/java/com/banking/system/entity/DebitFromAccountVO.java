package com.banking.system.entity;

public class DebitFromAccountVO {

	String fromEmailId;		
	float debitAmount;

	public String getFromEmailId() {
		return fromEmailId;
	}

	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}

	public float getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(float debitAmount) {
		this.debitAmount = debitAmount;
	}

	public DebitFromAccountVO(String fromEmailId, float debitAmount) {
		super();
		this.fromEmailId = fromEmailId;
		this.debitAmount = debitAmount;
	}

	public DebitFromAccountVO() {
		super();
		
	}
	
	

}
