package com.funding.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.funding.web.dao.BuyingDao;
import com.funding.web.entity.Buying;

public class OracleBuyingDao implements BuyingDao {

	@Override
	public int insert(Buying buying) throws Exception {
		int result = 0;
				
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		String sql =  "INSERT INTO buying(funding_id, member_id, quantity, pay_pr, req) VALUES ()";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, buying.getFunding_id());
		ps.setString(2, buying.getMember_id());
		ps.setString(3, buying.getQuantity());
		ps.setString(4, buying.getPay_pr());
		ps.setString(5, buying.getReq());
		
		result = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return result;
		
	}

	@Override
	public int delete(String Id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
