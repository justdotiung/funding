package com.blackswan.web.admin.eventcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.oracle.OracleEventDao;
import com.blackswan.web.event.UserEvent;
import com.blackswan.web.event.UserEventDAO;


@WebServlet("/admin/event/detail")
public class EventDetail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserEventDAO d = new OracleEventDao();
		String id = req.getParameter("id");
		
		try {
		req.setAttribute("event",d.get(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/admin/event/detail.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserEventDAO d = new OracleEventDao();
		String id = req.getParameter("id");
		String con = req.getParameter("con");
		
		try {
			UserEvent event =d.get(id);
			event.setCondition(con);
		req.setAttribute("event",d.get(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
