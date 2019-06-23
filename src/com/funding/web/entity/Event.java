package com.funding.web.entity;


public class Event {
   private String id;
   private String regdate;
   private String attach;
   private String sdate;
   private String edate;
   private String hit;
   private String state;
   private String admin_id;

public Event() {
	super();
	// TODO Auto-generated constructor stub
}


public Event(String id, String regdate, String attach, String sdate, String edate, String hit, String state,
		String admin_id) {
	this.id = id;
	this.regdate = regdate;
	this.attach = attach;
	this.sdate = sdate;
	this.edate = edate;
	this.hit = hit;
	this.state = state;
	this.admin_id = admin_id;
}


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getRegdate() {
	return regdate;
}
public void setRegdate(String regdate) {
	this.regdate = regdate;
}
public String getAttach() {
	return attach;
}
public void setAttach(String attach) {
	this.attach = attach;
}
public String getSdate() {
	return sdate;
}
public void setSdate(String sdate) {
	this.sdate = sdate;
}
public String getEdate() {
	return edate;
}
public void setEdate(String edate) {
	this.edate = edate;
}
public String getHit() {
	return hit;
}
public void setHit(String hit) {
	this.hit = hit;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getAdmin_id() {
	return admin_id;
}
public void setAdmin_id(String admin_id) {
	this.admin_id = admin_id;
}
    
   
   
	
}
