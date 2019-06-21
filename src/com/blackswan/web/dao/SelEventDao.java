package com.blackswan.web.dao;

import java.util.List;

import com.blackswan.web.entity.SelEvent;
import com.blackswan.web.entity.SelEventView;

public interface SelEventDao {
	
	
	SelEvent get(String member_id) throws Exception;	//회원정보 상세보기
	
	int insert(SelEvent event) throws Exception;	//회원가입
	int update(SelEvent event) throws Exception;	//마이페이지-정보수정
	
	List<SelEventView> getList() throws Exception;
	List<SelEventView> getList(int page) throws Exception;
	List<SelEventView> getList(int page, String field, String query) throws Exception;

	SelEvent search() throws Exception;
	
}
