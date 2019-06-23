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
		return getList(page, "title", "");
	}

	@Override
	public List<SelEventView> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		int start = 1 + (page - 1) * 10;
		
		int end = page * 10;
		
		List<SelEventView> list = new ArrayList<>();
		

		String sql ="select title,regdate,to_char(sdate,'YYYY-MM-DD') sdate,to_char(edate,'YYYY-MM-DD') edate, state, id from SEL_EVENT_VIEW "
				+ "where "+field+" like ? and num between ? and ?";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%" + query + "%");
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
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
	public List<SelEventView> search(int page , SelEventView selEvent) throws Exception {
		List<String> sqls = new ArrayList<>(); 
		List<SelEventView> list = new ArrayList<>();
		
		int start = 1 + (page - 1) * 10;
		int end = page * 10;
		
		String sql ="select title,regdate,to_char(sdate,'YYYY-MM-DD') sdate,to_char(edate,'YYYY-MM-DD') edate, state, id from SEL_EVENT_VIEW";
		//String e = "";
		if(selEvent.getState().equals("0"))
			sql="select title,regdate,to_char(sdate,'YYYY-MM-DD') sdate,to_char(edate,'YYYY-MM-DD') edate, state, id from SEL_EVENT_VIEW";
		if(!selEvent.getTitle().equals("") && selEvent.getTitle() !=null ) {
			String sq = "title like '%"+selEvent.getTitle()+"%'";
			sqls.add(sq);
		}
		if(!selEvent.getSdate().equals("") && selEvent.getSdate() !=null ) {
			String sq ="sdate = '"+selEvent.getSdate()+"'";
			sqls.add(sq);
		}
		if(!selEvent.getState().equals("") && selEvent.getState() !=null && !selEvent.getState().equals("0") ) {
			String sq ="state = '"+selEvent.getState()+"'";
			sqls.add(sq);
		}
		if(!selEvent.getEdate().equals("") && selEvent.getEdate() !=null ) {
			String sq ="edate = '"+selEvent.getEdate()+"'";
			sqls.add(sq);
		}
		if(sqls.size() != 0) {
			sql += " where ";
			for (int i = 0; i < sqls.size(); i++) {
				if(i == sqls.size()-1)
					sql+=sqls.get(i);
				else
					sql+=sqls.get(i)+" and ";
			}
			sql+=" and num between '"+start+"' and '"+end+"'";
			System.out.println(sql);
		}else
			sql+=" where num between '"+start+"' and '"+end+"'";
			System.out.println(sql);
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
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
	public int getCount() throws Exception {
		
		return getCount("title", "");
	}

	@Override
	public int getCount(String field, String query)throws Exception {
		int count=0;
		String sql = "select count(id) count from SEL_EVENT_VIEW where "+field+" like ?";
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"PRJ\"", "1234");
	//	Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "%"+query+"%");
		//Statement는 sql을 넣어줘야 한다.
		//result=statement.executeUpdate(sql);
		ResultSet rs = statement.executeQuery();
		while(rs.next())
			count = rs.getInt("count");

 		rs.close();	
		statement.close();
		connection.close();

		return count;

	}

	@Override
	public List<SelEventView> search(SelEventView selEvent) throws Exception {
		// TODO Auto-generated method stub
		return search(1, selEvent);
	}
	
}
