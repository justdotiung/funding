package com.blackswan.web.dao;

import java.util.List;

import com.blackswan.web.entity.Member;

public interface MemberDao {
	
	List<Member> getList() throws Exception;	//������-ȸ������Ʈ
	List<Member> getList(int page) throws Exception;	//������-ȸ������Ʈ(������ �ѱ��)
	List<Member> getList(int page, String field, String query) throws Exception;	//������-ȸ������Ʈ(�˻�)
	
	Member get(String mail) throws Exception;	//ȸ������ �󼼺���
	
	int insert(Member member) throws Exception;	//ȸ������
	int update(Member member) throws Exception;	//����������-��������

}
