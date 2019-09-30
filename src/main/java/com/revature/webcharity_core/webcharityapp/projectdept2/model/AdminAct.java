package com.revature.webcharity_core.webcharityapp.projectdept2.model;

public class AdminAct {
	

	private String request_type;
	private double fund_needed;

	
	
	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	public double getFund_needed() {
		return fund_needed;
	}
	public void setFund_needed(double fund_needed) {
		this.fund_needed = fund_needed;
	}
	@Override
	public String toString() {
		return "AdminAct [request_type=" + request_type + ", fund_needed=" + fund_needed + "]";
	}
}
