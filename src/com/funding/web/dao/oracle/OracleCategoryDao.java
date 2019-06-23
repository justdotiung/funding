package com.funding.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funding.web.dao.CategoryDao;
import com.funding.web.dao.MemberDao;
import com.funding.web.entity.Category;
import com.funding.web.entity.CategoryView;
import com.funding.web.entity.Member;

public class OracleCategoryDao implements CategoryDao {

	@Override
	public List<Category> getlist() throws Exception {
		List<Category> list = new ArrayList<>();
		
		String sql = "select id, admin_id , name from category";

		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			Category category =  new Category(
									rs.getString("id"),
									rs.getString("admin_id"),
									rs.getString("name")
									);
			list.add(category);
		}
			
		rs.close();
		st.close();
		con.close();

		return list;
	}

	@Override
	public Category get(String Id) throws Exception {
		Category category = null;

		String sql = "select id, admin_id , name from category id = to_number(?)";
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setString(1, Id);
		ResultSet rs = pt.executeQuery();
		while(rs.next()) {
			category = new Category(
						rs.getString("id"),
						rs.getString("adnim_id"),
						rs.getString("name")
					);		
		}
		rs.close();
		pt.close();
		con.close();
		return category;
	}

	@Override
	public int insert(Category category) throws Exception {
		int result = 0;
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		String sql = "INSERT INTO category (ADMIN_ID,name) VALUES (to_number(?),?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,category.getAdmin_Id());
		ps.setString(2,category.getName());
		
		result = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return result;
	}

	
	@Override
	public int delete(String Id) throws Exception {
		int result = 0;
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		String sql = "delete from category where id = to_number(?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,Id);
		
		result = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return result;
	}
	public List<CategoryView> countlist() throws Exception{
		List<CategoryView> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		String sql = "select count,id,name from category_view";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			CategoryView ca = new CategoryView(rs.getInt("count"), rs.getString("id") ,rs.getString("name"));
			list.add(ca);
		}
		ps.close();
		con.close();
		
		return list;
	}

	@Override
	public int sum() throws Exception {
		int result =0;
		String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
		String sql = "select sum(to_number(count)) sum from category_view";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
			result = rs.getInt("sum");
		
		ps.close();
		con.close();
		
		return result;
	}

}
