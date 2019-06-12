package com.blackswan.web.dao;

import java.util.List;

import com.blackswan.web.entity.Member;

public interface MemberDao {
	
	List<Member> getList() throws Exception;	//관리자-회원리스트
	List<Member> getList(int page) throws Exception;	//관리자-회원리스트(페이지 넘기기)
	List<Member> getList(int page, String field, String query) throws Exception;	//관리자-회원리스트(검색)
	
	Member get(String mail) throws Exception;	//회원정보 상세보기
	
	int insert(Member member) throws Exception;	//회원가입
	int update(Member member) throws Exception;	//마이페이지-정보수정

}
