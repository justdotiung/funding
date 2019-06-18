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

		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%" + query + "%");
		st.setInt(2, start);
		st.setInt(3, end);
		
		ResultSet rs = st.executeQuery();


		rs.close();
		st.close();
		con.close();

		return list;
	}

	@Override
	public Member get(String email) throws Exception {
		Member member = null;

		String sql = "select * from member where email = ?";
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setString(1, email);
		ResultSet rs = pt.executeQuery();
		while(rs.next()) {
			member = new Member(
					rs.getString("id"),
					rs.getString("email"),
					rs.getString("name"),
					rs.getString("pw"),
					rs.getString("phone"),
					rs.getString("profile"),
					rs.getString("event_check"),
					rs.getString("admin_id"),
					rs.getString("address"),
					rs.getString("address_num"),
					rs.getString("regdate")
				    );
					
		}
		
		return member;
	}

	@Override
	public int insert(Member member) throws Exception {
		int result = 0;
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		String sql = "INSERT INTO member ( email, name, pw, phone , event_check) VALUES (?,?,?,to_number(?),to_number(?))";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, member.getEmail());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPw());
		ps.setString(4, member.getPhone());
		ps.setString(5, member.getEventcheck());
		
		result = ps.executeUpdate();
		
		return result;
	}

	@Override
	public int update(Member member) throws Exception {
		return 0;
	}
	@Override
	public List<Member> getUK() throws Exception {
		List<Member> list = new ArrayList<Member>();
		String sql = "select email , phone from member";
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement pt = con.prepareStatement(sql);
		
		ResultSet rs = pt.executeQuery();
		while(rs.next()) {
		Member member = new Member(
					rs.getString("email"),
					rs.getString("phone")
				    );
		list.add(member);
		}
		return list;
	}
	
}
