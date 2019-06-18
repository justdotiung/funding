package com.blackswan.web.admin.management.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.SelEventDao;
import com.blackswan.web.dao.oracle.OracleSelEventDao;
import com.blackswan.web.entity.SelEvent;
import com.blackswan.web.entity.SelEventView;
@WebServlet("/view/admin/reg")
public class EventRegController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	req.getRequestDispatcher("/WEB-INF/view/admin/eventreg.jsp").forward(req, resp);
}
}
