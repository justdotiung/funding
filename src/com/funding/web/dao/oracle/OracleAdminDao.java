package com.funding.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.funding.web.dao.AdminDao;
import com.funding.web.entity.Admin;

public class OracleAdminDao implements AdminDao {

	@Override
	public Admin get() throws Exception {
		Admin admin = null;

		String sql = "select * from admin";
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		Statement st = con.createStatement();
	
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			admin = new Admin( rs.getString("id"),rs.getString("id_un"),rs.getString("pw"));				 
		}
		
		return admin;
	}	
}
