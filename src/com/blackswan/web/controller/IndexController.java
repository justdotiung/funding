package com.blackswan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view/main")
public class IndexController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String fun = req.getParameter("fun");
//		if(session.getAttribute("id") != null)
//			System.out.println("세션완료");
		req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
	}
}
