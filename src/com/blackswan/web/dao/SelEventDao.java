package com.blackswan.web.dao;

import java.util.List;

import com.blackswan.web.entity.Event;
import com.blackswan.web.entity.SelEvent;

public interface SelEventDao {
	
	
	SelEvent get(String member_id) throws Exception;	//ȸ������ �󼼺���
	
	int insert(SelEvent event) throws Exception;	//ȸ������
	int update(SelEvent event) throws Exception;	//����������-��������
	
	List<SelEvent> getList() throws Exception;
	List<SelEvent> getList(int page) throws Exception;
	List<SelEvent> getList(int page, String field, String query) throws Exception;
	
	
}
