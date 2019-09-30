package com.revature.webcharity_core.webcharityapp.projectdept2.model;


public class loginUser {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private long phone_no;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	@Override
	public String toString() {
		return "login [id=" + id + ", name=" + name + ", phone_no=" + phone_no + "]";
	}
	
}
