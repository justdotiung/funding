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
import com.blackswan.web.entity.Member;
import com.blackswan.web.event.UserEvent;
import com.blackswan.web.event.UserEventDAO;

public class OracleEventDao implements UserEventDAO {

	@Override
	public List<UserEvent> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1);
	}

	@Override
	public List<UserEvent> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1, "id", "");
	}

	@Override
	public List<UserEvent> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		int start = 1 + (page - 1) * 10;
		int end = page * 10;
		
		List<UserEvent> list = new ArrayList<>();
		
		String sql = "SELECT * FROM event WHERE " + field + " LIKE ? AND NUM BETWEEN ? AND ?";

		String url = "jdbc:oracle:thin:@192.168.0.16:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%" + query + "%");
		st.setInt(2, start);
		st.setInt(3, end);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			UserEvent event = new UserEvent(rs.getInt("num"),rs.getString("id"), rs.getString("object"),
					rs.getDate("applyday"),
					rs.getDate("startday"),
					rs.getDate("endday"),
					rs.getString("condition")
					);
				

			list.add(event);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	@Override
	public UserEvent get(String id) throws ClassNotFoundException, SQLException {
		
		UserEvent event =null;
		String sql ="select id,startday,endday,img,condition,link from event where id = ?";
		
		String url = "jdbc:oracle:thin:@192.168.0.16:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			event = new UserEvent(rs.getString("id"),
								rs.getDate("startday"),
								rs.getDate("endday"),
								rs.getString("link"),
								rs.getString("IMG"),
								rs.getString("condition")
					);

		}

		rs.close();
		st.close();
		con.close();
		return event;
	}

	public int insert(UserEvent user) throws ClassNotFoundException, SQLException {
		int result = 0;
		String sql = "insert into event from(event_seq.nextval,?,'ÀüÃ¼',sysdate,?,?,?,?,?)";
		
		String url = "jdbc:oracle:thin:@192.168.0.16:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
	
		st.setString(1, user.getId());
		st.setDate(2, (Date)user.getSday());
		st.setDate(3,(Date)user.getEday());
		st.setString(4, user.getCondition());
		st.setString(5, user.getImg());
		st.setString(6, user.getLink());
		
		
		result = st.executeUpdate();
	
			return result;	

			
	}
}
