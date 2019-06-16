package com.blackswan.web.controller.membe.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/view/member/mypage")
public class MypageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String a = (String) session.getAttribute("email");
		String fun = req.getParameter("fun");
		
		System.out.println(session.getAttribute("email"));
		
		if(req.getParameter("fun") == null)
			req.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp").forward(req, resp);	
		else {
			req.setAttribute("fun", fun);
			req.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp").forward(req, resp);	

			}
		}

}
