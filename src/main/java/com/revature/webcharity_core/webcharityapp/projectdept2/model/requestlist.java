package com.revature.webcharity_core.webcharityapp.projectdept2.model;

public class requestlist {
	
	public String getName() {
		return request_type;
	}
	public void setName(String name) {
		this.request_type = request_type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String request_type;
	private int id;
	private double fund_needed;
	public double getFund_needed() {
		return fund_needed;
	}
	public void setFund_needed(double fund_needed) {
		this.fund_needed = fund_needed;
	}
	@Override
	public String toString() {
		return "requestlist [request_type=" + request_type + ", id=" + id + ", fund_needed=" + fund_needed + "]";
	}
	
}
