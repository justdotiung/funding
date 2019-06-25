package com.funding.web.entity;

public class Buying {
	private String id;
	private String funding_id;
	private String member_id;
	private String quantity;
	private String pay_date;
	private String pay_pr;
	private String shipping_date;
	private String req;
	private String state;

	public Buying() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Buying(String id, String funding_id, String member_id, String quantity, String pay_date, String pay_pr,
			String shipping_date, String req, String state) {
		super();
		this.id = id;
		this.funding_id = funding_id;
		this.member_id = member_id;
		this.quantity = quantity;
		this.pay_date = pay_date;
		this.pay_pr = pay_pr;
		this.shipping_date = shipping_date;
		this.req = req;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFunding_id() {
		return funding_id;
	}

	public void setFunding_id(String funding_id) {
		this.funding_id = funding_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public String getPay_pr() {
		return pay_pr;
	}

	public void setPay_pr(String pay_pr) {
		this.pay_pr = pay_pr;
	}

	public String getShipping_date() {
		return shipping_date;
	}

	public void setShipping_date(String shipping_date) {
		this.shipping_date = shipping_date;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
