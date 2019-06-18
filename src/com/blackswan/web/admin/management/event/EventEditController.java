package com.blackswan.web.admin.management.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.SelEventDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;
import com.blackswan.web.dao.oracle.OracleSelEventDao;
import com.blackswan.web.entity.Funding;
import com.blackswan.web.entity.SelEvent;
import com.blackswan.web.entity.SelEventView;

@WebServlet("/view/admin/eventedit")
public class EventEditController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		SelEventDao sDao = new OracleSelEventDao();
		FundingDao fDao = new OracleFundingDao();
		SelEvent selEvent = new SelEvent();
		Funding funding = new Funding();
		try {
			selEvent = sDao.get(id);
			String fId = selEvent.getFunding_id();
			funding = fDao.getTitle(fId);
			System.out.println(funding.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("funding", funding);
		req.setAttribute("event", selEvent);
		req.getRequestDispatcher("/WEB-INF/view/admin/eventedit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String state = req.getParameter("state");
		SelEventDao sDao = new OracleSelEventDao();
		int result = 0;
		try {
			SelEvent event = sDao.get(req.getParameter("id"));
			event.setState(state);
			result = sDao.update(event);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result != -1)
			resp.sendRedirect("event");
		else
			resp.sendRedirect("error");
	}
}
