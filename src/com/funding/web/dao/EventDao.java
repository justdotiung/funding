package com.funding.web.dao;

import java.util.List;

import com.funding.web.entity.Event;

public interface EventDao {
	
	
	Event get(String id) throws Exception;	//ȸ������ �󼼺���
	
	int insert(Event event) throws Exception;	//ȸ������
	int update(Event event) throws Exception;	//����������-��������
	
	List<Event> getList() throws Exception;
	List<Event> getList(int page) throws Exception;
	List<Event> getList(int page, String field, String query) throws Exception;
	
	
}
