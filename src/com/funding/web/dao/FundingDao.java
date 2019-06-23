package com.funding.web.dao;

import java.util.List;

import com.funding.web.entity.Funding;

public interface FundingDao {
	
//	List<Funding> getList() throws Exception;	//������-ȸ������Ʈ
	List<Funding> getList(String email) throws Exception;	//������-ȸ������Ʈ(������ �ѱ��)
//	List<Funding> getList(int page, String field, String query) throws Exception;	//������-ȸ������Ʈ(�˻�)
	
	Funding get(String mail) throws Exception;	//ȸ������ �󼼺���
	
	int insert(Funding funding) throws Exception;	//ȸ������
	int update(Funding funding) throws Exception;	//����������-��������

	Funding getTitle(String id) throws Exception;
	

}