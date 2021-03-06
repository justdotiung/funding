package com.funding.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funding.web.dao.FundingDao;
import com.funding.web.dao.oracle.OracleFundingDao;

@WebServlet("/view/main")
public class IndexController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String fun = req.getParameter("fun");
		
		FundingDao fDao = new OracleFundingDao();
		try {
			fDao.getList();
			System.out.println(fDao.getList().get(0).getId());
			req.setAttribute("list", fDao.getList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
	}
}
