package com.funding.web.controller.member.funding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funding.web.dao.FundingDao;
import com.funding.web.dao.oracle.OracleFundingDao;

@WebServlet("/view/member/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String mid = req.getParameter("id");
		System.out.println(mid);
		FundingDao fDao = new OracleFundingDao();
		try {
			fDao.getk(mid);
			req.setAttribute("list", fDao.getk(mid));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/view/member/detail.jsp").forward(req, resp);
	}
}
