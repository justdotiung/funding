package com.blackswan.web.entity;

public class Admin {
	private String id;
	private String admin;
	private String pw;

	public Admin() {
	}
	
	
	public Admin(String id, String admin, String pw) {
		this.id = id;
		this.admin = admin;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
