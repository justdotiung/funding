package com.funding.web.controller.member.buying;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funding.web.dao.BuyingDao;
import com.funding.web.dao.oracle.OracleBuyingDao;
import com.funding.web.entity.Buying;
@WebServlet("/view/member/buying")
public class BuyingController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		System.out.println(id);
		BuyingDao bDao = new OracleBuyingDao();
		Buying buying = new Buying();
				
		bDao.insert(buying);
	
	}
}
