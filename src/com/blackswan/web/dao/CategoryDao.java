package com.blackswan.web.dao;


import java.util.List;

import com.blackswan.web.entity.Category;
import com.blackswan.web.entity.CategoryView;

public interface CategoryDao {
	
	List<Category> getlist() throws Exception;
	Category get(String Id) throws Exception;	
	int insert(Category category) throws Exception;
	int delete(String Id) throws Exception;
	List<CategoryView> countlist()throws Exception;
	int sum()throws Exception;
}
