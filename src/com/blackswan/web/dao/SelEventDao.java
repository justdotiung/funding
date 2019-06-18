package com.blackswan.web.dao;

import java.util.List;

import com.blackswan.web.entity.Event;
import com.blackswan.web.entity.SelEvent;

public interface SelEventDao {
	
	
	SelEvent get(String member_id) throws Exception;	//회원정보 상세보기
	
	int insert(SelEvent event) throws Exception;	//회원가입
	int update(SelEvent event) throws Exception;	//마이페이지-정보수정
	
	List<SelEvent> getList() throws Exception;
	List<SelEvent> getList(int page) throws Exception;
	List<SelEvent> getList(int page, String field, String query) throws Exception;
	
	
}
