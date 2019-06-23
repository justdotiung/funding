package com.funding.web.admin.management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funding.web.dao.CategoryDao;
import com.funding.web.dao.oracle.OracleCategoryDao;
import com.funding.web.entity.Category;

@WebServlet("/view/admin/category")
public class CategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao cDao = new OracleCategoryDao();
		
		try {
			int sum = cDao.sum();
			System.out.println(sum);
			req.setAttribute("countlist", cDao.countlist());
			req.setAttribute("sum", cDao.sum());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/view/admin/category.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		CategoryDao cDao = new OracleCategoryDao();
		Category category = new Category();
		String id = (String) session.getAttribute("id");
		category.setName(name);
		category.setAdmin_Id(id);
		System.out.println(category.getAdmin_Id());
		int result = 0;
		try {
			cDao.insert(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result != -1)
			resp.sendRedirect("category");
		else
			resp.sendRedirect("error");
	}
}
