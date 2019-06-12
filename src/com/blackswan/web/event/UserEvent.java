package com.blackswan.web.event;

import java.util.Date;

public class UserEvent {
	private int num;
	private String id;
	private String object;
	private Date aday;
	private Date sday;
	private Date eday;
	private String img;
	private String link;
	private String condition;
	
	public UserEvent() {
	}
	

	
	public UserEvent(int num, String id, String object, Date aday, Date sday, Date eday, String condition) {
		super();
		this.num = num;
		this.id = id;
		this.object = object;
		this.aday = aday;
		this.sday = sday;
		this.eday = eday;
		this.condition = condition;
	}



	public UserEvent(String id, Date sday, Date eday, String img, String linck, String condition) {
		this.id = id;
		this.sday = sday;
		this.eday = eday;
		this.img = img;
		this.link = linck;
		this.condition = condition;
	}



	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public Date getAday() {
		return aday;
	}
	public void setAday(Date aday) {
		this.aday = aday;
	}

	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public Date getSday() {
		return sday;
	}
	
	
	
	
	public void setSday(Date sday) {
		this.sday = sday;
	}
	
	
	
	public Date getEday() {
		return eday;
	}
	
	
	
	public void setEday(Date eday) {
		this.eday = eday;
	}
}
