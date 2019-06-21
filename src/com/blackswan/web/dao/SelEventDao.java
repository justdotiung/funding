package com.blackswan.web.dao;

import java.util.List;

import com.blackswan.web.entity.SelEvent;
import com.blackswan.web.entity.SelEventView;

public interface SelEventDao {
	
	
	SelEvent get(String member_id) throws Exception;	//ȸ������ �󼼺���
	
	int insert(SelEvent event) throws Exception;	//ȸ������
	int update(SelEvent event) throws Exception;	//����������-��������
	
	List<SelEventView> getList() throws Exception;
	List<SelEventView> getList(int page) throws Exception;
	List<SelEventView> getList(int page, String field, String query) throws Exception;

	SelEvent search() throws Exception;
	
}
