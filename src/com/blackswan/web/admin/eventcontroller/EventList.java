package com.blackswan.web.admin.eventcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.oracle.OracleEventDao;
import com.blackswan.web.event.UserEventDAO;


@WebServlet("/admin/event/prelist")
public class EventList extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserEventDAO d = new OracleEventDao();
		try {
		req.setAttribute("list",d.getList());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/admin/event/prelist.jsp").forward(req, resp);
	}
}
