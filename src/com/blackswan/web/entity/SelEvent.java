package com.blackswan.web.entity;

public class SelEvent {
	private String id;
	private String admin_id;
	private String funding_id;
	private String regdate;
	private String sdate;
	private String edate;
	private String attach;
	private String link;
	private String manager;
	private String man_eamil;
	private String state;

	public SelEvent() {
	}
	
	

	public SelEvent(String id,String regdate, String sdate, String edate, String state) {
		super();
		this.id = id;
		this.regdate = regdate;
		this.sdate = sdate;
		this.edate = edate;
		this.state = state;
	}



	public SelEvent(String funding_id, String sdate, String edate, String attach, String link, String manager,
			String man_eamil) {
		this.funding_id = funding_id;
		this.sdate = sdate;
		this.edate = edate;
		this.attach = attach;
		this.link = link;
		this.manager = manager;
		this.man_eamil = man_eamil;
	}



	public SelEvent(String id, String admin_id, String funding_id, String regdate, String sdate, String edate,
			String attach, String link, String manager, String man_eamil, String state) {
		
		this.id = id;
		this.admin_id = admin_id;
		this.funding_id = funding_id;
		this.regdate = regdate;
		this.sdate = sdate;
		this.edate = edate;
		this.attach = attach;
		this.link = link;
		this.manager = manager;
		this.man_eamil = man_eamil;
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



	public String getFunding_id() {
		return funding_id;
	}



	public void setFunding_id(String funding_id) {
		this.funding_id = funding_id;
	}



	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
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

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getMan_eamil() {
		return man_eamil;
	}

	public void setMan_eamil(String man_eamil) {
		this.man_eamil = man_eamil;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
