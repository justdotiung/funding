package com.blackswan.web.controller.membe.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Member;
@WebServlet("/view/member/mypage")
public class MypageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		String fun = req.getParameter("fun");
		MemberDao mDao = new OracleMemberDao();
		FundingDao dao = new OracleFundingDao();
		
		System.out.println(session.getAttribute("email"));
		
		if(req.getParameter("fun") == null)
			req.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp").forward(req, resp);	
		else {

			try {
				String id = mDao.get(email).getId();
				req.setAttribute("funding", dao.getList(id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("fun", fun);
			req.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp").forward(req, resp);	

			}
		}

}
