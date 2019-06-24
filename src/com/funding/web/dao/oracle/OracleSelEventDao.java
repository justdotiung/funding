package com.funding.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.funding.web.dao.SelEventDao;
import com.funding.web.entity.SelEvent;
import com.funding.web.entity.SelEventView;

public class OracleSelEventDao implements SelEventDao {

	@Override
	public List<SelEventView> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1);
	}

	@Override
	public List<SelEventView> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(page, "","","","");
	}
	
	public List<SelEventView> getList(int page, String query, String sdate, String edate, String state) throws ClassNotFoundException, SQLException {
		int start = 1 + (page - 1) * 10;
		
		int end = page * 10;
		
		List<SelEventView> list = new ArrayList<>();
		
		//String sql ="SELECT num, title, to_char(regdate,'YYYY.MM.DD') regdate, to_char(sdate,'YYYY.MM.DD') sdate, to_char(edate,'YYYY.MM.DD') edate, state, id FROM sel_event_view where title like '%"+query+"%'";
		
		StringBuilder sql= new StringBuilder(); 
		sql.append("SELECT num, title, to_char(regdate,'YYYY.MM.DD') regdate, to_char(sdate,'YYYY.MM.DD') sdate, to_char(edate,'YYYY.MM.DD') edate, state, id FROM sel_event_view where title like '%"+query+"%'");
		
		if("0".equals(state))
			sql.append("");	
		if(!sdate.equals(""))
			sql.append(" and sdate >=to_date('"+sdate+"')"); 
		if(!edate.equals(""))
			sql.append(" and edate <=to_date('"+edate+"')"); 
		if(!state.equals("") && !"0".equals(state))
			sql.append(" and state ="+state); 
		sql.append(" and num between "+start+" and "+end);
		
	
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		Statement st = con.createStatement();
		
	
		ResultSet rs = st.executeQuery(sql.toString());
		
		while(rs.next()) {
			SelEventView event = new SelEventView(
					rs.getString("id"),
					rs.getString("regdate"),
					rs.getString("sdate"),
					rs.getString("edate"), 
					rs.getString("state"),
					rs.getString("title"));
			list.add(event);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	@Override
	public SelEvent  get(String id) throws Exception{
		
		SelEvent event =null;
		String sql ="select id,admin_id,regdate,sdate,edate,attach_img,link,manager,man_eamil,state,funding_id "
				  + "from sel_event where id = ?";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		  
		st.setString(1, id);
		
		
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
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
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
	
		int result = 0;
		String sql = "update sel_event set state = ? where id= to_number(?)";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
	
		st.setString(1,event.getState());
		st.setString(2, event.getId());
		result = st.executeUpdate();
	
		return result;	
	}

	@Override
	public int getCount() throws Exception {
		
		return getCount("","","","");
	}

	@Override
	public int getCount(String query, String sdate, String edate, String state)throws Exception {
		int count=0;
		StringBuilder sql = new StringBuilder();
		
		sql.append("select count(id) count from SEL_EVENT_VIEW where title like '%"+query+"%'");		
				
		if("0".equals(state) && state != null)
			sql.append("");	
		if(!sdate.equals("") && sdate!= null)
			sql.append(" and sdate >=to_date('"+sdate+"')"); 
		if(!edate.equals("") && edate != null)
			sql.append(" and edate <=to_date('"+edate+"')"); 
		if(!state.equals("") && !"0".equals(state) && state !=null)
			sql.append(" and state ="+state); 
		
		
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		Connection connection = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		Statement statement = connection.createStatement();
		
		
		ResultSet rs = statement.executeQuery(sql.toString());
		while(rs.next())
			count = rs.getInt("count");

 		rs.close();	
		statement.close();
		connection.close();
		return count;

	}

}
