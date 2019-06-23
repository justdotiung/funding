package com.funding.web.dao;

import java.util.List;

import com.funding.web.entity.SelEvent;
import com.funding.web.entity.SelEventView;

public interface SelEventDao {
	
	
	SelEvent get(String member_id) throws Exception;	//ȸ������ �󼼺���
	
	int insert(SelEvent event) throws Exception;	//ȸ������
	int update(SelEvent event) throws Exception;	//����������-��������
	
	List<SelEventView> getList() throws Exception;
	List<SelEventView> getList(int page) throws Exception;
	List<SelEventView> getList(int page, String field, String query) throws Exception;

	List<SelEventView> search(SelEventView selEvent)throws Exception;
	
	int getCount() throws Exception;
	int getCount(String field, String query)throws Exception;

	List<SelEventView> search(int page, SelEventView selEvent) throws Exception;
	 
}
