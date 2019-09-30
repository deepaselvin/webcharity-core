package com.revature.webcharity_core.webcharityapp.projectdept2.model;

public class adminreg {
private String amountDonated;
private int Fundneeded;
public int getFundneeded() {
	return Fundneeded;
}
public void setFundneeded(int fundneeded) {
	Fundneeded = fundneeded;
}
public String getAmountDonated() {
	return amountDonated;
}
public void setAmountDonated(String amountDonated) {
	this.amountDonated = amountDonated;
}
private String RequestName;
	public String getRequestName() {
	return RequestName;
}
public void setRequestName(String requestName) {
	RequestName = requestName;
}
	private String adminName;
	private long Phnoneno;
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public long getPhnoneno() {
		return Phnoneno;
	}
	public void setPhnoneno(long phnoneno) {
		Phnoneno = phnoneno;
	}
	@Override
	public String toString() {
		return "adminreg [adminName=" + adminName + ", Phnoneno=" + Phnoneno + "]";
	}
}

