package com.blackswan.web.entity;

public class Member {
	private String id;
	private String email;
    private String name;
    private String pw;
    private String phone;
    private String profile;
    private String eventCheck;
    private String admin_id;
    private String address;
    private String address_num;
    private String regdate;
	
 
    public Member() {
	
    }
    
	public Member(String email, String name, String pw, String phone, String eventCheck) {
		super();
		this.email = email;
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.eventCheck = eventCheck;
	}

	

	public Member(String id, String email, String name, String pw, String phone, String profile, String eventCheck,
			String admin_id, String address, String address_num, String regdate) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.profile = profile;
		this.eventCheck = eventCheck;
		this.admin_id = admin_id;
		this.address = address;
		this.address_num = address_num;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getEventcheck() {
		return eventCheck;
	}
	public void setEventcheck(String eventcheck) {
		this.eventCheck = eventcheck;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_num() {
		return address_num;
	}
	public void setAddress_num(String address_num) {
		this.address_num = address_num;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	
    
}
