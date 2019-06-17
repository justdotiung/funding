package com.blackswan.web.dao;

import java.util.List;

import com.blackswan.web.entity.Funding;

public interface FundingDao {
	
//	List<Funding> getList() throws Exception;	//관리자-회원리스트
	List<Funding> getList(String email) throws Exception;	//관리자-회원리스트(페이지 넘기기)
//	List<Funding> getList(int page, String field, String query) throws Exception;	//관리자-회원리스트(검색)
	
	Funding get(String mail) throws Exception;	//회원정보 상세보기
	
	int insert(Funding funding) throws Exception;	//회원가입
	int update(Funding funding) throws Exception;	//마이페이지-정보수정
	

}
