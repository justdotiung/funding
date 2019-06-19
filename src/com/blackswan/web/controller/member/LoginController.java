package com.blackswan.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Member;


@WebServlet("/view/member/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		HttpSession session = req.getSession();
		
		MemberDao dao = new OracleMemberDao();
		try {
			Member member = dao.get(email);
			if(member == null)
				resp.sendRedirect("login?error=1");
			else if(!member.getPw().equals(pw))
				resp.sendRedirect("login?error=1");
			
			else {
				session.setAttribute("id", member.getId());
				System.out.println(member.getId());
				resp.sendRedirect("/view/main");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
