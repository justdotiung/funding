package com.blackswan.web.event;

import java.sql.SQLException;
import java.util.List;


public interface UserEventDAO {
	List<UserEvent> getList() throws ClassNotFoundException, SQLException;
	List<UserEvent> getList(int page) throws ClassNotFoundException, SQLException;
	List<UserEvent> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;
	
	UserEvent get(String id) throws ClassNotFoundException, SQLException;
	int insert(UserEvent user) throws ClassNotFoundException, SQLException;
	
}
