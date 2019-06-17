package com.blackswan.web.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Member;

@WebServlet("/view/guest/signup")
public class SignUpController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/guest/signup.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		String pw1 = req.getParameter("pw1");
		String phone = req.getParameter("phone");
		String check = req.getParameter("eventCheck");

		MemberDao dao = new OracleMemberDao();
		Member member = new Member(email, name, pw, phone, check);

		System.out.println(member);
		if (pw == null || pw.equals("") || !pw.equals(pw1)) {
			req.setAttribute("error", "비밀번호 불일치하거나 입력되지않았습니다.");
			req.getRequestDispatcher("/WEB-INF/view/guest/signup.jsp").forward(req, resp);
		}
		try {
			dao.insert(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			resp.sendRedirect("../member/login");
	}
}
