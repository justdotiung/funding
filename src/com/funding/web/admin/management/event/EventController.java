package com.funding.web.admin.management.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funding.web.dao.SelEventDao;
import com.funding.web.dao.oracle.OracleSelEventDao;
import com.funding.web.entity.SelEventView;

@WebServlet("/view/admin/event")
public class EventController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int page = 1;
		String p = req.getParameter("page");
	
		if(p!=null && !p.equals(""))
			page =Integer.parseInt(p);
		
		System.out.println(page);
		SelEventDao sDao = new OracleSelEventDao();
		List<SelEventView> list = new ArrayList<>();
		try {
			
			list = sDao.getList(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("event", list);
		req.getRequestDispatcher("/WEB-INF/view/admin/event.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String state = req.getParameter("state");
		String sdate = req.getParameter("sdate");
		String edate = req.getParameter("edate");
		SelEventDao dao = new OracleSelEventDao();
		SelEventView selEvent = new SelEventView(sdate,edate,state,title);	
		try {
			req.setAttribute("count", dao.getCount("title", title));
			req.setAttribute("event", dao.search(selEvent));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		req.getRequestDispatcher("/WEB-INF/view/admin/event.jsp").forward(req, resp);
	}
}
