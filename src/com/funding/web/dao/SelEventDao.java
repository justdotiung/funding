package com.funding.web.dao;

import java.util.List;

import com.funding.web.entity.SelEvent;
import com.funding.web.entity.SelEventView;

public interface SelEventDao {
	
	
	SelEvent get(String member_id) throws Exception;	//회원정보 상세보기
	
	int insert(SelEvent event) throws Exception;	//회원가입
	int update(SelEvent event) throws Exception;	//마이페이지-정보수정
	
	List<SelEventView> getList() throws Exception;
	List<SelEventView> getList(int page) throws Exception;
	List<SelEventView> getList(int page, String field, String query) throws Exception;

	List<SelEventView> search(SelEventView selEvent)throws Exception;
	
	int getCount() throws Exception;
	int getCount(String field, String query)throws Exception;

	List<SelEventView> search(int page, SelEventView selEvent) throws Exception;
	 
}
