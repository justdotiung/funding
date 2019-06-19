package com.blackswan.web.entity;

public class Category {
	private String id;
	private String admin_Id;
	private String name;

	public Category() {
	}

	
	public Category(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Category(String id, String admin_Id, String name) {
		this.id = id;
		this.admin_Id = admin_Id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(String admin_Id) {
		this.admin_Id = admin_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
