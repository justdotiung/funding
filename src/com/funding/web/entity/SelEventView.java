package com.funding.web.entity;

public class SelEventView extends SelEvent {
	private String title;

	public String getTitle() {
		return title;
	}

	

	public SelEventView(String id,String regdate, String sdate, String edate, String state, String title) {
		super(id,regdate, sdate, edate, state);
		this.title = title;
	}



	public SelEventView( String sdate, String edate, String state,  String title) {
		super(sdate,edate,state);
		this.title = title;
	}
	
}
