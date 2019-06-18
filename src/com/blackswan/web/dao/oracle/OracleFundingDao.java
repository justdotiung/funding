package com.blackswan.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.entity.Funding;
import com.blackswan.web.entity.Member;

public class OracleFundingDao implements FundingDao {


	@Override
	public List<Funding> getList(String email) throws Exception {

		
		List<Funding> list = new ArrayList<>();
		
		String sql = "SELECT to_char(member_id) id, to_char(category_id) ca, title, t_amount, intro_img, s_date, e_date FROM funding WHERE member_id = to_number(?)";

		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, email);
		
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			Funding	funding = new Funding(
						rs.getString("id"),
						rs.getString("ca"),
						rs.getString("title"),
						rs.getString("t_amount"),
						rs.getString("intro_img"),
						rs.getString("s_date"),
						rs.getString("e_date"));
			list.add(funding);

		}
		rs.close();
		st.close();
		con.close();

		return list;
	}

	@Override
	public Funding get(String mid) throws Exception {
		Funding funding = null;

		String sql = "select  "
				+ "id, admin_id, member_id,  category_id,  regdate, title, t_amount,"
				+ " intro_video, intro_img, s_date, e_date,  hit, state "
				+ "from funding where member_id = ?";
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setString(1, mid);
		ResultSet rs = pt.executeQuery();
		while(rs.next()) {
			funding = new Funding(
						rs.getString("id"),
						rs.getString("admin_id"),
						rs.getString("member_id"),
						rs.getString("category_id"),
						rs.getString("regdate"),
						rs.getString("title"),
						rs.getString("t_amount"),
						rs.getString("intro_video"),
						rs.getString("intro_img"),
						rs.getString("s_date"),
						rs.getString("e_date"),
						rs.getString("hit"),
						rs.getString("state")
				    );
					
		}
		
		return funding;
	}


	@Override
	public int insert(Funding funding) throws Exception {
		int result = 0;
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		String sql = "INSERT INTO funding (member_id,category_id,title,t_amount,intro_img,s_date,e_date) "
				+ 		"VALUES (?,to_number(?),?,to_number(?),?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, funding.getMember_id());
		ps.setString(2, funding.getCategory_id());
		ps.setString(3, funding.getTitle());
		ps.setString(4, funding.getAmount());
		ps.setString(5, funding.getIntro_img());
		ps.setString(6, funding.getsDate());
		ps.setString(7, funding.geteDate());
		
		result = ps.executeUpdate();
		
		return result;
	}

	@Override
	public int update(Funding funding) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
