package com.blackswan.web.entity;

public class Member {
	private String email;
    private String name;
    private String pw;
    private String phone;
    private String profile;
    private String blacklist;
    private String blackreason;
    private String eventcheck;
    private String admin_id;
    private String secede;
    private String qna_number;
    private String address;
    private String address_num;
    private String regdate;
	
    public Member() {
	
    }
    
	public Member(String email, String name, String pw, String phone) {
		super();
		this.email = email;
		this.name = name;
		this.pw = pw;
		this.phone = phone;
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
	public String getBlacklist() {
		return blacklist;
	}
	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}
	public String getBlackreason() {
		return blackreason;
	}
	public void setBlackreason(String blackreason) {
		this.blackreason = blackreason;
	}
	public String getEventcheck() {
		return eventcheck;
	}
	public void setEventcheck(String eventcheck) {
		this.eventcheck = eventcheck;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getSecede() {
		return secede;
	}
	public void setSecede(String secede) {
		this.secede = secede;
	}
	public String getQna_number() {
		return qna_number;
	}
	public void setQna_number(String qna_number) {
		this.qna_number = qna_number;
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
