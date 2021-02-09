package com.banking.system.entity;

public class FundTranferVO {

	String fromEmailId;	
	String toEmailId;	
	float transferAmount;

	public String getFromEmailId() {
		return fromEmailId;
	}

	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}

	public String getToEmailId() {
		return toEmailId;
	}

	public void setToEmailId(String toEmailId) {
		this.toEmailId = toEmailId;
	}

	public float getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(float transferAmount) {
		this.transferAmount = transferAmount;
	}

	public FundTranferVO(String fromEmailId,String toEmailId, float transferAmount) {
		super();
		this.fromEmailId = fromEmailId;
		this.toEmailId = toEmailId;
		this.transferAmount = transferAmount;
	}

	public FundTranferVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
