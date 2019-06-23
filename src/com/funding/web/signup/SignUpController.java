package com.funding.web.signup;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funding.web.dao.MemberDao;
import com.funding.web.dao.oracle.OracleMemberDao;
import com.funding.web.entity.Member;

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
			System.out.println(phone);
			List<Member> list = dao.getUK();
			System.out.println(list.get(17).getPhone());
			for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getEmail().equals(email)) {
						req.setAttribute("error", "존재하는 이메일 혹은 번호.");
						req.getRequestDispatcher("/WEB-INF/view/guest/signup.jsp").forward(req, resp);
					}
					if(list.get(i).getPhone().equals(phone)) {
						req.setAttribute("error", "번호.");
						req.getRequestDispatcher("/WEB-INF/view/guest/signup.jsp").forward(req, resp);
					}
			}
				dao.insert(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			resp.sendRedirect("../member/login");
	}
}
