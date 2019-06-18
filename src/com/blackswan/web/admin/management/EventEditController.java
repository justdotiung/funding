package com.blackswan.web.admin.management;

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
@WebServlet("/view/admin/eventedit")
public class EventEditController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	SelEventDao sDao = new OracleSelEventDao();
	List<SelEvent> list = new ArrayList<>();
	try {
		list = sDao.getList();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	req.setAttribute("event",list);
	req.getRequestDispatcher("/WEB-INF/view/admin/eventedit.jsp").forward(req, resp);
}
}
