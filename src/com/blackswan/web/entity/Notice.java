package com.blackswan.web.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Notice {
	private int id;
	private String title;
	private String content;
	private String writerId;
	private Date regDate;
	private int hit;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}


	public Notice(int id, String title, String content, String writerId, Date regDate, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.content=content;
		this.writerId = writerId;
		this.regDate = regDate;
		this.hit = hit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date redDate) {
		this.regDate = redDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
