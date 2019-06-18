package com.blackswan.web.entity;

public class Funding {
	private String id;
	private String admin_id;
	private String member_id;
	private String category_id;
	private String regdate;
	private String title;
	private String amount;
	private String video;
	private String intro_img;
	private String sDate;
	private String eDate;
	private String hit;
	private String state;

	public Funding() {
	}

	
	
	public Funding(String member_id, String category_id, String title, String amount, String intro_img, String sDate,
			String eDate) {
		
		this.member_id = member_id;
		this.category_id = category_id;
		this.title = title;
		this.amount = amount;
		this.intro_img = intro_img;
		this.sDate = sDate;
		this.eDate = eDate;
	}



	public Funding(String id, String admin_id, String member_id, String category_id, String regdate, String title,
			String amount, String video, String intro_img, String sDate, String eDate, String hit, String state) {
		
		this.id = id;
		this.admin_id = admin_id;
		this.member_id = member_id;
		this.category_id = category_id;
		this.regdate = regdate;
		this.title = title;
		this.amount = amount;
		this.video = video;
		this.intro_img = intro_img;
		this.sDate = sDate;
		this.eDate = eDate;
		this.hit = hit;
		this.state = state;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getIntro_img() {
		return intro_img;
	}

	public void setIntro_img(String intro_img) {
		this.intro_img = intro_img;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
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
	
	

}
