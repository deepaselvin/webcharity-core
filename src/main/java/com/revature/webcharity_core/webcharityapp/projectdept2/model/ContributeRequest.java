package com.revature.webcharity_core.webcharityapp.projectdept2.model;

public class ContributeRequest {
	 
    private	double fund_needed;
private int id;
	private String name;
	private long userId ;
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	private int requestid ; 
	private  double amountdonated ;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public double getFund_needed() {
		return fund_needed;
	}

	public void setFund_needed(double fund_needed) {
		this.fund_needed = fund_needed;
	}
	
	
	


	public int getRequestid() {
		return requestid;
	}


	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public double getAmountdonated() {
		return amountdonated;
	}

	public void setAmountdonated(double amt) {
		this.amountdonated = amt;
	}

	@Override
	public String toString() {
		return "ContributeRequest [fund_needed=" + fund_needed + ", id=" + id + ", name=" + name + ", userId=" + userId
				+ ", requestid=" + requestid + ", amountdonated=" + amountdonated + "]";
	}

}
