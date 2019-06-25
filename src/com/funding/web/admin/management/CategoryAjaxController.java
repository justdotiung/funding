package com.funding.web.admin.management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funding.web.dao.CategoryDao;
import com.funding.web.dao.oracle.OracleCategoryDao;
import com.funding.web.entity.Category;
import com.funding.web.entity.CategoryView;


@WebServlet("/view/admin/category-ajax")
public class CategoryAjaxController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		int sum = 0;
		List<CategoryView> list = new ArrayList<>();
		StringBuilder json = new StringBuilder();
//		if (id == null || !id.equals("1")) {
//			resp.sendRedirect("/error.jsp");
//			return;
//		} 새로운 페이지 보낼때 어떻게 해야하는지 물어보기

		CategoryDao cDao = new OracleCategoryDao();
		int result = 0;
		try {

				String name = req.getParameter("n");
				Category category = new Category();
				category.setName(name);
				category.setAdmin_Id(id);
				System.out.println(category.getName());
				System.out.println(category.getAdmin_Id());

				result = cDao.insert(category);
				if (result == -1) {
					resp.sendRedirect("/error.jsp");
					return;
				}
			list = cDao.countlist();
			sum = cDao.sum();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		json.append("{\"list\":[");
		for (int i = 0; i < list.size(); i++) {
			CategoryView cate = list.get(i);
			json.append(String.format("{\"count\":%d,", cate.getCount()));
			json.append(String.format("\"name\":\"%s\",", cate.getName()));
			json.append(String.format("\"id\":\"%s\"}", cate.getId()));
			if(i != list.size()-1)
				json.append(",");
		}
		json.append(String.format("],\"sum\":%d}",sum));
		
		System.out.println(json);
		out.write(json.toString());
	}
}
