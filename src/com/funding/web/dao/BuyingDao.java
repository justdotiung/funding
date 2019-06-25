package com.funding.web.dao;


import java.util.List;

import com.funding.web.entity.Buying;

public interface BuyingDao {
	
//	List<Category> getlist() throws Exception;
//	Category get(String Id) throws Exception;	
	int insert(Buying buying) throws Exception;
	int delete(String Id) throws Exception;
//	List<CategoryView> countlist()throws Exception;
//	int sum()throws Exception;
}
