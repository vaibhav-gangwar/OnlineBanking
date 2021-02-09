package com.banking.system.entity;

public class CreditToAccountVO {

	String fromEmailId;		
	float creditAmount;

	public String getFromEmailId() {
		return fromEmailId;
	}

	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}

	public float getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(float creditAmount) {
		this.creditAmount = creditAmount;
	}

	public CreditToAccountVO(String fromEmailId, float creditAmount) {
		super();
		this.fromEmailId = fromEmailId;
		this.creditAmount = creditAmount;
	}

	public CreditToAccountVO() {
		super();
		
	}
	
	

}
