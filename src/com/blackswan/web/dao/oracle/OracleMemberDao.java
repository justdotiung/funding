package com.blackswan.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.entity.Member;

public class OracleMemberDao implements MemberDao {

	@Override
	public List<Member> getList() throws Exception {
		return getList(1, "name", "");
	}

	@Override
	public List<Member> getList(int page) throws Exception {
		return getList(page, "name", "");
	}

	@Override
	public List<Member> getList(int page, String field, String query) throws Exception {

		int start = 1 + (page - 1) * 10;
		int end = page * 10;
		
		List<Member> list = new ArrayList<>();
		
		String sql = "SELECT * FROM MEMBER WHERE " + field + " LIKE ? AND NUM BETWEEN ? AND ?";

		String url = "jdbc:oracle:thin:@192.168.0.16:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%" + query + "%");
		st.setInt(2, start);
		st.setInt(3, end);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Member member = new Member(rs.getString("mail"), rs.getString("name"), "", rs.getString("phone"), "", rs.getInt("black"), 
					rs.getDate("regdate"), rs.getString("condition"));

			list.add(member);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	@Override
	public Member get(String mail) throws Exception {
		return null;
	}

	@Override
	public int insert(Member member) throws Exception {
		int result = 0;
		Class.forName("");
		
		
		return result;
	}

	@Override
	public int update(Member member) throws Exception {
		return 0;
	}

	
	
}
