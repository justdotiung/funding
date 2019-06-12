package com.blackswan.web.admin.eventcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.oracle.OracleEventDao;
import com.blackswan.web.event.UserEvent;
import com.blackswan.web.event.UserEventDAO;


@WebServlet("/admin/event/insert")
public class EventInsert extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sday = req.getParameter("sday");
		String eday = req.getParameter("eday");
		String img = req.getParameter("img");
		String link = req.getParameter("link");
		String con = req.getParameter("con");
		String id = req.getParameter("id");
		//날짜 변환 !
		Date sd = new Date();
		Date ed = new Date();
		try {
			DateFormat s =new SimpleDateFormat("yyyy-MM-dd");
			 sd = s.parse(sday);
			DateFormat ee =new SimpleDateFormat("yyyy-MM-dd");
			ed = s.parse(eday);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		
		
		UserEventDAO d = new OracleEventDao();
		try {
			UserEvent user = new UserEvent(id, sd, ed, img, link, con);
			d.insert(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.sendRedirect("prelist");
	}
}
