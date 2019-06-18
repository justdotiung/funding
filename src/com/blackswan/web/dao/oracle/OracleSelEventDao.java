package com.blackswan.web.dao.oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.SelEventDao;
import com.blackswan.web.entity.Event;
import com.blackswan.web.entity.Member;
import com.blackswan.web.entity.SelEvent;
import com.blackswan.web.event.UserEvent;
import com.blackswan.web.event.UserEventDAO;

public class OracleSelEventDao implements SelEventDao {

	@Override
	public List<SelEvent> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1);
	}

	@Override
	public List<SelEvent> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1, "id", "");
	}

	@Override
	public List<SelEvent> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		int start = 1 + (page - 1) * 10;
		int end = page * 10;
		
		List<SelEvent> list = new ArrayList<>();
		
		String sql = "SELECT * FROM SEL_EVENT WHERE " + field + " LIKE ?";

		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%" + query + "%");
	
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			SelEvent event = new SelEvent(
					rs.getString("id"), 
					rs.getString("admin_id"),
					rs.getString("funding_id"),
					rs.getString("regdate"), 
					rs.getString("sdate"), 
					rs.getString("edate"),
					rs.getString("attach_img"),
					rs.getString("link"), 
					rs.getString("manager"),
					rs.getString("man_eamil"),
					rs.getString("state"));
				

			list.add(event);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	@Override
	public SelEvent  get(String member_id) throws Exception{
		
		SelEvent event =null;
		String sql ="select id, admin_id, funding_id, img, regdate,sdate,edate, attach_img,link, manager, man_eamil,state "
				  + "from sel_event where id = ?";
		
		String url = "jdbc:oracle:thin:@192.168.0.16:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		  
		st.setString(1, member_id);
		
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			event = new SelEvent(
					rs.getString("id"), 
					rs.getString("admin_id"),
					rs.getString("funding_id"),
					rs.getString("regdate"), 
					rs.getString("sdate"), 
					rs.getString("edate"),
					rs.getString("attach_img"),
					rs.getString("link"), 
					rs.getString("manager"),
					rs.getString("man_eamil"),
					rs.getString("state")
					);

		}

		rs.close();
		st.close();
		con.close();
		return event;
	}

	public int insert(SelEvent selEvent) throws Exception {
		int result = 0;
		String sql = "insert into sel_event (funding_id,sdate,edate,attach_img,link,manager,man_eamil) VALUES"
				+ "(?,?,?,?,?,?,?)";
		
		String url = "jdbc:oracle:thin:@192.168.0.16:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
	
		st.setString(1, selEvent.getFunding_id());
		st.setString(2, selEvent.getSdate());
		st.setString(3,selEvent.getEdate());
		st.setString(4, selEvent.getAttach());
		st.setString(5, selEvent.getLink());
		st.setString(6, selEvent.getManager());
		st.setString(7, selEvent.getMan_eamil());
		
		result = st.executeUpdate();
	
			return result;	

			
	}

	@Override
	public int update(SelEvent event) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
