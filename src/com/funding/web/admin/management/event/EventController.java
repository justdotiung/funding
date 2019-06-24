package com.funding.web.admin.management.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funding.web.dao.SelEventDao;
import com.funding.web.dao.oracle.OracleSelEventDao;
import com.funding.web.entity.SelEventView;

@WebServlet("/view/admin/event")
public class EventController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String sessionId= (String) session.getAttribute("id");
		if(sessionId !=null && sessionId.equals("1")) {
			
			int page = 1;
			String p = req.getParameter("page");
			String title = "";
			String state ="";
			String edate ="";
			String sdate ="";
			
			String new_title = req.getParameter("title");
			String new_state = req.getParameter("state");
			String new_sdate = req.getParameter("sdate");
			String new_edate = req.getParameter("edate");
			
			String old_title = req.getParameter("old_title");
			String old_sdate = req.getParameter("old_sdate");
			String old_edate = req.getParameter("old_edate");
			String old_state = req.getParameter("old_state");
			
			
			if(p!=null && !p.equals(""))
				page =Integer.parseInt(p);
			
			if(new_title !=null ) {
				title= new_title;
				if(old_title!=null && !old_title.equals(new_title))
					page=1;
			}
			if(new_state !=null) {
				state = new_state;
				if(old_state!=null && !old_state.equals(new_state))
					page=1;
			}
			if(new_sdate !=null) {
				sdate = new_sdate;
				if(old_sdate!=null && !old_sdate.equals(new_sdate))
					page=1;
			}
			if(new_edate !=null) {
				edate =new_edate;
				if(old_edate!=null && !old_edate.equals(new_edate))
					page=1;
			}
			SelEventDao sDao = new OracleSelEventDao();
			List<SelEventView> list = new ArrayList<>();
			try {
				int count = sDao.getCount(title,sdate,edate,state);
				int scount = sDao.getCount(title,sdate,edate,"2");
				list = sDao.getList(page,title,sdate,edate,state);
				req.setAttribute("scount", scount);
				req.setAttribute("count", count);
				req.setAttribute("event", list);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("/WEB-INF/view/admin/event.jsp").forward(req, resp);
		}
		else
			resp.sendRedirect("/error.jsp");
	}
}
