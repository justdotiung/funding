package com.blackswan.web.dao;

import java.util.List;

import com.blackswan.web.entity.Event;

public interface EventDao {
	
	
	Event get(String id) throws Exception;	//회원정보 상세보기
	
	int insert(Event event) throws Exception;	//회원가입
	int update(Event event) throws Exception;	//마이페이지-정보수정
	
	List<Event> getList() throws Exception;
	List<Event> getList(int page) throws Exception;
	List<Event> getList(int page, String field, String query) throws Exception;
	
	
}
